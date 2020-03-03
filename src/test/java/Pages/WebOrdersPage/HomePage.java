package Pages.WebOrdersPage;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='ctl00_menu']")
    public List<WebElement> orderMenu;

    @FindBy(xpath = "//a[.='View all products']")
    public WebElement viewAllProductsButton;

    public List<String> orderMenuData(){
        List<String> menues = new ArrayList<>();
        menues.add("View all orders");
        menues.add("View all orders");
        menues.add("Order");
        return menues;

    }
}
