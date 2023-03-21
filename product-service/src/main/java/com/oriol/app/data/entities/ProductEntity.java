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
@SQLDelete(sql = "UPDATE users SET deleted =true WHERE id = ?")
@Where(clause = "deleted = false")
public class ProductEntity extends BaseEntity {
    /*
     * @String id
     * @LocalDateTime createdAt
     * @LocalDateTime updatedAt
     * @Boolean deleted
     */
    @Builder
    public ProductEntity(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
    }
    private String name;
}
