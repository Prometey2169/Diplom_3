package pojo;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String email;
    private String name;
    private String password;

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

}


