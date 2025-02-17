package cz.upce.fei.nnpiacv.service;

import cz.upce.fei.nnpiacv.domain.User;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final Map<Long,User> users = new HashMap<>();

    @PostConstruct
    public void init() {
        User user1 = new User(0L,"pepe@bomba.cz","admin");
        User user2 = new User(1L,"thomas@bomba.cz","admin2");

        users.put(user1.getId(),user1);
        users.put(user2.getId(),user2);
    }

    public User findUser(Long id) {
        log.debug("User requested: {}", users.get(id).toString());

        return users.get(id);
    }

    public Collection<User> findUsers() {
        return users.values();
    }
}
