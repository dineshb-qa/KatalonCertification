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
import pages.ClaimPage
import pages.Common
import pages.LoginPage

import org.openqa.selenium.Keys as Keys

'Navigate to the page'
Common common = new Common()
common.navigateToUrl(GlobalVariable.baseUrl)

'Login to the application with valid username and password'
LoginPage loginPage = new LoginPage()
loginPage.loginToTheApplication(GlobalVariable.username, GlobalVariable.password)

'Navigate to Claim menu'
ClaimPage claimPage = new ClaimPage()
claimPage.navigateToClaimMenu()

'Select "Submit Claim" tab'
claimPage.selectSubmitClaimMenuFromTopBarMenu()

'Submit new claim'
String claimRemark = 'Claim_Remark_' + new Random().nextInt(100) + 1
String claimReferenceId = claimPage.submitClaim("Medical Reimbursement", "Indian Rupee", claimRemark)

'Select "Employee Claims" tab'
claimPage.selectEmployeeClaimsMenuFromTopBarMenu()

'Search and Verify Employee claims list filtered by "Medical Reimbursement" Event Name'
claimPage.searchClaimListByEventName('Medical Reimbursement')
claimPage.verifyEmployeeClaimDetailsInTableBy_EventName('Medical Reimbursement')
WebUI.comment('Verified that, employee claims are filtered correctly by event name: ' + 'Medical Reimbursement')