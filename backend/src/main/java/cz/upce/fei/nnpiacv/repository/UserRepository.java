package cz.upce.fei.nnpiacv.repository;

import cz.upce.fei.nnpiacv.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    void removeUserById(long id);
}
