package tanaduus.github.io;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 夏加龙
 * @date 2022/9/16
 */
@Data
@Builder
public class SummerResp implements Serializable {

    private Integer id;

    private String name;

    private BigDecimal amount;

    private String extra;
}
