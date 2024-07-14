package cn.xuanzhi33.carprojectserver.service;

import cn.xuanzhi33.carprojectserver.pojo.PagedSensorDataVO;
import cn.xuanzhi33.carprojectserver.pojo.SensorData;

import java.util.List;

public interface SensorDataService {
    PagedSensorDataVO getPagedData(int page, int pageSize);
    int insertData(SensorData sensorData);
}
