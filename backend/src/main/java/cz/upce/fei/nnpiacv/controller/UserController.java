package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.domain.User;
import cz.upce.fei.nnpiacv.dto.UserRequestDto;
import cz.upce.fei.nnpiacv.dto.UserResponseDto;
import cz.upce.fei.nnpiacv.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@Slf4j
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id) {
        return userService.findUser(id);
    }


    @GetMapping
    public Collection<User> findUser(@RequestParam(required=false) String email) {
        if(email==null) {
            return userService.findUsers();
        }else {
            return Collections.singletonList(userService.findByEmail(email));
        }
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDto user) {
        log.info("Request for creating user obtained {}", user);

        User createdUser = userService.createUser(new User(user.getEmail(), user.getPassword()));

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDto.builder()
                .id(createdUser.getId())
                .email(createdUser.getEmail())
                .password(createdUser.getPassword())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        log.info("Request for deleting user obtained");
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequestDto user) {
        log.info("Request for updating user obtained {}", user);

        User updatedUser = userService.updateUser(id, new User(user.getEmail(), user.getPassword()));

        return ResponseEntity.ok(UserResponseDto.builder()
                .email(updatedUser.getEmail())
                .password(updatedUser.getPassword())
                .build());
    }



}
