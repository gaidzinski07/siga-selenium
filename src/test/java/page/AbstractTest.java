package page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest<T> {
	
	private WebDriver driver;
	protected Wait<WebDriver> wait;
	private String baseUrl;
	private T page;
	
	public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		baseUrl = "https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/siga";
		driver.get(baseUrl);
		//page = PageFactory.initElements(driver, T);
	}
	
}