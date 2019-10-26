package ro.msg.learning.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.services.ExportStockServices;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ExportStockController {
    private final ExportStockServices stockServices;

    public ExportStockController(ExportStockServices stockServices) {
        this.stockServices = stockServices;
    }

    @GetMapping("/locations/{id}/stocks/export")
    public List<StockDTO> getExportedStock(@Valid @RequestBody @PathVariable("id") Long id) {
        return stockServices.getExportedStock(id);

    }
}
