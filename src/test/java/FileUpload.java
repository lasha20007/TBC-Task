import io.qameta.allure.Description;
import org.junit.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FileUpload {

    String homePageUrl = "http://the-internet.herokuapp.com/";


    @Test
    @Description("This method uploads file and checks if the file is uploaded successfully")
    public void fileUploadTest() {

        open(homePageUrl);
        $(byText("File Upload")).click();

        File file = new File("andromeda.jpg");

        $("#file-upload").uploadFile(file);
        $(".button").click();
        $("#uploaded-files").shouldHave(text(file.getName()));

        sleep(3000);

    }
}
