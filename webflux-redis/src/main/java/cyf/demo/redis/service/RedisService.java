package cyf.demo.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Cheng Yufei
 * @create 2018-04-27 10:43
 **/
@Service
@Slf4j
public class RedisService {

    @Autowired
    private ReactiveRedisTemplate reactiveRedisTemplate;
    
    public void save() {
    }
        
}
