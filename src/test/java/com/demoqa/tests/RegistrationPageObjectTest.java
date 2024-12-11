package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class RegistrationPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillAllFieldsTest() {
        registrationPage.openPage()
                .removeBlockingElements()
                .setFirstName("Jane")
                .setLastName("Doe")
                .setEmail("jana@test.com")
                .setGender("Female")
                .setNumber("1234567890")
                .setDateOfBirth("04", "May", "2014")
                .setSubjects("Computer Science")
                .setHobbies("Sports")
                .setImagePath("test-img.jpg")
                .setAddress("17926 Eleanora Islands")
                .setState("NCR")
                .setCity("Delhi")
                .submit();

        registrationPage
                .submissionCheckSuccess()
                .submissionModalMessage("Thanks for submitting the form");

        registrationPage
                .checkResultTablePairs("Student Name", "Jane Doe")
                .checkResultTablePairs("Student Email", "jana@test.com")
                .checkResultTablePairs("Gender", "Female")
                .checkResultTablePairs("Mobile", "1234567890")
                .checkResultTablePairs("Date of Birth", "04 May,2014")
                .checkResultTablePairs("Subjects", "Computer Science")
                .checkResultTablePairs("Hobbies", "Sports")
                .checkResultTablePairs("Picture", "test-img.jpg")
                .checkResultTablePairs("Address", "17926 Eleanora Islands")
                .checkResultTablePairs("State and City", "NCR Delhi");
//      sleep(600_000);
    }

    @Test
    void fillRequiredFieldsTest() {
        registrationPage
                .openPage()
                .setFirstName("Jane")
                .setLastName("Doe")
                .setGender("Female")
                .setNumber("1234567890")
                .submit();

        registrationPage
                .submissionCheckSuccess()
                .submissionModalMessage("Thanks for submitting the form");

        registrationPage
                .checkResultTablePairs("Student Name", "Jane Doe")
                .checkResultTablePairs("Gender", "Female")
                .checkResultTablePairs("Mobile", "1234567890");
    }

    @Test
    void shortPhoneNumberTest() {
        registrationPage
                .openPage()
                .setFirstName("Jane")
                .setLastName("Doe")
                .setGender("Female")
                .setNumber("123456789")
                .submit();

        registrationPage
                .submissionCheckFail();

    }
}