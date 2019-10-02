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
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDTO> getAllProducts() {
        return productServices.getAllProducts();
    }

    //update product
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productServices.updateProduct(productDTO);
        // return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    //get one single product
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return productServices.getProduct(id);

    }

    //create product
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productServices.createProduct(productDTO);
        // return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    //deleting the product
    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public void deleteProduct(ProductDTO productDTO) {
        productServices.deleteProduct(productDTO);
        //return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    //deleting by id
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProductById(@PathVariable("id") Long id) {
        productServices.deleteProductById(id);
        // return new ResponseEntity<>("Product is deleted successsfully by id ", HttpStatus.OK);
    }
}
