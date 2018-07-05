package StepsDefinitions;

import Pages.WestmarinePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URL;


public class Westmarine_steps extends WestmarinePage {

    protected static WebDriver driver;
    protected static WestmarinePage currentPage = new WestmarinePage();
    int  totalRcs=0;
    String productName = "";



    @Given("^I am on Home Page$")
    public void i_am_on_Home_Page() throws Throwable {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to ("https://www.westmarine.com/");
        URL url = new URL(driver.getCurrentUrl());
        currentPage.initializeTest(driver);

        String response = currentPage.testingUrl(url);
        Assert.assertTrue("It's not ok",response.equalsIgnoreCase("ok")== true);
        System.out.println("The page load as expected");
        System.out.println();

    }

    @And("^I enter an item \"([^\"]*)\"$")
    public void i_enter_an_item(String item) throws Throwable {

        currentPage.searchBar.sendKeys(item);
        System.out.println("Item to find: "+item);
        System.out.println();

    }

    @When("^I click on the search icon$")
    public void i_click_on_the_search_icon() throws Throwable {
        Assert.assertTrue("The icon is not displayed", currentPage.searchIcon.isEnabled()== true);
        currentPage.searchIcon.click();

    }

    @Then("^I should able to see the search results$")
    public void i_should_able_to_see_the_search_results() throws Throwable {
        String totRecords="";
        Assert.assertTrue("There's no value for total records", currentPage.totalRecords.isDisplayed() == true);
        Assert.assertTrue("There's no more than one result for the research", currentPage.blockRecords.isDisplayed()== true);
        if (currentPage.totalRecords.getText().contains("(") || currentPage.totalRecords.getText().contains(")") ){
            totRecords = currentPage.totalRecords.getText().replace("(","");
            totRecords = totRecords.replace(")","");
        }
        totalRcs = Integer.parseInt(totRecords);
        System.out.println("Total records: "+totalRcs);
        System.out.println();
    }

    @And("^I am able to select one$")
    public void i_am_able_to_select_one() throws Throwable {
        Assert.assertTrue("There's no results", totalRcs > 0);
        System.out.println("size visible items " + currentPage.productContainer.size());
        System.out.println();
        int ramdonNum = (int) Math.floor(Math.random() * currentPage.productContainer.size());
        productName = currentPage.productContainer.get(ramdonNum).getText();
        System.out.println("product name "+productName);
        System.out.println();
        currentPage.productContainer.get(ramdonNum).click();
    }

    @And("^selected item is the same displayed$")
    public void selected_item_is_the_same_displayed() throws Throwable {
        Assert.assertTrue("item is not the same selected",productName.equalsIgnoreCase(currentPage.productNameDesc.getText()));
        System.out.println("Item selected match with the item displayed: "+currentPage.productNameDesc.getText());
        currentPage.tearDown(driver);
    }
}
