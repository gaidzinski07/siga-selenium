package page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestMethodOrder(OrderAnnotation.class)
public class CadastrarOcorrenciaFeriadoPageTest {
	
	public WebDriver driver;
	protected Wait<WebDriver> wait;
	private String baseUrl;
	private CadastrarOcorrenciaFeriadoPage page;
	
	@BeforeEach
	public void initTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		baseUrl = "https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/siga/app/feriado/editar-ocorrencia?id=12";
		String loginUrl = "https://8080-projetosiga-sigadocker-x5rdszc9ipl.ws-us114.gitpod.io/siga/";
		page = PageFactory.initElements(driver, CadastrarOcorrenciaFeriadoPage.class);
		page.navigateToPage(loginUrl, baseUrl);
	}
	
	@AfterEach
	public void finishTest() {
		driver.close();
		page = null;
	}
	
	@Test
	@Order(1)
	public void testarCamposVazios() {
		page.salvarOcorrenciaFeriado();
		String modalValue = page.lerModal(wait);
		assertEquals(page.ERRO_FORM_VAZIO, modalValue);
	}
	
	@Test
	@Order(2)
	public void testarDataInvalida1() {
		String dataInvalida = "32/01/1998";
		page.preencherCampos(dataInvalida, "", "", "", "", "");
		page.salvarOcorrenciaFeriado();
		String modalValue = page.lerModal(wait);
		assertEquals(page.ERRO_DATA_INVALIDA, modalValue);
	}
	
	@Test
	@Order(3)
	public void testarDataInvalida2() {
		String dataInvalida = "31/04/1998";
		page.preencherCampos(dataInvalida, "", "", "", "", "");
		page.salvarOcorrenciaFeriado();
		String modalValue = page.lerModal(wait);
		assertEquals(page.ERRO_DATA_INVALIDA, modalValue);
	}
	
	@Test
	@Order(4)
	public void testarDataInvalidaAnoNaoBissexto() {
		String dataInvalida = "29/02/2023";
		page.preencherCampos(dataInvalida, "", "", "", "", "");
		page.salvarOcorrenciaFeriado();
		String modalValue = page.lerModal(wait);
		assertEquals(page.ERRO_DATA_INVALIDA, modalValue);
	}
	
	@Test
	@Order(5)
	public void testarDataValida() {
		String dataValida = "13/11/2021";
		String nomeFeriado;
		page.preencherCampos(dataValida, "", "", "", "", "");
		nomeFeriado = page.getDriver().findElement(By.xpath("/html/body/div[4]/div/form/div[2]/div[1]/div/div/b")).getText();
		System.out.println("FERIADO: " + nomeFeriado);
		page.salvarOcorrenciaFeriado();
		wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		AdicionarFeriadoPage afp = PageFactory.initElements(driver, AdicionarFeriadoPage.class);
		String linhaFeriado = nomeFeriado + " " + dataValida;
		List<String> list = afp.tableContent().stream().filter(a -> a.equals(linhaFeriado)).collect(Collectors.toList());
		assertFalse(list.isEmpty());
	}

}
