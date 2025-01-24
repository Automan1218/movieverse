package sg.edu.nus.movieverse.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@Getter
@Setter
public class Movie extends BaseEntity{
    @Column(nullable = false)
    private String title;

    private int releaseYear;
    private double rating;
    private int ratingCount;

    @Column(columnDefinition = "TEXT")
    private String description;

    private boolean isDeleted = false;

    @ManyToOne
    @JoinColumn(name = "prequel")
    private Movie prequel;

    @ManyToOne
    @JoinColumn(name = "sequel")
    private Movie sequel;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "genreId")
    )
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "movie_starredby",
            joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "actorId")
    )
    private List<Actor> actors;

    @ManyToMany
    @JoinTable(
            name = "movie_directedby",
            joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "directorId")
    )
    private List<Director> directors;

    @ManyToMany
    @JoinTable(
            name = "movie_producedby",
            joinColumns = @JoinColumn(name = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "producerId")
    )
    private List<Producer> producers;
}
