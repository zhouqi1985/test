package test5.test5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.openqa.selenium.WebDriver.*;
import org.testng.asserts.*;
import org.openqa.selenium.support.*;
import junit.framework.Assert;

  

public class firefox {
	@Autowired  
	private plogonBaidu plogonBaidu;
	
//	 WebDriver driver = null;
//	 WebElement btnSearch = null;
	public boolean isElementExsit(WebDriver driver, By locator) {  
        boolean flag = false;  
        try {  
            WebElement element=driver.findElement(locator);  
            flag=true;
            System.out.println("Element:" + locator.toString()  
            + " is exsit!");
        } catch (NoSuchElementException e) {  
            System.out.println("Element:" + locator.toString()  
                    + " is not exsit!");  
        }  
        return flag;  
    } 
	
	public void DriverWeb(String browserName,String browserPath,String baseUrl)
	{
		String propertyKey="webdriver."+browserName+".bin";
		System.setProperty(propertyKey,browserPath);
		WebDriver driver=new FirefoxDriver();
		Navigation navigation=driver.navigate();
		navigation.to(baseUrl);
	}
	
	 public void browserTest()
	 {
		 WebDriver driver=DriverWeb("fireforx","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		 Navigation navigation=driver.navigate();
		 navigation.to("http://www.google.com.hk");
		 navigation.to("http://www.baidu.com");
	 }
	
	
	
	 public void openBaidu()
	 {


	  final String sUrl = "http://www.baidu.com/";
	  System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
	  WebDriver driver=new FirefoxDriver();

	  //driver.get(sUrl);
	  Navigation navigation=driver.navigate();
	  navigation.to("http://www.google.com.hk");
	  navigation.to("http://www.baidu.com");
	  try{
		  Thread.sleep(3000);
	  }catch(InterruptedException e)
	  {
		  e.printStackTrace();
	  }
	  navigation.back();
	  try{
		  Thread.sleep(3000);
	  }catch(InterruptedException e)
	  {
		  e.printStackTrace();
	  }
	  navigation.forward();
	  try{
		  Thread.sleep(3000);
	  }catch(InterruptedException e)
	  {
		  e.printStackTrace();
	  }
	  navigation.refresh();
	  
	  Assert.assertTrue("未成功进入待测试页面！",isElementExsit(driver,By.id("su")));//若找到“百度一下”的按钮表示跳转成功

	 }
	 
	 public void waitTime(int seconds)
	 {
		 try{
			  Thread.sleep(seconds);
		  }catch(InterruptedException e)
		  {
			  e.printStackTrace();
		  }
	 }
	 
	 public void checkboxOn(WebElement checkbox)
	 {
		 if(!checkbox.isSelected())
		 {
			 checkbox.click();
		 }
	 }
	 
	 public void checkboxOff(WebElement checkbox)
	 {
		 if(checkbox.isSelected())
		 {
			 checkbox.click();
		 }
	 }
	 
	 public void logonBaidu(WebDriver driver)
	 {


		 WebElement txtLogonid=driver.findElement(By.id("TANGRAM__PSP_4__account")); 
		 WebElement txtPassword=driver.findElement(By.id("TANGRAM__PSP_4__password")); 
		 WebElement txtVericode=driver.findElement(By.id("TANGRAM__PSP_4__verifyCode")); 
		 WebElement cheProtocal=driver.findElement(By.id("TANGRAM__PSP_4__isAgree")); 
		 WebElement butLogon=driver.findElement(By.id("TANGRAM__PSP_4__submit")); 
		 
		 txtLogonid.sendKeys(plogonBaidu.getLogonid());
		 txtPassword.sendKeys(plogonBaidu.getLogonpassword());
		 txtVericode.sendKeys(plogonBaidu.getVerifycode());
		 
		 if(plogonBaidu.getProtocal().equalsIgnoreCase("y"))
		 {
			 checkboxOn(cheProtocal);
		 }
		 else
		 {
		 checkboxOff(cheProtocal);
		 }
		 
		 butLogon.click();	
		 waitTime(3000);
		 isElementExsit(driver,By.xpath("//img[@src='/static/passpc-account/img/reg/success_6d23af3f.png']"));
	

	 }
	//span[@class='card_infoNum']
	 
	 public WebElement FindBy(WebDriver driver,String method,String key)
	 {
		 WebElement webelement = null;
		 if(method=="ID")
		 { 
	         try 
	        { 
	        	 webelement=driver.findElement(By.id(key));       
	          } 
	          catch (Exception e) 
	      { 
	            
	      } 
		 }else if (method=="Name")
		 { 
			 webelement=driver.findElement(By.name(key));
		 }
		 else if (method=="CSS")
		 { 
			 webelement=driver.findElement(By.cssSelector(key));
		 }
		 else if (method=="XPath")
		 { 
			 webelement=driver.findElement(By.xpath(key));
		 }
		 return webelement;
		 
	 }
	 
	 public void loginBaidu(WebDriver driver)
	 {

		 WebElement txtLoginid=driver.findElement(By.id("TANGRAM__PSP_8__userName")); 
		 WebElement txtPassword=driver.findElement(By.id("TANGRAM__PSP_8__password")); 
		 WebElement cheNext=driver.findElement(By.id("TANGRAM__PSP_8__memberPass")); 
		 WebElement butLogin=driver.findElement(By.id("TANGRAM__PSP_8__submit")); 	 
		 txtLoginid.sendKeys(plogonBaidu.getLogonid());
		 txtPassword.sendKeys(plogonBaidu.getLogonpassword());		 
		 if(plogonBaidu.getProtocal().equalsIgnoreCase("y"))
		 {
			 checkboxOn(cheNext);
		 }
		 else
		 {
		 checkboxOff(cheNext);
		 }
		 
		 butLogin.click();	
		 waitTime(3000);
		 if(isElementExsit(driver,By.id("TANGRAM__PSP_8__error")))
		 {
		 WebElement errormesgResult=driver.findElement(By.id("TANGRAM__PSP_8__error"));
		 Assert.assertEquals("Search Failed", plogonBaidu.getErrormesg(), errormesgResult.getText());
		 }
	

	 }
	 
	 public void fatie(WebDriver driver)
	 {

		 WebElement labTienum=driver.findElement(By.xpath("//span[@class='card_infoNum']")); 
		 WebElement butSubmit=driver.findElement(By.xpath("//div[@class='j_floating']")); 
		 int intlabTienum= Integer.parseInt(labTienum.getText())+1; 
		 butSubmit.click();
		 waitTime(3000);
		 WebElement labTienum2=driver.findElement(By.xpath("//span[@class='card_infoNum']")); 
		 Assert.assertEquals("Search Failed", labTienum2.getText(), Integer.toString(intlabTienum));	

	 }

	 public void normalSearch(WebDriver driver)
	 {
		 WebElement txtSearchInput=driver.findElement(By.id("kw")); 
		 WebElement butSearch=driver.findElement(By.id("su")); 
		 txtSearchInput.sendKeys("a");
		 waitTime(3000);
		 txtSearchInput.sendKeys(plogonBaidu.getSearchtext());
		 butSearch.click();
		 waitTime(3000);
		 if(isElementExsit(driver,By.xpath("//div[@id='1']/h3/a/em")))
			 {
			 WebElement searchResult=driver.findElement(By.xpath("//div[@id='1']/h3/a/em"));
			 Assert.assertEquals("Search Failed", plogonBaidu.getSearchtext(), searchResult.getText());
			 }
	 }
	 
	 public void highSearch(WebDriver driver)
	 {
		 WebElement txtSearchKey1=driver.findElement(By.name("q1")); 
		 WebElement txtSearchKey2=driver.findElement(By.name("q2")); 
		 WebElement txtSearchKey3=driver.findElement(By.name("q3")); 
		 WebElement txtSearchKey4=driver.findElement(By.name("q4")); 
		 Select selTime=new Select(driver.findElement(By.name("1m")));
		 Select selDoc=new Select(driver.findElement(By.name("ft")));
		 Select selKey=new Select(driver.findElement(By.id("adv-setting-6")));
		 WebElement txtWebsite=driver.findElement(By.name("q6")); 
		 WebElement buthighSearch=driver.findElement(By.id("adv-setting-7")); 
		 
		 txtSearchKey1.sendKeys(plogonBaidu.getSearchkey1());
		 txtSearchKey2.sendKeys(plogonBaidu.getSearchkey2());
		 txtSearchKey3.sendKeys(plogonBaidu.getSearchkey3());
		 txtSearchKey4.sendKeys(plogonBaidu.getSearchkey4());
		 selTime.selectByVisibleText(plogonBaidu.getSearchtime());
		 selDoc.selectByVisibleText(plogonBaidu.getSearchdoc());
		 
		 selKey.deselectAll();
		 selKey.selectByVisibleText(plogonBaidu.getSearchkeypos());
		 txtWebsite.sendKeys(plogonBaidu.getSearchwebsite());
		 buthighSearch.click();
		 waitTime(3000);
		 if(isElementExsit(driver,By.xpath("//div[@id='1']")))
			 {
			 WebElement searchResult=driver.findElement(By.xpath("//div[@id='1']"));
			 verifyallkey(searchResult);
			 verifyintegritykey(searchResult);
			 verifonekey(searchResult);
			 verifyexcludekey(searchResult);
			 
			 }
	 }
	 
	 public void payment(WebDriver driver)
	 {

		 List<WebElement> List = new ArrayList();
		 List=driver.findElements(By.xpath("//div[@class='bank']/ul/li"));

		 WebElement btnGame=driver.findElement(By.name("GameID"));
		 WebElement txtLoginname=driver.findElement(By.id("LoginName")); 
		 WebElement txtLoginname2=driver.findElement(By.id("ConfirmLoginName")); 
		 WebElement txtValidcode=driver.findElement(By.id("ValidCode")); 
		 
		 Select selArea=new Select(driver.findElement(By.id("GameAreaID")));
		 Select selArea2=new Select(driver.findElement(By.id("ConfirmGameAreaID")));
		 Select selMoney=new Select(driver.findElement(By.id("ProductID")));

		 WebElement btnNextstep=driver.findElement(By.id("checkinfo")); 
		 
		 for(int i=0;i<=List.size();i++)
		 {
			 if(List.get(i).getText().equalsIgnoreCase(plogonBaidu.getBankname()))
			 {
				 List.get(i).click();
			 }
			 break;
		 }		
		 
		 btnGame.click();
		 txtLoginname.sendKeys(plogonBaidu.getLogonid());
		 txtLoginname2.sendKeys(plogonBaidu.getLogonid());
		 selArea.selectByVisibleText(plogonBaidu.getGamearea());
		 selArea2.selectByVisibleText(plogonBaidu.getGamearea());
		 selMoney.selectByVisibleText(plogonBaidu.getGamemoney());
		 btnNextstep.click();

		 waitTime(3000);
		 if(isElementExsit(driver,By.xpath("//input[@value='确认充值']")))
			 {
			 WebElement checkmethod=driver.findElement(By.id("tabIndex"));
			 WebElement checkbank=driver.findElement(By.id("payType"));
			 
			 verifpaymentinfo(checkmethod,checkbank);
			 
			 }
	 }
	 
	 public void verifpaymentinfo(WebElement searchResult1,WebElement searchResult2)
	 {

		 waitTime(3000);

	 }
	 
	 public void verifyallkey(WebElement searchResult)
	 {

		 waitTime(3000);

	 }
	 
	 public void verifyintegritykey(WebElement searchResult)
	 {

		 waitTime(3000);

	 }
	 
	 public void verifonekey(WebElement searchResult)
	 {

		 waitTime(3000);

	 }
	 
	 public void verifyexcludekey(WebElement searchResult)
	 {

		 waitTime(3000);

	 }
	 ////div[@id='1']/h3/a/em
	////div[@id='1']/h3
	 /*
	
	
	public static void main(String[] args)
	{

	}
*/
}
