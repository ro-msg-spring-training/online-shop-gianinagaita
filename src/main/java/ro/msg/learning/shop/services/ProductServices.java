package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.convert.ProductConverter;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.exceptions.RecordNotFoundException;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServices {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductDTO createProduct(ProductDTO productDto) {
        return productConverter.convertEntityToDto(productRepository.save(productConverter.convertDtoToEntity(productDto)));
    }

    public void deleteProduct(ProductDTO productDto) {
        Product product = productRepository.findById(productDto.getProductId()).get();
        productRepository.delete(product);
    }

    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RecordNotFoundException("Product id '" + id + "' does no exist");
        }
        productRepository.deleteById(id);
    }

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductConverter::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public ProductDTO getProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RecordNotFoundException("Product id '" + productId + "' does no exist");
        }
        return productConverter.convertEntityToDto(productRepository.getOne(productId));
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {

        if (productRepository.getOne(productDTO.getProductId()) != null) {
            Product product = productConverter.convertDtoToEntity(productDTO);
            product.setName(productDTO.getName());
            product.setImageUrl(productDTO.getImageUrl());
            product.setPrice(productDTO.getPrice());
            product.setWeight(productDTO.getWeight());
            product.setDescription(productDTO.getDescription());
            return productConverter.convertEntityToDto(productRepository.save(product));
        } else {
            return null;
        }
    }
}
