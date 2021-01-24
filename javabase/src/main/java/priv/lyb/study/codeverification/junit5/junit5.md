junit5: 单元测试工具;
    import org.junit.jupiter.api.Test 用在Spring Boot 2.2.X以后
    import org.junit.Test用在2.2.x之前

注解:
    1.BeforeAll: 在任何其他操作之前运行的方法，为静态方法;
    2.AfterAll: 所有其他操作之后运行的方法，为静态方法;
    3.BeforeEach: 通常用于创建和初始化公共对象的方法，并在每次测试前运行;
    4.AfterEach: 在每次测试后执行清理(打开文件关闭，网络连接关闭)
    5.Test: 标记测试方法入口;