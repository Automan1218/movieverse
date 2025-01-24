package sg.edu.nus.movieverse.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@Getter
@Setter
public class Role extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String name;

    @OneToOne(mappedBy = "role", cascade = CascadeType.ALL)
    private User user;
}
