package com.demoqa.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {

    private static final DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("dd");
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("MMMM");
    private static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yyyy");

    private LocalDate date;
    private LocalDate start;
    private LocalDate end;

    public RandomDate(LocalDate start) {
        this.start = start;
        this.date = this.getDate(this.start);
    }

    public RandomDate(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        this.start = start;
        this.end = end;
        this.date = this.getDate(this.start, this.end);
    }

    public LocalDate getDate(LocalDate startInclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public LocalDate getDate(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    public String getFormattedDay() {
        return this.date.format(DAY_FORMATTER);
    }

    public String getFormattedMonth() {
        return this.date.format(MONTH_FORMATTER);
    }

    public String getFormattedYear() {
        return this.date.format(YEAR_FORMATTER);
    }

}
