package sg.edu.nus.movieverse.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "episode")
public class Episode extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "seasonId", nullable = false)
    private Season season;

    private int installment;
    private Date airDate;
    private int runtime;

    @ManyToMany
    @JoinTable(
            name = "episode_starredby",
            joinColumns = @JoinColumn(name = "episodeId"),
            inverseJoinColumns = @JoinColumn(name = "actorId")
    )
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(
            name = "episode_directedby",
            joinColumns = @JoinColumn(name = "episodeId"),
            inverseJoinColumns = @JoinColumn(name = "directorId")
    )
    private List<Director> directors;
}
