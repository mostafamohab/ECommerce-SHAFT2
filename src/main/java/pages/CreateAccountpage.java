//Package that contains all project main classes
package pages;

//Libraries Used
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CreateAccountpage {

	// Create an Object from WebDriver GUI Interface
	private SHAFT.GUI.WebDriver driver;

	// Constructor
	public CreateAccountpage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	// Store Xpath for Male Radio Button Field
	private By Male = By.xpath("//label[@for='id_gender1']");
	// Store Xpath for Female Radio Button Field
	private By Female = By.xpath("//label[@for='id_gender2']");
	// Store Xpath for First Name Text Field
	private By Firstname = By.xpath("//input[@id='customer_firstname']");
	// Store Xpath for Last Name Text Field
	private By Lastname = By.xpath("//input[@id='customer_lastname']");

	// Store Xpath for Email Text Field
	private By Email = By.xpath("//input[@id='email']");

	// Store Xpath for Password Text Field
	private By Password = By.xpath("//input[@id='passwd']");
	// Store Xpath for Day Drop Down List Field
	private By Day = By.xpath("//select[@id='days']");
	// Store Xpath for Month Drop Down List Field
	private By Month = By.xpath("//select[@id='months']");
	// Store Xpath for Year Drop Down List Field
	private By Year = By.xpath("//select[@id='years']");
	// Store Xpath for Sign Up for News Letter Checkbox
	private By Checkbox1 = By.xpath("//input[@id='newsletter']");
	// Store Xpath for Recieve Special Offers Checkbox
	private By Checkbox2 = By.xpath("//input[@id='optin']");
	// Store Xpath for Company Text Field
	private By Company = By.xpath("//input[@id='company']");
	// Store Xpath for Address Text Field
	private By Address = By.xpath("//input[@id='address1']");
	// Store Xpath for City Text Field
	private By City = By.xpath("//input[@id='city']");
	// Store Xpath for State Drop Down List Field
	private By State = By.xpath("//select[@id='id_state']");
	// Store Xpath for Postcode Text Field
	private By Postcode = By.xpath("//input[@id='postcode']");
	// Store Xpath for Additional Information Text Field
	private By Other = By.xpath("//textarea[@id='other']");
	// Store Xpath for Home phone Text Field
	private By Homephone = By.xpath("//input[@id='phone']");
	// Store Xpath for Mobile phone Text Field
	private By Mobilephone = By.xpath("//input[@id='phone_mobile']");
	// Store Xpath for Register Button after filling all required data
	private By Submit = By.xpath("//button[@id='submitAccount']");
	// Store Xpath for Signout Button
	private By Signout = By.xpath("//a[@class='logout']");


	// Methods
	@Step("Function that returns xpath for Male Radio Button Field")
	public CreateAccountpage chooseMale() {
		driver.element().click(Male);
		return this;
	}

	@Step("Function that returns xpath for First Name Text Field")
	public CreateAccountpage enterFirstName(String text) {
		driver.element().type(Firstname,text);
		return this;
	}

	@Step("Function that returns xpath for Last Name Text Field")
	public CreateAccountpage enterLastName(String text) {
		driver.element().type(Lastname,text);
		return this;
	}

	@Step("Function that returns xpath for Email Text Field")
	public CreateAccountpage clickEmail() {
		driver.element().click(Email);
		return this;
	}

	@Step("Function that returns xpath for Password Text Field")
	public CreateAccountpage enterPassword(String text) {
		driver.element().typeSecure(Password,text);
		return this;
	}

	@Step("Function that returns xpath for Day Drop Down List Field")
	public CreateAccountpage selectDay(String text) {
		driver.element().select(Day,text);
		return this;
	}

	@Step("Function that returns xpath for Month Drop Down List Field")
	public CreateAccountpage selectMonth(String text) {
		driver.element().select(Month,text);
		return this;
	}

	@Step("Function that returns xpath for Year Drop Down List Field")
	public CreateAccountpage selectYear(String text) {
		driver.element().select(Year,text);
		return this;
	}

	@Step("Function that returns xpath for Sign Up for News Letter Checkbox")
	public CreateAccountpage clickCheckBox1() {
		driver.element().click(Checkbox1);
		return this;
	}

	@Step("Function that returns xpath for Recieve Special Offers Checkbox")
	public CreateAccountpage clickCheckBox2() {
		driver.element().click(Checkbox2);
		return this;
	}

	@Step("Function that returns xpath for Company Text Field")
	public CreateAccountpage enterCompany(String text) {
		driver.element().type(Company,text);
		return this;
	}

	@Step("Function that returns xpath for Address Text Field")
	public CreateAccountpage enterAddress(String text) {
		driver.element().type(Address,text);
		return this;
	}

	@Step("Function that returns xpath for City Text Field")
	public CreateAccountpage enterCity(String text) {
		driver.element().select(City,text);
		return this;
	}

	@Step("Function that returns xpath for State Drop Down List Field")
	public CreateAccountpage enterState(String text) {
		driver.element().type(State,text);
		return this;
	}

	@Step("Function that returns xpath for Postcode Text Field")
	public CreateAccountpage enterPostCode(String text) {
		driver.element().type(Postcode,text);
		return this;
	}

	@Step("Function that returns xpath for Additional Information Text Field")
	public CreateAccountpage enterOtherInfo(String text) {
		driver.element().type(Other,text);
		return this;
	}

	@Step("Function that returns xpath for Home phone Text Field")
	public CreateAccountpage enterHomePhone(String text) {
		driver.element().type(Homephone,text);
		return this;
	}

	@Step("Function that returns xpath for Mobile phone Text Field")
	public CreateAccountpage enterMobilePhone(String text) {
		driver.element().type(Mobilephone,text);
		return this;
	}

	@Step("Function that returns xpath for Register Button after filling all required data")
	public CreateAccountpage submit() {
		driver.element().click(Submit);
		return this;
	}

	@Step("Function that returns xpath for Sign Out button")
	public CreateAccountpage signOut() {
		driver.element().click(Signout);
		return this;
	}
}