package cyf.demo.dao.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 二库对应对象
 *
 * @author Cheng Yufei
 * @create 2017-10-12 11:45
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cyfdb_second_coll")
public class SecondMongoObject {

    @Id
//    private Integer id;
    private String id;

    private String introduction;

    @Override
    public String toString() {
        return "SecondMongoObject{" +
                "id=" + id +
                ", pwd='" + introduction + '\'' +
                '}';
    }
}
