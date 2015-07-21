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
        DriverHelper.getCurrentDriver().navigate().to(java.lang.String.valueOf(arg1));
    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(java.lang.String arg1) throws Throwable {
        DriverHelper.getCurrentDriver().findElement(By.id("lst-ib")).sendKeys(arg1);
    }

    @Then("^I found \"([^\"]*)\"$")
    public void I_found(String arg1) throws Throwable {
        Assert.assertEquals(arg1,
                DriverHelper.getCurrentDriver().
                        findElement(By.xpath("//ol[@id='rso']/div[@class='srg']")).findElement(By.xpath("//li[@class='g']//h3[@class='r']/a[text()='" + arg1 + "']")).getText());
    }

    @And("^Title is \"([^\"]*)\"$")
    public void Title_is(String arg1) throws Throwable {
        Assert.assertEquals(arg1, DriverHelper.getCurrentDriver().getTitle());
    }
}
