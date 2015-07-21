package skeleton;

import Helpers.DriverHelper;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class GoogleSearchSteps {
    @Given("^I navigate to \"([^\"]*)\"$")
    public void I_navigate_to(String arg1) throws Throwable {
        DriverHelper.getCurrentDriver().navigate().to(arg1);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String arg1) throws Throwable {
        DriverHelper.getCurrentDriver().findElement(By.id("lst-ib")).sendKeys(arg1);
    }

    @Then("^I found \"([^\"]*)\"$")
    public void I_found(String arg1) throws Throwable {
        Assert.assertEquals(arg1,
                DriverHelper.getCurrentDriver().
                        findElement(By.xpath("//*[@id=\"rso\"]/div[3]/li[1]/div/h3/a")).getText());
    }

    @And("^Title is \"([^\"]*)\"$")
    public void Title_is(String arg1) throws Throwable {
        Assert.assertEquals(arg1, DriverHelper.getCurrentDriver().getTitle());
    }
}
