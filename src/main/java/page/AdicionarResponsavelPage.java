package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdicionarResponsavelPage extends AbstractPage{
	
	@FindBy(xpath = "/html/body/div[4]/form/fieldset[1]/div/div[1]/div/input")
	private WebElement nome;

	@FindBy(xpath = "/html/body/div[4]/form/fieldset[1]/div/div[2]/div/input")
	private WebElement descricao;
	
	@FindBy(xpath = "/html/body/div[4]/form/div/div/div/button[1]")
	private WebElement botaoSalvar;
	
	public final String ERRO_CAMPOS_INVALIDOS = "Preencha os campos corretamente";
	
	public AdicionarResponsavelPage (WebDriver driver) {
		super(driver);
	}
	
	public void preencherNomeDescricacao(String nome, String descricao) {
		this.nome.sendKeys(nome);
		this.descricao.sendKeys(descricao);
	}
	
	public void submit() {
		botaoSalvar.click();
	}
	
}
