package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class AddEmployeePage {
	
	@Keyword
	def enterEmployeeNameDetails(String firstName, String middleName, String lastName) {
		WebUI.setText(findTestObject('AddEmployeePage/input_employeeFirstName'), firstName)
		WebUI.setText(findTestObject('AddEmployeePage/input_employeeMiddleName'), middleName)
		WebUI.setText(findTestObject('AddEmployeePage/input_employeeLastName'), lastName)
		KeywordUtil.logInfo('Employee full name: ' + firstName + ' ' + middleName + ' ' + lastName)
	}
	
	@Keyword
	def enterEmployeeIdDetails(String employeeId) {
		WebUI.click(findTestObject('CommonPage/input_employeeId'))
		WebUI.sendKeys(findTestObject('CommonPage/input_employeeId'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('CommonPage/input_employeeId'), Keys.chord(Keys.DELETE))
		WebUI.setText(findTestObject('CommonPage/input_employeeId'), employeeId)
		KeywordUtil.logInfo('Employee Id: ' + employeeId)
	}
	
	@Keyword
	def uploadEmployeeImage(String employeeImagePath) {
		WebUI.sendKeys(findTestObject('AddEmployeePage/img_uploadEmployeeImage'), employeeImagePath)
	}
	
	@Keyword
	def createNewEmployeeWithFullNameDetails_WithEmployeeIDAndImage(String firstName, String middleName, String lastName, String employeeId, String employeeImagePath) {
		enterEmployeeNameDetails(firstName, middleName, lastName)
		enterEmployeeIdDetails(employeeId)
		uploadEmployeeImage(employeeImagePath)
		WebUI.click(findTestObject('CommonPage/btn_save'))
		
		WebUI.waitForElementVisible(findTestObject('CommonPage/tooltip_successfullySaved'), 20)
		WebUI.verifyElementVisible(findTestObject('CommonPage/tooltip_successfullySaved'))
		WebUI.verifyElementText(findTestObject('PIMPage/text_employeeNameOnEditPage'), firstName + ' ' + lastName)
		KeywordUtil.logInfo('\"' + firstName + ' ' + middleName + ' ' + lastName + '\" employee is created successfully')
	}
}
