package cz.upce.fei.nnpiacv.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "app_user")
@NoArgsConstructor
public class User {
    @Id
    private long id;
    @Column(unique = true)
    private String email;
    private String password;


    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private List<Role> roles;

    public User(long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }
}