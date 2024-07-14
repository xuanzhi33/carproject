package cn.xuanzhi33.carprojectserver.pojo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PageInfoDTO {
    @Min(value = 1, message = "page should be greater than 0")
    private int page;
    @Max(value = 100, message = "pageSize should be less than 100")
    private int pageSize;
}
