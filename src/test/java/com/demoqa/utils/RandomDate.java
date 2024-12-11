package com.demoqa.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {

    private LocalDate date;
    private LocalDate start;
    private LocalDate end;

    public RandomDate(LocalDate start) {
        this.start = start;
        this.date = this.getDate(this.start);
    }

    public RandomDate(LocalDate start, LocalDate end) {
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

    public String getDay() {
        return this.date.format(DateTimeFormatter.ofPattern("dd"));
    }

    public String getMonth() {
        return this.date.format(DateTimeFormatter.ofPattern("MMMM"));
    }

    public String getYear() {
        return this.date.format(DateTimeFormatter.ofPattern("yyyy"));
    }

}
