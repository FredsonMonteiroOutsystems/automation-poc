package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import java.util.Base64;

public class PageBase {

    // Methods
    @Attachment(value = "Evidence image", type = "image/png")
    public byte[] saveScreenshot() {
        String screenshotAsBase64 = Selenide.screenshot(OutputType.BASE64);
        byte[] decoded = Base64.getDecoder().decode(screenshotAsBase64);
        return decoded;
    }
}
