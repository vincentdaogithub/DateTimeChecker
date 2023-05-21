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

WebUI.openBrowser('http://localhost:8084/DateTimeChecker/')

WebUI.setText(findTestObject('Form/input_Day_txtDay'), txtDay)

WebUI.setText(findTestObject('Form/input_Month_txtMonth'), txtMonth)

WebUI.setText(findTestObject('Form/input_Year_txtYear'), txtYear)

WebUI.click(findTestObject('Form/input_Year_btAction_Check'))

if (Boolean.valueOf(isDayFailed)) {
    WebUI.verifyElementPresent(findTestObject('Result/font_Input data for Day is out of range'), 0)
}

if (Boolean.valueOf(isMonthFailed)) {
    WebUI.verifyElementPresent(findTestObject('Result/font_Input data for Month is out of range'), 0)
}

if (Boolean.valueOf(isYearFailed)) {
    WebUI.verifyElementPresent(findTestObject('Result/font_Input data for Year is out of range'), 0)
}

WebUI.closeBrowser()

