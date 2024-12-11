package com.demoqa.testdata;

import com.demoqa.utils.RandomDate;
import com.github.javafaker.Faker;

import java.time.LocalDate;

public class RegistrationData {

    Faker faker = new Faker();
    RandomDate randomBirthday = new RandomDate(LocalDate.of(1900, 1, 1));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            address = faker.address().fullAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            subjects = faker.options().option("Computer Science", "Social Studies", "English", "Chemistry"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            birthDay = randomBirthday.getDay(),
            birthMonth = randomBirthday.getMonth(),
            birthYear = randomBirthday.getYear(),
            phone = faker.numerify("79########"),
            image = faker.options().option("test-img.jpg", "2.jpg", "3.jpg"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
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
