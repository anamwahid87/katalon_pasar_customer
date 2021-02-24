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
WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/Page_Pasar.id/btn_ok'), FailureHandling.OPTIONAL)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

'Klik Profile'
WebUI.click(findTestObject('Page_Pasar.id/btn_profile'))
WebUI.takeScreenshot()

'Klik Masuk'
WebUI.click(findTestObject('Page_Pasar.id/btn_masuk'))

WebUI.delay(2)

'Input Email'
WebUI.setText(findTestObject('Page_Pasar.id/input_email'), GlobalVariable.email_valid_prod)

'Input Password'
WebUI.setText(findTestObject('Object Repository/Page_Pasar.id/input_password'), GlobalVariable.password_valid_prod)

WebUI.click(findTestObject('Object Repository/Page_Pasar.id/btn_ok'), FailureHandling.OPTIONAL)
WebUI.takeScreenshot()

WebUI.delay(2)

'Berhasil Login'
WebUI.click(findTestObject('Object Repository/New Object/Page_Pasar.id/button_Login')) 
WebUI.takeScreenshot()

WebUI.waitForPageLoad(5)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_Pasar.id/btn_profile'))

'Klik Logout'
WebUI.click(findTestObject('Object Repository/Page_Pasar.id/btn_logout'))

WebUI.delay(4)

WebUI.click(findTestObject('Object Repository/Page_Pasar.id/btn_profile'))

'Make sure there is no logout button'
WebUI.verifyElementNotPresent(findTestObject('Page_Pasar.id/btn_logout'), 3, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()

