package ro.msg.learning.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.ReveneuDTO;
import ro.msg.learning.shop.services.ReveneuServices;

import java.util.List;

@RestController
@AllArgsConstructor
public class RevenueController {
    private final ReveneuServices reveneuServices;

    @RequestMapping(value = "/reveneu", method = RequestMethod.GET)
    public List<ReveneuDTO> getAllProducts() {
        return reveneuServices.getAllDataForGivenData();
    }
}
