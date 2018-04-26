package cyf.demo.mongo;

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
        scanBasePackages = {"cyf.demo.dao", "cyf.demo.mongo"},exclude={MongoReactiveAutoConfiguration.class,MongoReactiveDataAutoConfiguration.class,MongoAutoConfiguration.class,MongoDataAutoConfiguration.class}
)
public class FluxMongoApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FluxMongoApplication.class)
                .run(args);
    }
}
