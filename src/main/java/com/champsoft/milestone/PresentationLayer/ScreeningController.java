package com.champsoft.milestone.PresentationLayer;


import com.champsoft.milestone.BusinessLogicLayer.InvalidScreeningDataException;
import com.champsoft.milestone.BusinessLogicLayer.ScreeningService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/screenings")
public class ScreeningController {

    private final ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {

        this.screeningService = screeningService;
    }

    // GET all screenings
    @GetMapping
    public Map<String, Object> getScreenings() {
        List<ScreeningResponseModel> screenings = this.screeningService.getScreenings();
        return Map.of(
                "status", "success",
                "message", "Screenings found",
                "data", screenings
        );
    }

    // GET single screening by ID
    @GetMapping("/{id}")
    public Map<String, Object> getScreeningById(@PathVariable String id) {
        ScreeningResponseModel screening = this.screeningService.getScreeningById(id);
        return Map.of(
                "status", "success",
                "message", "Screening found",
                "data", screening
        );
    }

    // POST create new screening
    @PostMapping
    public Map<String, Object> createScreening(@RequestBody ScreeningRequestModel screeningData) throws InvalidScreeningDataException {
        ScreeningResponseModel savedScreening = this.screeningService.createScreening(screeningData);
        Map<String, Object> result;

        if (savedScreening != null) {
            result = Map.of(
                    "status", "success",
                    "message", "Screening created successfully",
                    "newScreening", savedScreening,
                    "id", savedScreening.getScreeningId()
            );
        } else {
            result = Map.of(
                    "status", "failure",
                    "message", "Could not be saved in database"
            );
        }
        return result;
    }

    // PUT update screening
    @PutMapping("/{id}")
    public Map<String, Object> updateScreening(@PathVariable String id, @RequestBody ScreeningRequestModel screeningData) throws InvalidScreeningDataException {
        ScreeningResponseModel updatedScreening = this.screeningService.updateScreening(id, screeningData);
        return Map.of(
                "status", "success",
                "message", "Screening updated successfully",
                "id", id,
                "updatedData", updatedScreening
        );
    }

    // DELETE screening by ID
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteScreening(@PathVariable int id) {
        this.screeningService.deleteScreeningById(id);
        return Map.of(
                "status", "success",
                "message", "Screening deleted successfully",
                "id", id
        );
    }
}
