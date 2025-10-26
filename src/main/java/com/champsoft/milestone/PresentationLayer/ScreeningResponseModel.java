package com.champsoft.milestone.PresentationLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScreeningResponseModel {
    private int screeningId;
    private String day;
    private int screeningHour;
    private int projectionRoomNumber;
    private MovieSummary movie;
}
