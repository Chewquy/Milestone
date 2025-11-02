package com.champsoft.milestone.BusinessLogicLayer;

import com.champsoft.milestone.DataAccessLayer.Movie;
import com.champsoft.milestone.DataAccessLayer.MovieRepository;
import com.champsoft.milestone.DataAccessLayer.Screening;
import com.champsoft.milestone.DataAccessLayer.ScreeningRepositery;
import com.champsoft.milestone.PresentationLayer.MovieRequestModel;
import com.champsoft.milestone.PresentationLayer.MovieResponseModel;
import com.champsoft.milestone.PresentationLayer.ScreeningResponseModel;
import com.champsoft.milestone.mappers.MovieMapper;
import com.champsoft.milestone.mappers.ScreeningMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {


    private final MovieRepository movieRepository;
    private final ScreeningRepositery screeningRepository;
    private final MovieMapper movieMapper;
    private final ScreeningMapper screeningMapper;

    public MovieService(MovieRepository movieRepository,
                        ScreeningRepositery screeningRepository,
                        MovieMapper movieMapper,
                        ScreeningMapper screeningMapper) {
        this.movieRepository = movieRepository;
        this.screeningRepository = screeningRepository;
        this.movieMapper = movieMapper;
        this.screeningMapper = screeningMapper;
    }

    // Return all movies as DTOs
    public List<MovieResponseModel> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        List<MovieResponseModel> responses = new ArrayList<>();
        for (Movie movie : movies) {
            responses.add(movieMapper.toResponse(movie));
        }
        return responses;
    }

    // Return a single movie as a DTO
    public MovieResponseModel getMovieById(int id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(movieMapper::toResponse).orElse(null);
    }

    // Create movie from a request model
    public MovieResponseModel createMovie(MovieRequestModel movieData) {
        Movie movie = movieMapper.fromRequestModelToEntity(movieData);
        return movieMapper.toResponse(movieRepository.save(movie));
    }

    // Update movie
    public MovieResponseModel updateMovie(int id, MovieRequestModel movieData) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        existingMovie.setName(movieData.getName());
        existingMovie.setSynopsis(movieData.getSynopsis());
        existingMovie.setGenre(movieData.getGenre());
        existingMovie.setReleaseYear(movieData.getReleaseYear());
        existingMovie.setDirector(movieData.getDirector());

        Movie updatedMovie = movieRepository.save(existingMovie);
        return movieMapper.toResponse(updatedMovie);
    }

    // Delete movie by ID
    public void deleteMovieById(int id) throws ScreeningNotFoundException {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ScreeningNotFoundException("Movie with id: " + id + " not found."));

        // Set movie_id = null for related screenings
        List<Screening> screenings = screeningRepository.findByMovieId(id);
        for (Screening screening : screenings) {
            screening.setMovie(null);
            screeningRepository.save(screening);
        }

        movieRepository.delete(movie);
    }

    // Get all screenings related to a specific movie
    public List<ScreeningResponseModel> getScreeningsByMovie(int movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        List<Screening> screenings = screeningRepository.findAll();
        List<ScreeningResponseModel> movieScreenings = new ArrayList<>();

        for (Screening screening : screenings) {
            if (screening.getMovie() != null && screening.getMovie().getId() == (movie.getId())) {
                movieScreenings.add(screeningMapper.toResponse(screening));
            }
        }
        return movieScreenings;
    }
}
