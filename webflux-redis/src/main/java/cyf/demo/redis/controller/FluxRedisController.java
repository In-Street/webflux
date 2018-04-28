package cyf.demo.redis.controller;

import cyf.demo.dao.model.City;
import cyf.demo.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Cheng Yufei
 * @create 2018-04-27 10:43
 **/
@RestController
@RequestMapping("/redis")
public class FluxRedisController {

    @Autowired
    private RedisService redisService;

    /**
     * 返回值必须有，如果为void 则 redis存储数据失败
     * @return
     */
    @GetMapping("/save")
    public Mono<Boolean> save() {
        return redisService.save();
    }

    @GetMapping("/get")
    public Mono get() {
        return redisService.get();
    }

    /**
     * 当将返回值设为 void 时，redis 删除key 值失效，无法删除key；
     * 当设置为 Mono<Boolean> ,删除成功。
     */
   /* @GetMapping("/del")
    public void del() {
        redisService.del();
    }*/
    @GetMapping("/del")
    public Mono<Boolean>  del() {
        return redisService.del();
    }
}
