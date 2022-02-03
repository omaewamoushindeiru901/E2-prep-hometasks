package hw2;

import java.time.LocalDate;
import java.time.Period;

@FunctionalInterface
public interface CountPeriod {
    Period countPeriod(LocalDate start, LocalDate end);
}
