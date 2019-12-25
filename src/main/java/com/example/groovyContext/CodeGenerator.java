package com.example.groovyContext;

import com.example.groovyContext.metadata.CodeGenConfig;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import groovy.lang.GroovyClassLoader;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.StringWriter;

@Slf4j
public class CodeGenerator {
    public Class getGeneratedClass(CodeGenConfig config) {
        StringWriter writer = new StringWriter();

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("templates//groovyEvaluation.mustache");

        try {
            mustache.execute(writer,config).flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String code = writer.toString();

        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        return groovyClassLoader.parseClass(code);
    }
}
