package Pages.EtsyPage;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class EtsyPage {
    public EtsyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='global-enhancements-search-query']")
    public WebElement searchBox;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchButton;


    }
