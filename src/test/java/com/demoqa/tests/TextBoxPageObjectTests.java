package com.demoqa.tests;

import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.Test;

public class TextBoxPageObjectTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .removeBlockingElements()
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submit();

        textBoxPage.resultName("Alex")
                .resultEmail("alex@egorov.com")
                .resultCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1");
    }
}