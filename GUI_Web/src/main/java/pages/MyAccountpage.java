//Package that contains all project main classes
package pages;

//Libraries Used
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MyAccountpage {

	// Create an Object from WebDriver GUI Interface
	private SHAFT.GUI.WebDriver driver;

	// Constructor
	public MyAccountpage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	// Locators
	// Store Xpath for Women Button on Menu
	private By Women = By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]");
	// Store Xpath for Blouses Submenu Under Women Button on Menu
	private By Blouses = By.xpath("//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Blouses')]");
	// Store Xpath for My Account containing username Label on upper right corner
	private By Account = By.xpath("//a[@class='account']");
	// Store Xpath for Order History and Details Button
	private By History = By.xpath("//span[contains(text(),'Order history and details')]");

	// Methods
	@Step("Function that returns xpath for Women Button on Menu")
	public MyAccountpage hoverOnWomen() {
		driver.element().hover(Women);
		return this;
	}

	@Step("Function that returns xpath for Blouses Submenu Under Women Button on Menu")
	public MyAccountpage clickBlouses() {
		driver.element().click(Blouses);
		return this;
	}

	@Step("Function that returns xpath for My Account containing username Label on upper right corner")
	public MyAccountpage clickAccount() {
		driver.element().click(Account);
		return this;
	}

	@Step("Function that returns xpath for Order History and Details Button")
	public MyAccountpage clickHistory() {
		driver.element().click(History);
		return this;
	}
}