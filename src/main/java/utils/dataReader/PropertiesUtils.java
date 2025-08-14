package utils.dataReader;

import org.apache.commons.io.FileUtils;
import utils.report.LogsUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;

public class PropertiesUtils {

    private PropertiesUtils() {
        super();
    }

    public static final String PROPERTIES_PATH = "src/main/resources/";
    public static Properties loadProperties() {
        try {
            Properties properties = new Properties();
            Collection<File> propertiesFilesList;

            propertiesFilesList = FileUtils.listFiles(
                    new File(PROPERTIES_PATH),
                    new String[]{"properties"},
                    true // recursively include subfolders
            );

            propertiesFilesList.forEach(propertyFile -> {
                try (FileInputStream fis = new FileInputStream(propertyFile)) {
                    properties.load(fis);
                } catch (IOException ioe) {
                    LogsUtils.error("Error loading file: " + propertyFile.getName() + " - " + ioe.getMessage());
                }
            });

            // Merge loaded properties with existing system properties
            properties.putAll(System.getProperties());
            System.getProperties().putAll(properties);

            LogsUtils.info("Loading Properties File Data");
            return properties;

        } catch (Exception e) {
            LogsUtils.error("Failed to Load Properties File Data because: " + e.getMessage());
            return null;
        }
    }
    public static String getPropertyValue(String key){
        try{
            return System.getProperty(key);
        }catch (Exception e){
            LogsUtils.error(e.getMessage());
            return "";
        }
    }
}
