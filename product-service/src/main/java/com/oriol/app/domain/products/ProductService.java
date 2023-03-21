package com.oriol.app.domain.products;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductGateway productGateway;

    public Product create(Product product) {
        return productGateway.create(product);
    }

    public List<Product> getProducts() {
        return productGateway.getProducts();
    }

    public void delete(String id) {
        productGateway.delete(id);
    }

}
