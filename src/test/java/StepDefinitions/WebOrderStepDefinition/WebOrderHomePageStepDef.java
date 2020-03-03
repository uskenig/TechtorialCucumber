package StepDefinitions.WebOrderStepDefinition;

import Pages.WebOrdersPage.HomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebOrderHomePageStepDef {
    HomePage page = new HomePage();

    @Then("the user validate menu order")
    public void the_user_validate_menu_order() {
        //this is for api response or database
        List<String> expected = page.orderMenuData();
        //this is coming from website
        List<String> actual = new ArrayList<>();
        //used this first loop to get the text from web elements
        for(WebElement element : page.orderMenu){
            actual.add(element.getText());
        }
        for (int i = 0; i < actual.size(); i++){
            Assert.assertEquals(expected.get(i), actual.get(i));
        }
        System.out.println("This is for menu");
    }
}
