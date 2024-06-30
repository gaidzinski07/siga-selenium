package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastrarOcorrenciaFeriadoPage extends AbstractPage {
	
	@FindBy(id="dtIniFeriado")
	private WebElement dataInicio;
	
	@FindBy(name="dtFimFeriado")
	private WebElement dataFim;
	
	@FindBy(name="idOrgaoUsu")
	private WebElement orgao;
	
	@FindBy(id="formulario_lotacao_lotacaoSel_sigla")
	private WebElement lotacao;
	
	@FindBy(id="lotacao_lotacaoSelSpan")
	private WebElement nomeLotacao;
	
	@FindBy(xpath="/html/body/div[4]/div/form/div[2]/div[3]/div[1]/div/select")
	private WebElement uf;
	
	@FindBy(xpath="//*[@id=\"localidades\"]/select")
	private WebElement localidade;
	
	@FindBy(xpath="/html/body/div[4]/div/form/div[2]/div[5]/div/div/input[1]")
	private WebElement submit;
	
	public final String ERRO_FORM_VAZIO = "Preencha a data de início";
	public final String ERRO_DATA_INVALIDA = "Dia inválido.";

	public CadastrarOcorrenciaFeriadoPage(WebDriver driver) {
		super(driver);
	}
	
	public void preencherCampos(String dataInicio, String dataFim, String orgao, String lotacao, String uf, String localidade) {
		this.dataInicio.sendKeys(dataInicio);
//		this.dataFim.sendKeys(dataFim);
//		this.orgao.sendKeys(orgao);
//		this.lotacao.sendKeys(lotacao);
//		this.uf.sendKeys(uf);
//		this.localidade = getDriver().findElement(By.xpath("//*[@id=\"localidades\"]/select"));
//		this.localidade.sendKeys(localidade);
	}
	
	public void salvarOcorrenciaFeriado() {
		submit.click();
	}

}
