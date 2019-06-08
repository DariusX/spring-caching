package com.zerses.spring.caching.repository;

import java.util.HashMap;
import java.util.Map;

public class MyRepository {

    private static Map<String, String> storageMap = new HashMap<>();

    static {
        storageMap.put("K1", "V1");
        storageMap.put("K2", "V2");
        storageMap.put("K3", "V3");
        storageMap.put("K4", "V4");
        storageMap.put("K5", "V5");
        storageMap.put("K6", "V6");
    }

    public static String getV(String key) {
        return storageMap.get(key);
    }
}
