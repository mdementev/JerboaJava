package skeleton;

import Helpers.DriverHelper;
import cucumber.api.java.en.Given;

import java.util.Dictionary;

public class GoogleSearchSteps {
    @Given("^I navigate to \"([^\"]*)\"$")
    public void I_navigate_to(String arg1) throws Throwable {
        Dictionary<String, Object> settings = DriverHelper.getCurrentDriver().get();
        DriverHelper.getCurrentDriver();
    }




    private String getWelcomeMessage(int PlatformID, String PlatformType, int Appversion)
    {
        if (PlatformType == "SpecialDevice" && AppVersion == 1 && (PlatformID == 1 || PlatformID == 2) )
        {
            return OLD_VALUE;
        }

        booleanb shownew = false;

        switch (PlatformID)
        {
            case 1:
                shownew = true;
                break;

            case 2:
                shownew = true;

            case 3:
                return OLD_VALUE;

            case 4:
                shownew = true;
                break;

        }

        if (shownew) {
            if (AppVersion < VERSION_THRESHOLD) {
                return OLD_VALUE;
            }
            else {
                return NEW_VALUE;;
            }
        }

        return null;
    }


}
