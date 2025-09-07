package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestDataUtil {
    private static JsonNode testData;

    static {
        try {
            File file = new File("src/test/resources/testdata/apiTestData.json");
            ObjectMapper mapper = new ObjectMapper();
            testData = mapper.readTree(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test data: " + e.getMessage());
        }
    }

    public static String getStringData(String section, String key) {
        return testData.get(section).get(key).asText();
    }

    public static int getIntData(String section, String key) {
        return testData.get(section).get(key).asInt();
    }
}
