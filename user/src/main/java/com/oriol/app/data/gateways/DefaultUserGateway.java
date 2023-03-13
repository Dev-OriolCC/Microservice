package com.oriol.app.data.gateways;

import com.oriol.app.data.entities.UserEntity;
import com.oriol.app.data.repositories.UserRepository;
import com.oriol.app.domain.users.User;
import com.oriol.app.domain.users.UserGateway;
import com.oriol.app.web.dto.UserDto;
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
        System.out.println("Data");
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


    // Builders
//    public UserDto toDto(User user) {
//        return UserDto.builder()
//                .id(user.getId())
//                .name(user.getName())
//                .createdAt(user.getCreatedAt())
//                .updatedAt(user.getUpdatedAt())
//                .deleted(user.isDeleted())
//                .build();
//    }

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
