package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.domain.User;
import cz.upce.fei.nnpiacv.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public User findUser(@PathVariable Long id) {
        return userService.findUser(id);
    }

/*
    @GetMapping("/user")
    public User findUser(@RequestParam Long id) {
        return userService.findUser(id);
    }
    */

    @GetMapping("/user")
    public Collection<User> findUsers() {

        return userService.findUsers();
    }
}
