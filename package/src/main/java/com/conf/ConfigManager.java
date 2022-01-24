package com.conf;

public class ConfigManager {
    private final static String message = "hello module";

    private static ConfigManager instance;

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getMessage() {
        return message;
    }
}
