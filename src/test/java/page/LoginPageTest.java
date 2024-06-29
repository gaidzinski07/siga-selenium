package page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	
	public WebDriver driver;
	protected Wait<WebDriver> wait;
	private String baseUrl;
	private LoginPage page;
	
//	@BeforeEach
//	public void initTest() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
//		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
//		baseUrl = "https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/siga/";
//		driver.get(baseUrl);
//		page = PageFactory.initElements(driver, LoginPage.class);
//	}
//	
//	@AfterEach
//	public void finishTest() {
//		driver.close();
//		page = null;
//	}
//	
//	@Test
//	public void testeLoginVazio() {
//		page.preencherCampos("", "");
//		page.submit();
//		assertEquals(page.ERROR_MESSAGE_VAZIO, page.loginResult());
//	}
//	
//	@Test
//	public void testeLoginErrado() {
//		page.preencherCampos("MatriculaErrada123", "SenhaErrada123");
//		page.submit();
//		assertEquals(page.ERROR_MESSAGE_INVALIDO, page.loginResult());
//	}
//	
//	@Test
//	public void testeLoginCerto() {
//		page.preencherCampos(page.VALID_USERNAME, page.VALID_PASSWORD);
//		page.submit();
//		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
//		assertEquals(page.SUCCESS_MESSAGE, page.loginResult());
//	}

}
