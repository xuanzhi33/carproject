package cn.xuanzhi33.carprojectserver.pojo;

import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class PageInfoDTO {
    @Min(value = 1, message = "page should be greater than 0")
    private int page;
    @Range(min = 1, max = 100, message = "pageSize should be between 1 and 100")
    private int pageSize;
}
