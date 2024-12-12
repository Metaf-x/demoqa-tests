package com.demoqa.testdata;

import com.demoqa.utils.RandomDate;
import com.github.javafaker.Faker;

import java.time.LocalDate;

public class RegistrationData {

    private static final String[] GENDERS = {"Male", "Female", "Other"};
    private static final String[] SUBJECTS = {"Computer Science", "Social Studies", "English", "Chemistry"};
    private static final String[] HOBBIES = {"Sports", "Reading", "Music"};
    private static final String[] IMAGES = {"test-img.jpg", "2.jpg", "3.jpg"};
    private static final String[] STATES = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

    Faker faker = new Faker();
    RandomDate randomBirthday = new RandomDate(LocalDate.of(1900, 1, 1));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            address = faker.address().fullAddress(),
            gender = faker.options().option(GENDERS),
            subjects = faker.options().option(SUBJECTS),
            hobbies = faker.options().option(HOBBIES),
            birthDay = randomBirthday.getFormattedDay(),
            birthMonth = randomBirthday.getFormattedMonth(),
            birthYear = randomBirthday.getFormattedYear(),
            phone = faker.numerify("79########"),
            image = faker.options().option(IMAGES),
            state = faker.options().option(STATES),
            city = getRandomCity(state);

    private String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("State " + state + " is not on the list");
        };
    }

    public String shortPhoneInvalid = faker.numerify("79#######");
}
