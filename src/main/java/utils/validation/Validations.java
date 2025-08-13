package utils.validation;

import io.qameta.allure.Step;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class Validations {
    private Validations(){}
@Step("Validate True")
    public static void validateTrue(boolean condition , String message){

        Assert.assertTrue(condition,message);
    }
    public static void validateEquals(String actual,String expected ,String message){
        Assert.assertEquals(actual,expected,message);
    }


}