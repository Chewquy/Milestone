package com.champsoft.milestone.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieResponseModel {

    private long id;
    private String name;
    private String synopsis;
    private String genre;
    private int releaseYear;
    private String director;

}
