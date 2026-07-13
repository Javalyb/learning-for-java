# learning-for-java

> Java 学习实践项目 —— 涵盖 Java 语言基础、主流框架与中间件

[![Java](https://img.shields.io/badge/Java-8/17-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.4.1|2.2.6|3.0.13-brightgreen)]()
[![Maven](https://img.shields.io/badge/Maven-3-red)]()
[![License](https://img.shields.io/badge/License-MIT-lightgrey)]()

---

## 📋 项目概览

多模块 Maven 项目，用于系统性学习 **Java** 语言特性及微服务生态中的主流中间件。包含 **11 个顶层模块**、多个子模块，涵盖从基础语法到分布式架构的完整知识体系。

```yaml
groupId: priv.lyb.java
artifactId: learning-for-java
version: 1.0-SNAPSHOT
Java: 1.8（默认） / 17（spring3-demo）
构建工具: Maven
```

---

## 🏗️ 模块索引

### 1. 📘 `java-base` — Java 语言核心基础
**技术：** Java 8 ~ 17 特性、JVM、并发、设计模式、IO/NIO、网络编程

| 主题 | 包路径 | 说明 |
|------|--------|------|
| 基础语法 | `study.base.*` | 注解、数组、枚举、异常、泛型、内部类、字符串、关键字 |
| 集合框架 | `study.base.*` | ArrayList / LinkedList / HashMap / Queue / Set / Stack、fail-fast/fail-safe |
| IO/NIO | `study.base.*` | 字节流、字符流、NIO、序列化 |
| 并发编程 | `study.concurrent.*` | 线程、线程池、AQS、原子类、CountDownLatch / CyclicBarrier / Exchanger |
| JVM | `study.jvm.*` | 类加载机制 |
| 设计模式 | `study.designpattern.*` | 创建型、结构型、行为型共 20+ 种模式 |
| JDK 新特性 | `study.jdk8new.*` | Lambda、Stream、Optional、LocalDateTime、默认方法 |
| 网络编程 | `study.network.*` | TCP、Socket、BIO/NIO |
| 算法练习 | `study.leecode.*` | 链表反转等经典算法 |

**依赖：** Spring Boot 2.4.1、Guava 30.1、JUnit 5

---

### 2. 🌱 `spring` — Spring 生态

聚合 POM，包含 Spring Boot 与 Spring Cloud 两大模块。

#### 2.1 `spring/spring-boot` — Spring Boot 特性
- **技术：** AOP 切面编程、Redis 集成
- **内容：** 接口幂等性实现（`PreventDuplicationAspect` 防重复提交）
- **依赖：** Spring Boot 2.4.1、Redis、Fastjson、Commons IO

#### 2.2 `spring/spring-cloud` — Spring Cloud 微服务全家桶
**版本：** Spring Boot 2.2.6 + Spring Cloud Hoxton.SR4

| 子模块 | 功能 | 关键依赖 |
|--------|------|----------|
| `spring-cloud-eurake` | 服务注册中心 | Eureka Server |
| `spring-boot-client1/2/3` | 服务提供者示例 | Eureka Client |
| `spring-boot-ribbon` | 客户端负载均衡 | Ribbon |
| `spring-boot-feign` | 声明式 HTTP 调用 | Feign |
| `spring-boot-hystrix` | 熔断降级 | Hystrix |
| `spring-boot-zuul` | API 网关 | Zuul |
| `spring-boot-gateway` | 新一代网关 | Spring Cloud Gateway |
| `spring-boot-config` | 配置中心客户端 | Config Client |
| `spring-boot-bus` | 配置动态刷新 | Cloud Bus + RabbitMQ |
| `spring-boot-nacos` | 阿里云注册/配置 | Nacos |

---

### 3. 🚀 `spring-cloud-alibaba` — Spring Cloud Alibaba 生态
**版本：** Spring Boot 2.6.13 + Spring Cloud 2021.0.9 + Alibaba 2021.0.6.1

| 子模块 | 功能 | 亮点 |
|--------|------|------|
| `sca-nacos` | 注册中心 + 配置中心 | Nacos 服务发现与配置管理 |
| `sca-sentinel` | 流量治理 | 限流/熔断/降级规则配置（`FlowLimitController`、`DegradeController`） |
| `sca-gateway` | 网关代理 | Spring Cloud Gateway 路由转发 |
| `sca-demo` | Feign 服务调用方 | Feign + Sentinel 熔断集成 |
| `sca-demo1` | 服务提供方 | Nacos 注册 + 配置中心示例 |

---

### 4. 🔌 `dubbo` — 自定义 Netty RPC
**技术：** Netty 手写 RPC 框架（非 Apache Dubbo）

基于 Netty 自实现的轻量级 RPC 通信框架，包含服务发布与服务调用示例。

---

### 5. 🗄️ `mybatis` — MyBatis + Druid + MySQL
**版本：** MyBatis 2.0 + Druid 1.1.10 + MySQL 5.1.46

完整三层架构 CRUD 示例：Controller → Service → Mapper → MySQL

---

### 6. 💾 `mysql` — 原生 JDBC
**版本：** MySQL Connector 8.0.23

纯 JDBC 数据库连接操作，无 ORM 封装。

---

### 7. 🔴 `redis` — Redis 入门
**状态：** 脚手架项目，待补充 Redis 客户端集成

---

### 8. 🐘 `zookeeper` — ZooKeeper 学习
**状态：** 脚手架项目，待补充 ZK 客户端集成

---

### 9. 🌐 `distributed` — 分布式系统
**状态：** 脚手架项目，待补充分布式理论和实践

---

### 10. 📨 `message-queue` — 消息队列

#### 10.1 `rabbit-mq` — RabbitMQ
**状态：** 脚手架项目，待补充 AMQP 集成

#### 10.2 `rocketMQ` — RocketMQ（完整示例）
**版本：** rocketmq-spring-boot-starter 2.2.3

涵盖 RocketMQ 四大消息模型：
| 示例 | 说明 |
|------|------|
| 同步/异步消息 | SimpleProducer/Consumer、AsyncProducer/Consumer |
| 延时消息 | DelayProducer/Consumer |
| 顺序消息 | OrderlyProducer/Consumer |
| 事务消息 | TransactionProducer/Consumer + TransactionListenerImpl |

---

### 11. 🆕 `spring3-demo` — Spring Boot 3.x 实战
**版本：** Spring Boot 3.0.13 + **Java 17**

完整三层 CRUD：H2 内存数据库 + JPA + RESTful API
- `User` 实体 (JPA)
- `UserRepository` (Spring Data JPA)
- `UserService` / `UserServiceImpl`（业务层）
- `UserController`（REST 端点）

---

## 🔧 构建与运行

### 环境要求

| 依赖 | 版本 |
|------|------|
| JDK | 1.8+（spring3-demo 需要 17+） |
| Maven | 3.6+ |
| MySQL | 5.7+（mybatis / mysql 模块） |
| RocketMQ | 4.x+（message-queue 模块） |

### 构建命令

```bash
# 完整构建（跳过测试）
mvn clean install -DskipTests

# 构建指定模块
mvn clean install -pl java-base -DskipTests

# 运行指定模块测试
mvn test -pl java-base

# 强制刷新 SNAPSHOT 依赖
mvn clean install -U
```

### 运行方式

**IDE：** 直接执行各模块 `*Application.java` 的 `main` 方法

**命令行：**
```bash
# Spring Boot 模块
mvn spring-boot:run -pl java-base

# 需先构建父 POM
mvn clean install -DskipTests
mvn spring-boot:run -pl <module-name>
```

### 数据库配置

`mybatis` / `mysql` 模块需要在 `application.yml` 中配置：
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/learning?useSSL=false&serverTimezone=UTC
    username: root
    password: your_password
```

---

## 📂 项目结构（简化）

```
learning-for-java/
├── pom.xml                              # 根 POM（聚合模块）
├── java-base/                           # Java 语言基础
├── spring/
│   ├── pom.xml                          # 聚合 POM
│   ├── spring-boot/                     # Spring Boot 特性
│   └── spring-cloud/                    # Spring Cloud 全家桶
│       ├── spring-cloud-eurake/         # 注册中心
│       ├── spring-boot-client1~3/       # 服务提供者
│       ├── spring-boot-ribbon/          # 负载均衡
│       ├── spring-boot-feign/           # 声明式调用
│       ├── spring-boot-hystrix/         # 熔断
│       ├── spring-boot-zuul/            # Zuul 网关
│       ├── spring-boot-gateway/         # Gateway 网关
│       ├── spring-boot-config/          # 配置中心
│       ├── spring-boot-bus/             # 消息总线
│       └── spring-boot-nacos/           # Nacos
├── spring-cloud-alibaba/                # Alibaba 微服务
│   ├── sca-nacos/
│   ├── sca-sentinel/
│   ├── sca-gateway/
│   ├── sca-demo/
│   └── sca-demo1/
├── dubbo/                               # Netty RPC
├── mybatis/                             # MyBatis + Druid
├── mysql/                               # 原生 JDBC
├── redis/                               # Redis（脚手架）
├── zookeeper/                           # ZooKeeper（脚手架）
├── distributed/                         # 分布式（脚手架）
├── message-queue/
│   ├── rabbit-mq/                       # RabbitMQ（脚手架）
│   └── rocketMQ/                        # RocketMQ 完整示例
├── spring3-demo/                        # Spring Boot 3 + Java 17
└── README.md                            # 本文件
```

---

## 📚 学习资源

### 在线电子书

| 资源 | 链接 |
|------|------|
| On Java 8 | [lingcoder](https://lingcoder.gitee.io/onjava8) · [wizardforcel](https://wizardforcel.gitbooks.io/onjava8) · [hardocs](https://hardocs.com/d/onjava8/) |
| Spring Framework | [docs4dev](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans) |
| Spring Boot | [docs4dev](https://www.docs4dev.com/docs/zh/spring-boot/2.1.1.RELEASE/reference) |
| Spring Security | [docs4dev](https://www.docs4dev.com/docs/zh/spring-security/5.1.2.RELEASE/reference) |
| Spring AMQP | [docs4dev](https://www.docs4dev.com/docs/zh/spring-amqp/2.1.2.RELEASE/reference) |
| Spring Data JPA | [docs4dev](https://www.docs4dev.com/docs/zh/spring-data-jpa/2.1.5.RELEASE/reference) |
| Spring Data JDBC | [docs4dev](https://www.docs4dev.com/docs/zh/spring-data-jdbc/1.0.5.RELEASE/reference) |
| Spring Data Redis | [docs4dev](https://www.docs4dev.com/docs/zh/spring-data-redis/2.1.5.RELEASE/reference) |
| Spring 实战（第五版） | [potoyang](https://potoyang.gitbook.io/spring-in-action-v5/) |
| Spring 5 参考文档 | [flydean](https://docs.flydean.com/spring-framework-documentation5/) |

### 实用网站

- [设计模式（中文）](https://refactoringguru.cn/design-patterns) — 设计模式图解
- [JCSprout](https://crossoverjie.top/JCSprout/) — Java Core 知识总结
- [CS-Book](https://github.com/iamshuaidi/CS-Book) — 计算机书籍合集
- [docs4dev](https://github.com/docs4dev/docs4dev) — 技术文档中文翻译
- [图灵社区](https://www.ituring.com.cn/) — 技术书籍社区

### 学习视频

- [线程池原理和分析](https://live.csdn.net/room/weixin_48013460/xDZsaiJG) — 线程介绍 + 手写线程池

---

## 📝 项目约定

- 基础包名：`priv.lyb`
- 除了 `spring/spring-cloud`（2.2.6）和 `spring3-demo`（3.0.13），其余模块均继承 `spring-boot-starter-parent:2.4.1`
- Lombok 作为可选依赖广泛使用
- `.md` 笔记与源码混合存放，请编辑 `src/` 下的原始文件
- 大多数代码以独立 `main` 类或 `@Test` 方法组织，按需单独执行

---

## 📄 License

本项目为个人学习实践，仅供学习参考。
