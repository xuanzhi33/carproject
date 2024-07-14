package cn.xuanzhi33.carprojectserver.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PagedSensorDataVO {
    private int page;
    private int pageSize;
    private int total;
    private List<SensorData> data;
}
