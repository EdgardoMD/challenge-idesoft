package dev.edgardomd.challengeidesoft.infraestructure.gateway.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class ApiHolidayResponse {
    private String status;
    private Collection<HolidayClient> data;
}
