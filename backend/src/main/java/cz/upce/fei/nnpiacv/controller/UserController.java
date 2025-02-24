package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.domain.User;
import cz.upce.fei.nnpiacv.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

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


    @GetMapping("/user")
    public Collection<User> findUser(@RequestParam(required=false) String email) {
        if(email==null) {
            return userService.findUsers();
        }else {
            return Collections.singletonList(userService.findByEmail(email));
        }
    }



}
