package cyf.demo.introduction.controller;

import cyf.demo.dao.model.City;
import cyf.demo.introduction.service.CityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Cheng Yufei
 * @create 2018-04-14 上午11:03
 **/
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityHandler cityHandler;

    @PostMapping
    public Mono save(@RequestBody City city) {

                return cityHandler.save(city);
        }

    @GetMapping
    public Flux<City> findAll() {

        return cityHandler.findAl();
    }

    @GetMapping("/{id}")
    public Mono<City> getById(@PathVariable long id) {

        return cityHandler.getById(id);
    }
}
