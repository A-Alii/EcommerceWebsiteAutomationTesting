package Pages;

import Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class CartPage extends TestBase {

    public CartPage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor js =( (JavascriptExecutor) driver);
    @FindBy(xpath = "//input[@title='Qty']")
    WebElement countInput;

    @FindBy(xpath = "(//button[@name='update_cart_action'])[4]")
    WebElement update;

    @FindBy(xpath = "//p[contains(@class,'item-msg')]")
    WebElement errorMessage;

    @FindBy(xpath = "//button[@title='Empty Cart']")
    WebElement emptyButton;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[1]/h1")
    WebElement emptyMessage;



    public void editCount() {
        countInput.clear();
        countInput.sendKeys("1000");
    }

    public void clickUpdate() {
        update.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }



    public void clickEmptyCart() {
        emptyButton.click();
    }

    public String getEmptyMessage() {
        js.executeScript("arguments[0].style.border='5px solid red';", emptyMessage);
        return emptyMessage.getText();
    }


}
