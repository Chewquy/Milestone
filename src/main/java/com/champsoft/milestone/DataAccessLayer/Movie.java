package com.champsoft.milestone.DataAccessLayer;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String synopsis;
    private String genre;
    private int releaseYear;
    private String director;


    public Movie(String name, String synopsis, String genre, int releaseYear, String director) {
        this.name = name;
        this.synopsis = synopsis;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.director = director;
    }

}
