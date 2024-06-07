package Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Auther: oyy0v0
 * @Date: 2024/6/7 - 06 - 07 - 18:55
 * @Description: Pojo
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announces {
    /**
     * 通告创建时间
     */
    private Date time;
    /**
     * 通告内容
     */
    private String annText;
}
