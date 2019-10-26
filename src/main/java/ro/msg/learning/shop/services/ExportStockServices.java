package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.convert.StockConverter;
import ro.msg.learning.shop.dto.StockDTO;
import ro.msg.learning.shop.exceptions.LocationNotFoundException;
import ro.msg.learning.shop.model.Location;
import ro.msg.learning.shop.model.Stock;
import ro.msg.learning.shop.repository.LocationRepository;
import ro.msg.learning.shop.repository.StockRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExportStockServices {
    private final StockRepository stockRepository;
    private final LocationRepository locationRepository;
    private final StockConverter stockConverter;

    public List<StockDTO> getExportedStock(Long id) {
        Optional<Location> location = locationRepository.findLocationById(id);

        if (location.isPresent()) {
            List<Stock> stockList = stockRepository.findStockByLocationId(id);
            return stockList.stream()
                    .map(StockConverter::convertEntityStockToDto)
                    .collect(Collectors.toList());
        } else {
            throw new LocationNotFoundException("Location with  id '" + id + "' does no exist");
        }
    }
}
