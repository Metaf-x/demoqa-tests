package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {

    private SelenideElement userName = $("#userName"),
            userEmail = $("#userEmail"),
            currentAddress = $("#currentAddress"),
            permanentAddress = $("#permanentAddress"),
            submitBtn = $("#submit");

    private SelenideElement outputName = $("#output #name"),
            outputEmail = $("#output #email"),
            outputCurrentAddress = $("#output #currentAddress"),
            outputPermanentAddress = $("#output #permanentAddress");


    public TextBoxPage openPage() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String value) {
        userName.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmail.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddress.setValue(value);
        return this;
    }

    public TextBoxPage submit() {
        submitBtn.click();
        return this;
    }

    public TextBoxPage resultName(String value) {
        outputName.shouldHave(text(value));
        return this;
    }

    public TextBoxPage resultEmail(String value) {
        outputEmail.shouldHave(text(value));
        return this;
    }

    public TextBoxPage resultCurrentAddress(String value) {
        outputCurrentAddress.shouldHave(text(value));
        return this;
    }

    public TextBoxPage resultPermanentAddress(String value) {
        outputPermanentAddress.shouldHave(text(value));
        return this;
    }
}
