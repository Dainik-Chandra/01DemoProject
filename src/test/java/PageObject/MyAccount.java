package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	WebDriver ldriver;
	public MyAccount(WebDriver rdriver)
	{
	ldriver = rdriver;	
	PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="email_create")
	WebElement emailCreate;

	@FindBy(id="SubmitCreate")
	WebElement submitCreate;

	@FindBy(id="email")
	WebElement email;

	@FindBy(id="passwd")
	WebElement passwd;

	@FindBy(id="SubmitLogin")
	WebElement submitLogin;

	public void enterEmail(String email) 
	{
		emailCreate.sendKeys(email);
	}
	public void clickOnCreateAnAccount()
	{
		submitCreate.click();
	}
	public void enterRegisteredEmail(String REmail)
	{
		email.sendKeys(REmail);
	}
	public void enterPassword(String pwd)
	{
		passwd.sendKeys(pwd);
	}
	public void clickOnSignIn()
	{
		submitLogin.click();
	}
	public String getTitle()
	{
		String title= ldriver.getTitle(); 
		return title;
	}
}
