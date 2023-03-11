package com.oriol.app.domain.users;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserService {
    private final UserGateway userGateway;
    public User create(User user) {
        return userGateway.create(user);
    }

    public List<User> getUsers() {
        return userGateway.getUsers();
    }

    public void delete(String id) {
        userGateway.delete(id);
    }
}
