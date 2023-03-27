package com.oriol.app.data.gateways;

import com.oriol.app.data.entities.ProductEntity;
import com.oriol.app.data.repositories.ProductRepository;
import com.oriol.app.domain.products.Product;
import com.oriol.app.domain.products.ProductGateway;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
public class DefaultProductGateway implements ProductGateway {

    private final ProductRepository productRepository;

    public DefaultProductGateway(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        product.setId(UUID.randomUUID().toString());
        // Call and get stickers for this.
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
                .barcode(product.getBarcode())
                .build();
    }

    public Product toModel(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .createdAt(productEntity.getCreatedAt())
                .updatedAt(productEntity.getUpdatedAt())
                .deleted(productEntity.isDeleted())
                .barcode(productEntity.getBarcode())
                .build();
    }

}
