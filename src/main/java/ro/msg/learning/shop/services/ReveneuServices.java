package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.exceptions.OrderNotFound;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Ordeer;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Revenue;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.OrderDetailRepository;
import ro.msg.learning.shop.repository.OrderRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ReveneuServices {
    private LocationRepository locationRepository;
    private OrderRepository orderRepository;
    private OrderDetailRepository orderDetailRepository;
    @Scheduled(cron = "0 59 23 * * ?")
    public void aggregationSum(Revenue revenue){
        List<Location> locations=locationRepository.findAll();
        LocalDate date = LocalDate.now().minusDays(1); //yesterday

    }
    public BigDecimal getSumOfTheLocation(List<Location> locationList){
        locationList.stream().map(new
                                          Function<Location, BigDecimal>() {
                                              @Override
                                              public BigDecimal apply(Location location) {
                                                  Optional<Ordeer> ordeer=orderRepository.findOrderByShippedFrom(location);
                                                  if(ordeer.isPresent()){
                                                    List<Ordeer> ordeerList= (List<Ordeer>) ordeer.get();
                                                   BigDecimal sum=getSumOfTheOrder(ordeerList);
                                                  }
                                                  else
                                                  {
                                                    throw new OrderNotFound("Doesn't exist any order for this location");
                                                  }
                                              }
                                          });
    }
    public BigDecimal getSumOfTheOrder(List<Ordeer> ordeerList){
        ordeerList.stream().map(
                new Function<Ordeer, BigDecimal>() {
                    @Override
                    public BigDecimal apply(Ordeer ordeer) {
                      List<OrderDetail> orderDetailList=
                        BigDecimal sum=sum+orderDetail.getProduct().getPrice();
                    }
                }
        )
    }
}
