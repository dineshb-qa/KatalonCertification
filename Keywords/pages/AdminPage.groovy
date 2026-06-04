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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class AdminPage {

	Common common = new Common()
	
	@Keyword
	def navigateToAdminMenu() {
		LeftMenu leftMenu = new LeftMenu()
		leftMenu.selectMenuByName("Admin")
		KeywordUtil.logInfo('\"Admin\" menu is selected')
	}
	
	@Keyword
	def selectUsersMenuFromUserManagementTopBarMenu() {
		common.selectSubMenuFromTopBarMenu("User Management", "Users")
		WebUI.verifyElementText(findTestObject('AdminPage/text_sysytemUsersMenuName'), "System Users")
		KeywordUtil.logInfo('\"User Management -> Users\" menu is selected from top bar')
	}
	
	@Keyword
	selectUserRoleFromDropdown(String userRoleName){
		common.selectOptionFromDropdownAndSearch("User Role", userRoleName)
		KeywordUtil.logInfo('User list is filtered by user role as: ' + userRoleName)
	}
	
	@Keyword
	selectUserStatusFromDropdown(String userStatusName){
		common.selectOptionFromDropdownAndSearch("Status", userStatusName)
		KeywordUtil.logInfo('User list is filtered by user status as: ' + userStatusName)
	}
	
	@Keyword
	def searchUsersByUserByRoleAndStatus(String userRole, String userStatus) {
		selectUserRoleFromDropdown(userRole)
		selectUserStatusFromDropdown(userStatus)
	}
	
	@Keyword
	def searchUsersByUserBy_Username_UserRole_EmployeeName_Status(String username, String userRole, String employeeName, String userStatus) {
		setUsername(username)
		selectUserRoleFromDropdown(userRole)
		selectEmployeeName(employeeName)
		selectUserStatusFromDropdown(userStatus)
	}
	
	@Keyword
	def setUsername(String username) {
		WebUI.setText(findTestObject('AddUserPage/input_username'), username)
	}
	
	@Keyword
	def selectEmployeeName(String employeeName) {
		WebUI.setText(findTestObject('AddUserPage/input_employeeName'), employeeName)
		WebUI.waitForElementVisible(findTestObject('AddUserPage/ddOption_firstEmpoyeeNameSuggestion'), 15)
		WebUI.waitForElementClickable(findTestObject('AddUserPage/ddOption_firstEmpoyeeNameSuggestion'), 15)
	}
	
	@Keyword
	def searchUsersByUserByRole(String userRole) {
		selectUserRoleFromDropdown(userRole)
	}
	
	@Keyword
	def searchUsersByStatus(String userStatus) {
		selectUserStatusFromDropdown(userStatus)
	}
	
	@Keyword
	def verifyUsersFilteredByUsername(String username) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('AdminPage/text_textFromUsernameColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), username)
		}
	}
	
	@Keyword
	def verifyUsersFilteredByAdminRole(String userRoleValue) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('AdminPage/text_textFromUserRoleColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), userRoleValue)
		}		
	}
	
	@Keyword
	def verifyUsersFilteredByEmployeeName(String employeeName) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('AdminPage/text_textFromEmployeeNameColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), employeeName)
		}
	}
	
	@Keyword
	def verifyUsersFilteredByEnabledStatus(String userStatusValue) {
		List<WebElement> rows = WebUI.findWebElements(findTestObject('AdminPage/text_textFromStatusColumnCellInTable'), 10)
		KeywordUtil.logInfo('Rowscount:' + rows.size())
		
		if(rows.size() == 0) {
			KeywordUtil.logInfo("There are no matching records.")
		}
		
		for (int i = 0; i < rows.size(); i++) {
			WebUI.verifyElementText(WebUI.convertWebElementToTestObject(rows.get(i)), userStatusValue)
		}
	}
	
	@Keyword
	def verifyUsersFilteredByAdminRoleAndEnabledStatus(String userRoleValue, String userStatusValue) {
		verifyUsersFilteredByAdminRole(userRoleValue)
		verifyUsersFilteredByEnabledStatus(userStatusValue)
	}
	
	@Keyword
	def verifyUsersFilteredByAdminRoleAndDisabledStatus(String userRoleValue, String userStatusValue) {
		verifyUsersFilteredByAdminRole(userRoleValue)
		verifyUsersFilteredByEnabledStatus(userStatusValue)
	}
	
	@Keyword
	def verifyUsersFilteredBy_Username_Role_EmployeeName_Status(String username, String userRole, String employeeName, String userStatus) {
		verifyUsersFilteredByUsername(username)
		verifyUsersFilteredByAdminRole(userRole)
		verifyUsersFilteredByEmployeeName(employeeName)
		verifyUsersFilteredByEnabledStatus(userStatus)
	}
	
	@Keyword
	def deleteTheUser() {
		WebUI.click(findTestObject('CommonPage/btn_deleteUser'))
		WebUI.verifyElementVisible(findTestObject('CommonPage/text_deleteConfirmationMsg'))
		KeywordUtil.logInfo("Delete confirmation alert is displayed.")
		WebUI.click(findTestObject('CommonPage/btn_confirmDelete'))
	}
	
	@Keyword
	def verifyUserDeletedSuccessfully() {		
		WebUI.waitForElementVisible(findTestObject('CommonPage/tooltip_successfullyDeleted'), 20)
		WebUI.verifyElementVisible(findTestObject('CommonPage/tooltip_successfullyDeleted'))
		
		WebUI.waitForElementVisible(findTestObject('CommonPage/tooltip_noRecordsFound'), 20)
		WebUI.verifyElementVisible(findTestObject('CommonPage/tooltip_noRecordsFound'))
	}
}
