package steps;

import base.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class addMultipleEmployeesSteps extends BaseClass {
    @Given("user navigates to the add employee page")
    public void user_navigates_to_the_add_employee_page() {
        pimPage.navigateToAddEmployee();
    }
    @When("user enters new employee's {string}, {string}, and {string}")
    public void userEntersNewEmployeeSAnd(String firstName, String middleName, String lastName) {
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }
    @When("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        addEmployeePage.saveButton.click();
    }
    @Then("new employee {string} is added successfully")
    public void new_employee_is_added_successfully(String fullName) {
        Assert.assertEquals("Employee full name does not match", fullName, personalDetailsPage.employeeFullName.getText());
    }
    @When("user enters employee's full name and clicks on save button")
    public void user_enters_employee_s_full_name_and_clicks_on_save_button(DataTable dataTable) {
        List<Map<String, String>> mapList = dataTable.asMaps();
        int mapListSize = mapList.size();
        System.out.println("mapListSize = " + mapListSize);
//        System.out.println(mapList);
//        mapList.forEach(System.out::println);
        for (Map<String, String> user : mapList) {
            System.out.println(user.get("FirstName"));
            addEmployeePage.firstName.sendKeys(user.get("FirstName"));   // Ariana
            addEmployeePage.middleName.sendKeys(user.get("MiddleName")); // A.
            addEmployeePage.lastName.sendKeys(user.get("LastName"));     // Knight
            addEmployeePage.saveButton.click();

            // Assertion/Validation
            String expectedFullName = user.get("FirstName") + " " + user.get("MiddleName") + " " + user.get("LastName");
            String actualFullName = personalDetailsPage.employeeFullName.getText();
            Assert.assertEquals("User does not match",expectedFullName, actualFullName);

            // click Add Employee again
            wait(1);
            pimPage.addEmployee.click();
        }
    }
    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("All employees are added successfully using DataTable");
    }

}
