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
	private WebElement botaoSalvar;
	
	private WebDriver driver;
	
	public AdicionarResponsavelPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void preencherNomeDescricacao(String _nome, String _descricao) {
		nome.sendKeys(_nome);
		descricao.sendKeys(_descricao);
	}
	
	public void submit() {
		botaoSalvar.click();
	}
	
}
