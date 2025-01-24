package sg.edu.nus.movieverse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "directors")
@Getter
@Setter
public class Director extends BaseEntity{
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "directors")
    private List<Movie> movies;
}
