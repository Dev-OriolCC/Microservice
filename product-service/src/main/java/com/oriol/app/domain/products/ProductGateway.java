package com.oriol.app.domain.products;

import com.oriol.app.domain.MsPagination;

import java.util.List;
public interface ProductGateway {

    Product create(Product product);
    List<Product> getProducts();
    MsPagination<Product> getProducts(int page);
    void delete(String id);

}
