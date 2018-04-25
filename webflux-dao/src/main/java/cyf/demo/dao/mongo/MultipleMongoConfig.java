package cyf.demo.dao.mongo;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * 多数据源
 * 读取对应的配置信息并且构造对应的MongoTemplate
 *
 * 避免spring操作时不知道使用哪个出现 NoUniqueBeanDefinitionException.
 * 注解	       备注
   @Primary	   优先方案，被注解的实现，优先被注入
   @Qualifier  先声明后使用，相当于多个实现起多个不同的名字，注入时候告诉我你要注入哪个
 *
 *
 *
 * @author Cheng Yufei
 * @create 2017-08-07 18:43
 **/
//@Configuration
public class MultipleMongoConfig {

    @Autowired
    private MultipleMongoProperties mongoProperties;

    //两个template中有一个得有@Primary注解，Service注入template时按名称注入@Resource，factory同样
    @Primary
    @Bean
    public MongoTemplate primaryMongoTemplate() throws Exception {
        System.out.println();
        return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()));
    }

    @Bean
    public MongoTemplate secondMongoTemplate() throws Exception {
        System.out.println();
        return new MongoTemplate(secondFactory(this.mongoProperties.getSecond()));
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory(MongoProperties mongo) throws Exception {
        System.out.println();
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

    @Bean
    public MongoDbFactory secondFactory(MongoProperties mongo) throws Exception {
        System.out.println();
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()),
                mongo.getDatabase());
    }

}
