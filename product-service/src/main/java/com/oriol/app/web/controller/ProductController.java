package com.oriol.app.web.controller;

import com.oriol.app.domain.products.Product;
import com.oriol.app.domain.products.ProductGateway;
import com.oriol.app.domain.products.ProductService;
import com.oriol.app.web.controller.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/products/")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(toDto(productService.create(toModel(productDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> productDtos = productService.getProducts().stream().map(this::toDto).toList();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(String id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // Builder
    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .deleted(product.isDeleted())
                .build();
    }

    public Product toModel(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .createdAt(productDto.getCreatedAt())
                .updatedAt(productDto.getUpdatedAt())
                .deleted(productDto.isDeleted())
                .build();
    }


}
