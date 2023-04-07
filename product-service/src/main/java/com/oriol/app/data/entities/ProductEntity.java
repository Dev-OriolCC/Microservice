package com.oriol.app.data.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class ProductEntity extends BaseEntity {
    /*
     * @String id
     * @LocalDateTime createdAt
     * @LocalDateTime updatedAt
     * @Boolean deleted
     */
    @Builder
    public ProductEntity(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name, String barcode,
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
    private String name;
    private String barcode;
    private Double sugar;
    private Double calories;
    private Double saturatedFats;
    private Double transFats;
    private Double sodium;
}
