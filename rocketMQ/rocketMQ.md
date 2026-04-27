# RocketMQ 学习笔记

## 架构组成
- **NameServer** — 路由注册中心，无状态，各节点独立，Broker 向所有 NameServer 注册
- **Broker** — 消息存储和中转，分为 Master 和 Slave
- **Producer** — 消息生产者
- **Consumer** — 消息消费者

## 消息模型
- **Topic** — 消息主题，一类消息的逻辑分类
- **Tag** — 消息标签，Topic 下的二级分类，用于过滤
- **Queue** — 消息队列，一个 Topic 可有多个 Queue
- **Message** — 消息体

## 消息类型

| 类型 | 说明 | 场景 |
|------|------|------|
| 同步消息 | 发送后等待 Broker 确认 | 重要通知、短信 |
| 异步消息 | 发送后异步回调 | 响应时间敏感的业务 |
| 单向消息 | 发送后不关心结果 | 日志收集 |
| 顺序消息 | 同一队列内 FIFO | 订单状态变更 |
| 延迟消息 | 延迟指定时间后投递 | 超时未支付取消订单 |
| 事务消息 | 两阶段提交保证本地事务与消息原子性 | 下单扣库存 |
| 批量消息 | 一次发送多条消息 | 批量处理 |

## 消费模式
- **CLUSTERING（集群消费）** — 相同 ConsumerGroup 下每条消息只被一个消费者消费（默认）
- **BROADCASTING（广播消费）** — 每条消息被 ConsumerGroup 下所有消费者消费

## 消费进度
- **Offset** — 消费位点，记录每个 Queue 的消费进度
- 支持从队列头部或尾部开始消费

## 延迟级别
18 个预设级别: 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h

## 消息过滤
- **Tag 过滤** — `selectorExpression = "tagA || tagB"`
- **SQL92 过滤** — 需 Broker 开启 `enablePropertyFilter=true`

## 常见问题

### 消息重复
- RocketMQ 保证 at-least-once，需业务幂等处理

### 消息丢失
- 同步刷盘 + 同步复制可保证不丢失，但性能较低
- 生产者重试机制可减少发送失败
