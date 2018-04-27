import cyf.demo.dao.model.City;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @author Cheng Yufei
 * @create 2018-04-26 14:37
 **/
public class TestOne {

    @Test
    public void t1() {
        List<City> list = Lists.newArrayList();
        for (int i = 0; i < 30; i++) {
            list.add(new City(String.valueOf(i)));
        }
        long start = System.currentTimeMillis();
        list.forEach(i->{
            i.setProvinceId(RandomUtils.nextLong());
        });
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    @Test
    public void t2() {

    }


}
