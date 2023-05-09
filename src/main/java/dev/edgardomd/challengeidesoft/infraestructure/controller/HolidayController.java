package dev.edgardomd.challengeidesoft.infraestructure.controller;

import dev.edgardomd.challengeidesoft.domain.model.Holiday;
import dev.edgardomd.challengeidesoft.domain.port.input.GetHollidays;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    private final GetHollidays getHollidaysSortByType;

    public HolidayController(GetHollidays getHollidaysSortByType) {
        this.getHollidaysSortByType = getHollidaysSortByType;
    }

    @GetMapping
    public ResponseEntity<Collection<Holiday>> getAllHolidays() {
        return ResponseEntity.ok(getHollidaysSortByType.execute());
    }

    @GetMapping("/{type}")
    public ResponseEntity<Collection<Holiday>> getHolidaysByType(@PathVariable String type) {
        Collection<Holiday> holidays = getHollidaysSortByType.execute();
        Collection<Holiday> filteredHolidays = holidays.stream()
                .filter(holiday -> holiday.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredHolidays);
    }

    @GetMapping("/dateRange")
    public ResponseEntity<Collection<Holiday>> getHolidaysByDateRange(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        Collection<Holiday> holidays = getHollidaysSortByType.execute();
        Collection<Holiday> filteredHolidays = holidays.stream()
                .filter(holiday -> holiday.getDate().compareTo(start) >= 0 && holiday.getDate().compareTo(end) <= 0)
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredHolidays);
    }


}
