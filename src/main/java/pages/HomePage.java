//Package that contains all project main classes
package pages;

//Libraries Used
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage {

    // Create an Object from WebDriver GUI Interface
    private SHAFT.GUI.WebDriver driver;

    // Constructor
    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    // Locators
    // Store Xpath for Signin button
    private By Signup = By.xpath("//a[@class='login']");
    // Store Xpath for Email Text Field above Sign Up Button
    private By Emailsignup = By.xpath("//input[@id='email_create']");
    // Store Xpath for Create account Button Field
    private By Createaccountbutton = By.xpath("//button[@id='SubmitCreate']//span");

    private By emptyspace = By.xpath("//div[@class='submit']");
    // Store Xpath for Email Text Field above Password Text Field and Sign In Button
    private By Emailsignin = By.xpath("//input[@id='email']");
    // Store Xpath for Password Text Field above Sign In Button
    private By Passwordsignin = By.xpath("//input[@id='passwd']");
    // Store Xpath for Sign In Button
    private By Signin = By.xpath("//p[@class='submit']//span[1]");

    private String url = "http://www.automationpractice.pl/index.php";
    private String title = "Google";

    // Methods
    @Step("When I navigate to the Home page.")
    public HomePage navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("Then the browser title should be 'Google'.")
    public HomePage verifyBrowserTitleIsCorrect(){
        driver.verifyThat().browser().title().isEqualTo(title).perform();
        return this;
    }

    @Step("Function that returns xpath for Signin button in the Upper Right Corner for Homepage")
    public HomePage clickSignUp() {
        driver.element().click(Signup);
        return this;
    }

    @Step("Function that returns xpath for Email Text Field in Create New Account Section")
    public HomePage emailSignup(String text) {
        driver.element().type(Emailsignup,text);
        driver.element().click(emptyspace);
        return this;
    }

    @Step("Function that returns xpath for Create Account Button in Create New Account Section")
    public HomePage clickCreateAccount() {
        driver.element().waitToBeReady(Createaccountbutton,true);
        driver.element().click(Createaccountbutton);
        return this;
    }

    @Step("Function that returns xpath for Email Text Field above Password Text Field and Sign In Button")
    public HomePage enterEmailSignin(String text) {
        driver.element().waitToBeReady(Emailsignin,true);
        driver.element().type(Emailsignin,text);
        return this;
    }

    @Step("Function that returns xpath for Password Field above Sign In Button")
    public HomePage enterPasswordSignin(String text) {
        driver.element().type(Passwordsignin,text);
        return this;
    }

    @Step("Function that returns xpath for Signin button if user is already registered")
    public HomePage clickSignIn() {
        driver.element().click(Signin);
        return this;
    }
}
