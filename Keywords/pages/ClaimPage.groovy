package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

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

public class ClaimPage {
	Common common = new Common()
	
	@Keyword
	def navigateToClaimMenu() {
		LeftMenu leftMenu = new LeftMenu()
		leftMenu.selectMenuByName("Claim")
		KeywordUtil.logInfo('\"Claim\" menu is selected')
	}
	
	@Keyword
	def selectSubmitClaimMenuFromTopBarMenu() {
		common.selectTopBarMenu("Submit Claim")
		WebUI.verifyElementText(findTestObject('CommonPage/text_cardTitle'), "Create Claim Request")
		KeywordUtil.logInfo('\"Submit Claim\" menu is selected from top bar')
	}
	
	@Keyword
	def selectMyClaimsMenuFromTopBarMenu() {
		common.selectTopBarMenu("My Claims")
		WebUI.verifyElementText(findTestObject('AdminPage/text_sysytemUsersMenuName'), "My Claims")
		KeywordUtil.logInfo('\"My Claims\" menu is selected from top bar')
	}
	
	@Keyword
	def selectEmployeeClaimsMenuFromTopBarMenu() {
		common.selectTopBarMenu("Employee Claims")
		WebUI.verifyElementText(findTestObject('AdminPage/text_sysytemUsersMenuName'), "Employee Claims")
		KeywordUtil.logInfo('\"Employee Claims\" menu is selected from top bar')
	}
	
	@Keyword
	selectClaimEventFromDropdown(String claimEvent){
		common.selectOptionFromDropdown("Event", claimEvent)
		KeywordUtil.logInfo('Claim event set to: ' + claimEvent)
	}
	
	@Keyword
	selectClaimCurrencyFromDropdown(String claimCurrency){
		common.selectOptionFromDropdown("Currency", claimCurrency)
		KeywordUtil.logInfo('Claim currency set to: ' + claimCurrency)
	}
	
	@Keyword
	setClaimRemark(String claimRemark){
		WebUI.setText(findTestObject('ClaimPage/input_claimRemark'), claimRemark)
		KeywordUtil.logInfo('Claim remark set to: ' + claimRemark)
	}
	
	@Keyword
	def submitClaim(String claimEvent, String claimCurrency, String claimRemark) {
		selectClaimEventFromDropdown(claimEvent)
		selectClaimCurrencyFromDropdown(claimCurrency)
		setClaimRemark(claimRemark)
		WebUI.click(findTestObject('ClaimPage/btn_create'))
		
		WebUI.waitForElementVisible(findTestObject('CommonPage/tooltip_successfullySaved'), 20)
		WebUI.verifyElementVisible(findTestObject('CommonPage/tooltip_successfullySaved'))
		
		String claimReferenceId = WebUI.getAttribute(findTestObject('ClaimPage/input_claimReferenceId'), 'value')
		KeywordUtil.logInfo('Claim Reference Id: ' + claimReferenceId)
		return claimReferenceId	
	}
	
	@Keyword
	def selectExpenseTypeFromDropdown(String expenceType){
		common.selectOptionFromDropdown("Expense Type", expenceType)
		KeywordUtil.logInfo('Expense Type set to: ' + expenceType)
	}
	
	@Keyword
	def enterExpenseDate(String expenseDate) {
		WebUI.setText(findTestObject('ClaimPage/input_expenseDate'), expenseDate)
		KeywordUtil.logInfo('Expense Date set to: ' + expenseDate)
	}
	
	@Keyword
	def enterExpenseAmount(String expenseAmount) {
		WebUI.setText(findTestObject('ClaimPage/input_expenseAmount'), expenseAmount)
		KeywordUtil.logInfo('Expense Amount set to: ' + expenseAmount)
	}
	
	@Keyword
	def enterExpenseNote(String expenseNote) {
		WebUI.setText(findTestObject('ClaimPage/input_expenseNote'), expenseNote)
		KeywordUtil.logInfo('Expense Note set to: ' + expenseNote)
	}
	
	@Keyword
	def enterExpenceDetailsForClaim(String expenceType, String expenseDate, String expenseAmount, String expenseNote) {
		WebUI.verifyElementText(findTestObject('CommonPage/text_cardTitle'), "Submit Claim")
		WebUI.click(findTestObject('ClaimPage/btn_add'))
		
		selectExpenseTypeFromDropdown(expenceType)
		enterExpenseDate(expenseDate)
		enterExpenseAmount(expenseAmount)
		enterExpenseNote(expenseNote)
		
		WebUI.click(findTestObject('CommonPage/btn_save'))
		WebUI.waitForElementVisible(findTestObject('CommonPage/tooltip_successfullySaved'), 20)
		WebUI.verifyElementVisible(findTestObject('CommonPage/tooltip_successfullySaved'))
		
		WebUI.click(findTestObject('ClaimPage/btn_submit'))
		WebUI.click(findTestObject('ClaimPage/btn_back'))
	}
	
