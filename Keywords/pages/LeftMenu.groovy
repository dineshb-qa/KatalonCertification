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

public class LeftMenu {
	@Keyword
	def isOrangeHRMLogoPresent() {
		WebUI.verifyElementPresent(findTestObject('LeftMenu/img_orangeHRMLogo'), 2)
	}
	
	@Keyword
	def verifyLeftMenuOptionsDisplayed() {
		TestData testData = findTestData("Data Files/Left Menu/Left Menu Options")
		
		for(int i=1; i<=testData.getRowNumbers(); i++) {
			if(!WebUI.verifyElementVisible(findTestObject('LeftMenu/option_leftMenuOption', [('left_menu_name') : testData.getValue(1, i)])))
				return false
			WebUI.comment('The \"' + testData.getValue(1, i) + '\" left menu is displayed')
		}
		
		return true
	}
	
	@Keyword
	def verifyUserCanToggleLeftMenu() {
		if(WebUI.verifyElementClickable(findTestObject('LeftMenu/btn_collapseLeftMenu'))) {
			WebUI.click(findTestObject('LeftMenu/btn_collapseLeftMenu'))
			
			if(WebUI.verifyElementAttributeValue(findTestObject('LeftMenu/panel_leftMenu'), 'class', 'oxd-sidepanel toggled', 2))
				WebUI.comment('Left menu is collapsed')
			else {
				WebUI.comment('Left menu is not collapsed')
				return false
			}
				
			WebUI.click(findTestObject('LeftMenu/btn_expandLeftMenu'))
				
				if(WebUI.verifyElementAttributeValue(findTestObject('LeftMenu/panel_leftMenu'), 'class', 'oxd-sidepanel', 2))
					WebUI.comment('Left menu is expanded')
				else {
					WebUI.comment('Left menu is not expanded')
					return false
				}
		}
		
		return true
	}
	
	@Keyword
	def selectMenuByName(String menuName) {
		WebUI.enhancedClick(findTestObject('LeftMenu/option_leftMenuOption', [('left_menu_name') : menuName]))
		WebUI.verifyElementText(findTestObject('PageHeader/text_moduleName'), menuName)
	}
}
