package com.oriol.app.web.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseDto {
    @Id
    private String id;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private boolean deleted = false;
}
