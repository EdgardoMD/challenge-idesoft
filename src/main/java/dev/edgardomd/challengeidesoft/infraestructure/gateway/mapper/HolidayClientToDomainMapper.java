package dev.edgardomd.challengeidesoft.infraestructure.gateway.mapper;

import dev.edgardomd.challengeidesoft.domain.model.Holiday;
import dev.edgardomd.challengeidesoft.infraestructure.gateway.model.HolidayClient;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

@Component
public class HolidayClientToDomainMapper {

    public Collection<Holiday> execute(Collection<HolidayClient> holidayClients) {
        Collection<Holiday> holidays = new ArrayList<>();
        if (holidayClients != null) {
            for (HolidayClient holidayClient : holidayClients) {
                holidays.add(Holiday.builder()
                        .withDate(holidayClient.getDate())
                        .withTiTle(holidayClient.getTitle())
                        .withType(holidayClient.getType())
                        .withInalienable(holidayClient.isInalienable())
                        .withExtra(holidayClient.getExtra())
                        .build());
            }
        }
        return holidays;
    }
}
