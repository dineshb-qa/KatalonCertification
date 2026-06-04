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

public class DashboardPage {
	@Keyword
	def isQuickLaunchWidgetDisplayed() {
		WebUI.verifyElementVisible(findTestObject('DahboardPage/widget_quickLaunch'))
	}

	@Keyword
	def verifyCardsDisplayedOn_QuickLaunchWidget() {
		TestData testData = findTestData("Data Files/Dashboard/Quick Launch Widget Cards")
		
		for(int i=1; i<=testData.getRowNumbers(); i++) {
			if(!WebUI.verifyElementVisible(findTestObject('DahboardPage/card_quickLaunchCard', [('quick_launch_card_name') : testData.getValue(1, i)])))
				return false
			WebUI.comment('The \"' + testData.getValue(1, i) + '\" card is displayed')
		}
		
		return true
	}
	
	@Keyword
	def verifyWidgetsDisplayedOn_DashboardPage() {
		TestData testData = findTestData("Data Files/Dashboard/Dashboard Page Widget Names")
		
		for(int i=1; i<=testData.getRowNumbers(); i++) {
			if(!WebUI.verifyElementVisible(findTestObject('DahboardPage/widget_dashboardPageWidget', [('dashboard_page_widget_name') : testData.getValue(1, i)])))
				return false
			WebUI.comment('The \"' + testData.getValue(1, i) + '\" widget is displayed')
		}
		
		return true
	}
}
