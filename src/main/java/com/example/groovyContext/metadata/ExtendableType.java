package com.example.groovyContext.metadata;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ExtendableType {
    protected String typeName;
    protected List<PropertyType> propertyTypes = new ArrayList<>();
    protected List<Function> functions = new ArrayList<>();

    public ExtendableType(String typeName){
        this.typeName = typeName;
    }

    public ExtendableType addPropertyType(String propertyName, String dataType){
        PropertyType propertyType = new PropertyType(propertyName,dataType, typeName);
        propertyTypes.add(propertyType);
        return this;
    }

    public Function addFunction(String functionName, String expression){
        Function function = new Function(functionName,expression);
        functions.add(function);
        return function;
    }

    public String getLowerCaseName(){
        return StringUtils.uncapitalize(typeName);
    }
}
