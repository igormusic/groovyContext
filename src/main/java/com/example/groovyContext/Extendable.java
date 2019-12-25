package com.example.groovyContext;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
public class Extendable {
    private Map<String,Object> properties = new HashMap<>();

    public Extendable put(String key, Object value){
        properties.put(key,value);
        return this;
    }

    public Object get(String key){
        return properties.get(key);
    }

    public Set<String> keySet() {
        return properties.keySet();
    }
}
