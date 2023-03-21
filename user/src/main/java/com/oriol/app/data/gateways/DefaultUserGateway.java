package com.oriol.app.data.gateways;

import com.oriol.app.data.config.CheckFraudResponse;
import com.oriol.app.data.entities.UserEntity;
import com.oriol.app.data.repositories.UserRepository;
import com.oriol.app.domain.users.User;
import com.oriol.app.domain.users.UserGateway;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import static java.util.stream.Collectors.toList;

@Component
public class DefaultUserGateway implements UserGateway {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public DefaultUserGateway(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }


    @Override
    public User create(User user) {
        //TODO: Connect to another Microservice
        CheckFraudResponse checkFraudResponse = restTemplate.getForObject("http://localhost:8081/api/v1/fraud/test",
                CheckFraudResponse.class);

        if (checkFraudResponse.isFraudster()) {
            System.out.println("Fraud");
        }
        return toModel(userRepository.save(toEntity(user)));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream().map(this::toModel).collect(toList());
    }

    @Override
    public void delete(String id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Error"));
        userRepository.delete(userEntity);
    }


    public UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .deleted(user.isDeleted())
                .build();
    }

    public User toModel(UserEntity userEntity) {
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .deleted(userEntity.isDeleted())
                .build();
    }
}
