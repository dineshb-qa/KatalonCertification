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
import internal.GlobalVariable
import pages.Common
import pages.LoginPage
import pages.PIMPage

import org.openqa.selenium.Keys as Keys

'Navigate to the page'
Common common = new Common()
common.navigateToUrl(GlobalVariable.baseUrl)

'Login to the application with valid username and password'
LoginPage loginPage = new LoginPage()
loginPage.loginToTheApplication(GlobalVariable.username, GlobalVariable.password)

'Navigate to PIM menu'
PIMPage pimPage = new PIMPage()
pimPage.navigateToPIMMenu()

'Select "Employee List" tab'
pimPage.selectEmployeeListMenuFromTopBarMenu()

'Search Employee List by Sub Unit'
pimPage.selectSubUnitFromDropdown('Human Resources')

'Verify Employee List filered by "Human Resources" Sub Unit'
pimPage.verifyEmployeeListFilteredBySubUnit("Human Resources")
WebUI.comment('Verified that, in the search results, the \"Sub Unit\" column value for each user is \"Human Resources\"')