# AOPDemo
Learning AOP

---

### xml方式配置AOP
**主要配置代码**

```xml
<aop:config> 
    <aop:aspect ref="aspect class 切面类">  
        <aop:pointcut id="..." expression="execution(* com..*.*(..))"/>  
        <aop:around method="切面类.方法" pointcut-ref="..."/>
    </aop:aspect>
</aop:config>
```



---
### 注解方式配置AOP
1. applicationContext.xml 扫包 `<context:component-scan basePackage="..."/>`
2. 开启自动代理 `<aop:aspectj-autoproxy/>`

---

### AOP实现声明式事务
#### 诸多概念
- A 
- C 
- I 
- D  

**传播机制**

**隔离级别**


| 概念名  | 英文         |               | 场景 |
|------|------------|---------------|----|
| 脏读   | dirty read | 没有提交到数据库，但被读取 |    |
| 幻读   |            | 每次读取的数量不一致    |    |
| 不可重复 |            |               |    |


### 事务的配置
**mysql事务管理器**
```xml

<bean id="transactionManger" class="...DataSourceTransactionManager">
    <properties name="dataSource" ref="dataSource"/>
</bean>
```
**事务详情**
```xml
<tx:advice id="advice" transaction-manager="">
    <tx:attributs>
        <tx:method name="..." />
    </tx:attributs>
</tx:attributs>
```

**配置到aop**

```xml

<aop:config>
    <aop:pointcut id=".." expression="..."/>
    <aop:advisor advice-ref="advice" pointcut-ref="..."/>
</aop:config>
```