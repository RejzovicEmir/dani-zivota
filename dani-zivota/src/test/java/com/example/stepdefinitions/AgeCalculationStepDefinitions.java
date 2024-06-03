package com.example.stepdefinitions;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AgeCalculationStepDefinitions {

    private LocalDate dateOfBirth;
    private long ageInDays;
    private String errorMessage;

    @Given("the user's date of birth is {string}")
    public void the_user_s_date_of_birth_is(String dob) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            this.dateOfBirth = LocalDate.parse(dob, formatter);

            if (this.dateOfBirth.isAfter(LocalDate.now())) {
                this.errorMessage = "Date of birth must be in the past";
            }
        } catch (Exception e) {
            this.errorMessage = "Invalid date format";
        }
    }

    @When("I calculate the age in days")
    public void i_calculate_the_age_in_days() {
        if (this.errorMessage == null) {
            this.ageInDays = ChronoUnit.DAYS.between(this.dateOfBirth, LocalDate.now());
        }
    }

    @Then("the age in days should be greater than 0")
    public void the_age_in_days_should_be_greater_than_0() {
        assertTrue(this.ageInDays > 0);
    }

    @Then("an error message {string} should be shown")
    public void an_error_message_should_be_shown(String expectedMessage) {
        assertEquals(expectedMessage, this.errorMessage);
    }
}
