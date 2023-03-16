package steps;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class Login2Steps extends BaseClass {
    @When("admin user logs in with valid credentials")
    public void admin_user_logs_in_with_valid_credentials() {
        //1st way
        loginPage.loginToWebsiteViaConfigs("username", "password");

        //2nd way
//        sendText(loginPage.username, ConfigsReader.getProperties("username"));
//        sendText(loginPage.password, ConfigsReader.getProperties("password"));
//        click(loginPage.loginBtn);

        //3rd way
//        loginPage.username.sendKeys("Admin");  // hardcode
//        loginPage.password.sendKeys(ConfigsReader.getProperties("password")); // from ConfigsReader
//        loginPage.loginBtn.clear();
    }
    @Then("admin user logs in successfully")
    public void admin_user_logs_in_successfully() {
        String expectedMessage = "Welcome Admin";
        String actualMessage = dashboardPage.welcome.getText();
        Assert.assertEquals("Admin user unable to log in",expectedMessage,actualMessage);
    }

    @When("ess user logs in with valid credentials")
    public void ess_user_logs_in_with_valid_credentials() {
        loginPage.loginToWebsiteViaConfigs("essUsername", "essPassword");
    }
    @Then("ess user logs in successfully")
    public void ess_user_logs_in_successfully() {
        String expectedMessage = "Welcome John";
        String actualMessage = dashboardPage.welcome.getText();
        Assert.assertEquals("ESS user unable to log in",expectedMessage,actualMessage);
    }

    @When("user enters a valid {string} and a valid {string}")
    public void user_enters_a_valid_and_a_valid(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
    }
    @And("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.loginBtn.click();
    }
    @Then("user logs in successfully and a {string} is displayed")
    public void user_logs_in_successfully_and_a_is_displayed(String expectedMessage) {
        //String actualMessage = dashboardPage.welcome.getText();
        Assert.assertEquals("User login is NOT successful",expectedMessage, dashboardPage.welcome.getText());
    }
//    @When("Admin user enters login credentials")
//    public void admin_user_enters_login_credentials(io.cucumber.datatable.DataTable dataTable) {
//        List<Map<String, String>> mapList = dataTable.asMaps();
//        for (Map<String, String> loginCredentials : mapList){
//            if (loginCredentials.get("Username") == null){
//
//            }
//        }
//    }
//    @Then("login negative tests are successfully")
//    public void login_negative_tests_are_successfully() {
//
//    }

}
