package Pages;

import Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {

    public HomePage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='level0 ']")
    WebElement MobileMenu;


    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public void clickOnMobileMenu() throws IOException {
        MobileMenu.click();
    }

}
