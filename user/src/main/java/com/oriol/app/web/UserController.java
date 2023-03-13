package com.oriol.app.web;

import com.oriol.app.domain.users.User;
import com.oriol.app.domain.users.UserService;
import com.oriol.app.web.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody final UserDto userDto) {
        System.out.println("YES");
        return new ResponseEntity<>(toDto(userService.create(toModel(userDto))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> userDtos = userService.getUsers().stream().map(this::toDto).collect(toList());
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(String id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Builder
    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .deleted(user.isDeleted())
                .build();
    }

    public User toModel(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .createdAt(userDto.getCreatedAt())
                .updatedAt(userDto.getUpdatedAt())
                .deleted(userDto.isDeleted())
                .build();
    }

}
