package com.example.order.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {

    // method to convert object to json using Gson
    public static String toJson(Object object) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(object);
    }

}