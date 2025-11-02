package com.champsoft.milestone.PresentationLayer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScreeningSummary {

    private int screeningId;
    private String day;
    private int screeningHour;
    private int projectionRoomNumber;

}
