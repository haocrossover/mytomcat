package com.killer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by killer on 21-5-18.
 */
public class MyMapping {

    private static Map<String,String> mapping =new HashMap<String, String>();

    static {
        mapping.put("/myServer","com.killer.");
    }

    public Map<String,String> getMapping() {
        return mapping;
    }
}
