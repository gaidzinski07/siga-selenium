package page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestMethodOrder(OrderAnnotation.class)
public class AdicionarResponsavelPageTest {
	public WebDriver driver;
	protected Wait<WebDriver> wait;
	private String baseUrl;
	private AdicionarResponsavelPage page;
	
	@BeforeEach
	public void initTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		baseUrl = "https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/sigawf/app/responsavel/novo";
		String firstUrl = "https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/sigawf/app/responsavel/listar";
		String loginUrl = "https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/siga/";
		page = PageFactory.initElements(driver, AdicionarResponsavelPage.class);
		page.navigateToPage(loginUrl, firstUrl);
	}
	
	@AfterEach
	public void finishTest() {
		driver.close();
		page = null;
	}
	
	@Test
	@Order(1)
	public void testCasoFeliz() {
		List<WebElement> before = driver.findElements(By.tagName("tr"));
		driver.get(baseUrl);
		page = PageFactory.initElements(driver, AdicionarResponsavelPage.class);
		page.preencherNomeDescricacao("João", "Organizador de Arquivos");
		page.submit();
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.get("https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/sigawf/app/responsavel/listar");
		List<WebElement> after = driver.findElements(By.tagName("tr"));
		System.out.println(before.size() + " || " + after.size());
		assertTrue(before.size() < after.size());
	}
	
	@Test
	@Order(2)
	public void testNomeVazio() {
		List<WebElement> before = driver.findElements(By.tagName("tr"));
		driver.get(baseUrl);
		page = PageFactory.initElements(driver, AdicionarResponsavelPage.class);
		page.preencherNomeDescricacao("", "Organizador de Arquivos");
		page.submit();
		//String msg = page.lerAlert();
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.get("https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/sigawf/app/responsavel/listar");
		List<WebElement> after = driver.findElements(By.tagName("tr"));
		System.out.println(before.size() + " || " + after.size());
		assertEquals(before.size(), after.size());
		//assertEquals(page.ERRO_CAMPOS_INVALIDOS, msg);
	}
	
	@Test
	@Order(3)
	public void testNomeMaiorQueOitenta() {
		List<WebElement> before = driver.findElements(By.tagName("tr"));
		driver.get(baseUrl);
		page = PageFactory.initElements(driver, AdicionarResponsavelPage.class);
		page.preencherNomeDescricacao("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "Organizador de Arquivos");
		page.submit();
		//String msg = page.lerAlert();
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.get("https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/sigawf/app/responsavel/listar");
		List<WebElement> after = driver.findElements(By.tagName("tr"));
		System.out.println(before.size() + " || " + after.size());
		assertEquals(before.size(), after.size());
		//assertEquals(page.ERRO_CAMPOS_INVALIDOS, msg);
	}
	
	@Test
	@Order(4)
	public void testDescricaoMaiorQueOitenta() {
		List<WebElement> before = driver.findElements(By.tagName("tr"));
		driver.get(baseUrl);
		page = PageFactory.initElements(driver, AdicionarResponsavelPage.class);
		page.preencherNomeDescricacao("Pedrinho", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		page.submit();
		//String msg = page.lerAlert();
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.get("https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/sigawf/app/responsavel/listar");
		List<WebElement> after = driver.findElements(By.tagName("tr"));
		System.out.println(before.size() + " || " + after.size());
		assertEquals(before.size(), after.size());
		//assertEquals(page.ERRO_CAMPOS_INVALIDOS, msg);
	}
	
	@Test
	@Order(5)
	public void testDescricaoVazia() {
		List<WebElement> before = driver.findElements(By.tagName("tr"));
		driver.get(baseUrl);
		page = PageFactory.initElements(driver, AdicionarResponsavelPage.class);
		page.preencherNomeDescricacao("Dimitri", "");
		page.submit();
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.get("https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/sigawf/app/responsavel/listar");
		List<WebElement> after = driver.findElements(By.tagName("tr"));
		System.out.println(before.size() + " || " + after.size());
		assertTrue(before.size() < after.size());
	}
	
	@Test
	@Order(6)
	public void testTudoVazio() {
		List<WebElement> before = driver.findElements(By.tagName("tr"));
		driver.get(baseUrl);
		page = PageFactory.initElements(driver, AdicionarResponsavelPage.class);
		page.preencherNomeDescricacao("", "");
		page.submit();
		//String msg = page.lerAlert();
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.get("https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/sigawf/app/responsavel/listar");
		List<WebElement> after = driver.findElements(By.tagName("tr"));
		System.out.println(before.size() + " || " + after.size());
		assertEquals(before.size(), after.size());
		//assertEquals(page.ERRO_CAMPOS_INVALIDOS, msg);
	}
	
}
