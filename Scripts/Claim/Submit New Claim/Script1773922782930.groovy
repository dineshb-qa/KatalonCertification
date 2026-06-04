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

'Add Expense details to submitted claim'
String expenseNote = 'Expense_Note' + new Random().nextInt(100) + 1
claimPage.enterExpenceDetailsForClaim("Planned Surgery", "2026-09-05", "10000", expenseNote)

'Select "My Claims" tab'
claimPage.selectMyClaimsMenuFromTopBarMenu()

'Search and Verify submitted claim details are displayed correctly under My Claims'
claimPage.searchClaimListBy_ReferenceId_EventName_Status(claimReferenceId, "Medical Reimbursement", "Submitted")
String claimSubmittedDate = new java.text.SimpleDateFormat("yyyy-dd-MM").format(new Date()).toString()
claimPage.verifyMyClaimDetailsInTableBy_ReferenceId_EventName_Description_Currency_SubmittedDate_Status_Amount(claimReferenceId, "Medical Reimbursement", claimRemark, "Indian Rupee", claimSubmittedDate, "Submitted", "10,000.00")

WebUI.comment('Verified that, newly created claim details are shown correctly in table view')
WebUI.comment('| Reference Id | Event Name | Description | Currency | Submitted Date | Status | Amount |')
WebUI.comment('| ' + claimReferenceId + ' | ' + 'Medical Reimbursement' + ' | ' + claimRemark + ' | ' + 'Indian Rupee' + ' | ' + claimSubmittedDate + ' | ' + 'Submitted' + ' | ' + '10,000.00' + ' |')