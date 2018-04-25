package cyf.demo.dao.mongo;

import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;

/**
 * mongodb
 *
 * 封装读取以mongodb开头的两个配置文件
 *
 * @author Cheng Yufei
 * @create 2017-08-07 18:34
 **/
@Data
//@Component
//@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {

        private MongoProperties primary = new MongoProperties();
        private MongoProperties second = new MongoProperties();
}



