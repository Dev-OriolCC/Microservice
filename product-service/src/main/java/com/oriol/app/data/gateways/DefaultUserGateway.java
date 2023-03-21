package com.oriol.app.data.gateways;

import com.oriol.app.data.entities.ProductEntity;
import com.oriol.app.data.repositories.ProductRepository;
import com.oriol.app.domain.products.Product;
import com.oriol.app.domain.products.ProductGateway;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class DefaultUserGateway implements ProductGateway {

    private final ProductRepository productRepository;

    public DefaultUserGateway(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return toModel(productRepository.save(toEntity(product)));
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll().stream().map(this::toModel).toList();
    }

    @Override
    public void delete(String id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Error"));
        productRepository.delete(productEntity);
    }

    public ProductEntity toEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .deleted(product.isDeleted())
                .build();
    }

    public Product toModel(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .createdAt(productEntity.getCreatedAt())
                .updatedAt(productEntity.getUpdatedAt())
                .deleted(productEntity.isDeleted())
                .build();
    }

}
