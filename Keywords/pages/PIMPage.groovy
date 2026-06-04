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

public class PIMPage {
	Common common = new Common()
	
	@Keyword
	def navigateToPIMMenu() {
		LeftMenu leftMenu = new LeftMenu()
		leftMenu.selectMenuByName("PIM")
		KeywordUtil.logInfo('\"PIM\" menu is selected')
	}
	
	@Keyword
	def selectEmployeeListMenuFromTopBarMenu() {
		common.selectTopBarMenu("Employee List")
		WebUI.verifyElementText(findTestObject('AdminPage/text_sysytemUsersMenuName'), "Employee Information")
		KeywordUtil.logInfo('\"Employee List\" menu is selected from top bar')
	}
	
	@Keyword
	def selectAddEmployeeuFromTopBarMenu() {
		common.selectTopBarMenu("Add Employee")
		KeywordUtil.logInfo('\"Add Employee\" menu is selected from top bar')
	}
	
	@Keyword
	selectEmploymentStatusFromDropdown(String employmentStatus){
		common.selectOptionFromDropdownAndSearch("Employment Status", employmentStatus)
		KeywordUtil.logInfo('Employee list is filtered by employment status as: ' + employmentStatus)
	}
	
	@Keyword
	def searchEmployeeListByEmploymentStatus(String employmentStatus) {
		selectEmploymentStatusFromDropdown(employmentStatus)
	}
	
	@Keyword
	def verifyEmployeeListFilteredByEmploymentStatus(String employmentStatus) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('PIMPage/text_textFromEmploymentStatusColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), employmentStatus)
		}
	}
	
	@Keyword
	selectJobTitleFromDropdown(String jobTitle){
		common.selectOptionFromDropdownAndSearch("Job Title", jobTitle)
		KeywordUtil.logInfo('Employee list is filtered by job title as: ' + jobTitle)
	}
	
	@Keyword
	def searchEmployeeListByJobTitle(String jobTitle) {
		selectJobTitleFromDropdown(jobTitle)
	}
	
	@Keyword
	def verifyEmployeeListFilteredByJobTitle(String jobTitle) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('PIMPage/text_textFromJobTitleColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), jobTitle)
		}
	}
	
	@Keyword
	selectSubUnitFromDropdown(String subUnit){
		common.selectOptionFromDropdownAndSearch("Sub Unit", subUnit)
		KeywordUtil.logInfo('Employee list is filtered by sub unit as: ' + subUnit)
	}
	
	@Keyword
	def searchEmployeeListBySubUnit(String subUnit) {
		selectSubUnitFromDropdown(subUnit)
	}
	
	@Keyword
	def verifyEmployeeListFilteredBySubUnit(String subUnit) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('PIMPage/text_textFromSubUnitColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), subUnit)
		}
	}
	
	@Keyword
	def searchEmployeeListByEmployeeId(String employeeId) {
		WebUI.setText(findTestObject('CommonPage/input_employeeId'), employeeId)
		WebUI.click(findTestObject('CommonPage/btn_search'))
		KeywordUtil.logInfo('Employee list is filtered by employee id: ' + employeeId)
	}
	
	@Keyword
	def verifyEmployeeListFilteredByEmployeeId(String employeeId) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('PIMPage/text_textFromIdColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), employeeId)
		}
	}
	
	@Keyword
	def verifyEmployeeListFilteredByEmployeeFirstAndMiddleName(String employeeFirstName, String employeeMiddleName) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('PIMPage/text_textFromFirstAndMiddleNameColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), employeeMiddleName.isEmpty()? employeeFirstName : employeeFirstName + ' ' + employeeMiddleName)
		}
	}
	
	@Keyword
	def verifyEmployeeListFilteredByEmployeeLastName(String employeeLastName) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('PIMPage/text_textFromLastNameColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), employeeLastName)
		}
	}
	
	@Keyword
	def verifyEmployeeListFilteredBy_EmployeeId_FirstName_MiddleName_LastName(String employeeId, String firstName, String middleName, String lastName) {
		verifyEmployeeListFilteredByEmployeeId(employeeId)
		verifyEmployeeListFilteredByEmployeeFirstAndMiddleName(firstName, middleName)
		verifyEmployeeListFilteredByEmployeeLastName(lastName)
	}
	
	@Keyword
	def deleteTheEmployee() {
		WebUI.click(findTestObject('CommonPage/btn_deleteUser'))
		WebUI.verifyElementVisible(findTestObject('CommonPage/text_deleteConfirmationMsg'))
		KeywordUtil.logInfo("Delete confirmation alert is displayed.")
		WebUI.click(findTestObject('CommonPage/btn_confirmDelete'))
	}
	
	@Keyword
	def verifyEmployeeDeletedSuccessfully() {
		WebUI.waitForElementVisible(findTestObject('CommonPage/tooltip_successfullyDeleted'), 20)
		WebUI.verifyElementVisible(findTestObject('CommonPage/tooltip_successfullyDeleted'))
		
		WebUI.waitForElementVisible(findTestObject('CommonPage/tooltip_noRecordsFound'), 20)
		WebUI.verifyElementVisible(findTestObject('CommonPage/tooltip_noRecordsFound'))
	}
}
