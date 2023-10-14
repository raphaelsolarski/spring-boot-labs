package com.example.springbootlabs.product;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private HashMap<Long, Product> products = new HashMap<>();
    public List<Product> getProducts() {
        return (List)products.values();
    }

    public void initializeValues(){
        List<Product> list = new ArrayList<>();

        list = List.of(
                new Product(1L,"Biurko Narozne","Biurko z szufladą na klawiaturę",550.00),
                new Product(2L,"Krzesło","Ergonomiczne krzeslo biurowe ",120.00),
                new Product(3L,"Fooo","Praesent et diam felis. Aliquam nec eros nisl. Nulla massa neque, interdum eu nisl vitae, tristique efficitur odio.",300.00),
                new Product(4L, "Baar","Praesent nisl orci, bibendum a elit vitae, lobortis ullamcorper orci. Vivamus eget enim id sem laoreet tempus. Maecenas sed mollis nisl, sit amet eleifend ipsum. Sed tempor, neque ac tincidunt vehicula, mauris magna ullamcorper nisi, vitae hendrerit sapien turpis vel magna. Fusce ac ante at leo auctor dapibus. Cras rutrum lorem leo, quis sodales arcu luctus ut. Aliquam turpis est, pulvinar eu diam ultricies, accumsan varius libero.0",1234.78),
                new Product(5L, "Fotel","Pellentesque tincidunt porta metus, quis pulvinar lorem maximus a. Vivamus malesuada suscipit nisi ut posuere. Donec nibh ligula, rutrum pulvinar bibendum vitae, varius ac elit. In eget mi eu tortor rutrum hendrerit sed vitae nulla. Ut sed lorem eget est luctus consequat. Phasellus varius non orci eu gravida. ",600.50)
        );
        list.forEach(product ->{
            this.products.put(product.getId(),product);
        });
    }

    public boolean exist(Long id) {
        if(!this.products.containsKey(id))
            return false;
        return true;
    }

    public Product delete(Long id) {
        Product product = this.products.get(id);
        this.products.remove(id);
        return product;
    }

    public Product addProduct(Product product) {
        this.products.put(Collections.max(this.products.keySet())+1,new Product(product.getName(),product.getDescription(),product.getPrice()));
        return product;
    }

    public Product update(Long id, Product product) {
        Product productToUpdate = this.products.get(id);
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        return productToUpdate;
    }
}
