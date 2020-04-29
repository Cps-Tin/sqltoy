package cn.cps.sqltoy.showcase;

import cn.cps.sqltoy.SqlToyApplication;
import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.sagacity.sqltoy.dao.SqlToyLazyDao;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SqlToyApplication.class)
public class QueryDemoTest
{
    /**
     * sqltoy 默认提供统一的lazyDao,正常情况下开发者无需自己写dao层
     */
    @Resource(name = "sqlToyLazyDao")
    private SqlToyLazyDao sqlToyLazyDao;

    @Test
    public void queryAnaInfo() {
        String[] paramNames = { "anaTitle", "anaTypeId" };
        Object[] paramValue = { "我", 1 };
        //最后一个参数是返回类型 null 则返回普通数组(可以传VO对象、Map.class)
        List anaInfo = sqlToyLazyDao.findBySql("sqltoy_query_anaInfo", paramNames, paramValue, null);
        System.out.println(JSON.toJSONString(anaInfo));
    }
}
