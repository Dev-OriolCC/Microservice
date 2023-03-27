package com.oriol.app.web.dto;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto extends BaseDto {
    public UserDto() {
    }

    @NotNull
    @Size(min = 4, message = "Name must be at least 4 characters")
    private String name;
    @Builder
    public UserDto(String id, LocalDateTime updatedAt, LocalDateTime createdAt, boolean deleted, String name) {
        super(id, updatedAt, createdAt, deleted);
        this.name = name;
    }

}
