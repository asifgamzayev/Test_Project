package com.test.Utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    private final static String PATH ="Config.properties";

    static {
        FileInputStream fis = null;
        try {
            fis =  new FileInputStream(PATH);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}

