package com.oriol.app.data.gateways;

import com.oriol.app.data.entities.ProductEntity;
import com.oriol.app.data.repositories.ProductRepository;
import com.oriol.app.domain.MsPagination;
import com.oriol.app.domain.products.Product;
import com.oriol.app.domain.products.ProductGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Component
public class DefaultProductGateway implements ProductGateway {
    private final ProductRepository productRepository;
    public DefaultProductGateway(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private int PAGE_SIZE = 1;
    @Override
    public Product create(Product product) {
        product.setId(UUID.randomUUID().toString());

        //TODO: Calculate Sugar

        //TODO: Calculate Calories

        //TODO: Calculate SaturatedFats

        //TODO: Calculate TransFats

        //TODO: Calculate Sodium

        // Call and get stickers for this.
        return toModel(productRepository.save(toEntity(product)));
    }

    @Override
    public List<Product> getProducts() {
        return null; //productRepository.findAll().stream().map(this::toModel).toList();
    }

    /**
     * @param page
     * @return
     */
    @Override
    public MsPagination<Product> getProducts(int page) {
        Page<ProductEntity> productEntityPagination = productRepository.findAll(PageRequest.of(page, PAGE_SIZE));
        System.out.println(productEntityPagination);
        List<Product> products = productEntityPagination.getContent().stream().map(this::toModel).collect(toList());
        System.out.println(products);
        return new MsPagination.PaginationPageBuilder<Product>("products")
                .body(products)
                .pageNumber(page)
                .totalPages(productEntityPagination.getTotalPages())
                .build();
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
