package page;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdicionarFeriadoPage extends AbstractPage {
	
	@FindBy(id="dscFeriado")
	private WebElement dscFeriado;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/form/div[2]/div/div/input[1]")
	private WebElement submit;
	
	@FindBy(xpath="/html/body/div[4]/div/div[2]/form/div[2]/div/div/input[2]")
	private WebElement deleteBtn;
	
	public final String ERRO_NOME_FERIADO_VAZIO = "Preencha a descricao do feriado";
		
	public AdicionarFeriadoPage(WebDriver driver) {
		super(driver);
	}
	
	public void preencherFeriadoESubmeter(String nomeFeriado) {
		dscFeriado.sendKeys(nomeFeriado);
		submit.click();
	}
	
	public List<String> tableContent() {
		return getDriver().findElements(By.tagName("tr")).stream().map(we -> we.getText()).collect(Collectors.toList());
	}
	
	private List<WebElement> tableElements() {
		return getDriver().findElements(By.tagName("tr"));
	}
	
	public String deletarFeriado(String feriado) {
		getDriver().findElement(By.xpath("//*[text()='"+feriado+"']")).click();
		String name = dscFeriado.getText();
		deleteBtn.click();
		Alert alert = getDriver().switchTo().alert();
		alert.accept();
		return name;
	}

}
