package cn.xuanzhi33.carprojectserver.pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RenameDTO {
    @Min(value = 1, message = "id should be greater than 0")
    private int id;
    @Size(min = 1, max = 30, message = "newName should be between 1 and 30 characters")
    private String newName;
}
