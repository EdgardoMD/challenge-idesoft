package dev.edgardomd.challengeidesoft.infraestructure.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dev.edgardomd.challengeidesoft.domain.model.Holiday;
import dev.edgardomd.challengeidesoft.domain.port.output.GetHolidaysGateway;
import dev.edgardomd.challengeidesoft.domain.usecase.GetHolidaysUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class HolidayControllerTest {

    private GetHolidaysUseCase getHolidaysUseCase;

    @Mock
    private GetHolidaysGateway gateway;

    @BeforeEach
    public void setUp() {
        getHolidaysUseCase = new GetHolidaysUseCase(gateway);
    }

    @Test
    void should_return_holidays_collection() {
        //GIVEN
        int expectedSize = 1;
        Collection<Holiday> oneCollectionOfHoliday = addCollection();
        when(gateway.execute()).thenReturn(oneCollectionOfHoliday);

        //WHEN
        Collection<Holiday> response = getHolidaysUseCase.execute();

        //THEN
        assertEquals(expectedSize, response.size());
        verify(gateway, times(1)).execute();


    }

    private Collection<Holiday> addCollection() {
        Collection<Holiday> oneCollectionOfHoliday = new ArrayList<>();
        oneCollectionOfHoliday.add(Holiday.builder()
                .withDate(LocalDate.parse("2023-12-25"))
                .withType("Religioso")
                .withTiTle("Navidad")
                .withInalienable(true)
                .withExtra("Religioso e irrenunciable")
                .build());
        return oneCollectionOfHoliday;


    }

}