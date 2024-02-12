package TestCases;

import Base.TestBase;
import Pages.CartPage;
import Pages.HomePage;
import Pages.MobilePage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class CartPageTest extends TestBase {

    public CartPageTest() throws IOException {
        super();
    }

    MobilePage mobilePage;
    HomePage homePage;
    CartPage cartPage;

    @BeforeMethod
    public void beforeMethod(Method method) throws IOException {
        log = extentReports.startTest(method.getName());
        initialization();
        mobilePage = new MobilePage();
        homePage = new HomePage();
        cartPage = new CartPage();
        homePage.clickOnMobileMenu();

    }

    @AfterMethod
    public void afterMethod(Method method , ITestResult result) throws IOException {
        tearDown(method,result);
    }

    @Test(priority = 3)
    public void verifyYouCantAddToCartThanAvailable() throws IOException {
        mobilePage.clickOnAddToCart();
        cartPage.editCount();
        cartPage.clickUpdate();
        String ActualError = "* The maximum quantity allowed for purchase is 500.";
        Assert.assertEquals(ActualError,cartPage.getErrorMessage());
        cartPage.clickEmptyCart();
        String ActualEmpty = "SHOPPING CART IS EMPTY";
        Assert.assertEquals(ActualEmpty, cartPage.getEmptyMessage());
    }
}
