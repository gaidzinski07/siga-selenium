package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import builder.AdicionarResponsavelBuilder;
import entity.AdicionarResponsavelEntity;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdicionarResponsavelAction {
	
	public WebDriver driver;
	protected Wait<WebDriver> wait;
	private String baseUrl;
	
	public AdicionarResponsavelAction(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		baseUrl = url;
	}
	
	public void resetTest(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		baseUrl = url;
		driver.get(baseUrl);
	}
	
	public void primeiroTeste() {
		resetTest(baseUrl);
		AdicionarResponsavelEntity entity = AdicionarResponsavelBuilder.get()
				.setNome("João")
				.setDescricao("Organizador de arquivos")
				.setTipo("Lotacao")
				.setLotacao("ZZ-LTEST")
				.build();
		runTestByInstance(entity);
	}
	
	private void runTestByInstance(AdicionarResponsavelEntity entity) {
		//TODO Teste automatizado usando instancia acima
	}
	
	
	public static void main(String[] args) {
		AdicionarResponsavelAction action = new AdicionarResponsavelAction("https://www.google.com");
		action.primeiroTeste();
	}
	
}
