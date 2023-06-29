package TestingClassPackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BasePackage.BaseClass;
import PageObject.IndexPage;
import PageObject.MyAccount;
import PageObject.RegisteredMyAccount;
import UtilitiesPackage.ReadConfig;
import UtilitiesPackage.ReadExcelFile;

public class TestingVerifyLogin extends BaseClass {

	IndexPage pg;
	
@Test(dataProvider = "LoginDataProvider")
	
	public void VerifyLogin(String userPwd, String expectedUsername) throws IOException 
	{
	logger.info("//////////////////Verify LogIn.../////////////////////");
		pg = new IndexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked On Sign in......");
		MyAccount ma = new MyAccount(driver);

		ReadConfig rc = new ReadConfig();
		String userEmail = rc.getUserName();
		ma.enterRegisteredEmail(userEmail);
		logger.info("Email entered....");
		ma.enterPassword(userPwd);
		logger.info("Password entered......");
		ma.clickOnSignIn();
		logger.info("Clicked on Sign In.....");
		RegisteredMyAccount regUser = new RegisteredMyAccount(driver);
		String userName = regUser.getUserName();
		
		
		if(userName.equals(expectedUsername))
		{
			Assert.assertTrue(true);
			logger.info("Verified expected username is passed.......");
			regUser.clickOnSignOut();
			logger.info("User is Sign out...........");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Verified expected username is failed....");
		} 
		
		
	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\TestData.xlsx";
		ReadExcelFile ref = new ReadExcelFile();

		int ttlRows = ref.getRowCount(fileName, "Sheet2");
		int ttlColumns = ref.getColCount(fileName, "Sheet2");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{

				data[i-1][j]=ref.getCellValue(fileName,"Sheet2", i,j);
			}

		}
		return data;
	}
	@Test(dependsOnMethods= {"VerifyLogin"})
	public void verifySignOut()
	{
		logger.info("//////////////////Verify Sign Out/////////////////////");
		String pageTitle = pg.getPageTitle();
		if(pageTitle.equals("Login - My Shop"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			Assert.assertTrue(false);
		}
	}
}