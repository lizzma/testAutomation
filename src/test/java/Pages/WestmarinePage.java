package Pages;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class WestmarinePage extends AbstractPage {



    public void initializeTest(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public static String testingUrl (URL url) throws Exception{
        String response = "";
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try{
            connection.connect();
            response = connection.getResponseMessage();
            connection.disconnect();

            return response;
        }
        catch(Exception exp){
            //System.out.println("Por aqui paso algo malo: "+response);
            return exp.getMessage();
        }
    }




    @FindBy(css = "input#search.text.ui-autocomplete-input")
    public WebElement searchBar;

    @FindBy(css = "div.search form button.button")
    public WebElement searchIcon;

    @FindBy(css = ".total-records")
    public WebElement totalRecords;

    @FindBy(css = "div.span-19.results-block")
    public WebElement blockRecords;

    @FindBy(css = ".grid-entry .productName")
    public List<WebElement> productContainer;

    @FindBy(css = ".title-desc")
    public WebElement productNameDesc;



    @After
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void tearDown(WebDriver driver){
        driver.close();
    }

}
