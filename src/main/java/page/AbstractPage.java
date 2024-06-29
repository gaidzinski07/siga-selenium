package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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

}
