package cyf.demo.mongo.service;

import cyf.demo.dao.mongo.PrimaryMongoObject;
import cyf.demo.dao.mongo.SecondMongoObject;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author Cheng Yufei
 * @create 2018-04-25 17:41
 **/
@Service
public class MongoService {

    @Resource
    private ReactiveMongoTemplate primaryMongoTemplate;
    @Resource
    private ReactiveMongoTemplate secondMongoTemplate;

    public Mono<PrimaryMongoObject> save(PrimaryMongoObject primaryMongoObject) {
        return primaryMongoTemplate.save(primaryMongoObject);
    }

    /**
     * 第二数据源存储
     * @param secondMongoObject
     * @return
     */
    public Mono<SecondMongoObject> save2(SecondMongoObject secondMongoObject) {
        return secondMongoTemplate.save(secondMongoObject);
    }

    public Flux<PrimaryMongoObject> findAllPrimary() {
        Flux<PrimaryMongoObject> all = primaryMongoTemplate.findAll(PrimaryMongoObject.class);
        return all;
    }

    public Flux<SecondMongoObject> findAllSecond() {
        Flux<SecondMongoObject> all = secondMongoTemplate.findAll(SecondMongoObject.class);
        return all;
    }
}
