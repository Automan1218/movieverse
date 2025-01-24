package sg.edu.nus.movieverse.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorite extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private FavoriteCategory category;

}
