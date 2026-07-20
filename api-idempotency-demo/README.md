# API 幂等性教学示例

运行 `mvn spring-boot:run` 后访问 `http://localhost:8080/`。页面可生成或复用 `Idempotency-Key`，并演示普通、连续和并发提交。

`POST /api/orders` 需要 JSON 请求体 `{ "userId": 1001, "productName": "Java 并发课程", "quantity": 1 }` 和 `Idempotency-Key` 请求头。

- 首次键：创建订单，返回 `201`。
- 已成功键：返回缓存的同一订单，返回 `200` 与 `Idempotency-Replayed: true`。
- 处理中键：返回 `409`。
- 缺失或空键：返回 `400`。

实现分两层：`InMemoryIdempotencyStore` 用 `ConcurrentHashMap.putIfAbsent` 做单实例原子占位；`orders(user_id, request_id)` 唯一索引处理缓存失效或多实例竞争。唯一索引冲突后服务会查询已创建订单并返回它。内存实现没有 TTL、不能跨进程共享，仅用于教学；生产环境应替换为 Redis 的原子 `SET NX EX`。
