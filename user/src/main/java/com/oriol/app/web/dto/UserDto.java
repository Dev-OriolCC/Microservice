package com.oriol.app.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto extends BaseDto {
    public UserDto() {
    }

    private String name;
    @Builder
    public UserDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
    }

}
