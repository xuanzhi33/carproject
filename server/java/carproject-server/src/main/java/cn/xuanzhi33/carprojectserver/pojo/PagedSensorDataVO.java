package cn.xuanzhi33.carprojectserver.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PagedSensorDataVO {
    private long page;
    private long pageSize;
    private long total;
    private List<SensorData> data;
}
