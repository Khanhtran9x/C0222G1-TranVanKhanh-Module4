package com.dictionary.service;

import java.util.HashMap;
import java.util.Map;

public class DictionaryServiceImpl implements IDictionaryService{
    public static Map<String, String> stringMap = new HashMap<>();
    static {
        stringMap.put("Hello", "Xin chao");
        stringMap.put("School", "Truong hoc");
        stringMap.put("Student", "Sinh vien");
        stringMap.put("Codegym", "Qua la pro luon");
        stringMap.put("Play", "Choi");
    }

    public String dictionaryLookup(String englishWord){
        if (stringMap.containsKey(englishWord)){
            return stringMap.get(englishWord);
        } else {
            return "Khong tim thay";
        }
    }
}
