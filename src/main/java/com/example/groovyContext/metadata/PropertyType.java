package com.example.groovyContext.metadata;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PropertyType {
    protected String propertyName;
    protected String dataType;
    protected String parentTypeName;
}
