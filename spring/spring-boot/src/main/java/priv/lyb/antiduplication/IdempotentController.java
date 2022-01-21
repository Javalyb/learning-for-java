package priv.lyb.antiduplication;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lyb
 * @Description:
 * @Date: 18:08 2022/01/06
 * 接口防重复提交
 */
@RestController
@RequestMapping("/web")
public class IdempotentController {

    @PostMapping("/sayNoDuplication")
    @PreventDuplication(expriceSeconds = 8)
    public String sayNoDuplication(@RequestParam("requestNum") String requestNum){
        return "sayNoDuplication".concat(requestNum);
    }
}
