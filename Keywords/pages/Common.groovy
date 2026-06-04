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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Common {
	@Keyword
	def navigateToUrl(String url) {
		WebUI.navigateToUrl(url)
	}

	@Keyword
	def isUserProfileDropdownDisplayed() {
		WebUI.verifyElementVisible(findTestObject('PageHeader/dropdown_userProfile'))
	}
	
	@Keyword
	def logoutFromTheApplication() {
		WebUI.click(findTestObject('PageHeader/dropdown_userProfile'))
		WebUI.click(findTestObject('PageHeader/link_logout'))
	}
	
	@Keyword
	def selectTopBarMenu(String topBarMainMenuName) {
		WebUI.enhancedClick(findTestObject('TopBarMenu/option_topBarMainMenuOption', [('topBarMainMenuName') : topBarMainMenuName]))
	}
	
	@Keyword
	def selectSubMenuFromTopBarMenu(String topBarMainMenuName, String topBarSubMenuName) {
		WebUI.enhancedClick(findTestObject('TopBarMenu/option_topBarMainMenuOption', [('topBarMainMenuName') : topBarMainMenuName]))
		WebUI.verifyElementText(findTestObject('PageHeader/text_subModuleName'), topBarMainMenuName)
		WebUI.enhancedClick(findTestObject('TopBarMenu/option_topBarSubMenuOption', [('topBarMainMenuName') : topBarMainMenuName, ('topBarSubMenuName') : topBarSubMenuName]))
	}
	
	@Keyword
	def selectOptionFromDropdownAndSearch(String dropdownName, String dropdownOptionName) {
		selectOptionFromDropdown(dropdownName, dropdownOptionName)
		WebUI.click(findTestObject('CommonPage/btn_search'))
	}
	
	@Keyword
	def selectOptionFromDropdown(String dropdownName, String dropdownOptionName) {
		WebUI.enhancedClick(findTestObject('CommonPage/dd_dropdownOption', [('dropdownName') : dropdownName]))
		WebUI.enhancedClick(findTestObject('CommonPage/dd_dropdownOptionValue', [('dropdownOptionName') : dropdownOptionName]))
	}
}
