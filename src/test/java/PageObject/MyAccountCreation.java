package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyAccountCreation {
	WebDriver ldriver;
	public MyAccountCreation(WebDriver rdriver)
	{
	ldriver = rdriver;	
	PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="id_gender1")
	WebElement gender;

	@FindBy(id="customer_firstname")
	WebElement firstName;
	
	@FindBy(id="customer_lastname")
	WebElement lastName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;

	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="submitAccount")
	WebElement submitAccount;
	
	public void clickOnMr()
	{
		gender.click();
	}
	
	public void enterFirstName(String firstname)
	{
		firstName.sendKeys(firstname);
	}
	public void enterLastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void enterDay(String day)
	{
		Select dd= new Select(days);
		dd.selectByValue(day);
	}
	public void enterMonth(String month)
	{
		Select dd= new Select(months);
		dd.selectByValue(month);
	}
	public void enterYear(String year)
	{
		Select dd= new Select(years);
		dd.selectByValue(year);
	}
	public void clickOnSignIn()
	{
		submitAccount.click();
	}
}
