package ro.msg.learning.shop.controller;

import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dto.ProductDTO;
import ro.msg.learning.shop.services.ProductServices;

import java.util.List;

@RestController
public class ProductController {
    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    //get all product
    @GetMapping(value = "/products")
    public List<ProductDTO> getAllProducts() {
        return productServices.getAllProducts();
    }

    //update product
    @PutMapping(value = "/products/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productServices.updateProduct(productDTO);
        // return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    //get one single product
    @GetMapping(value = "/products/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return productServices.getProduct(id);

    }

    //create product
    @PostMapping(value = "/products")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productServices.createProduct(productDTO);
        // return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    //deleting by id
    @DeleteMapping(value = "/products/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        productServices.deleteProductById(id);
        // return new ResponseEntity<>("Product is deleted successsfully by id ", HttpStatus.OK);
    }
}
