package cyf.demo.mongo.controller;

import cyf.demo.dao.mongo.PrimaryMongoObject;
import cyf.demo.dao.mongo.SecondMongoObject;
import cyf.demo.mongo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Cheng Yufei
 * @create 2018-04-25 17:50
 **/
@RestController
@RequestMapping("/mongo")
public class FluxMongoController {

    @Autowired
    private MongoService mongoService;


    @PostMapping("/save")
    public Mono<PrimaryMongoObject> save(@RequestBody PrimaryMongoObject primaryMongoObject) {
        Mono<PrimaryMongoObject> save = mongoService.save(primaryMongoObject);
        System.out.println();
        return save;
    }

    /**
     * 第二数据源存储
     * @param secondMongoObject
     * @return
     */
    @PostMapping("/save2")
    public Mono<SecondMongoObject> save(@RequestBody SecondMongoObject secondMongoObject) {
        Mono<SecondMongoObject> save = mongoService.save2(secondMongoObject);
        System.out.println();
        return save;
    }

    @GetMapping("/findAllPrimary")
    public Flux<PrimaryMongoObject> findAllPrimary() {
        return mongoService.findAllPrimary();
    }

    @GetMapping("/findAllSecond")
    public Flux<SecondMongoObject> findAllSecond() {
        return mongoService.findAllSecond();
    }
}
