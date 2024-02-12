package Pages;

import Base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class MobilePage extends TestBase {

    public MobilePage() throws IOException {
        // to define all element in this page
        PageFactory.initElements(driver, this);
    }


    JavascriptExecutor js =( (JavascriptExecutor) driver);
    @FindBy(xpath = "//select[@title='Sort By']")
    WebElement SortBy;

    @FindBy(xpath = "(//span[@class='price'])[3]")
    WebElement mobilePrice;

    @FindBy(id = "product-collection-image-1")
    WebElement phoneClick;

    @FindBy(xpath = "(//button[@class='button btn-cart'])[2]")
    WebElement addToCart;


    public String getMobilePageTitle(){
        return driver.getTitle();
    }

    public void selectSortByName(){
        Select select = new Select(SortBy);
        select.selectByVisibleText("Name");
        js.executeScript("arguments[0].style.border='5px solid red';", SortBy);
    }

    public String getMobilePrice(){
        return mobilePrice.getText();
    }

    public void clickOnXperiaPhone(){
        phoneClick.click();
    }

    public void clickOnAddToCart(){
        addToCart.click();
    }



}
