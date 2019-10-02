package ro.msg.learning.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.OrderConvert;
import ro.msg.learning.shop.dto.OrderDTO;
import ro.msg.learning.shop.dto.OrderDTOCreation;
import ro.msg.learning.shop.exceptions.RecordNotFoundException;
import ro.msg.learning.shop.model.Ordeer;
import ro.msg.learning.shop.services.OrderServices;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
public class OrderController {
    private OrderServices orderServices;
   private OrderDTO orderDTO;
   private OrderConvert orderConvert;
    public OrderController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public List<OrderDTO> createOrder(@RequestBody OrderDTOCreation orderDTOCreation) {
        //the type of the entity that we persist into DB
        List<Ordeer> ordercreation = new ArrayList();
        try {
            ordercreation = orderServices.createOrder(orderDTOCreation);
        } catch (RecordNotFoundException bs) {
            throw new RecordNotFoundException("This product doesn t exist ");
        }
        List<OrderDTO> ordeer= new ArrayList<>();
        for(Ordeer o:ordercreation){
           OrderDTO orderDTO= orderConvert.convertEntityToDto(o);
            ordeer.add(orderDTO);
        }
        return ordeer;
    }
}
