package priv.lyb.study.designpattern.behavitives.strategy.package1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @Author: LiuYingBo
 * @Description:
 * @Date: 13:17 2021/03/14
 */
public class BizService {
    private Map<String, Function<String, String>> checkResultDispatcher = new HashMap<>();

    {
        checkResultDispatcher.put("订单一", order -> String.format("对%s执行了业务操作", order));
        checkResultDispatcher.put("订单二", order -> String.format("对%s执行了业务操作", order));
        checkResultDispatcher.put("订单三", order -> String.format("对%s执行了业务操作", order));
    }

    public String getCheckResultResult(String order){
        Function<String, String> result = checkResultDispatcher.get(order);
        if (result!=null){
            return result.apply(order);
        }
        return "不在业务逻辑处理范围中";
    }


    public static void main(String[] args) {
        BizService bizService = new BizService();
        System.out.println(bizService.getCheckResultResult("订单一"));
    }


}
