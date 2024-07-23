package cn.xuanzhi33.carprojectserver.pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class PageInfoDTO {
    @Min(value = 1, message = "page should be greater than 0")
    @NotNull(message = "page should not be null")
    private Long page;

    @Range(min = 1, max = 100, message = "pageSize should be between 1 and 100")
    @NotNull(message = "pageSize should not be null")
    private Long pageSize;
}
