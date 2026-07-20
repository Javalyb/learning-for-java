package priv.lyb.sca.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.lyb.sca.demo.feign.HelloClient;

@RestController
@RequestMapping("/api")
public class FeignController {

    @Autowired
    private HelloClient helloClient;

    @GetMapping(value = "/feign")
    public String feign() {
        return "Feign call result: " + helloClient.hello();
    }
}
