package com.champsoft.milestone;

import com.champsoft.milestone.DataAccessLayer.Movie;
import com.champsoft.milestone.DataAccessLayer.MovieRepository;
import com.champsoft.milestone.DataAccessLayer.Screening;
import com.champsoft.milestone.DataAccessLayer.ScreeningRepositery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MilestoneApplication implements CommandLineRunner {

    private final ScreeningRepositery screeningRepositery;
    private final MovieRepository movieRepository;
    private static final Logger log = LoggerFactory.getLogger(MilestoneApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(MilestoneApplication.class, args);
        log.info("Milestone Application Started");
    }

    public MilestoneApplication(ScreeningRepositery screeningRepositery, MovieRepository movieRepository) {
        this.screeningRepositery = screeningRepositery;
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Movies
        Movie movie1 = movieRepository.save(new Movie("Iron Man", "Iron man saves the world", "Action", 2012, "Podz"));
        Movie movie2 = movieRepository.save(new Movie("Vendre ou Renover: The Movie", "Will you choose to sell or renovate that house?", "Reality", 2001, "Jean-François Provencal"));
        Movie movie3 = movieRepository.save(new Movie("The Lost Signal", "A hacker uncovers a digital ghost haunting the network", "Thriller", 2020, "Chloé Lambert"));
        Movie movie4 = movieRepository.save(new Movie("Frozen Ashes", "A detective trapped in the Arctic must solve a series of murders", "Mystery", 2018, "Marc-André Boucher"));
        Movie movie5 = movieRepository.save(new Movie("Echoes of Tomorrow", "Time travelers attempt to rewrite history", "Sci-Fi", 2023, "Sophie Gagnon"));
        Movie movie6 = movieRepository.save(new Movie("La Poutine Fatale", "A chef’s secret recipe sparks chaos in Quebec City", "Comedy", 2019, "Luc Tremblay"));
        Movie movie7 = movieRepository.save(new Movie("Beneath the Maple", "A family drama set in rural Quebec", "Drama", 2015, "Anne-Marie Lavoie"));
        Movie movie8 = movieRepository.save(new Movie("Neon Streets", "A police officer fights corruption in a cyberpunk Montreal", "Action", 2021, "Olivier Rousseau"));
        Movie movie9 = movieRepository.save(new Movie("Silent Harmony", "Two musicians reconnect through a mysterious melody", "Romance", 2017, "Isabelle Fortin"));
        Movie movie10 = movieRepository.save(new Movie("Quantum Café", "A barista discovers her café is a portal through time", "Fantasy", 2024, "Philippe Côté"));

// Screenings (20 total)
        screeningRepositery.save(new Screening("Monday", 14, 1, movie1));
        screeningRepositery.save(new Screening("Tuesday", 16, 2, movie1));
        screeningRepositery.save(new Screening("Wednesday", 19, 3, movie2));
        screeningRepositery.save(new Screening("Friday", 20, 4, movie3));
        screeningRepositery.save(new Screening("Saturday", 13, 5, movie3));
        screeningRepositery.save(new Screening("Sunday", 15, 6, movie4));
        screeningRepositery.save(new Screening("Monday", 18, 1, movie5));
        screeningRepositery.save(new Screening("Thursday", 21, 2, movie5));
        screeningRepositery.save(new Screening("Saturday", 12, 3, movie6));
        screeningRepositery.save(new Screening("Friday", 17, 4, movie6));
        screeningRepositery.save(new Screening("Sunday", 11, 5, movie7));
        screeningRepositery.save(new Screening("Tuesday", 19, 6, movie7));
        screeningRepositery.save(new Screening("Monday", 14, 7, movie8));
        screeningRepositery.save(new Screening("Wednesday", 16, 8, movie8));
        screeningRepositery.save(new Screening("Thursday", 20, 9, movie8));
        screeningRepositery.save(new Screening("Friday", 13, 1, movie9));
        screeningRepositery.save(new Screening("Saturday", 18, 2, movie9));
        screeningRepositery.save(new Screening("Sunday", 15, 3, movie9));
        screeningRepositery.save(new Screening("Monday", 19, 4, movie10));
        screeningRepositery.save(new Screening("Thursday", 21, 5, movie10));

    }


}
