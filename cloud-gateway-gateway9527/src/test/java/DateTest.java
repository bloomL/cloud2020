import cn.hutool.core.lang.Console;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

/**
 * @description: TODO
 * @author: lg
 * @create: 2020-09-16 21:14
 **/
@RunWith(SpringRunner.class)
public class DateTest {

    @Test
    public void dateInfo(){
        ZonedDateTime now = ZonedDateTime.now();
        //Console.log(now);
        //2020-09-16T21:20:57.505+08:00[Asia/Shanghai]
        System.out.println(now);
    }
}
