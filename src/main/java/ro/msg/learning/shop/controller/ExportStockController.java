package ro.msg.learning.shop.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.services.ExportStockServices;

import java.util.List;

@RestController
public class ExportStockController {
    private final ExportStockServices stockServices;

    public ExportStockController(ExportStockServices stockServices) {
        this.stockServices = stockServices;
    }

    @RequestMapping(value = "/exportStock/{id}", method = RequestMethod.GET)
    public List<StockDTO> getExportedStock(@PathVariable("id") Long id) {
        return stockServices.getExportedStock(id);

    }
}
