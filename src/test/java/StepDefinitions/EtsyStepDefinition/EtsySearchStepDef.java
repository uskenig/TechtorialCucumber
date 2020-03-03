package StepDefinitions.EtsyStepDefinition;

import Pages.EtsyPage.EtsyPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EtsySearchStepDef {
    WebDriver driver = Driver.getDriver();
    EtsyPage etsyHomePage = new EtsyPage();

    @Given("the user navigate to the Etsy")
    public void the_user_navigate_to_the_Etsy() {
        driver.get(ConfigReader.getProperty("urlEtsy"));
    }

    @When("the user search {string}")
    public void the_user_search(String searchValue) {
        etsyHomePage.searchBox.sendKeys(searchValue);
        etsyHomePage.searchButton.click();
    }

    @Then("the user validate title {string}")
    public void the_user_validate_title(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
}
