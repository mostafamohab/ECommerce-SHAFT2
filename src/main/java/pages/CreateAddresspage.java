//Package that contains all project main classes
package pages;

//Libraries Used
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CreateAddresspage {

	// Create an Object from WebDriver GUI Interface
	private SHAFT.GUI.WebDriver driver;

	// Constructor
	public CreateAddresspage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	// Locators
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
	// Store Xpath for Save Button after filling all required data
	private By Save = By.xpath("//button[@id='submitAddress']");
	// Store Xpath for Signout Button
	private By Signout = By.xpath("//a[@class='logout']");


	// Methods
	@Step("Function that returns xpath for Company Text Field")
	public CreateAddresspage enterCompany(String text) {
		driver.element().type(Company,text);
		return this;
	}

	@Step("Function that returns xpath for Address Text Field")
	public CreateAddresspage enterAddress(String text) {
		driver.element().type(Address,text);
		return this;
	}

	@Step("Function that returns xpath for City Text Field")
	public CreateAddresspage enterCity(String text) {
		driver.element().type(City,text);
		return this;
	}

	@Step("Function that returns xpath for State Drop Down List Field")
	public CreateAddresspage enterState(String text) {
		driver.element().select(State,text);
		return this;
	}

	@Step("Function that returns xpath for Postcode Text Field")
	public CreateAddresspage enterPostCode(String text) {
		driver.element().type(Postcode,text);
		return this;
	}

	@Step("Function that returns xpath for Additional Information Text Field")
	public CreateAddresspage enterOtherInfo(String text) {
		driver.element().type(Other,text);
		return this;
	}

	@Step("Function that returns xpath for Home phone Text Field")
	public CreateAddresspage enterHomePhone(String text) {
		driver.element().type(Homephone,text);
		return this;
	}

	@Step("Function that returns xpath for Mobile phone Text Field")
	public CreateAddresspage enterMobilePhone(String text) {
		driver.element().type(Mobilephone,text);
		return this;
	}

	@Step("Function that returns xpath for Register Button after filling all required data")
	public CreateAddresspage save() {
		driver.element().click(Save);
		return this;
	}

	@Step("Function that returns xpath for Sign Out button")
	public CreateAddresspage signOut() {
		driver.element().click(Signout);
		return this;
	}
}