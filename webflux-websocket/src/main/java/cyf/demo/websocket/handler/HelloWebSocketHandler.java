package cyf.demo.websocket.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/**
 * @author Cheng Yufei
 * @create 2018-05-12 上午10:14
 **/
@Component
public class HelloWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {

        Function<WebSocketMessage, WebSocketMessage> function = msg -> {
            return session.textMessage("服务端:" + msg.getPayloadAsText());

        };

        return session.send(session.receive().map(function));

    }
}
