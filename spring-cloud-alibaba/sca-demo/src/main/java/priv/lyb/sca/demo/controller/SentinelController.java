package priv.lyb.sca.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.lyb.sca.demo.handler.BlockHandler;

@RestController
@RequestMapping("/api")
public class SentinelController {

    @GetMapping("/sentinel")
    @SentinelResource(
            value = "hello-sentinel",
            blockHandlerClass = BlockHandler.class,
            blockHandler = "handleBlock",
            fallbackClass = BlockHandler.class,
            fallback = "handleFallback"
    )
    public String sentinel() {
        return "Sentinel OK, normal flow";
    }
}
