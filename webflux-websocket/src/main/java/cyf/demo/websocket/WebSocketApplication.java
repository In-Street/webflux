package cyf.demo.websocket;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * 排除 mongo 的两种自动localhost:27017 的自动配置
 * boot入口
 */
@SpringBootApplication(
        scanBasePackages = { "cyf.demo.websocket"}
)
public class WebSocketApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(WebSocketApplication.class)
                .run(args);
    }
}
