package sg.edu.nus.movieverse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "actors")
@Getter
@Setter
@Data
public class Actor extends BaseEntity{

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
}