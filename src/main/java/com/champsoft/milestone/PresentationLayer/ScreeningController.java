package com.champsoft.milestone.PresentationLayer;


import com.champsoft.milestone.BusinessLogicLayer.InvalidScreeningDataException;
import com.champsoft.milestone.BusinessLogicLayer.ScreeningService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "https://jazzy-babka-92a27a.netlify.app")
@RestController
@RequestMapping("/screenings")
public class ScreeningController {

    private final ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {

        this.screeningService = screeningService;
    }

    // GET all screenings
    @GetMapping
    public List<ScreeningResponseModel> getScreenings() {
        return this.screeningService.getScreenings();

    }

    // GET single screening by ID
    @GetMapping("/{id}")
    public ScreeningResponseModel getScreeningById(@PathVariable String id) {
        return this.screeningService.getScreeningById(id);

    }

    // POST create new screening
    @PostMapping
    public ScreeningResponseModel createScreening(@RequestBody ScreeningRequestModel screeningData) throws InvalidScreeningDataException {

        return this.screeningService.createScreening(screeningData);
    }

    // PUT update screening
    @PutMapping("/{id}")
    public ScreeningResponseModel updateScreening(@PathVariable String id, @RequestBody ScreeningRequestModel screeningData) throws InvalidScreeningDataException {
        return this.screeningService.updateScreening(id, screeningData);
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
