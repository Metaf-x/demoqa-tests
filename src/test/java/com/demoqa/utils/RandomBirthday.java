package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RandomBirthday {
    private static final DateTimeFormatter DAY_FORMATTER = DateTimeFormatter.ofPattern("dd");
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("MMMM");
    private static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yyyy");

    private final int minAge;
    private final int maxAge;
    private final Faker faker;

    public RandomBirthday(int minAge, int maxAge) {
        if (minAge > maxAge) {
            throw new IllegalArgumentException("Start age must be before end age");
        }
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.faker = new Faker();
    }

    LocalDate getDate() {
        return this.faker.date().birthday(this.minAge, this.maxAge).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }

    String getFormattedYear() {
        return this.getDate().format(YEAR_FORMATTER);
    }

    String getFormattedMonth() {
            return this.getDate().format(MONTH_FORMATTER);
    }

    String getFormattedDay() {
        return this.getDate().format(DAY_FORMATTER);
    }
}
