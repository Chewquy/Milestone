package com.champsoft.milestone.mappers;

import com.champsoft.milestone.DataAccessLayer.Movie;
import com.champsoft.milestone.DataAccessLayer.Screening;
import com.champsoft.milestone.PresentationLayer.MovieSummary;
import com.champsoft.milestone.PresentationLayer.ScreeningRequestModel;
import com.champsoft.milestone.PresentationLayer.ScreeningResponseModel;
import org.springframework.stereotype.Component;

@Component
public class ScreeningMapper {

    public ScreeningResponseModel toResponse(Screening screening) {
        Movie movie = screening.getMovie();
        MovieSummary movieSummary;

        if (movie == null)
            movieSummary = null;
        else
            movieSummary = new MovieSummary(movie.getId(), movie.getName(), movie.getGenre(), movie.getReleaseYear());

        return new ScreeningResponseModel(
                screening.getScreeningId(),
                screening.getDay(),
                screening.getScreeningHour(),
                screening.getProjectionRoomNumber(),
                movieSummary
        );
    }

    public Screening fromRequestModelToEntity(ScreeningRequestModel model) {

        Screening screening = new Screening();
        screening.setDay(model.getDay());
        screening.setScreeningHour(model.getScreeningHour());
        screening.setProjectionRoomNumber(model.getProjectionRoomNumber());

        return screening;
    }
}
