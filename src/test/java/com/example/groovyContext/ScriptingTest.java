package com.example.groovyContext;

import com.example.groovyContext.domain.Account;
import com.example.groovyContext.domain.Plan;
import com.example.groovyContext.domain.Product;
import com.example.groovyContext.metadata.EvaluationConfig;
import groovy.lang.GroovyObject;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScriptingTest {
    @Test
    public void test() throws IOException, IllegalAccessException, InstantiationException {
        Account account = new Account();
        account.put("paymentCount", 10);

        Plan plan = new Plan();
        plan.put("discountPercent", 0.8);

        Product product = new Product();
        product.put("paymentCost", 0.5);

        Context context = new Context();

        context.put("Account", account);
        context.put("Plan", plan);
        context.put("Product", product);

        EvaluationConfig config = new EvaluationConfig(context);

        config.addFunction("evaluate", "account.paymentCount() * plan.discountPercent() * product.paymentCost()");

        CodeGenerator generator = new CodeGenerator();

        Class clazz = generator.getEvaluationClass(config);

        Contextual contextual = (Contextual) clazz.newInstance();
        contextual.context(context);

        GroovyObject calc = (GroovyObject) contextual;

        Double result= (Double) calc.invokeMethod("evaluate", null);

        assertEquals(4.0, result);
    }

    private static String getResourceString(String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource(fileName);
        InputStream inputStream = resource.getInputStream();
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

}
