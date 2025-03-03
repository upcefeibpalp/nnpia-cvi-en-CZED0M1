package cz.upce.fei.nnpiacv.service;

import cz.upce.fei.nnpiacv.domain.User;
import cz.upce.fei.nnpiacv.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
    }

    public User findUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        log.debug("User requested: {}", user.orElse(null));

        return user.orElse(null);
    }

    public Collection<User> findUsers() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        User DbUser = this.findUser(id);
        DbUser.setEmail(user.getEmail());
        DbUser.setPassword(user.getPassword());
        userRepository.save(DbUser);
        return DbUser;
    }
}
