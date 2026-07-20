package priv.lyb.idempotencydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 接口前后端幂等性教学模块的启动入口。
 *
 * <p>后续示例会在该应用中演示浏览器请求键、服务端幂等状态与数据库唯一约束如何共同防止重复写入。</p>
 */
@SpringBootApplication
public class ApiIdempotencyDemoApplication {

    /**
     * 启动教学示例应用，便于直接运行并观察接口行为。
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiIdempotencyDemoApplication.class, args);

    }
}
