package TestingClassPackage;

import org.testng.annotations.*;

import BasePackage.BaseClass;
import PageObject.IndexPage;
import PageObject.MyAccount;
import PageObject.MyAccountCreation;
import PageObject.RegisteredMyAccount;
import UtilitiesPackage.ReadConfig;
import UtilitiesPackage.ReadExcelFile;
import junit.framework.Assert;

public class TestingVerifyUserRegistrationAndLogin extends BaseClass{
	ReadConfig readConfig = new ReadConfig();
	
	String userName = readConfig.getUserName();
	
	@Test(enabled=false)
	public void VerifyUserRegistrationAndLogin(String fname, String lname, String pwd)
	{
		logger.info("///////////////////VerifyUserRegistrationAndLogin////////////////////////");
		
		IndexPage ip = new IndexPage(driver);
		ip.clickOnSignIn();
		logger.info("Clicked on Sign in.........");
		
		MyAccount ma = new MyAccount(driver);
		ma.enterEmail(userName);
		logger.info("Email entered...........");
		ma.clickOnCreateAnAccount();
		logger.info("Create An Account button is clicked......");
		MyAccountCreation mac= new MyAccountCreation(driver);
		mac.clickOnMr();
		logger.info("Clicked on radio button......");
		mac.enterFirstName(fname);
		logger.info("First name entered.....");
		mac.enterLastName(lname);
		logger.info("Last name entered.....");
		mac.enterPassword(pwd);
		logger.info("Password entered.....");
		mac.enterDay("26");
		logger.info("Date selected....");
		mac.enterMonth("2");
		logger.info("Month selected.......");
		mac.enterYear("1994");
		logger.info("Year selected.........");
		mac.clickOnSignIn();
		logger.info("Clicked on Sign in..........");
		
		RegisteredMyAccount rma = new RegisteredMyAccount(driver);
		String userName = rma.getUserName();
		Assert.assertEquals("Dainik Chandra", userName);
		logger.info("Verify username is passed.....");
		rma.clickOnSignOut();
		logger.info("Clicked on Sign out.......");
	}
	
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\TestData.xlsx";
		ReadExcelFile ref = new ReadExcelFile();

		int ttlRows = ref.getRowCount(fileName, "Sheet1");
		int ttlColumns = ref.getColCount(fileName, "Sheet1");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{

				data[i-1][j]=ref.getCellValue(fileName,"Sheet1", i,j);
			}

		}
		return data;
	}

}
