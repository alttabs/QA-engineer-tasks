package stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import pages.WexPage;

import java.util.List;

public class StepDefinitions {
    private WexPage pom;
    private String toSearch;

    @Before
    public void setUp() throws Exception {
        pom = new WexPage();
    }

    @Given("I navigate to “www.wexinc.com”")
    public void NavigateToWexincCom() throws Throwable {
        pom.NavigateToWex("https://www.wexinc.com/");
    }


    @When("I select the search field")
    public void selectSearchField() throws Throwable {
        pom.getSearchField(".//*[@id=\"mega-menu-item-439\"]/a/i");
    }

    @Then("I insert {string} in the field")
    public void IinsertInTheField(String toSearch) throws Throwable {
        this.toSearch = toSearch;
        pom.fillSearchField("s", toSearch);
    }


    @And("I press search")
    public void iPressSearch() throws Throwable {
        pom.clickSearchField("//*[contains(@class, 'button') and contains(@class, 'wex-search-group-button')]");
    }

    @Then("I validate the returned result")
    public void iValidateTheReturnedResult() throws Throwable {
        List<WebElement> elements = pom.selectResults("//*[@class=\"wex-search-item wex-vr-m-bottom-small\"]/h4/a");

        Boolean isValid = true;
        for (WebElement e : elements) {
            String elementFound = e.getAttribute("innerHTML").toUpperCase();
            String stringToSearch = toSearch.toUpperCase();
            System.out.println(elementFound);

            if (!elementFound.contains(stringToSearch)) {
                isValid = false;
            }
        }
        if (!isValid) {
            Assert.fail();
        }
        pom.testQuit();
    }


    @Then("I validate if the search page is loaded")
    public void iValidateIfTheSearchPageIsReloaded() throws Throwable {
        String urlExpect = "https://www.wexinc.com/?bline=&s=";
        String urlReturned = pom.getPageUrl();
        if (urlExpect.equals(urlReturned)) {
            System.out.println("The expected page is loaded");
        } else {
            Assert.fail();
        }
        pom.testQuit();
    }

    @Then("I validate if the proper not found message is returned")
    public void iValidateIfTheProperMessageIsReturned() throws Throwable {
        String textMessage = pom.getElement("//*[@id=\"mainContent\"]/div[2]/div/div/div/p").getText();
        if (textMessage.equals("Sorry, there are no results that meet this criteria.")) {
            System.out.println("Message returned: " + textMessage);
        } else {
            Assert.fail();
        }
        pom.testQuit();

    }

    @Then("I validate if the keyword searched matches what was actually searched by the system")
    public void iValidateIfTheKeywordSearchedMatchTheDisplayed() throws Throwable {
        String displayedSearch = pom.getCssSelector("body > div.off-canvas-wrapper > div.off-canvas-content > div.wex-hero_container.wex-hero_container--short > div > div > nav > ul > li:nth-child(4)").getText();
        if (displayedSearch.contains(toSearch)) {
            System.out.println("Keyword returned: " + displayedSearch);
        }
        pom.testQuit();

    }

    @And("validate if the resulting article is really what is being shown as result")
    public void iNavigateToResultSearchArticle() {
        String articleResult = pom.getElement("//*[@id=\"mainContent\"]/div[2]/div/div/div[1]/h4/a").getText();
        pom.getElement("//*[@id=\"mainContent\"]/div[2]/div/div/div[1]/h4/a").click();
        String articleTitle = pom.getCssSelector("body > div.off-canvas-wrapper > div.off-canvas-content > div.wex-hero_container.wex-hero_container--short > div > div > div > div > div > h1").getText();
        if (articleResult.equals(articleTitle)) {
            System.out.println("Result displayed: " + articleResult + " Article title: " + articleTitle);
        } else {
            Assert.fail();
        }
        pom.testQuit();

    }

    @Then("I validate if the counter for total results does not exist")
    public void iValidadeIfTotalResultsDoesnotExists() {
        Boolean contains = pom.containsUrl();
        if (!contains) {
            System.out.println("[Success]Expected behavior: not display the total result");
        } else {
            System.out.println("It's not the expected behavior to show total results");
            Assert.fail();
        }
        pom.testQuit();
    }
}
