package com.oriol.app.domain.users;

import java.util.List;

public interface UserGateway {
    User create(User user);
    List<User> getUsers();
    void delete(String id);
}
