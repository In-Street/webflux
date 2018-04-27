package cyf.demo.redis;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * 排除 mongo 的两种自动localhost:27017 的自动配置
 * boot入口
 */
@SpringBootApplication(
        scanBasePackages = {"cyf.demo.dao", "cyf.demo.redis"},exclude={MongoReactiveAutoConfiguration.class,MongoReactiveDataAutoConfiguration.class,MongoAutoConfiguration.class,MongoDataAutoConfiguration.class}
)
public class FluxRedisApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FluxRedisApplication.class)
                .run(args);
    }
}
