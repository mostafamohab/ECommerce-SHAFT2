//Package that contains all test classes
package tests;

//Libraries Used
import java.io.IOException;
import java.util.ArrayList;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.ExcelFileManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


//Main Class initialization as public class
public class TestClassExcel {

	private SHAFT.GUI.WebDriver driver;
	private ExcelFileManager testData;
	private String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");
	private DataDriven d = new DataDriven();
	private String Email = RandomEmailGeneratorpage.getComplexRandomEmail();

	@BeforeClass(alwaysRun = true,description = "Setup Test Data.")
	public void beforeClass(){
		testData = new ExcelFileManager( className + ".xlsx");
	}

	@BeforeMethod(alwaysRun = true,description = "Setup Browser instance.")
	public void setUp() throws IOException {
		driver = new SHAFT.GUI.WebDriver();

		new HomePage(driver)
                .navigate();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-01")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 1,description = "Sign Up")
	public void signUp() throws IOException {
		// create an object from dataDriven class
		ArrayList<String> data;
		data = d.getData("Signup6");

		new HomePage(driver)
            .navigate()
			.clickSignUp()
			.emailSignup(Email)
			.clickCreateAccount();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-02")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 2,description = "Create New Account")
	public void createAccount() throws IOException {
        new HomePage(driver)
            .navigate()
            .clickSignUp()
            .emailSignup(Email)
            .clickCreateAccount();

		// create a new arraylist of strings in order to extract test data from excel
		ArrayList<String> data;
		data = d.getData("Register6");

		new CreateAccountpage(driver)
			.chooseMale()
			.enterFirstName(data.get(3))
			.enterLastName(data.get(4))
			.clickEmail()
			.enterPassword(data.get(2))
			.selectDay(data.get(5))
			.selectMonth(data.get(6))
			.selectYear(data.get(7))
			.clickCheckBox1()
			.submit()
			.signOut();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-03")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 3,description = "Sign In")
	public void signIn() throws IOException {
		// create a new arraylist of strings in order to extract test data from excel
		ArrayList<String> data;
		data = d.getData("Login6");

		new HomePage(driver)
            .navigate()
            .clickSignUp()
			.enterEmailSignin(Email)
			.enterPasswordSignin(data.get(2))
			.clickSignIn();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-04")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 4,description = "Add to Cart")
	public void addToCart() throws IOException {
        // create a new arraylist of strings in order to extract test data from excel
        ArrayList<String> data;
		data = d.getData("Login6");

		new HomePage(driver)
            .navigate()
            .clickSignUp()
            .enterEmailSignin(Email)
            .enterPasswordSignin(data.get(2))
            .clickSignIn();

		new MyAccountpage(driver)
			.hoverOnWomen()
			.clickBlouses();

		new Blousespage(driver)
			.hoverOnItem()
			.clickOnMore()
            .changeColor()
            .changeColor()
            .changeColor()
			.addtoCart();

	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-05")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 5,description = "Cart Check Out")
	public void cartCheckout() throws IOException {
        // create a new arraylist of strings in order to extract test data from excel
        ArrayList<String> data;
		data = d.getData("Login6");

		new HomePage(driver)
                .navigate()
                .clickSignUp()
                .enterEmailSignin(Email)
                .enterPasswordSignin(data.get(2))
                .clickSignIn();

        new MyAccountpage(driver)
                .hoverOnWomen()
                .clickBlouses();

        new Blousespage(driver)
                .hoverOnItem()
                .clickOnMore()
                .changeColor()
                .changeColor()
                .changeColor()
                .addtoCart();

        new Blousespage(driver)
                .clickCheckOut1()
                .clickCheckOut2();
    }

    @Story("ECommerce Basic Validations")
    @TmsLink("TC-06")
    @Epic("SHAFT Web GUI Template")
    @Test(priority = 6,description = "Cart Check Out")
    public void createAddress() throws IOException {
        // create a new arraylist of strings in order to extract test data from ex
        ArrayList<String> data;
		data = d.getData("Login6");

		new HomePage(driver)
                .navigate()
                .clickSignUp()
                .enterEmailSignin(Email)
                .enterPasswordSignin(data.get(2))
                .clickSignIn();

        new MyAccountpage(driver)
                .hoverOnWomen()
                .clickBlouses();

        new Blousespage(driver)
                .hoverOnItem()
                .clickOnMore()
                .changeColor()
                .changeColor()
                .changeColor()
                .addtoCart();

        new Blousespage(driver)
                .clickCheckOut1()
                .clickCheckOut2();

        // create a new arraylist of strings in order to extract test data from excel
        data = d.getData("Register6");

        new CreateAddresspage(driver)
                .enterCompany(data.get(8))
                .enterAddress(data.get(9))
                .enterCity(data.get(10))
                .enterState(data.get(11))
                .enterPostCode(data.get(12))
                .enterOtherInfo(data.get(13))
                .enterHomePhone(data.get(14))
                .enterMobilePhone(data.get(15))
                .save();

        new Blousespage(driver)
			.clickCheckOut3()
			.clickCheckBox()
			.clickCheckOut4()
			.clickBankWire()
			.confirmOrder();
	}

    @Story("ECommerce Basic Validations")
    @TmsLink("TC-07")
    @Epic("SHAFT Web GUI Template")
    @Test(priority = 7,description = "Cart Check Out with valid address")
    public void cartCheckout2() throws IOException {
        // create a new arraylist of strings in order to extract test data from ex
        ArrayList<String> data;
		data = d.getData("Login6");

		new HomePage(driver)
                .navigate()
                .clickSignUp()
                .enterEmailSignin(Email)
                .enterPasswordSignin(data.get(2))
                .clickSignIn();

        new MyAccountpage(driver)
                .hoverOnWomen()
                .clickBlouses();

        new Blousespage(driver)
                .hoverOnItem()
                .clickOnMore()
                .changeColor()
                .changeColor()
                .changeColor()
                .addtoCart();

        new Blousespage(driver)
                .clickCheckOut1()
                .clickCheckOut2()
                .clickCheckOut3()
                .clickCheckBox()
                .clickCheckOut4()
                .clickBankWire()
                .confirmOrder();
    }

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-08")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 8,description = "Check Order Details")
	public void checkOrderDetails() throws IOException {
    // create a new arraylist of strings in order to extract test data from excel
    	ArrayList<String> data;
		data = d.getData("Login6");

		new HomePage(driver)
           .navigate()
           .clickSignUp()
           .enterEmailSignin(Email)
           .enterPasswordSignin(data.get(2))
           .clickSignIn();

		new MyAccountpage(driver)
			.clickAccount()
			.clickHistory();

		new Blousespage(driver)
			.verifyOrderPlaced();
    }

	@AfterMethod(description = "Teardown Browser instance.")
	public void tearDown() {
			driver.quit();
	}

}