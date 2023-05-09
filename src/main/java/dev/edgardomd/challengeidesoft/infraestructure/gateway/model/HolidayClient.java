package dev.edgardomd.challengeidesoft.infraestructure.gateway.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class HolidayClient {

    private LocalDate date;
    private String title;
    private String type;
    private boolean inalienable;
    private String extra;

}
