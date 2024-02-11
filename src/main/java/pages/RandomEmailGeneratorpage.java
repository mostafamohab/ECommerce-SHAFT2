//Package that contains all project main classes
package pages;

//Libraries Used
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomEmailGeneratorpage {

	// Create an Object from WebDriver GUI Interface
	private SHAFT.GUI.WebDriver driver;

	// Constructor
	public RandomEmailGeneratorpage(SHAFT.GUI.WebDriver driver) {
		this.driver = driver;
	}

	// Methods

	@Step("Function that Generates Ranodom Email")
	public synchronized static String getComplexRandomEmail() {
		String lowerCharacters = "abcdefghijklmnopqrstuvwxyz";
		String upperCharacters = "ACDEFGHIJKLMNOPQRSTUVWXYZ";
		String numberCharacters = "0123456789";

		return RandomStringUtils.random(3, lowerCharacters)
				+	RandomStringUtils.random(3,upperCharacters)
				+	RandomStringUtils.random(3,numberCharacters)
				+	System.currentTimeMillis()
				+"@mail.com";

	}
}