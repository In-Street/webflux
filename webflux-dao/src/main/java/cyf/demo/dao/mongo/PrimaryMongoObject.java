package cyf.demo.dao.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 库对应的对象
 *
 * @author Cheng Yufei
 * @create 2017-08-08 15:42
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "first_mongo")

//一定要注意collection 的选择，否则 数据 存错地方
@Document(collection = "cyf_collections")
public class PrimaryMongoObject {

    @Id
    private String id;

    private String name;

    @Override
    public String toString() {
        return "PrimaryMongoObject{" + "id='" + id + '\'' + ", value='" + name + '\''
                + '}';
    }

}
