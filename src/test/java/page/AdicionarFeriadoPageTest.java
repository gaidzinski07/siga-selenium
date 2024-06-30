package page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestMethodOrder(OrderAnnotation.class)
public class AdicionarFeriadoPageTest {
	
	public WebDriver driver;
	protected Wait<WebDriver> wait;
	private String baseUrl;
	private AdicionarFeriadoPage page;
	
	@BeforeEach
	public void initTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		baseUrl = "https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/siga/app/feriado/listar";
		String loginUrl = "https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/siga/";
		page = PageFactory.initElements(driver, AdicionarFeriadoPage.class);
		page.navigateToPage(loginUrl, baseUrl);
	}
	
	@AfterEach
	public void finishTest() {
		driver.close();
		page = null;
	}
	
	@Test()
	@Order(1)
	public void addFeriadoTest() {
		String nomeFeriado = "Dia das mães 2";
		List<String> before = page.tableContent();
		page.preencherFeriadoESubmeter(nomeFeriado);
		List<String> after = page.tableContent();
		assertTrue(after.contains(nomeFeriado));
		assertTrue(before.size() < after.size());
	}
	
	@Test
	@Order(2)
	public void deleteFeriadoTest() {
		List<String> before = page.tableContent();
		String nomeFeriado = page.deletarFeriado("Dia das mães 2");
		System.out.println(nomeFeriado);
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		List<String> after = page.tableContent();
		assertFalse(after.contains(nomeFeriado));
		assertTrue(before.size() > after.size());
	}
	
	@Test
	@Order(3)
	public void addFeriadoVazioTest() {
		page.preencherFeriadoESubmeter("");
		String msg = page.lerAlert();
		assertEquals(page.ERRO_NOME_FERIADO_VAZIO, msg);
	}
}
