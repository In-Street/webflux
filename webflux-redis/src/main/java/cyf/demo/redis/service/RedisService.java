package cyf.demo.redis.service;

import com.alibaba.fastjson.JSONObject;
import cyf.demo.dao.model.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * @author Cheng Yufei
 * @create 2018-04-27 10:43
 **/
@Service
@Slf4j
public class RedisService {

    private ReactiveValueOperations valueOperations;

    private ReactiveRedisTemplate reactiveRedisTemplate;

    /**
     * 设置序列化 避免设置的key为乱码
     * @param reactiveRedisTemplate
     */
    @Autowired
    public void setReactiveRedisTemplate(ReactiveRedisTemplate reactiveRedisTemplate) {

        /*RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);*/

        RedisSerializer redisSerializer = new StringRedisSerializer();
        RedisSerializationContext.RedisSerializationContextBuilder<Object, Object> contextBuilder = RedisSerializationContext.newSerializationContext(redisSerializer);
        ReactiveValueOperations valueOperations = reactiveRedisTemplate.opsForValue(contextBuilder.build());
        this.reactiveRedisTemplate = reactiveRedisTemplate;
        this.valueOperations = valueOperations;
    }
    
    public Mono<Boolean> save() {
        City city = new City("北京市");
        Mono<Boolean> set = valueOperations.set("webflux_redis", JSONObject.toJSONString(city),Duration.of(120,SECONDS));
        return set;
    }
    public Mono get() {

        Mono mono = valueOperations.get("webflux_redis");

        /*Consumer<String> consumer = s -> JSONObject.parseObject(s, City.class);
        Mono mono1 = mono.doOnNext(consumer);*/
        Consumer<City> consumer = s -> s.setDescription("描述");
        Mono cityMono = mono.doOnEach(consumer);
        return cityMono;
    }

    public Mono<Boolean> del() {
        Mono<Boolean> delete = valueOperations.delete("webflux_redis");
        return delete;
    }
    //无返回值删除key失败
  /*  public void del() {
        Mono<Boolean> delete = valueOperations.delete("webflux_redis");
    }*/
}
