package com.oriol.app.data.gateways;

import com.oriol.app.data.entities.UserEntity;
import com.oriol.app.data.repositories.UserRepository;
import com.oriol.app.domain.users.User;
import com.oriol.app.domain.users.UserGateway;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class DefaultUserGateway implements UserGateway {
    private final UserRepository userRepository;

    public DefaultUserGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream().map().collect(toList());
    }

    @Override
    public void delete(String id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Error"));
        userRepository.delete(userEntity);
    }
}
