package com.example.groovyContext;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@NoArgsConstructor
public class Context {
    private Map<String,Extendable> objects = new HashMap<>();

    public void put(String name, Extendable object){
        objects.put(name, object);
    }

    public Extendable get(String name){
        return objects.get(name);
    }

    public Set<String> keySet() { return objects.keySet();}
}
