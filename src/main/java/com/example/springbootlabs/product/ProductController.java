package com.example.springbootlabs.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Year;
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
    public List<Product> getProducts(@RequestParam(required = false,name = "maxprice" ) Double maxPrice){
        if(maxPrice != null)
            return productService.getWithMaxPrice(maxPrice);

        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        if (!productService.exist(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );

        }
        return productService.getById(id);
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
    public Product addProduct(@RequestBody ProductDTO product){
        return productService.addProduct(product);
    }

    @PutMapping(path = "/{id}", headers = "Foo=Bar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product updateProduct(@RequestBody ProductDTO product,@PathVariable Long id) {
        if (!productService.exist(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
            return productService.update(id, product);
        }


    @GetMapping("/age")
    ResponseEntity<String> age(@RequestParam("yearOfBirth") int yearOfBirth) {
        if (isInFuture(yearOfBirth)) {
            return ResponseEntity.badRequest()
                    .body("Year of birth cannot be in the future");
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body("Your age is " + calculateAge(yearOfBirth));
    }

    private int calculateAge(int yearOfBirth) {
        return Year.now().getValue()-yearOfBirth;
    }

    private boolean isInFuture(int yearOfBirth) {
       return Year.now().getValue()-yearOfBirth<0;
    }
}
