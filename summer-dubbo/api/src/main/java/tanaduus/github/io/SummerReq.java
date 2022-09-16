package tanaduus.github.io;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author 夏加龙
 * @date 2022/9/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SummerReq extends BaseReq {

    @NotBlank(message = "名称不能为空")
    private String name;
}
