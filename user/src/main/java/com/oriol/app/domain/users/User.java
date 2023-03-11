package com.oriol.app.domain.users;

import java.time.LocalDateTime;

public class User {
    private String id;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private boolean deleted = false;
    private String name;
}
