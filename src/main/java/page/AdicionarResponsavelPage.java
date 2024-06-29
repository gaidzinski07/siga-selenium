package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdicionarResponsavelPage {
	
	@FindBy(xpath = "extrair")
	private WebElement nome;

	@FindBy(xpath = "extrair")
	private WebElement descricao;

	@FindBy(xpath = "extrair")
	private WebElement tipo;

	@FindBy(xpath = "extrair")
	private WebElement lotacao;
	
	@FindBy(xpath = "extrair")
	private WebElement botaoSalvar;
	
	private WebDriver driver;
	
	public AdicionarResponsavelPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public AdicionarResponsavelPage preencherNomeDescricacao(String _nome, String _descricao) {
		if(nome == null || descricao == null) {
			System.out.println("Os campos não existem no contexto do código.");
			return null;
		}
		nome.sendKeys(_nome);
		descricao.sendKeys(_descricao);
		return PageFactory.initElements(driver, AdicionarResponsavelPage.class);
	}
	
	public AdicionarResponsavelPage preencherTipoLotacao(String _tipo, String _lotacao) {
		if(tipo == null || lotacao == null) {
			System.out.println("Os campos não existem no contexto do código.");
			return null;
		}
		tipo.sendKeys(_tipo);
		lotacao.sendKeys(_lotacao);
		return PageFactory.initElements(driver, AdicionarResponsavelPage.class);
	}
	
	public void submit() {
		botaoSalvar.click();
	}
	
}
