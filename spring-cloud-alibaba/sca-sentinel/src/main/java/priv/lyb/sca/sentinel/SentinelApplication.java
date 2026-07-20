package priv.lyb.sca.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Sentinel 限流降级演示启动类.
 *
 * 启动前确保：
 * 1. Nacos Server 已启动（127.0.0.1:8848）
 * 2. Sentinel Dashboard 已启动（127.0.0.1:8080，可选，程序化规则已内置）
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class, args);
    }
}
