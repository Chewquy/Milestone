package com.champsoft.milestone.PresentationLayer;

import com.champsoft.milestone.BusinessLogicLayer.MovieService;
import com.champsoft.milestone.BusinessLogicLayer.ScreeningNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {

        this.movieService = movieService;
    }

    // GET all movies
    @GetMapping("/movies")
    public List<MovieResponseModel> getMovies() {
        return this.movieService.getMovies();
    }

    // GET movie by ID
    @GetMapping("/movies/{id}")
    public MovieResponseModel getMovieById(@PathVariable int id) {
        return this.movieService.getMovieById(id);
    }

    // POST create movie
    @PostMapping("/movies")
    public MovieResponseModel createMovie(@RequestBody MovieRequestModel movieData) {
        return this.movieService.createMovie(movieData);
    }

    // PUT update movie
    @PutMapping("/movies/{id}")
    public MovieResponseModel updateMovie(@PathVariable int id, @RequestBody MovieRequestModel movieData) {
        return this.movieService.updateMovie(id, movieData);
    }

    // DELETE movie
    @DeleteMapping("/movies/{id}")
    public Map<String, Object> deleteMovie(@PathVariable int id) throws ScreeningNotFoundException {
        this.movieService.deleteMovieById(id);
        return Map.of(
                "status", "success",
                "message", "Movie deleted successfully",
                "id", id

        );
    }

    // GET screenings for a specific movie
    @GetMapping("/movies/{id}/screenings")
    public List<ScreeningResponseModel> getScreeningsByMovie(@PathVariable int id) {
        return this.movieService.getScreeningsByMovie(id);
    }
}
