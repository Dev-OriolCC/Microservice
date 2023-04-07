package com.oriol.app.domain.products;

import com.oriol.app.domain.MsPagination;
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
    public MsPagination<Product> getProducts(int page) { return productGateway.getProducts(page); }
    public void delete(String id) {
        productGateway.delete(id);
    }

}
