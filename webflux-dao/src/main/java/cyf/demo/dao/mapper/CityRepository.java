package cyf.demo.dao.mapper;

import com.google.common.collect.Maps;
import cyf.demo.dao.model.City;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Cheng Yufei
 * @create 2018-04-14 上午11:04
 **/
@Repository
public class CityRepository {

    private ConcurrentMap<Long, City> map = new ConcurrentHashMap();

    private static final AtomicLong idGenerator = new AtomicLong(0);


    public long save(City city) {

        long id = idGenerator.incrementAndGet();
        city.setId(id);
        map.put(id, city);
        return id;
    }
    
    public  Collection<City> findAll() {
        return map.values();
    }

    public City getById(long id) {
        return map.get(id);
    }

    public Flux getKerrsByIds(Flux<Integer> ids) {
        Flux<City> flux = ids.flatMap(id -> Mono.justOrEmpty(map.get(id)));

        Map map = Maps.newHashMap();
        flux.doOnNext(f -> {
            map.put(f.getId(), f);
        });
        System.out.println(map.size());
        return flux;
    }
}
