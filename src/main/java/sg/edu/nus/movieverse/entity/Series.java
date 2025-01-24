package sg.edu.nus.movieverse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "series")
@Getter
@Setter
public class Series extends BaseEntity{

    @Column(nullable = false)
    private String name;

    private Date premiereDate;
    private Date finaleDate;

    @OneToMany(mappedBy = "series", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Season> seasons;
}
