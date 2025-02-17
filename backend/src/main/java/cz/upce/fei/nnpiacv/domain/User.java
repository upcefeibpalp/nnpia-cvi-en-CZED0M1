package cz.upce.fei.nnpiacv.domain;

import lombok.*;

@Data
@AllArgsConstructor
public class User {
    private long id;
    private String email;
    private String password;
}