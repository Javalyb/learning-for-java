##REDIS:

##数据类型：
###基本类型：
String：数据结构类似HashMap<String,Object>。Object数据类型可以为String，Number，bit
场景：
String类型：利用setNX用于分布式全局锁、
Number类型：计数器

Hash：数据结构类似HashMap<String,HashMap<String,Object>>，结构化的对象(没有嵌套对象)；
场景：服务单购物车

List和Zset集合有「正向坐标」和「反向坐标」，『正向坐标』从0开始，「反向坐标」从末尾-1开始;
List:有序，可重复。数据结构类似HashMap<String,List<Object>>；
场景：
分页，消息队列

Set：无序，不可重复。数据结构类似HashMap<String,HashSet<Object>>;
场景：根据交、并、差指令用于关注列表

Zset:有序，不可重复。数据结构类似HashMap<String,Zset<Object>>;
场景：排行榜

###高级用法
Bitmap：「位图」支持按bit位来存储信息，可以用来实现布隆过滤器（BloomFilter）

Geospatial：
场景：地理位置经纬度运算

Streams：

HyperLogLog：适合大规模数据去重工作

pub/sub：提供订阅发布功能，用作简单的消息队列

LUA：通过LUA脚本的原子性执行批操作

事务

##持久化
RDB和AOF