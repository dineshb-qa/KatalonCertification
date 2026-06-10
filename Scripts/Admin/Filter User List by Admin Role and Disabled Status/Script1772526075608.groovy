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

WebUI.callTestCase(findTestCase('PIM/Add New Employee with Full Name and Image'), [('empFirstName') : 'Neeraj', ('empMiddleName') : 'Katalon'
        , ('empLastName') : 'Sharma'], FailureHandling.OPTIONAL)

'Navigate to Admin menu'
AdminPage adminPage = new AdminPage()
adminPage.navigateToAdminMenu()

'Select "Users" menu from "User Management"'
adminPage.selectUsersMenuFromUserManagementTopBarMenu()

'Add new Admin user with disabled status'
AddUserPage addUserPage = new AddUserPage()
String username = ('Katalon_Admin_User_' + new Random().nextInt(1000)) + 1
addUserPage.addNewUser('Admin', 'Enabled', 'Neeraj Sharma', username, '1Password*', '1Password*')

'Search System Users by Admin role and Disabled status'
adminPage.searchUsersByUserByRoleAndStatus("Admin", "Disabled")

'Verify System Users filered by Admin role and Disabled status'
adminPage.verifyUsersFilteredByAdminRoleAndDisabledStatus("Admin", "Disabled")
WebUI.comment('Verified that, in the search results, the \"User Role\" column value for each user is \"Admin\" and \"Status\" column value for each user is \"Disabled\"')