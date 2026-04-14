package configReader;

import models.MonsterData;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ConfigReader
{
    private static final JSONObject CONFIG;

    static {
        try {
            CONFIG = loadConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String baseURL()
    {
        return CONFIG.getString("baseUrl");
    }


    public static String nameValue()
    {
        return CONFIG.getJSONObject("testData").getString("name");
    }

    public static String hpValue()
    {
        return CONFIG.getJSONObject("testData").getString("hp");
    }

    public static String attackValue()
    {
        return CONFIG.getJSONObject("testData").getString("attack");
    }

    public static String defenceValue()
    {
        return CONFIG.getJSONObject("testData").getString("defence");
    }

    public static String speedValue()
    {
        return CONFIG.getJSONObject("testData").getString("speed");
    }

    public static MonsterData monsterData()
    {
        JSONObject testData = CONFIG.getJSONObject("testData");
        return new MonsterData(
                testData.getString("name"),
                testData.getString("hp"),
                testData.getString("attack"),
                testData.getString("defence"),
                testData.getString("speed")
        );
    }


    private static JSONObject loadConfig() throws IOException {
         try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.json")) {
             if (inputStream == null) {
                 throw new RuntimeException("no file available");

             }
             String text = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
             return new JSONObject(text);
         } catch (Exception e) {
             throw new RuntimeException("filed to laod file");
         }
     }
}
