package cn.xuanzhi33.carprojectserver.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SensorDataDTO {
    @NotEmpty(message = "user should not be empty")
    @Size(min = 1, max = 30, message = "user should be between 1 and 30 characters")
    private String user;
    @NotEmpty(message = "data should not be empty")
    private String data;
}
