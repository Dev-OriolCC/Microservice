package com.oriol.app.domain.users;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private boolean deleted = false;
    private String name;
}
