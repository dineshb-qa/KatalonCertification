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
import software.amazon.awssdk.auth.credentials.internal.WebIdentityCredentialsUtils

public class LoginPage {
	@Keyword
	def loginToTheApplication(String username, String password) {
		WebUI.setText(findTestObject('LoginPage/input_username'), username)
		WebUI.setEncryptedText(findTestObject('LoginPage/input_password'), password)
		WebUI.click(findTestObject('LoginPage/btn_login'))
	}

	@Keyword
	def getLoginErrorMessageText() {
		WebUI.getText(findTestObject('LoginPage/text_loginErrorMsg'))
	}

	@Keyword
	def isLoginPageDisplayed() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/input_username'))
		WebUI.verifyElementVisible(findTestObject('LoginPage/input_password'))
		WebUI.verifyElementVisible(findTestObject('LoginPage/btn_login'))
		WebUI.comment('Login page is displayed')
		return true
	}
	
	@Keyword
	def verifySocialMediaOptionsAreDisplayed() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/link_linkedInOption'))
		WebUI.verifyElementVisible(findTestObject('LoginPage/link_facebookOption'))
		WebUI.verifyElementVisible(findTestObject('LoginPage/link_twitterOption'))
		WebUI.verifyElementVisible(findTestObject('LoginPage/link_youtubeOption'))
	}
	
	@Keyword
	def verifyApplicationVersionIsDisplayed() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/text_appVersion'))
		KeywordUtil.logInfo("The OrangeHRM app version is: " + WebUI.getText(findTestObject('LoginPage/text_appVersion')))
	}
	
	@Keyword
	def verifyCopyrightTextIsDisplayed() {
		WebUI.verifyElementVisible(findTestObject('LoginPage/text_copyrightText'))
		KeywordUtil.logInfo("The Copyright text is: " + WebUI.getText(findTestObject('LoginPage/text_copyrightText')))
	}
}
