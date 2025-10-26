package com.champsoft.milestone.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieSummary {
    private long id;
    private String name;
    private String genre;
    private int releaseYear;
}
