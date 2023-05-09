package dev.edgardomd.challengeidesoft.domain.port.input;

import dev.edgardomd.challengeidesoft.domain.model.Holiday;

import java.util.Collection;

public interface GetHollidays {

    Collection<Holiday> execute();
}
