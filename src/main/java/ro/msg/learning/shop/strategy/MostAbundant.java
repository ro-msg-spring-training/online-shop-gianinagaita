package ro.msg.learning.shop.strategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.OrderDTOCreation;
import ro.msg.learning.shop.dto.ProductQuantity;
import ro.msg.learning.shop.exceptions.StockNotFoundException;
import ro.msg.learning.shop.exceptions.StrategyEnableException;
import ro.msg.learning.shop.model.Address;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Ordeer;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.CustomerRepository;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.repository.StockRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor

public class MostAbundant implements Strategy {
    private  StockRepository stockRepository;
    private CustomerRepository costumerRepository;
    private OrderRepository orderRepository;
    @Override
    public List<Ordeer> createOrder(OrderDTOCreation orderDTOCreation) {
        List<Ordeer> ordeerArrayList = new ArrayList<>();
        List<Ordeer> ordeer= new ArrayList<>();
        try {
            //the type that we need to return: location, productquantity
            //locatia in urma strategiei
            List<Location> locationList = getLocation(orderDTOCreation);
            //produsele dorite
            List<ProductQuantity> productQuantities = orderDTOCreation.getProductQunatityList();
            for (int i = 0; i < locationList.size(); i++) {
                Optional<Stock> stock = stockRepository.findStockByLocationIdAndProductId(locationList.get(i).getId(), productQuantities.get(i)
                        .getId());
                Stock newstock;
                if (stock.isPresent() && (stock.get().getQuantity() > orderDTOCreation.getProductQunatityList().get(i).getQuantity())) {
                    newstock = stock.get();
                    newstock.setQuantity(newstock.getQuantity() - orderDTOCreation.getProductQunatityList().get(i).getQuantity());
                } else {
                    throw new StockNotFoundException("Doesn't exist this quantity in this stock");
                }
            }
            Address address = new Address();
            address.setCountry(orderDTOCreation.getAddress().getCountry());
            address.setStreetAddress(orderDTOCreation.getAddress().getStreetAddress());
            address.setCity(orderDTOCreation.getAddress().getCity());
            address.setCounty(orderDTOCreation.getAddress().getCounty());
            for(Location l:locationList){
                ordeer.add(new Ordeer( l,
                        costumerRepository.findCustomerById(orderDTOCreation.getCustomerId()),
                        orderDTOCreation.getCreatedAt(),
                        address));
            }
            for(Ordeer o:ordeer){
                orderRepository.save(o);
            }

        } catch (StrategyEnableException strategy) {
            throw new StrategyEnableException("Strategy Enable");
        }
        return ordeer;
    }
    public List<Location> getLocation(OrderDTOCreation orderDTOCreation) {

        List<ProductQuantity> products = orderDTOCreation.getProductQunatityList();
        List<Location> finallocation = new ArrayList<>();
        Location location = null;
        Integer initialquantity=0;
        for (ProductQuantity productQuantity : products) {
            List<Stock> stockList = stockRepository.findStockByProductId(productQuantity.getId());
            for (Stock s : stockList) {
                if (s.getQuantity() >=initialquantity) {
                    initialquantity = s.getQuantity();
                    location = s.getLocation();
                }
            }
            initialquantity=0;
            finallocation.add(location);
        }

        return finallocation;
    }

    }



