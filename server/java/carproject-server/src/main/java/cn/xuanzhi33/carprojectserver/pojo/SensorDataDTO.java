package cn.xuanzhi33.carprojectserver.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SensorDataDTO {
    @NotEmpty(message = "user should not be empty")
    private String user;
    @NotEmpty(message = "data should not be empty")
    private String data;
}
