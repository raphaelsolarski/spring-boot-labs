package com.example.springbootlabs.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController()
@RequestMapping(path = "api/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {

        this.productService = productService;
        productService.initializeValues();
    }

    @GetMapping
    public List<Product> getProducts(){

        return productService.getProducts();
    }
    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Long id){
        if(!productService.exist(id)){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );

        }
        return productService.delete(id);

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product updateProduct(@RequestBody Product product,@PathVariable Long id) {
        if (!productService.exist(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
            return productService.update(id, product);
        }

}
