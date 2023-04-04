# AOPDemo
Learning AOP

### xml方式配置AOP
**主要配置代码**
```
<aop:config> 
    <aop:aspect ref="aspect class 切面类">  
        <aop:pointcut id="..." expression="execution(* com..*.*(..))">  
        <aop:around method="切面类.方法" pointcut-ref="...">
    <aop:aspect/>
<aop:config/>
```

### 注解方式配置AOP
1. applicationContext.xml 扫包 `<context:component-scan basePackage="..."/>`
2. 开启自动代理 `<aop:aspectj-autoproxy/>`
