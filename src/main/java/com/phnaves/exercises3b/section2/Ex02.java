package com.phnaves.exercises3b.section2;

import java.util.HashMap;
import java.util.Map;

class Config {
    static Map<String, String> configs = new HashMap<>();

    static {
        configs.put("Config 1", "Full access");
        configs.put("Config 2", "Notifications");
    }
}

public class Ex02 {
    public static void main(String[] args) {
        System.out.println(Config.configs);
    }
}
