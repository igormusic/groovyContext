package com.example.groovyContext.metadata;

import com.example.groovyContext.Context;
import com.example.groovyContext.Extendable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Accessors(fluent = true)
public class CodeGenConfig {
    protected List<ExtendableType> types = new ArrayList<>();
    protected List<Function> functions = new ArrayList<>();

    public CodeGenConfig(Context context){
        for(String typeName: context.keySet()){
            ExtendableType type = addType(typeName);
            Extendable object = context.get(typeName);

            for(String propertyName:object.keySet()){
                Object propertyValue = object.get(propertyName);
                String dataType = propertyValue.getClass().getName();

                type.addPropertyType(propertyName,dataType);
            }
        }
    }

    public ExtendableType addType(String name){
        ExtendableType type = new ExtendableType(name);
        types.add(type);
        return type;
    }

    public Function addFunction(String name, String expression){
        Function function = new Function(name, expression);
        functions.add(function);
        return function;
    }
}
