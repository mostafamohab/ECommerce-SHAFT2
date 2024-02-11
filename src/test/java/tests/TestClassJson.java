//Package that contains all test classes
package tests;

//Libraries Used
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;
import java.lang.reflect.Method;

//Main Class initialization as public class
public class TestClassJson {

	private SHAFT.GUI.WebDriver driver;
	private JSONFileManager testData;
	private String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

	private String Email = RandomEmailGeneratorpage.getComplexRandomEmail();
	private String Password;
	private String FirstName;
	private String LastName;
	private String Day;
	private String Month;
	private String Year;
	private String Company;
	private String Address;
	private String City;
	private String State;
	private String PostCode;
	private String Other;
	private String HomePhone;
	private String MobilePhone;

	@BeforeClass(alwaysRun = true,description = "Setup Test Data.")
	public void beforeClass(){
		testData = new JSONFileManager( className + ".json");
	}

	@BeforeMethod(alwaysRun = true,description = "Setup Browser instance.")
	public void setUp(Method method) {
		//Email = testData.getTestData(method.getName() + ".Email");
		Password = testData.getTestData(method.getName() + ".Password");
		FirstName = testData.getTestData(method.getName() + ".FirstName");
		LastName = testData.getTestData(method.getName() + ".LastName");
		Day = testData.getTestData(method.getName() + ".Day");
		Month = testData.getTestData(method.getName() + ".Month");
		Year = testData.getTestData(method.getName() + ".Year");
		Company = testData.getTestData(method.getName() + ".Company");
		Address = testData.getTestData(method.getName() + ".Address");
		City = testData.getTestData(method.getName() + ".City");
		State = testData.getTestData(method.getName() + ".State");
		PostCode = testData.getTestData(method.getName() + ".PostCode");
		Other = testData.getTestData(method.getName() + ".Other");
		HomePhone = testData.getTestData(method.getName() + ".HomePhone");
		MobilePhone = testData.getTestData(method.getName() + ".MobilePhone");

		driver = new SHAFT.GUI.WebDriver();
		new HomePage(driver)
                .navigate();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-09")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 9,description = "Sign Up")
	public void signUp() {
		// Create an object from Homepage Class
		// Click on Sign Up Button

		new HomePage(driver)
            .navigate()
			.clickSignUp()
			.emailSignup(Email)
			.clickCreateAccount();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-10")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 10,description = "Create New Account")
	public void createAccount() throws IOException {

        new HomePage(driver)
            .navigate()
            .clickSignUp()
            .emailSignup(Email)
            .clickCreateAccount();

		new CreateAccountpage(driver)
			.chooseMale()
			.enterFirstName(FirstName)
			.enterLastName(LastName)
			.clickEmail()
			.enterPassword(Password)
			.selectDay(Day)
			.selectMonth(Month)
			.selectYear(Year)
			.clickCheckBox1()
			.submit()
			.signOut();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-11")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 11,description = "Sign In")
	public void signIn() throws IOException {

		new HomePage(driver)
            .navigate()
            .clickSignUp()
			.enterEmailSignin(Email)
			.enterPasswordSignin(Password)
			.clickSignIn();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-12")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 12,description = "Add to Cart")
	public void addToCart() {

        new HomePage(driver)
            .navigate()
            .clickSignUp()
            .enterEmailSignin(Email)
            .enterPasswordSignin(Password)
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
	@TmsLink("TC-13")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 13,description = "Cart Check Out")
	public void cartCheckOut() {

        new HomePage(driver)
                .navigate()
                .clickSignUp()
                .enterEmailSignin(Email)
                .enterPasswordSignin(Password)
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
    @TmsLink("TC-14")
    @Epic("SHAFT Web GUI Template")
    @Test(priority = 14,description = "Cart Check Out")
    public void createAddress() throws IOException {

        new HomePage(driver)
                .navigate()
                .clickSignUp()
                .enterEmailSignin(Email)
                .enterPasswordSignin(Password)
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

        new CreateAddresspage(driver)
                .enterCompany(Company)
                .enterAddress(Address)
                .enterCity(City)
                .enterState(State)
                .enterPostCode(PostCode)
                .enterOtherInfo(Other)
                .enterHomePhone(HomePhone)
                .enterMobilePhone(MobilePhone)
                .save();

        new Blousespage(driver)
			.clickCheckOut3()
			.clickCheckBox()
			.clickCheckOut4()
			.clickBankWire()
			.confirmOrder();
	}

    @Story("ECommerce Basic Validations")
    @TmsLink("TC-15")
    @Epic("SHAFT Web GUI Template")
    @Test(priority = 15,description = "Cart Check Out with valid address")
    public void cartCheckOut2() {

        new HomePage(driver)
                .navigate()
                .clickSignUp()
                .enterEmailSignin(Email)
                .enterPasswordSignin(Password)
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
	@TmsLink("TC-16")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 16,description = "Check Order Details")
	public void checkOrderDetails() {

        new HomePage(driver)
           .navigate()
           .clickSignUp()
           .enterEmailSignin(Email)
           .enterPasswordSignin(Password)
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