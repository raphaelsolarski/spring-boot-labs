package com.example.springbootlabs.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ResponseBody
    public List<Product> getProducts(){

        return productService.getProducts();
    }
    @GetMapping("/checkprice")
    ResponseEntity<String> price(
            @RequestParam("price") int price) {

        if (price<0) {
            return new ResponseEntity<>(
                    "Price cannot be less than 0",
                    HttpStatus.BAD_REQUEST);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "foo");

        return new ResponseEntity<>(
                "Price is good",
                headers,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
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
    @ResponseBody
    public Product addProduct(@RequestBody ProductDTO product){
        return productService.addProduct(product);
    }

    @PutMapping(path = "/{id}", headers = "Foo=Bar")
    @ResponseStatus(code = HttpStatus.CREATED)
    @ResponseBody
    public Product updateProduct(@RequestBody ProductDTO product,@PathVariable Long id) {
        if (!productService.exist(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
            return productService.update(id, product);
        }

}
