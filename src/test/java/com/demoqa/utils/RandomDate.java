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

    /**
     * Конструктор для генерации случайной даты, начиная с указанной даты до текущей даты.
     *
     * @param start начальная дата
     */
    public RandomDate(LocalDate start) {
        this.start = start;
        this.date = this.getDate(this.start);
    }

    /**
     * Конструктор для генерации случайной даты в указанном диапазоне.
     *
     * @param start начальная дата
     * @param end конечная дата
     */
    public RandomDate(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        this.start = start;
        this.end = end;
        this.date = this.getDate(this.start, this.end);
    }

    /**
     * Генерация случайной даты, начиная с указанной даты до текущей даты.
     *
     * @param startInclusive начальная дата
     * @return случайная дата
     */
    public LocalDate getDate(LocalDate startInclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    /**
     * Генерация случайной даты в указанном диапазоне.
     *
     * @param startInclusive начальная дата
     * @param endExclusive конечная дата
     * @return случайная дата
     */
    public LocalDate getDate(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }

    /**
     * Получение дня в формате "dd".
     *
     * @return день в формате "dd"
     */
    public String getFormattedDay() {
        return this.date.format(DAY_FORMATTER);
    }

    /**
     * Получение месяца в формате "MMMM".
     *
     * @return месяц в формате "MMMM"
     */
    public String getFormattedMonth() {
        return this.date.format(MONTH_FORMATTER);
    }

    /**
     * Получение года в формате "yyyy".
     *
     * @return год в формате "yyyy"
     */
    public String getFormattedYear() {
        return this.date.format(YEAR_FORMATTER);
    }

}
