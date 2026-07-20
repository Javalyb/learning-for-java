# AGENTS.md

本文档为在本仓库中协作的 Codex（Codex.ai/code）提供项目说明与工作约束。

## 语言要求

- 与用户的交流、解释、代码注释及新增文档均使用简体中文。
- 代码中的标识符、命令、配置项和第三方技术名称保持其原有英文写法。

## 构建命令

本项目是一个面向 Java 8 的多模块 Maven 工程，应在仓库根目录执行构建命令：

```bash
# 完整构建项目（跳过测试）
mvn clean install -DskipTests

# 构建指定模块（以 java-base 为例）
mvn clean install -pl java-base -DskipTests

# 运行指定模块的测试
mvn test -pl java-base

# 强制更新依赖后构建
mvn clean install -U
```

项目未配置 lint 或静态分析工具。仓库提交了 IntelliJ IDEA 配置（`.idea/`）。每个模块都可以独立运行：可在 IDEA 中运行对应的 `*Application.java` 主类，或通过 `mvn spring-boot:run -pl <模块名>` 启动。

## 架构概览

根 `pom.xml` 聚合全部模块，并设置 `maven.compiler.source/target = 8`；依赖版本不在根 POM 统一管理，而由各模块自行维护。

### 模块说明

- `java-base`：Java 基础知识示例，是最大的模块。代码按主题组织在 `priv.lyb.study.base.*` 下，覆盖注解、数组、枚举、异常、泛型、IO、并发等内容。许多主题配有中文 `.md` 笔记。该模块使用 Spring Boot 2.4.1 作为容器，并启用了 `@ServletComponentScan` 以支持 Servlet 示例。
- `spring`：仅为聚合 POM，包含 `spring-boot` 和 `spring-cloud`。
- `spring/spring-cloud`：基于 Spring Cloud Hoxton.SR4 与 Spring Boot 2.2.6，包含 Eureka、Ribbon、Feign、Hystrix、Zuul、Gateway、Config、Bus、Nacos 等 Spring Cloud Netflix/Alibaba 体系示例。
- `dubbo`：位于 `priv.lyb.nettyrpc.*` 下的自定义 Netty RPC 实现，不是 Apache Dubbo 框架。
- `mybatis`：MyBatis 2.0、Druid 1.1.10、MySQL 5.1.46，基于 Spring Boot 2.4.1。
- `mysql`：使用 `mysql-connector-java 8.0.23` 的原生 JDBC 示例，不使用 ORM。
- `redis`、`zookeeper`、`distributed`、`message-queue`（rabbit-mq 与 rocketMQ）：用于相应中间件学习的 Spring Boot 2.4.1 脚手架。

### 通用约定

- 所有模块以 `priv.lyb` 作为基础包名。
- 除 `spring/spring-cloud` 因 Hoxton.SR4 兼容性使用 Spring Boot 2.2.6 外，大多数模块继承 `spring-boot-starter-parent:2.4.1`。
- Lombok 是几乎所有模块都会引入的可选依赖。
- 示例代码通常是独立的 `main` 类或单独执行的 `@Test` 方法，不应假定它们能作为完整测试套件统一运行。
- 所有类，方法，参数，变量都需要加注释

## 开发注意事项

- 这是学习与练习仓库，不是生产应用；代码质量、测试覆盖率和风格的一致性可能存在差异。
- Markdown 笔记与源码交错存放，部分笔记也会出现在 `target/classes/` 中；只编辑 `src/` 下的源文件副本。
- Git 使用稀疏检出，相关配置位于 `.git/info/sparse-checkout`。
- 修改代码前先确认目标模块和现有示例的组织方式；避免顺带改动无关示例。
