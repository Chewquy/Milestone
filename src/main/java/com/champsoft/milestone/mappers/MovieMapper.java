package com.champsoft.milestone.mappers;

import com.champsoft.milestone.DataAccessLayer.Movie;
import com.champsoft.milestone.PresentationLayer.MovieRequestModel;
import com.champsoft.milestone.PresentationLayer.MovieResponseModel;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieResponseModel toResponse(Movie movie) {
        return new MovieResponseModel(
                movie.getId(),
                movie.getName(),
                movie.getSynopsis(),
                movie.getGenre(),
                movie.getReleaseYear(),
                movie.getDirector()
        );
    }

    public Movie fromRequestModelToEntity(MovieRequestModel model) {
        Movie movie = new Movie();
        movie.setName(model.getName());
        movie.setSynopsis(model.getSynopsis());
        movie.setGenre(model.getGenre());
        movie.setReleaseYear(model.getReleaseYear());
        movie.setDirector(model.getDirector());
        return movie;
    }
}
