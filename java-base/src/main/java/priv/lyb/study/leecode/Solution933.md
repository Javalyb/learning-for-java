# 933. 最近的请求次数

## 问题描述

写一个 `RecentCounter` 类来计算特定时间范围内最近的请求。

它只有一个方法：`ping(int t)`，其中 `t` 代表以**毫秒**为单位的某个时间。

返回从 `t - 3000` 到 `t` 之间（含两端）的 `ping` 数。

**保证**每次对 `ping` 的调用都使用比之前更大的 `t` 值。

## 示例

```
输入：
["RecentCounter", "ping", "ping", "ping", "ping"]
[[], [1], [100], [3001], [3002]]

输出：
[null, 1, 2, 3, 3]

解释：
RecentCounter recentCounter = new RecentCounter();
recentCounter.ping(1);     // requests = [1]，范围 [-2999,1]，返回 1
recentCounter.ping(100);   // requests = [1, 100]，范围 [-2900,100]，返回 2
recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围 [1,3001]，返回 3
recentCounter.ping(3002);  // requests = [100, 3001, 3002]，范围 [2,3002]，返回 3
```

## 解法：队列（滑动窗口）

### 思路

维护一个队列，存储所有 `ping` 的时间戳。

- 每次 `ping(t)` 时，将 `t` 入队
- 计算窗口左边界 `min = t - 3000`
- 将队头所有 **小于** `min` 的时间戳出队（它们已超出窗口）
- 返回队列的大小

### 正确性关键

使用 `<` 而非 `<=` 判断出队条件，是因为窗口是**闭区间** `[t-3000, t]`，等于 `min` 的时间戳仍在窗口内，应当保留。

### 复杂度分析

| 指标 | 值 |
|------|-----|
| 时间复杂度 | **O(1)** 均摊 — 每个时间戳至多入队和出队一次 |
| 空间复杂度 | **O(W)** — 其中 W 是窗口内最大请求数 |

> 最坏情况下，3000ms 内所有时间戳都保留，队列大小与输入规模无关，因此空间复杂度实际上是 O(常数)。

### Java 实现

```java
class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        int min = t - 3000;
        while (!queue.isEmpty() && queue.peek() < min) {
            queue.poll();
        }
        return queue.size();
    }
}
```

## 数据结构选型

| 数据结构 | 理由 |
|----------|------|
| `Queue<Integer>` (LinkedList) | 先进先出特性完全匹配时间线顺序；队头是最旧的请求，队尾是最新的 |

> **注**：也可用 `ArrayDeque` 替代 `LinkedList`，前者在内存布局上更紧凑（连续数组 vs 链表节点），但对此题实际影响可忽略。

## 测试用例

```text
ping(1)    → 1   (队列: [1])
ping(100)  → 2   (队列: [1, 100])
ping(3001) → 3   (队列: [100, 3001])    ← 1 被移除，因为 1 < 1
ping(3002) → 3   (队列: [100, 3001, 3002])
```
