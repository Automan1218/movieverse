package sg.edu.nus.movieverse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String name;

    @OneToOne(mappedBy = "role", cascade = CascadeType.ALL)
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
