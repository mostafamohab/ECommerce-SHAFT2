//Package that contains all project main classes
package pages;

//Libraries Used
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Blousespage {

	// Create an Object from WebDriver GUI Interface
	private SHAFT.GUI.WebDriver driver;

	// Constructor
	public Blousespage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	//Locators
	// Store Xpath for Item
	private By Item = By.xpath("//a[@title='Blouse'][@class='product_img_link']");

	// Store Xpath for different Colour
	private By Color = By.xpath("//a[@title='White']");
	// Store Xpath for More Button
	private By More = By.xpath("(//span[contains(text(),'More')][1])[1]");
	// Store Xpath for Add to Cart Button
	private By Addtocart = By.xpath("(//span[contains(text(),'Add to cart')][1])");
	// Store Xpath for Proceed to Check Out First Button
	private By Checkout1 = By.xpath("(//span[contains(text(),'Proceed to checkout')][1])");
	// Store Xpath for Proceed to Check Out Second Button (Summary)
	private By Checkout2 = By.xpath("(//span[contains(text(),'Proceed to checkout')][1][1])[2]");
	// Store Xpath for Proceed to Check Out Third Button (Address)
	private By Checkout3 = By.xpath("(//span[contains(text(),'Proceed to checkout')][1])[2]");
	// Store Xpath for agree to the terms and conditions Checkbox
	private By Checkbox = By.xpath("//input[@id='cgv']");
	// Store Xpath for Check Out Fourth Button (Shipping)
	private By Checkout4 = By.xpath("//button[@name='processCarrier']");
	// Store Xpath for Pay by Bank Wire Button (Payment)
	private By Bankwire = By.xpath("//a[@class='bankwire']");
	// Store Xpath for Confirm Order Button after Choosing payment Method (Payment)
	private By Confirmorder = By.xpath("(//button[@type='submit'][1])[2]");
	// Store Xpath for Order Details (Plus) Button under order reference table label
	private By Details = By.xpath("//span[@class='footable-toggle']");
	// Store CSS for Product Decription Field content for order history
	private By Productdesc = By.cssSelector("#order-detail-content > table > tbody > tr > td.bold > label");
	// Store Xpath for Order Details Button
	private By Details2 = By.xpath("//tbody/tr[1]/td[7]/a[1]/span[1]");
	// Store Xpath for Order Reference Text that contains Reorder Button and Order Status
	private By Orderplaced = By.xpath("//div[@id='block-history']//p");

	//Methods
	@Step("Function that returns xpath for Item")
	public Blousespage hoverOnItem() {
		driver.element().hover(Item);
		return this;
	}

	@Step("Function that returns xpath for More Button")
	public Blousespage clickOnMore() {
		driver.element().click(More);
		return this;
	}

	@Step("Function that returns xpath for Changed Color")
	public Blousespage changeColor() {
		driver.element().click(Color);
		return this;
	}

	@Step("Function that returns xpath for Add to Cart Button")
	public Blousespage addtoCart() {
		driver.element().click(Addtocart);
		return this;
	}

	@Step("Function that returns xpath for Proceed to Check Out First Button")
	public Blousespage clickCheckOut1() {
		driver.element().waitToBeReady(Checkout1);
		driver.element().click(Checkout1);
		return this;
	}

	@Step("Function that returns xpath for Proceed to Check Out Second Button (Summary)")
	public Blousespage clickCheckOut2() {
		driver.element().click(Checkout2);
		return this;
	}

	@Step("Function that returns xpath for Proceed to Check Out Third Button (Address)")
	public Blousespage clickCheckOut3() {
		driver.element().click(Checkout3);
		return this;
	}

	@Step("Function that returns xpath for agree to the terms and conditions Checkbox")
	public Blousespage clickCheckBox() {
		driver.element().click(Checkbox);
		return this;
	}

	@Step("Function that returns xpath for Check Out Fourth Button (Shipping)")
	public Blousespage clickCheckOut4() {
		driver.element().click(Checkout4);
		return this;
	}

	@Step("Function that returns xpath for Pay Blousespage Bank Wire Button (Payment)")
	public Blousespage clickBankWire() {
		driver.element().click(Bankwire);
		return this;
	}

	@Step("Function that returns xpath for Confirm Order Button after Choosing payment Method (Payment)")
	public Blousespage confirmOrder() {
		driver.element().clickAndHold(Confirmorder);
		return this;
	}

	@Step("Function that returns xpath for Order Details (Plus) Button under order reference table label")
	public Blousespage clickDetails() {
		driver.element().click(Details);
		return this;
	}

	@Step("Function that returns CSS for Product Decription Field content for order history")
	public Blousespage hoverOnProductDesc() {
		driver.element().hover(Productdesc);
		return this;
	}

	@Step("Function that returns xpath for Order Details Button")
	public Blousespage clickDetails2() {
		driver.element().click(Details2);
		return this;
	}

	@Step("Function that returns xpath for Order Status text label")
	public Blousespage verifyOrderPlaced() {
		String Expectedproductstatus = "placed";
		try {
			// Compare Variable for Order Status with the Status Placed
			driver.verifyThat().element(Orderplaced).textTrimmed().contains(Expectedproductstatus).perform();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Order is Successfully Placed");
		}
		return this;
	}
}
