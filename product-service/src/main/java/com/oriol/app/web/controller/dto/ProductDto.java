package com.oriol.app.web.controller.dto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Setter
@Getter
public class ProductDto extends BaseDto {

    public ProductDto() {
    }

    @Builder
    public ProductDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name, String barcode,
                      Double sugar, Double calories, Double saturatedFats, Double transFats, Double sodium) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
        this.barcode = barcode;
        this.sugar = sugar;
        this.calories = calories;
        this.saturatedFats = saturatedFats;
        this.transFats = transFats;
        this.sodium = sodium;
    }
    @NotNull
    @Size(min = 4, message = "Name must be at least 4 characters")
    private String name;
    @NotNull
    private String barcode;

    private Double sugar;
    private Double calories;
    private Double saturatedFats;
    private Double transFats;
    private Double sodium;
}
