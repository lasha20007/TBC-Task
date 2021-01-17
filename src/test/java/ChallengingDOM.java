import io.qameta.allure.Description;
import org.junit.Test;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class ChallengingDOM {

    String homePageUrl = "http://the-internet.herokuapp.com/";

    @Test
    @Description("Check for 0 in table at first line")
    public void table() {
        open(homePageUrl);
        $(byText("Challenging DOM")).click();

        List<String> list = $$(byXpath("//*/tbody/tr[1]/td")).texts();
        list.remove(list.size() - 1);

        for (String item: list
             ) {
            String last = item.substring(item.length() - 1);
            System.out.println(last);
            System.out.println(last.equals("0"));
        }
    }
}
