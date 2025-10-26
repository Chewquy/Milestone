package com.champsoft.milestone.BusinessLogicLayer;


import com.champsoft.milestone.DataAccessLayer.Movie;
import com.champsoft.milestone.DataAccessLayer.MovieRepository;
import com.champsoft.milestone.DataAccessLayer.Screening;
import com.champsoft.milestone.DataAccessLayer.ScreeningRepositery;
import com.champsoft.milestone.PresentationLayer.ScreeningRequestModel;
import com.champsoft.milestone.PresentationLayer.ScreeningResponseModel;
import com.champsoft.milestone.mappers.ScreeningMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class ScreeningService {

        private final ScreeningRepositery screeningRepository;
        private final MovieRepository movieRepository;
        private final MovieService movieService;
        private final ScreeningMapper screeningMapper;

        public ScreeningService(ScreeningRepositery screeningRepository,
                                MovieRepository movieRepository,
                                MovieService movieService,
                                ScreeningMapper screeningMapper) {
            this.screeningRepository = screeningRepository;
            this.movieRepository = movieRepository;
            this.movieService = movieService;
            this.screeningMapper = screeningMapper;
        }

        public List<ScreeningResponseModel> getScreenings() {
            List<Screening> screenings = screeningRepository.findAll();
            List<ScreeningResponseModel> screeningResponseModels = new ArrayList<>();

            for (Screening screening : screenings) {
                screeningResponseModels.add(screeningMapper.toResponse(screening));
            }

            return screeningResponseModels;
        }

        public ScreeningResponseModel getScreeningById(String id) {
            int idParsed = Integer.parseInt(id);
            Optional<Screening> filteredScreening = screeningRepository.findById(idParsed);
            return screeningMapper.toResponse(filteredScreening.get());
        }

    public ScreeningResponseModel createScreening(ScreeningRequestModel request) {
        // Fetch the real Movie from the DB
        Movie movie = movieRepository.findById(request.getMovieId())
                .orElseThrow(() -> new IllegalArgumentException("Movie not found with id: " + request.getMovieId()));

        // Map and attach movie
        Screening screening = screeningMapper.fromRequestModelToEntity(request);
        screening.setMovie(movie);

        // Save and return
        Screening saved = screeningRepository.save(screening);
        return screeningMapper.toResponse(saved);
    }

        public ScreeningResponseModel updateScreening(String id, ScreeningRequestModel screeningData)
                throws InvalidScreeningDataException {

            long idParsed = Long.parseLong(id);
            Screening existingScreening = screeningRepository.findAll().stream()
                    .filter(s -> s.getScreeningId() == idParsed)
                    .findFirst()
                    .orElse(null);

            existingScreening.setDay(screeningData.getDay());
            existingScreening.setScreeningHour(screeningData.getScreeningHour());
            existingScreening.setProjectionRoomNumber(screeningData.getProjectionRoomNumber());
            existingScreening.setMovie(movieRepository.findById(screeningData.getMovieId()).get());

            if (existingScreening.getScreeningHour() < 0 || existingScreening.getScreeningHour() > 23) {
                throw new InvalidScreeningDataException("Invalid screening hour (must be 0–23)");
            }
            if (existingScreening.getProjectionRoomNumber() <= 0) {
                throw new InvalidScreeningDataException("Room number must be positive");
            }

            return screeningMapper.toResponse(screeningRepository.save(existingScreening));
        }

        public void deleteScreeningById(int id) {
            screeningRepository.deleteById(id);
        }
    }

