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
import pages.AddUserPage
import pages.AdminPage
import pages.Common
import pages.LoginPage

import org.openqa.selenium.Keys as Keys

'Navigate to the page'
Common common = new Common()
common.navigateToUrl(GlobalVariable.baseUrl)

'Login to the application with valid username and password'
LoginPage loginPage = new LoginPage()
loginPage.loginToTheApplication(GlobalVariable.username, GlobalVariable.password)

'Navigate to Admin menu'
AdminPage adminPage = new AdminPage()
adminPage.navigateToAdminMenu()

'Select "Users" menu from "User Management"'
adminPage.selectUsersMenuFromUserManagementTopBarMenu()

'Add new Admin user'
AddUserPage addUserPage = new AddUserPage()
String username = 'Katalon_Admin_User_' + new Random().nextInt(1000) + 1
addUserPage.addNewUser('Admin', 'Enabled', 'Emily Jones', username, '1Password*', '1Password*')

'Search and verify newly added user details'
adminPage.searchUsersByUserBy_Username_UserRole_EmployeeName_Status(username, 'Admin', 'Emily Jones', 'Enabled')

'Verify newly added user details'
adminPage.verifyUsersFilteredBy_Username_Role_EmployeeName_Status(username, 'Admin', 'Emily Jones', 'Enabled')
WebUI.comment('Verified that, \"' + username + '\" user details are shown correctly"')

'Delete the Admin user'
adminPage.deleteTheUser()

'Verify user deleted successfully'
adminPage.verifyUserDeletedSuccessfully()
WebUI.comment('Verified that, \"' + username + '\" user deleted successfully"')