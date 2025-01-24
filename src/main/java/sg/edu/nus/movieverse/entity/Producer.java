package sg.edu.nus.movieverse.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "producers")
@Getter
@Setter
public class Producer extends BaseEntity{

    @Column(nullable = false)
    private String companyName;

    private String website;

    @ManyToMany(mappedBy = "producers")
    private List<Movie> movies;
}