	@Keyword
	def setClaimReferenceId(String referenceId) {
		WebUI.setText(findTestObject('ClaimPage/input_enterClaimReferenceId'), referenceId)
		KeywordUtil.logInfo('Claim reference id value set to: ' + referenceId)
	}
	
	@Keyword
	selectClaimEventNameFromDropdown(String claimEventName){
		common.selectOptionFromDropdown("Event Name", claimEventName)
		KeywordUtil.logInfo('Claim event name set to: ' + claimEventName)
	}
	
	@Keyword
	searchClaimListByEventName(String claimEventName){
		common.selectOptionFromDropdown("Event Name", claimEventName)
		WebUI.click(findTestObject('CommonPage/btn_search'))
		KeywordUtil.logInfo('Claim list filtered by event name: ' + claimEventName)
	}
	
	@Keyword
	selectClaimStatusFromDropdown(String claimStatus){
		common.selectOptionFromDropdown("Status", claimStatus)
		KeywordUtil.logInfo('Claim status set to: ' + claimStatus)
	}
	
	@Keyword
	def searchClaimListBy_ReferenceId_EventName_Status(String referenceId, String eventName, String status) {
		setClaimReferenceId(referenceId)
		selectClaimEventNameFromDropdown(eventName)
		selectClaimStatusFromDropdown(status)
		WebUI.click(findTestObject('CommonPage/btn_search'))
	}
	
	@Keyword
	def verifyClaimsListFilteredByClaimReferenceId(String claimReferenceId) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('ClaimPage/text_textFromReferenceIdColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), claimReferenceId)
		}
	}
	
	@Keyword
	def verifyClaimsListFilteredByClaimEventName(String claimEventName) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('ClaimPage/text_textFromEventNameColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), claimEventName)
		}
	}
	
	@Keyword
	def verifyClaimsListFilteredByClaimDescripion(String claimDescription) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('ClaimPage/text_textFromDescriptionColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), claimDescription)
		}
	}
	
	@Keyword
	def verifyClaimsListFilteredByClaimCurrency(String claimCurrency) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('ClaimPage/text_textFromCurrencyColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), claimCurrency)
		}
	}
	
	@Keyword
	def verifyClaimsListFilteredByClaimSubmittedDate(String claimSubmittedDate) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('ClaimPage/text_textFromSubmittedDateColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), claimSubmittedDate)
		}
	}
	
	@Keyword
	def verifyClaimsListFilteredByClaimStatus(String claimStatus) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('ClaimPage/text_textFromStatusColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), claimStatus)
		}
	}
	
	@Keyword
	def verifyClaimsListFilteredByClaimAmount(String claimAmount) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('ClaimPage/text_textFromAmountColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), claimAmount)
		}
	}
	
	@Keyword
	def verifyMyClaimDetailsInTableBy_ReferenceId_EventName_Description_Currency_SubmittedDate_Status_Amount(String claimReferenceId, String claimEventName, String claimDescription, String claimCurrency, String claimSubmittedDate, String claimStatus, String claimAmount) {
		verifyClaimsListFilteredByClaimReferenceId(claimReferenceId)
		verifyClaimsListFilteredByClaimEventName(claimEventName)
		verifyClaimsListFilteredByClaimDescripion(claimDescription)
		verifyClaimsListFilteredByClaimCurrency(claimCurrency)
		verifyClaimsListFilteredByClaimSubmittedDate(claimSubmittedDate)
		verifyClaimsListFilteredByClaimStatus(claimStatus)
		verifyClaimsListFilteredByClaimAmount(claimAmount)
	}
	
	@Keyword
	def verifyEmployeeClaimsListFilteredByClaimEventName(String claimEventName) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('ClaimPage/text_textFromEmployeeEventNameColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), claimEventName)
		}
	}
	
	@Keyword
	def verifyEmployeeClaimDetailsInTableBy_EventName(String claimEventName) {
		verifyEmployeeClaimsListFilteredByClaimEventName(claimEventName)
	}
}
