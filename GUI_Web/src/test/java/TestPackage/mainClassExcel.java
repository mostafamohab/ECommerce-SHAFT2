//Package that contains all test classes
package TestPackage;

//Libraries Used
import java.io.IOException;
import java.util.ArrayList;
import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.JavascriptExecutor;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


//Main Class initialization as public class
public class mainClassExcel {

	private SHAFT.GUI.WebDriver driver;
	private JSONFileManager testData;
	private String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");
	private dataDriven d = new dataDriven();


	@BeforeClass(description = "Setup Test Data.")
	public void beforeClass(){
		testData = new JSONFileManager( className + ".xlsx");
	}

	@BeforeMethod(description = "Setup Browser instance.")
	public void setUp() {
		driver = new SHAFT.GUI.WebDriver();
		new HomePage(driver).navigate();


		// Setting Chrome Window Size to be maximized
		driver.browser().maximizeWindow();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-001")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 1,description = "Sign Up")
	public void signUp() throws IOException {

		// create an object from dataDriven class
		// create a new arraylist of strings in order to extract test data from excel
		//dataDriven d = new dataDriven();
		ArrayList<String> data = d.getData("Signup6");

		// Create an object from javascript executor class
		// Use java script in order to scroll by mouse till elements appearing
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		// Create an object from Homepage Class
		// Click on Sign Up Button
		// Use java script in order to scroll by mouse till elements appearing
		new HomePage(driver)
			.clickSignUp();

		js.executeScript("window.scrollBy(0,100)", "");

		// Enter Valid Email Address
		new HomePage(driver)
			.emailSignup(data.get(1))
			.clickCreateAccount();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-002")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 2,description = "Create New Account")
	public void createAccount() throws IOException {

		// create an object from dataDriven class
		//dataDriven d = new dataDriven();

		// create a new arraylist of strings in order to extract test data from excel
		ArrayList<String> data = d.getData("Register6");

		// Create an object from CreateAccountPage Class
		// Click on Male Radio Button as a Gender
		// Enter First Name
		// Enter Last Name
		// Enter Password
		// Select Day from Calendar
		// Select Month from Calendar
		// Select Year
		// Click on Sign Up for News Letter Checkbox
		// Click on Recieve Offers Checkbox
		// Enter Company
		// Enter Address
		// Select City
		// Select State
		// Enter Postal
		// Enter Additional Information
		// Enter Homephone
		// Enter Mobile Number
		// Press on Register Button after filling all required data
		// Click on Sign out Button
		new CreateAccountpage(driver)
			.chooseMale()
			.enterFirstName(data.get(3))
			.enterLastName(data.get(4))
			.enterPassword(data.get(2))
			.selectDay(data.get(5))
			.selectMonth(data.get(6))
			.selectYear(data.get(7))
			.clickCheckBox1()
			.clickCheckBox2()
			.enterCompany(data.get(8))
			.enterAddress(data.get(9))
			.enterCity(data.get(10))
			.enterState(data.get(11))
			.enterPostCode(data.get(12))
			.enterOtherInfo(data.get(13))
			.enterHomePhone(data.get(14))
			.enterMobilePhone(data.get(15))
			.submit()
			.signOut();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-003")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 3,description = "Sign In")
	public void signIn() throws IOException {

		// create an object from dataDriven class
		// create a new arraylist of strings in order to extract test data from excel
		//dataDriven d = new dataDriven();
		ArrayList<String> data = d.getData("Login6");

		// Create an object from Homepage Class
		// Enter Valid Email
		// Enter Valid Password
		// Press on Sign in Button
		new HomePage(driver)
			.enterEmailSignin(data.get(1))
			.enterPasswordSignin(data.get(2))
			.clickSignIn();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-004")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 4,description = "Add to Cart")
	public void addToCart() {

		// Create an object from javascript executor class
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Create an object from MyAccountPage Class
		// Hover on Women Button on Menu
		// Click on Blouse Sub Menu under Women Button from Menu Section
		new MyAccountpage(driver)
			.hoverOnWomen()
			.clickBlouses();

		// Create an object from Blouses Page Class
		// Hover on Item by Mouse Action
		new Blousespage(driver)
			.hoverOnItem();

		// Use java script in order to scroll by mouse till elements appearing
		js.executeScript("window.scrollBy(0,500)", "");

		// Hover on Item by Mouse Action and Click on More Button
		new Blousespage(driver)
			.clickOnMore();

		// Use java script in order to scroll by mouse till elements appearing
		js.executeScript("window.scrollBy(0,350)", "");

		// Hover on Add to Cart Button and Click on It
		new Blousespage(driver)
			.addtoCart();

	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-005")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 5,description = "Cart Check Out")
	public void cartCheckout() {

		// Create an object from javascript executor class
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Create an object from Blouses Page Class
		// Use Explicit Wait in order for First Checkout button to appear in Screen
		// Move and Click by Mouse on First Checkout Button Element
		// Move and Click by Mouse on Second Checkout Button Element
		new Blousespage(driver)
			.clickCheckOut1()
			.clickCheckOut2();

		// Use java script in order to scroll by mouse till elements appearing
		js.executeScript("window.scrollBy(0,500)", "");

		// Move and Click by Mouse on Third Checkout Button Element
		// Hover and Click by Mouse on agree to the terms and conditions Checkbox
		new Blousespage(driver)
			.clickCheckOut3()
			.clickCheckBox();

		// Use java script in order to scroll by mouse till elements appearing
		js.executeScript("window.scrollBy(0,500)", "");

		// Hover and Click by Mouse on Check Out Fourth Button (Shipping)
		new Blousespage(driver)
			.clickCheckOut4();

		// Use java script in order to scroll by mouse till elements appearing
		js.executeScript("window.scrollBy(0,500)", "");

		// Hover and Click by Mouse on Pay by Bank Wire Button (Payment)
		new Blousespage(driver)
			.clickBankWire();

		// Use java script in order to scroll by mouse till elements appearing
		js.executeScript("window.scrollBy(0,500)", "");

		// Hover and Click by Mouse on Confirm Order Button after Choosing payment
		// Method (Payment)
		new Blousespage(driver)
			.confirmOrder();
	}

	@Story("ECommerce Basic Validations")
	@TmsLink("TC-006")
	@Epic("SHAFT Web GUI Template")
	@Test(priority = 6,description = "Check Order Details")
	public void checkOrderDetails() {

		// Create an object from MyAccountPage Class
		// Hover and Click by Mouse on My Account that contains username Label on
		// upper right corner
		// Use java script in order to scroll by mouse till elements appearing
		// js.executeScript("window.scrollBy(0,500)", "");
		// Hover and Click by Mouse on Order History and Details Button
		new MyAccountpage(driver)
			.clickAccount()
			.clickHistory();

		// Create an object from Blouses Page Class
		// Hover and Click by Mouse on Order Details Button under order reference
		// table label
		// Hover and Click by Mouse on Order Details Button
		// Hover on Product Description Field for order history
		// Assertion with JUnit in order to check if order is placed or not and checking
		// if keyword "placed"
		// exists in order history to check if order was placed successfully or not
		// and printing Order is Successfully Placed in case of success
		new Blousespage(driver)
			.clickDetails()
			.clickDetails2()
			.hoverOnProductDesc()
			.verifyOrderPlaced();
	}

	@AfterMethod(description = "Teardown Browser instance.")
	public void tearDown() {
			driver.quit();
	}

}