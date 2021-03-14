## Eurake Server集群模式：
Peer to Peer，即点对点模式，无主从之分，去中心化，每一个Peer都是对等的。当某个Eurake Server节点挂掉后，
Eurake Client的请求会自动切换到其他Eurake Server节点。每个Eurake Server在接收到请求后，会把数据同步给其他Eurake Server节点；

## 心跳机制：
默认情况下，如果Eurake Server在一定时间内没有接收到某个Eurake Client实例的的心跳，Eurake Server将会注销该实例；

## 高可用和弱一致性
Eurake Server集群中，只要还有一个节点正常运行就能保证注册服务可用，即保证了可用性。但是查询到的信息可能不是最新的，即不能保证强一致性。

## Eurake Server自我保护机制：
15分钟内超过85%的节点都没有正常的心跳，Eurake任务客户端和服务端出现了网络故障。会出现以下几种情况：
- Eurake不会从注册表中移除长时间没有收到心跳而过期的服务；
- Eurake仍然能够接收新服务的注册和发现，但是不会同步到其他节点上，即保证当前节点的可用性；
- 当故障解除后，当前实例的新注册信息会同步到其他节点上；

