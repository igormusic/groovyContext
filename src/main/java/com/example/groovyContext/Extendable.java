package com.example.groovyContext;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
public class Extendable {
    private Map<String,Object> properties = new HashMap<>();

    public void put(String key, Object value){
        properties.put(key,value);
    }

    public Object get(String key){
        return properties.get(key);
    }

    public Set<String> keySet() {
        return properties.keySet();
    }
}
