package cyf.demo.introduction;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * boot入口
 *
 */
@SpringBootApplication(
        scanBasePackages = {"cyf.demo.dao"}
)
public class FluxApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FluxApplication.class)
                .run(args);
    }
}
