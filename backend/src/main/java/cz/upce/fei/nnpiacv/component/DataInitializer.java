package cz.upce.fei.nnpiacv.component;

import cz.upce.fei.nnpiacv.domain.Role;
import cz.upce.fei.nnpiacv.domain.User;
import cz.upce.fei.nnpiacv.repository.RoleRepository;
import cz.upce.fei.nnpiacv.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public DataInitializer(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository= roleRepository;
    }

    @Override
    public void run(String... args){
        userRepository.removeUserById(0L);
        User user = new User(0L,"admin@upce.cz","admin");

        Role role = new Role(0L, "ADMIN");
        roleRepository.save(role);
        user.setRoles(Collections.singletonList(role));

        if (!userRepository.existsById(user.getId())){
            log.debug("Admin user created{}", user);
            userRepository.save(user);
        }

    }
}
