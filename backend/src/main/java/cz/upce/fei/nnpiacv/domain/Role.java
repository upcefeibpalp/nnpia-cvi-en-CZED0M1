package cz.upce.fei.nnpiacv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;


import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    private Long id;

    private String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {

    }
}
