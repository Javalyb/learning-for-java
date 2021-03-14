## 自动装配：
@EnableAutoConfiguration：开启第三方自动装配，通过当中@Import注解中指定类AutoConfigurationImportSelector中的方法selectImports，
扫描整个工程中autoconfigure包下的META-INF/spring.factories中的配置类；

## 运行流程：