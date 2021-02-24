import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.delay(2)

WebUI.navigateToUrl(GlobalVariable.url_prod)

WebUI.waitForPageLoad(5)


public class AllowGeoLocationPopup {
	public static final String AUTOMATE_USERNAME = "YOUR_USERNAME";
	public static final String AUTOMATE_KEY = "YOUR_ACCESS_KEY";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
  
	public static void main(String[] args) throws Exception {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability("browser", "Chrome");
	  caps.setCapability("browser_version", "75.0");
	  caps.setCapability("os", "Windows");
	  caps.setCapability("os_version", "10");
  
	  // INIT CHROME OPTIONS
	  ChromeOptions options = new ChromeOptions();
	  Map < String, Object > prefs = new HashMap < String, Object > ();
	  Map < String, Object > profile = new HashMap < String, Object > ();
	  Map < String, Object > contentSettings = new HashMap < String, Object > ();
  
	  // SET CHROME OPTIONS
	  // 0 - Default, 1 - Allow, 2 - Block
	  contentSettings.put("geolocation", 1);
	  profile.put("managed_default_content_settings", contentSettings);
	  prefs.put("profile", profile);
	  options.setExperimentalOption("prefs", prefs);
  
	  // SET CAPABILITY
	  caps.setCapability(ChromeOptions.CAPABILITY, options);
	  WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	  driver.get("https://the-internet.herokuapp.com/geolocation");
	  driver.findElement(By.xpath("//*[@id='content']/div/button")).click();
	  Thread.sleep(5000);
	  driver.quit();
	}
  }
  
  

WebUI.click(findTestObject('Object Repository/Page_Pasar.id/btn_ok'), FailureHandling.OPTIONAL)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Page_Pasar.id/btn_profile'))

WebUI.click(findTestObject('Page_Pasar.id/btn_masuk'))

WebUI.delay(1)

WebUI.setText(findTestObject('Page_Pasar.id/input_email'), GlobalVariable.email_valid_prod)

WebUI.setText(findTestObject('Object Repository/Page_Pasar.id/input_password'), GlobalVariable.password_valid_prod)

WebUI.click(findTestObject('Object Repository/Page_Pasar.id/btn_submit_login'))

