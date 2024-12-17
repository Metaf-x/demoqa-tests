package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class RandomBirthday {

    private final int minAge;
    private final int maxAge;
    private final Faker faker;

    /**
     * Generates a random birthday date within the specified age range.
     *
     * @param minAge The minimum age for the birthday.
     * @param maxAge The maximum age for the birthday.
     * @throws IllegalArgumentException if minAge is greater than maxAge.
     */
    public RandomBirthday(int minAge, int maxAge) {
        if (minAge > maxAge) {
            throw new IllegalArgumentException("Start age must be before end age");
        }
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.faker = new Faker();
    }

    private LocalDate getDate() {
        return this.faker.date().birthday(this.minAge, this.maxAge).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    }

    public String getFormattedYear() {
        return getDate().format(DateTimeFormatter.ofPattern("yyyy", Locale.ENGLISH));
    }

    public String getFormattedMonth() {
        return getDate().format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH));
    }

    public String getFormattedDay() {
        return getDate().format(DateTimeFormatter.ofPattern("dd", Locale.ENGLISH));
    }
}
