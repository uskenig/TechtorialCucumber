package StepDefinitions.WebOrderStepDefinition;

import Pages.WebOrdersPage.AllProductsPage;
import Pages.WebOrdersPage.HomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AllProductsStepDef {
    HomePage homePage = new HomePage();
    AllProductsPage allProductsPage = new AllProductsPage();

    @Then("the user click view all products button")
    public void the_user_click_view_all_products_button() {
        homePage.viewAllProductsButton.click();
    }

    @Then("the user validate product table")
    public void the_user_validate_product_table() {
        List<String> actualList = allProductsPage.getProductList();
        List<String> expectedList = allProductsPage.expectedData();
        Assert.assertTrue(actualList.containsAll(expectedList));
    }
}
