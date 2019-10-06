package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.convert.ReveneuConverter;
import ro.msg.learning.shop.dto.ReveneuDTO;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Ordeer;
import ro.msg.learning.shop.model.OrderDetail;
import ro.msg.learning.shop.model.Revenue;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.OrderDetailRepository;
import ro.msg.learning.shop.repository.OrderRepository;
import ro.msg.learning.shop.repository.ReveneuRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReveneuServices {
    private final LocationRepository locationRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ReveneuRepository reveneuRepository;
    private final ReveneuConverter reveneuConverter;

    @Scheduled(cron = "0 59 23 * * ?")
    public void aggregationSum() {
        List<Location> locations = locationRepository.findAll();
        LocalDate date = LocalDate.now().minusDays(1); //yesterday
        locations.forEach(location -> {
            long i = 0;
            BigDecimal sum = getSumOfTheLocation(location);
            Revenue revenue1 = new Revenue();
            revenue1.setDate(date);
            revenue1.setLocation(location);
            revenue1.setSum(sum);
            revenue1.setId(i);
            i++;
            reveneuRepository.save(revenue1);
        });
    }

    public BigDecimal getSumOfTheLocation(Location location) {
        List<Ordeer> ordeer = orderRepository.findOrderByShippedFrom(location);
        return ordeer.stream().map(this::getSumOfTheOrder).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getSumOfTheOrder(Ordeer ordeer) {
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrdeer(ordeer);
        return orderDetailList.stream()
                .map(orderDetail -> orderDetail.getProduct().getPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<ReveneuDTO> getAllDataForGivenData() {
        List<Revenue> revenueList = reveneuRepository.findAll();
        return revenueList.stream().map(revenue -> reveneuConverter.convertEntityToDto(revenue)).collect(Collectors.toList());
    }
}
