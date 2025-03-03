package cz.upce.fei.nnpiacv.domain;

import cz.upce.fei.nnpiacv.dto.UserResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "app_user")
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NonNull
    private String email;
    @NonNull
    private String password;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private List<Role> roles;
}