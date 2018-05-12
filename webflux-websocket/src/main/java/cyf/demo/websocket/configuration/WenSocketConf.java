package cyf.demo.websocket.configuration;

import com.google.common.collect.Maps;
import cyf.demo.websocket.handler.HelloWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

import java.util.Map;

/**
 * @author Cheng Yufei
 * @create 2018-05-12 上午10:21
 **/
@Configuration
public class WenSocketConf {

    @Autowired
    @Bean
    public HandlerMapping set(HelloWebSocketHandler handler) {
        Map map = Maps.newHashMap();
        map.put("/hello", handler);

        SimpleUrlHandlerMapping urlHandlerMapping = new SimpleUrlHandlerMapping();
        urlHandlerMapping.setUrlMap(map);
        urlHandlerMapping.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return urlHandlerMapping;
    }

    @Bean
    public WebSocketHandlerAdapter setAdapter() {
        return new WebSocketHandlerAdapter();
    }
}
