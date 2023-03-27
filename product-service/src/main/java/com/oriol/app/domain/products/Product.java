package com.oriol.app.domain.products;

import lombok.*;
import java.time.LocalDateTime;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private boolean deleted = false;
    // ->
    private String name;
    private String barcode;
    private Double sugar;
    private Double calories;
    private Double saturatedFats;
    private Double transFats;
    private Double sodium;
}
