import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class testDemoqa {
    String firstName = "Serg";
    String lastName = "Grey";
    String userEmail = "grey@gmail.com";
    String userNumber = "85769042345";
    String currentAddress = "Moskow";
    String Subjects = "English";

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-2").doubleClick();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--020:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(Subjects).pressEnter();
        $("#hobbiesWrapper").$(new ByText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.jpeg");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Agra")).click();
        $("#submit").click();


        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Serg Grey"), text(userEmail), text("20 July,2000"), text("Male"), text(Subjects), text(currentAddress));

    }
}

