package ro.msg.learning.shop.convert;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.repository.SupplierRepository;

@Component
@RequiredArgsConstructor
public class ProductConverter {
    private final ProductCategoryRepository productCategoryRepository;
    private final SupplierRepository supplierRepository;

    public static ProductDTO convertEntityToDto(Product product) {
        return new ProductDTO(product);
    }

    public Product convertDtoToEntity(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .weight(productDTO.getWeight())
                .imageUrl(productDTO.getImageUrl())
                .productCategory(productCategoryRepository.findById(productDTO.getCategoryId()).get())
                .supplier(supplierRepository.getOne(productDTO.getSupplierId()))
                .build();
    }
}

