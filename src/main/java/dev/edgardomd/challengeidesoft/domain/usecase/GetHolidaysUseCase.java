package dev.edgardomd.challengeidesoft.domain.usecase;

import dev.edgardomd.challengeidesoft.domain.model.Holiday;
import dev.edgardomd.challengeidesoft.domain.port.input.GetHollidays;
import dev.edgardomd.challengeidesoft.domain.port.output.GetHolidaysGateway;

import java.util.Collection;

public class GetHolidaysUseCase implements GetHollidays {

    private final GetHolidaysGateway getHolidaysGateway;

    public GetHolidaysUseCase(GetHolidaysGateway getHolidaysGateway) {
        this.getHolidaysGateway = getHolidaysGateway;
    }

    @Override
    public Collection<Holiday> execute() {
        Collection<Holiday> holidays = getHolidaysGateway.execute();
        return holidays;
    }
}
