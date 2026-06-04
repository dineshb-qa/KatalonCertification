import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
import pages.AddEmployeePage
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

'Select "Add Employee" tab'
pimPage.selectAddEmployeeuFromTopBarMenu()

'Add new employee'
AddEmployeePage addEmployeePage = new AddEmployeePage()
String employeeId = 'EMP_' + new Random().nextInt(100) + 1
addEmployeePage.createNewEmployeeWithFullNameDetails_WithEmployeeIDAndImage('Melvin', 'Brandon', 'Moore', employeeId, RunConfiguration.getProjectDir() + "/Include/resources/inspectocat.jpg")

'Search and Verify new Employee Details'
pimPage.selectEmployeeListMenuFromTopBarMenu()
pimPage.searchEmployeeListByEmployeeId(employeeId)
pimPage.verifyEmployeeListFilteredBy_EmployeeId_FirstName_MiddleName_LastName(employeeId, 'Melvin', 'Brandon', 'Moore')
WebUI.comment('Verified that, \"' + employeeId + '\" employee details are shown correctly"')

'Delete the employee'
pimPage.deleteTheEmployee()

'Verify employee deleted successfully'
pimPage.verifyEmployeeDeletedSuccessfully()
WebUI.comment('Verified that, employee with employee id \"' + employeeId + '\" is deleted successfully"')