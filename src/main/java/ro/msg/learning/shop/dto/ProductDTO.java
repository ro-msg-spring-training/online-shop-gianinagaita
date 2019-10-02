package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.Product;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Double weight;
    private String imageUrl;
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
    private Long supplierId;
    private String supplierName;
    private Long productId;

    public ProductDTO(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.weight = product.getWeight();
        this.imageUrl = product.getImageUrl();
        this.categoryId = product.getProductCategory().getId();
        this.categoryDescription = product.getProductCategory().getDescription();
        this.categoryName = product.getProductCategory().getName();
        this.productId = product.getId();
        this.supplierId = product.getSupplier().getId();
        this.supplierName = product.getSupplier().getName();
    }
}
