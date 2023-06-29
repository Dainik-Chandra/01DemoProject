package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredMyAccount {
	WebDriver ldriver;
	public RegisteredMyAccount(WebDriver rdriver)
	{
	ldriver = rdriver;	
	PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement rUserName;
	
	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	public String getUserName()
	{
		String text= rUserName.getText();
		return text;
	}
	
	public void clickOnSignOut()
	{
		signOut.click();
	}
}
