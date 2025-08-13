package tests.testcases;


import org.testng.annotations.Test;
import pages.P0_HomePage;
import tests.TestBase;
import utils.helper.PropertiesUtils;


public class TestContactUsFeature extends TestBase {


    @Test
    public void testContactUsfeature() {

        new P0_HomePage(driver)
                .navigateToPage()
                .assertTitle()
                .assertURL()
                .openContactUsPage()
                .fullContactUsFields(PropertiesUtils.getPropertyValue("Fname") + PropertiesUtils.getPropertyValue("Lname")
                        , PropertiesUtils.getPropertyValue("Email")
                        , PropertiesUtils.getPropertyValue("Message"))
                .clickToSubmitMessage();

    }

    @Test
    public void testContactUsfeatureWithInvalidEmail() {
        new P0_HomePage(driver)
                .navigateToPage()
                .assertTitle()
                .assertURL()
                .openContactUsPage()
                .fullContactUsFields(data.getFname() + data.getLname(), data.getInvalidEmail(), user.MSG)
                .clickToSubmitMessage();
    }

    @Test
    public void testContactUsfeatureWithInvalidMassage() {
        new P0_HomePage(driver)
                .navigateToPage()
                .assertTitle()
                .assertURL()
                .openContactUsPage()
                .fullContactUsFields(user.Fname + user.Lname, user.Email.get(0), user.InvalidMSG)
                .clickToSubmitMessage();
    }

}