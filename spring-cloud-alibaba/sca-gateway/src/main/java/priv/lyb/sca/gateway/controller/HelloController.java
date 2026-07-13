package priv.lyb.sca.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from SCA Gateway, port: " + port;
    }
}
