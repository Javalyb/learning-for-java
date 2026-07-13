package priv.lyb.sca.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "sca-demo1", path = "/api")
public interface HelloClient {

    @GetMapping("/hello")
    String hello();
}
