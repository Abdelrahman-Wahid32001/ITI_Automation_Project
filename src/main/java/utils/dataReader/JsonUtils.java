package utils.dataReader;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonUtils() {
    }

     //Reads a JSON file and maps it to the specified class type.

    public static <T> T readJsonAsObject(String filePath, Class<T> valueType) {
        try {
            return mapper.readValue(new File(filePath), valueType);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }
}


