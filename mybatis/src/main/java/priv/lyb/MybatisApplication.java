package priv.lyb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "priv.lyb")
@RestController
public class MybatisApplication {
    @Autowired
    private Mapper mapper;

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @RequestMapping("/list")
    public void fun1() {
        System.out.println("--------------------开始");
        List<Entity> entities = mapper.listData();
        for (Entity entity : entities) {
            String[] arr = entity.getOrderNo().split(",");
            for (int i = 0; i < arr.length; i++) {
                HashMap<String, String> mapParam = new HashMap<>();
                mapParam.put("caseNo", entity.getCaseNo());
                mapParam.put("ladingNo", entity.getLadingNo());
                mapParam.put("orderNo", arr[i]);
                mapper.insertData(mapParam);
            }
        }
        System.out.println("--------------------结束");

    }
}
