package priv.lyb.sca.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api")
public class ConfigController {

    @Value("${app.message:default-message}")
    private String message;

    @GetMapping("/config")
    public String config() {
        return "Nacos config message: " + message;
    }
}
