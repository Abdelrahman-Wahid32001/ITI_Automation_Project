
package drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.dataReader.PropertiesUtils;

import java.util.Map;

public class D2_EdgeOption extends AbstractDriver implements WebDriverOptions<EdgeOptions>{
    @Override
    public EdgeOptions getOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        //edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--disable-extensions");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--remote-allow-origins=*");
        if(!PropertiesUtils.getPropertyValue("executionType").equalsIgnoreCase("local")){
            edgeOptions.addArguments("--headless=new");
             edgeOptions.addArguments("window-size=1920,1080"); 
        }
        Map<String, Object> edgePrefs = Map.of(
                "profile.default_content_setting_values.notifications", 2,
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "autofill.profile_enabled", false
        );
        edgeOptions.setExperimentalOption("prefs", edgePrefs);
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return edgeOptions;
    }

    @Override
    public WebDriver startDriver() {
        return new EdgeDriver(getOptions());
    }
}
