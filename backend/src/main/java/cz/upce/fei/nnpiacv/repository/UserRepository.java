package cz.upce.fei.nnpiacv.repository;

import cz.upce.fei.nnpiacv.domain.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> getUserById(long id);

    List<User> findUserByEmail(@NonNull String email);

    List<User> findUserById(long id);
}
