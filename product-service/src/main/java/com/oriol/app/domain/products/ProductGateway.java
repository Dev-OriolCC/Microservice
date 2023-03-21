package com.oriol.app.domain.products;

import java.util.List;
public interface ProductGateway {

    Product create(Product product);
    List<Product> getProducts();
    void delete(String id);

}
