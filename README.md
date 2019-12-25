# groovyContext

Assume that we would like to evaluate expression like this:

```
account.paymentCount() * plan.discountPercent() * product.paymentCost()
```

and that we would like to defer to runtime for decisions:

- which objects are part of the evaluation context (account, plan and product in example above)
- what are the properties of those objects (paymentCount, discountPercent and paymentCost)

See ScriptingTest for example of the creating context and driving code generation based on the context.

