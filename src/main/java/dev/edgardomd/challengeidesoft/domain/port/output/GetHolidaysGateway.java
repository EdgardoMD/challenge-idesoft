package dev.edgardomd.challengeidesoft.domain.port.output;

import dev.edgardomd.challengeidesoft.domain.model.Holiday;

import java.util.Collection;

public interface GetHolidaysGateway {
    Collection<Holiday> execute();
}
