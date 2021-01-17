import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ShiftingContent {

    String homePageUrl = "http://the-internet.herokuapp.com/";

    @Test
    @Description("Check hover for Home button")
    public void home() {

        open(homePageUrl);
        $(byText("Shifting Content")).click();
        $(withText("Menu Element")).click();

        String fontSize = $(byText("Home")).getCssValue("font-size");
        $(byText("Home")).hover().shouldNotHave(Condition.cssValue("font-size", fontSize));
        
        sleep(3000);

    }

    @Test
    @Description("Check for change an image position")
    public void image() {

        open(homePageUrl);
        $(byText("Shifting Content")).click();
        $(withText("An image")).click();

        String position = $(".shift").getCssValue("left");
        $(byAttribute("href", "/shifting_content/image?pixel_shift=100")).click();
        $(".shift").shouldNotHave(Condition.cssValue("left", position));

        sleep(3000);

    }
}
