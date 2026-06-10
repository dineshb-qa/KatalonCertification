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

WebUI.callTestCase(findTestCase('PIM/Add New Employee with Full Name and Image'), [('empFirstName') : 'Sachin', ('empMiddleName') : 'Katalon'
        , ('empLastName') : 'Yadav'], FailureHandling.OPTIONAL)

'Navigate to Admin menu'
AdminPage adminPage = new AdminPage()
adminPage.navigateToAdminMenu()

'Select "Users" menu from "User Management"'
adminPage.selectUsersMenuFromUserManagementTopBarMenu()

'Add new ESS user in disabled state'
AddUserPage addUserPage = new AddUserPage()
String username = 'Katalon_ESS_Disabled_User_' + new Random().nextInt(1000) + 1
addUserPage.addNewUser('ESS', 'Disabled', 'Sachin Yadav', username, '1Password*', '1Password*')

'Search System Users by Disabled status'
adminPage.searchUsersByStatus("Disabled")

'Verify System Users filered by Disabled status'
adminPage.verifyUsersFilteredByEnabledStatus("Disabled")
WebUI.comment('Verified that, in the search results, the \"Status\" column value for each user is \"Disabled\"')