package com.oriol.app.web;

import com.oriol.app.domain.users.User;
import com.oriol.app.domain.users.UserGateway;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    public User create(User user) {
        return null;
    }

    public List<User> getUsers() {
        return null;
    }

    public void delete(String id) {

    }
}
