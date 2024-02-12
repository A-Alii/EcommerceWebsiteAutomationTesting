package Pages;

import Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class DetailedMobilePage extends TestBase {
    public DetailedMobilePage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }


    JavascriptExecutor js =( (JavascriptExecutor) driver);

    @FindBy(xpath = "//span[@class='price']")
    WebElement detailedMobilePrice;


    public String getDetailedMobilePrice(){
        js.executeScript("arguments[0].style.border='5px solid red';", detailedMobilePrice);
        return detailedMobilePrice.getText();
    }


}

