package cyf.demo.introduction;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * boot入口
 *
 */
@SpringBootApplication(
        scanBasePackages = {"cyf.demo.dao","cyf.demo.introduction"},exclude={MongoAutoConfiguration.class,MongoDataAutoConfiguration.class}
)
public class FluxApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FluxApplication.class)
                .run(args);
    }
}
