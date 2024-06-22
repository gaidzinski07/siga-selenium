package selenium;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import builder.AdicionarResponsavelBuilder;
import entity.AdicionarResponsavelEntity;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AdicionarResponsavelActionTest {
	
	public WebDriver driver;
	protected Wait<WebDriver> wait;
	private String baseUrl;
	
	@BeforeAll
	public void start() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		baseUrl = "https://8080-projetosiga-sigadocker-thm6nvg4wec.ws-us114.gitpod.io/sigawf/app/responsavel/listar";
	}
	
	@BeforeEach
	public void resetTest() {
		driver.get(baseUrl);
	}
	
	@Test
	public void testeCaminhoFeliz() {
		AdicionarResponsavelEntity entity = AdicionarResponsavelBuilder.get()
				.setNome("João")
				.setDescricao("Organizador de arquivos")
				.setTipo("Lotacao")
				.setLotacao("ZZ-LTEST")
				.build();
		//TODO Teste automatizado usando instancia acima
		driver.findElement(By.xpath("teste")).click();
	}

}
