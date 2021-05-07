package priv.lyb;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: apollo
 * @Description:
 * @Date: 23:04 2021/03/20
 */
@Repository
public interface Mapper {
    public List<Entity> listData();
    public void insertData(Map<String,String> map);
}
