package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
	
	@FindBy(xpath="/html/body/div[4]/div/div/div/form/div[1]/div/input")
	private WebElement username;
	
	@FindBy(xpath="/html/body/div[4]/div/div/div/form/div[2]/div/input")
	private WebElement password;
	
	@FindBy(xpath="/html/body/div[4]/div/div/div/form/div[3]/div/div/button")
	private WebElement submit;
		
	public final String ERROR_MESSAGE_INVALIDO = "Usuário ou senha incorretos. Tente novamente, ou clique";
	public final String ERROR_MESSAGE_VAZIO = "Informe os campos Matrícula e Senha";
	public final String SUCCESS_MESSAGE = "SUCESSO";
	public final String VALID_USERNAME = "ZZ99999";
	public final String VALID_PASSWORD = "Password1";
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public LoginPage preencherCampos(String userName, String password) {
		this.username.sendKeys(userName);
		this.password.sendKeys(password);
		
		return PageFactory.initElements(getDriver(), this.getClass());
	}
	
	public void submit() {
		this.submit.click();
	}
	
	public String loginResult() {
		List<WebElement> erros = getDriver().findElements(By.className("login-invalido"));
		if(erros.isEmpty()) {
			return SUCCESS_MESSAGE;
		}
		WebElement erro = erros.get(0);
		if(ERROR_MESSAGE_VAZIO.contains(erro.getText())) {
			return ERROR_MESSAGE_VAZIO;
		}
		return ERROR_MESSAGE_INVALIDO;
	}

}
