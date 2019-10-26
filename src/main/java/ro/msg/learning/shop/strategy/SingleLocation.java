package ro.msg.learning.shop.strategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.base.BaseEntity;
import ro.msg.learning.shop.dto.OrderDTOCreation;
import ro.msg.learning.shop.dto.ProductQuantity;
import ro.msg.learning.shop.exceptions.RecordNotFoundException;
import ro.msg.learning.shop.exceptions.StockNotFoundException;
import ro.msg.learning.shop.exceptions.StrategyEnableException;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.CustomerRepository;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.repository.StockRepository;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class SingleLocation implements Strategy {
    private StockRepository stockRepository;
    private LocationRepository locationRepository;
    private CustomerRepository costumerRepository;
    private OrderRepository orderRepository;

    @Override
    public List<Ordeer> createOrder(OrderDTOCreation orderDTOCreation) {
        List<Ordeer> ordeer = new ArrayList<>();
        try {
            List<Location> locationList = getLocation(orderDTOCreation);
            List<ProductQuantity> productQuantities = orderDTOCreation.getProductQunatityList();
            ordeer = updatingTheStock(locationList, productQuantities, orderDTOCreation);
        } catch (StrategyEnableException strategy) {
            throw new StrategyEnableException("Strategy Enable");
        }
        return ordeer;
    }

    public List<Location> getLocation(OrderDTOCreation orderDTOCreation) {
        List<Location> locationList1 = locationRepository.findAll();
        List<Location> locations = new ArrayList<>();
        for (Location l : locationList1) {
            if (verifyIfLocationHasAllProducts(l, orderDTOCreation.getProductQunatityList()) == true) {
                locations.add(l);
            }
        }
        //for that case when we have 2 ore more locations with all the products and quantities required
        Optional<Location> singlelocation = locations.stream().min(Comparator.comparingLong(BaseEntity::getId));
//making an exception class of type RuntimeException
        if (locations.size() == 0)
            throw new RecordNotFoundException("Location not found");
//for the moment;
        List<Location> returningLocation = new ArrayList<Location>();
        if (singlelocation.isPresent()) {
            returningLocation.add(singlelocation.get());
        }

        return returningLocation;
    }

    private boolean verifyIfLocationHasAllProducts(Location location, List<ProductQuantity> productQunatityList) {
        //numai pt prod din lista aia, dupa locatie si product id
        List<Stock> stockList = stockRepository.findStockByLocationIdAndProductIdIn(location.getId(), productQunatityList.stream()
                .map(ProductQuantity::getId).collect(Collectors.toList()));
        System.out.println(stockList);
        //the list of the productids
        List<Long> stockProductIds = stockList.stream()
                .map(stock -> stock.getStockId().getProductId())
                .collect(Collectors.toList());
        List<Long> productsQuantityIds = productQunatityList.stream()
                .map(ProductQuantity::getId)
                .collect(Collectors.toList());

        if (!stockProductIds.containsAll(productsQuantityIds)) return false;
        else {
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            for (int i = 0; i < stockProductIds.size(); i++) {
                Integer quantity = stockRepository.findQuantityByProductIdAndLocationId(stockProductIds.get(i), location.getId());
                map.put(stockProductIds.get(i), quantity);
            }
            if (containsList((HashMap<Long, Integer>) map, productsQuantityIds, location) == true) return true;
            else return false;
        }
    }

    public boolean containsList(HashMap<Long, Integer> map, List<Long> list, Location location) {
        int x = 0;
        for (Long key : list) {
            int quantity = stockRepository.findQuantityByProductIdAndLocationId(key, location.getId());
            if (map.get(key) >= quantity)
                x = 1;
            else
                x = 0;
        }
        if (x == 0) return false;
        else return true;
    }

    public List<Ordeer> updatingTheStock(List<Location> locationList, List<ProductQuantity> productQuantityList, OrderDTOCreation orderDTOCreation) {
        List<Ordeer> ordeerList = new ArrayList<>();
        for (int i = 0; i < locationList.size(); i++) {
            Optional<Stock> stock = stockRepository.findStockByLocationIdAndProductId(locationList.get(i).getId(), productQuantityList.get(i)
                    .getId());
            Stock newstock;
            if (stock.isPresent() && (stock.get().getQuantity() > orderDTOCreation.getProductQunatityList().get(i).getQuantity())) {
                newstock = stock.get();
                newstock.setQuantity(newstock.getQuantity() - orderDTOCreation.getProductQunatityList().get(i).getQuantity());
            } else {
                throw new StockNotFoundException("Doesn't exist this quantity in this stock");
            }
        }
        ordeerList = generationOrder(orderDTOCreation, locationList);
        return ordeerList;
    }

    public List<Ordeer> generationOrder(OrderDTOCreation orderDTOCreation, List<Location> locationList) {
        List<Ordeer> ordeerList = new ArrayList<>();
        Customer customer = costumerRepository.findCustomerById(orderDTOCreation.getCustomerId());
        for (Location l : locationList) {
            ordeerList.add(new Ordeer(l, customer, orderDTOCreation.getCreatedAt(), orderDTOCreation.getAddress()));
        }
        orderRepository.saveAll(ordeerList);
        return ordeerList;
    }
}



