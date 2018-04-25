package cyf.demo.introduction.service;

import cyf.demo.dao.mapper.CityRepository;
import cyf.demo.dao.model.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * @author Cheng Yufei
 * @create 2018-04-14 上午11:06
 **/
@Component
@Slf4j
public class CityHandler {

    @Autowired
    private CityRepository cityRepository;

    public Mono<Long> save(City city) {
        return Mono.create(sink->sink.success(cityRepository.save(city)));

    }

    public Flux<City> findAll() {
        return Flux.fromIterable(cityRepository.findAll());
    }


    /**
     * 执行顺序： 1 - 2  - sink - return，异步体现；
     *
     * 不返回City／Long等对象而直接使用 Flux 和 Mono 是非阻塞写法，相当于回调方式。利用函数式可以减少了回调，因此会看不到相关接口。这恰恰是 WebFlux 的好处：集合了非阻塞 + 异步。
     *
     * @return
     */
    public Flux<City> findAl() {

        Collection<City> all = cityRepository.findAll();

        System.out.println("1");

        Flux<City> flux = Flux.create(sink -> {
            System.out.println("sink");
            all.forEach(a -> {
                sink.next(a);
            });
            sink.complete();
        });

        System.out.println("2");
        return flux;
    }

    public Mono<City> getById(long id) {
        return Mono.justOrEmpty(cityRepository.getById(id));

    }
}
