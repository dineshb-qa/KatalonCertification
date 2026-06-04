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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import pages.Common
import pages.DashboardPage
import pages.LoginPage

'Navigate to the page'
Common common = new Common()
common.navigateToUrl(GlobalVariable.baseUrl)

'Login to the application with valid username and password'
LoginPage loginPage = new LoginPage()
loginPage.loginToTheApplication(GlobalVariable.username, GlobalVariable.password)

'Verify Quick Launch widget is displayed on Dashboard'
DashboardPage dashboardPage = new DashboardPage()
assert dashboardPage.isQuickLaunchWidgetDisplayed() == true
WebUI.comment('Verified that, "Quick Launch" widget is displayed on Dashboard page')

'Verify cards displayed on Quick Launch widget'
dashboardPage.verifyCardsDisplayedOn_QuickLaunchWidget()
WebUI.comment('Verified that expected cards are displayed on Quick Launch widget')