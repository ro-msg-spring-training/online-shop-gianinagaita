package ro.msg.learning.shop.strategy;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ro.msg.learning.shop.configuration.RouteMatrix;
import ro.msg.learning.shop.dto.*;
import ro.msg.learning.shop.model.*;
import ro.msg.learning.shop.repository.*;
import java.util.*;
import java.util.stream.Collectors;
@AllArgsConstructor
@Component
public class Proximity implements Strategy {
    private RouteMatrix routeMatrix;
    private LocationRepository locationRepository;
    private CustomerRepository costumerRepository;
    private OrderRepository orderRepository;
    private StockRepository stockRepository;

    //give me the list in order of the closed location
    @Override
    public List<Ordeer> createOrder(OrderDTOCreation orderDTOCreation) {
        List<ResponseProximityStrategy> responseProximityStrategies = generatingOrder(orderDTOCreation);
        List<Ordeer> ordeer = new ArrayList<>();

        for (int i = 0; i <=responseProximityStrategies.size(); i++) {
            Address address = new Address();
            address.setCountry(orderDTOCreation.getAddress().getCountry());
            address.setStreetAddress(orderDTOCreation.getAddress().getStreetAddress());
            address.setCity(orderDTOCreation.getAddress().getCity());
            address.setCounty(orderDTOCreation.getAddress().getCounty());
            ordeer.add(new Ordeer(responseProximityStrategies.get(i).getLocation(), costumerRepository.findCustomerById(orderDTOCreation.getCustomerId()), orderDTOCreation.getCreatedAt(),
                    address));
        }
        orderRepository.saveAll(ordeer);
        return ordeer;
    }

    public List<ResponseProximityStrategy> generatingOrder(OrderDTOCreation orderDTOCreation) {
        List<ResponseProximityStrategy> responseProximityStrategies = new ArrayList<ResponseProximityStrategy>();
        List<ProductQuantity> productQuantities = orderDTOCreation.getProductQunatityList(); //productquantity list of order
        List<Location> locationList = getLocation(orderDTOCreation);//the list with the closed address
        int j = -1;
        int boughtquantity = 0;
        int length = orderDTOCreation.getProductQunatityList().size();
        while (productQuantities.size() != 0) {
            j++;
            for (int i = 0; i < length; i++) {
                Optional<Stock> stock = stockRepository.findStockByLocationIdAndProductId(locationList.get(j).getId(), productQuantities.get(i).getId());
                Stock newstock;
                if (stock.isPresent() && stock.get().getQuantity() > 0) {
                    newstock = stock.get();
                    if ((newstock.getQuantity() - productQuantities.get(i).getQuantity()) > 0) {
                        boughtquantity = newstock.getQuantity() - productQuantities.get(i).getQuantity();
                        newstock.setQuantity(boughtquantity);
                        productQuantities.remove(i);
                        responseProximityStrategies.add(new ResponseProximityStrategy(locationList.get(j), productQuantities.get(i).getId(), productQuantities.get(i).getQuantity()));
                    } else {
                        boughtquantity = newstock.getQuantity();
                        newstock.setQuantity(0);
                        productQuantities.get(i).setQuantity(productQuantities.get(i).getQuantity() - boughtquantity);
                        responseProximityStrategies.add(new ResponseProximityStrategy(locationList.get(j), productQuantities.get(i).getId(), boughtquantity));

                    }

                }
            }
            if (productQuantities.size() != 0) {
                length = productQuantities.size();
            }
        }
        return responseProximityStrategies;
    }

    public List<Location> getLocation(OrderDTOCreation orderDTOCreation) {
        List<String> locationList = new ArrayList<>();
        List<Location> alllocations = locationRepository.findAll(); //list with all the locations
        String orderaddress = orderDTOCreation.getAddress().getCountry()+"," + orderDTOCreation.getAddress().getCounty()+"," + orderDTOCreation.getAddress().getCity()+"," + orderDTOCreation.getAddress().getStreetAddress();
        locationList.add(orderaddress);
        locationList.addAll(alllocations.stream().map(location -> location.getAddress().getCounty() + "," + location.getAddress().getCounty() + "," + location.getAddress().getCity() + "," + location.getAddress().getStreetAddress()).collect(Collectors.toList()));
        DistanceResponseDTO distanceResponseDTO = getDistance(locationList);
        List<Long> distanceBetweenLocations = distanceResponseDTO.getDistance();
        distanceBetweenLocations.remove(0); //because the first one is the order address
        locationList.remove(0);//the order address
        Map<Long, Location> map = new HashMap<>();
        for (int i = 0; i < distanceBetweenLocations.size(); i++) {
            map.put(distanceBetweenLocations.get(i), alllocations.get(i));
        }
        sortbykey(map);
        //returnic the list of locations in order of distance
        return getListOfLocationInOrderOfDistance(map);
    }


    public DistanceResponseDTO getDistance(List<String> locationList) {
        String routematrixURL=routeMatrix.getUrl()+routeMatrix.getKey();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<DistanceRequestDTO> request = new HttpEntity<>(new DistanceRequestDTO(locationList, true));
        ResponseEntity<DistanceResponseDTO> responseDTOResponseEntity = restTemplate.exchange(routematrixURL, HttpMethod.POST, request, DistanceResponseDTO.class);
        DistanceResponseDTO distanceResponseDTO = responseDTOResponseEntity.getBody();
        return distanceResponseDTO;
    }

    public void sortbykey(Map<Long, Location> map) {
        TreeMap<Long, Location> sorted = new TreeMap<>();
        sorted.putAll(map);
    }

    public List<Location> getListOfLocationInOrderOfDistance(Map<Long, Location> map) {
        List<Location> locationListinorder = new ArrayList<>();
        for (Map.Entry<Long, Location> entry : map.entrySet()) {
            locationListinorder.add(entry.getValue());
        }
        return locationListinorder;
    }
}






