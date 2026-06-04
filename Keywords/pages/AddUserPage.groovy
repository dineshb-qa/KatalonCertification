package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

public class AddUserPage {
	@Keyword
	def enterUserDetails(String userRole, String status, String employeeName, String username, String password, String confirmPassword) {
		Common common = new Common()
		common.selectOptionFromDropdown("User Role", userRole)
		common.selectOptionFromDropdown("Status", status)
		WebUI.setText(findTestObject('AddUserPage/input_employeeName'), employeeName)
		WebUI.waitForElementVisible(findTestObject('AddUserPage/ddOption_firstEmpoyeeNameSuggestion'), 15)
		WebUI.waitForElementClickable(findTestObject('AddUserPage/ddOption_firstEmpoyeeNameSuggestion'), 15)
		WebUI.click(findTestObject('AddUserPage/ddOption_firstEmpoyeeNameSuggestion'))
		WebUI.setText(findTestObject('AddUserPage/input_username'), username)
		WebUI.setText(findTestObject('AddUserPage/input_password'), password)
		WebUI.setText(findTestObject('AddUserPage/input_confirmPassword'), confirmPassword)
	}
	
	@Keyword
	def addNewUser(String userRole, String status, String employeeName, String username, String password, String confirmPassword) {
		WebUI.click(findTestObject('AdminPage/btn_addUser'))
		enterUserDetails(userRole, status, employeeName, username, password, confirmPassword)
		WebUI.click(findTestObject('CommonPage/btn_save'))
		WebUI.waitForElementVisible(findTestObject('CommonPage/tooltip_successfullySaved'), 20)
		WebUI.verifyElementVisible(findTestObject('CommonPage/tooltip_successfullySaved'))
		KeywordUtil.logInfo('\"' + username + '\" user is created successfully')
	}
}
