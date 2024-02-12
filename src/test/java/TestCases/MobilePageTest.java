package TestCases;

import Base.TestBase;
import Pages.DetailedMobilePage;
import Pages.HomePage;
import Pages.MobilePage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class MobilePageTest extends TestBase{
    public MobilePageTest() throws IOException {
        super();
    }
    MobilePage mobilePage;
    HomePage homePage;
    DetailedMobilePage detailedMobilePage;

    @BeforeMethod
    public void beforeMethod(Method method) throws IOException {
        log = extentReports.startTest(method.getName());
        initialization();
        mobilePage = new MobilePage();
        homePage = new HomePage();
        detailedMobilePage = new DetailedMobilePage();

    }

    @AfterMethod
    public void afterMethod(Method method , ITestResult result) throws IOException {

        tearDown(method,result);

    }

    @Test (priority = 1)
    public void verifyItemsOnMobilePageCanStoreByName() throws IOException {
        String Actual = "Home page";
        Assert.assertEquals(Actual,homePage.getHomePageTitle() , "HOME PAGE TITLE PRINTED......");
        homePage.clickOnMobileMenu();
        String ActualMobile = "Mobile";
        Assert.assertEquals(ActualMobile,mobilePage.getMobilePageTitle(), "MOBILE PAGE TITLE PRINTED......");
        mobilePage.selectSortByName();
    }

    @Test (priority = 2)
    public void verifyCostOfProduct() throws IOException {
        homePage.clickOnMobileMenu();
        String Actual = mobilePage.getMobilePrice();
        mobilePage.clickOnXperiaPhone();
        String Expected = detailedMobilePage.getDetailedMobilePrice();
        Assert.assertEquals(Actual,Expected);
    }

}
