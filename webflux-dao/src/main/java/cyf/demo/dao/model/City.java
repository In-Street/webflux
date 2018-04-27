package cyf.demo.dao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Cheng Yufei
 * @create 2018-04-14 上午11:04
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;

    public City(String cityName) {
        this.cityName = cityName;
    }

}
