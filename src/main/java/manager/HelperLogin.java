package manager;

import dto.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperLogin extends HelperBase{
    // cv726nkq1q@kzccv.com
    public HelperLogin(WebDriver driver){
        super(driver);
    }

    By OPEN_LOGIN_PAGE_BTN =
            By.xpath("//a[contains(text(), 'Log in')]");
    By INPUT_EMAIL = By.xpath("//input[@id='user']");
    By BTN_LOGIN = By.xpath("//input[@id='login']");
    By INPUT_PASSWORD = By.xpath("//input[@name='password']");
    By CONFIRM_PASSWORD_BTN =
            By.xpath("//button[@id='login-submit']");
    By TEXT_WORKSPACE_AFTER_LOGIN =
            By.xpath("//span[@data-testid='home-team-tab-name']");

    /*
    1. open sign up page
    2. enter email
    3. click on button continue
    4. enter password
    5. click continue login
    6. assert for workspace
    */

    public void login(UserDTO userDTO, WebDriverWait wait) {
        openLoginPage();
        enterEmailLogin(userDTO);
        clickContinueLogin();
        typePasswordLogin(userDTO, wait);
        clickConfirmPasswordButton();
    }

    public void openLoginPage(){
    click(OPEN_LOGIN_PAGE_BTN);
    }
    public void enterEmailLogin(UserDTO userDTO){
    type(INPUT_EMAIL,userDTO
            .getEmail());
    }


    public void clickContinueLogin() {
        click(BTN_LOGIN);
    }

    public void typePasswordLogin(UserDTO userDTO, WebDriverWait wait) {
        WebElement element =
                wait.until(ExpectedConditions
                        .visibilityOfElementLocated(INPUT_PASSWORD));
//        pause(5000);
        type(INPUT_PASSWORD, userDTO.getPassword());
    }

    public void clickConfirmPasswordButton(){
        click(CONFIRM_PASSWORD_BTN);
    }

    public void waitElement(By locator, int millis) {
        int counter = 0;
        WebElement el = null;
        try {
            el = driver.findElement(By.xpath(""));
        } catch (Exception e) {

        }
        while(el == null || counter < 30) {
            counter ++;
            pause(millis);
            try {
                el = driver.findElement(By.xpath(""));
            } catch (Exception e) {

            }
        }
    }

    public boolean validateLoginSuccess() {
        return isElementEnable(TEXT_WORKSPACE_AFTER_LOGIN);
    }

    public boolean validatePasswordInputEnable(WebDriverWait wait) {
        WebElement element =
                wait.until(ExpectedConditions
                        .visibilityOfElementLocated(INPUT_PASSWORD));
        return isElementEnable(INPUT_PASSWORD);
    }

}