package cyf.demo.introduction.controller;

import cyf.demo.dao.mapper.CityRepository;
import cyf.demo.dao.model.City;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

/**
 *
 *  Flux 表示的是包含 0 到 N 个元素的异步序列
 *  Mono 表示的是包含 0 或者 1 个元素的异步序列
 *  Flux 和 Mono 之间可以进行转换。对一个 Flux 序列进行计数操作，得到的结果是一个 Mono<Long>对象。把两个 Mono 序列合并在一起，得到的是一个 Flux 对象
 *
 * @author Cheng Yufei
 * @create 2018-04-25 15:26
 **/
@RestController
@RequestMapping("/intro")
public class IntroductionController {

    @Autowired
    private CityRepository cityRepository;

    /**
     * Flux静态方法创建Flux序列：
     * <p>
     * just()：可以指定序列中包含的全部元素。创建出来的 Flux 序列在发布这些元素之后会自动结束
     * fromArray()，fromIterable()和 fromStream()：可以从一个数组、Iterable 对象或 Stream 对象中创建 Flux 对象。
     * empty()：创建一个不包含任何元素，只发布结束消息的序列。
     * error(Throwable error)：创建一个只包含错误消息的序列。
     * never()：创建一个不包含任何消息通知的序列。
     * range(int start, int count)：创建包含从 start 起始的 count 个数量的 Integer 对象的序列。
     * interval(Duration period)和 interval(Duration delay, Duration period)：创建一个包含了从 0 开始递增的 Long 对象的序列。其中包含的元素按照指定的间隔来发布。除了间隔时间            之外，还可以指定起始元素发布之前的延迟时间。
     * intervalMillis(long period)和 intervalMillis(long delay, long period)：与 interval()方法的作用相同，只不过该方法通过毫秒数来指定时间间隔和延迟时间。
     * <p>
     * 当序列的生成需要复杂的逻辑时，则应该使用 generate() 或 create() 方法。
     *
     * @return
     */
    @GetMapping("/fluxStatic")
    public Flux<Integer> fluxStatic() {
//        return Flux.just("Hello World");
        return Flux.range(5, 4);
    }

    /**
     * generate()方法通过同步和逐一的方式来产生 Flux 序列。序列的产生是通过调用所提供的 SynchronousSink 对象的 next()，complete()和 error(Throwable)方法来完成的,next()方法只能最多被调用一次.
     *
     * @return
     */
    @GetMapping("/fluxGenerate")
    public Flux fluxGenerate() {
        return Flux.generate(sink -> {
            sink.next("Hello World");
            //complete()方法来结束该序列。如果不调用 complete()方法，所产生的是一个无限序列
            sink.complete();
        });
    }

    /**
     * next()方法只能最多被调用一次.
     *
     * @return
     */
    @GetMapping("/fluxGenerate2")
    public Flux fluxGenerate2() {

        return Flux.generate(ArrayList::new, (list, sink) -> {

            // error：more than one call to onNext
         /* for (int i = 0; i <5 ; i++) {
              sink.next(i);
              list.add(i);
          }
          sink.complete();*/

            int i = RandomUtils.nextInt();
            sink.next(i);
            list.add(i);
            if (list.size() > 3) {
                sink.complete();
            }
            return list;
        });
    }

    /**
     * create()方法 使用FluxSink 支持同步和异步的消息产生，并且可以在一次调用中产生多个元素
     *
     * @return
     */
    @GetMapping("/fluxCreate")
    public Flux fluxCreate() {
        return Flux.create(sink -> {
            for (int i = 0; i < 4; i++) {
                sink.next(i);
            }
            sink.complete();
        });
    }

    @GetMapping("/mono")
    public Mono mono() {
        return Mono.create(sink -> {
            sink.success("hello");
        });
    }

    @GetMapping("/kerr")
    public Flux<City> getKerrs(Integer[] ids) {
        Flux<Integer> idsFlux = Flux.just(ids);
        return cityRepository.getKerrsByIds(idsFlux);
    }
}
