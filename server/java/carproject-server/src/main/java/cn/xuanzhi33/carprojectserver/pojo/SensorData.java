package cn.xuanzhi33.carprojectserver.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SensorData {
    private int id;
    private String user;
    private String data;
    private String createTime;
}
