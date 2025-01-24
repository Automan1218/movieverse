package sg.edu.nus.movieverse.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "season")
@Getter
@Setter
public class Season extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "seriesId", nullable = false)
    private Series series;

    private int installment;
    private Date premiereDate;
    private Date finaleDate;

    @OneToMany(mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episode> episodes;

    @ManyToMany
    @JoinTable(
            name = "season_producedby",
            joinColumns = @JoinColumn(name = "seasonId"),
            inverseJoinColumns = @JoinColumn(name = "producerId")
    )
    private List<Producer> producers;
}
