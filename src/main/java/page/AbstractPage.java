package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

//@Getter
//@Setter
public class AbstractPage {

	private WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToPage(String loginUrl, String urlDestino) {
		driver.get(loginUrl);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.preencherCampos(loginPage.VALID_USERNAME, loginPage.VALID_PASSWORD);
		loginPage.submit();
		driver.get(urlDestino);
	}
	
	public String lerAlert() {
		String str = driver.switchTo().alert().getText();
		System.out.println(str);
		return str;
	}
	
	public String lerModal(Wait<WebDriver> wait) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-dialog")));
		WebElement modalContainer = driver.findElement(By.xpath("/html/body/div[5]/div"));
		WebElement modalContentBody = modalContainer.findElement(By.xpath("/html/body/div[5]/div/div/div[2]"));
		return modalContentBody.getText();
	}

}
