package com.champsoft.milestone.DataAccessLayer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ScreeningId;

    @Column(name="screening")
    private String day;
    private int screeningHour;
    private int projectionRoomNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movieId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Movie movie;


    public Screening(String day, int screeningTime, int projectionRoomNumber, Movie movie) {
        this.day = day;
        this.screeningHour = screeningTime;
        this.projectionRoomNumber = projectionRoomNumber;
        this.movie = movie;
    }
}
