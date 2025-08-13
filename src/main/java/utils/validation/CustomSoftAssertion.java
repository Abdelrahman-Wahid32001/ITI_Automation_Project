package utils.validation;

import org.testng.asserts.SoftAssert;

public class CustomSoftAssertion extends SoftAssert {

    public static CustomSoftAssertion SoftAssertion = new CustomSoftAssertion();
    public static void AssertAll(){
        try {
            SoftAssertion.assertAll("Custom Soft Assertion");
        }
        catch (Exception e) {
            System.out.println("Custom Soft Assertion Failed");

        }
    }

}
