//Package that contains all project main classes
package pages;

//Libraries Used
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Results {

    // Create an Object from WebDriver GUI Interface
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By resultStats = By.id("result-stats");

    // Constructor
    public Results(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    // Methods
    @Step("Then the result stats will show some data (will not be empty).")
    public Results assertResultStatsIsNotEmpty(){
        driver.assertThat().element(resultStats).text().doesNotEqual("")
                .withCustomReportMessage("Check that result stats is not empty").perform();
        return this;
    }
}
