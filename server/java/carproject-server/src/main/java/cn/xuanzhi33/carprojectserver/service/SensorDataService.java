package cn.xuanzhi33.carprojectserver.service;

import cn.xuanzhi33.carprojectserver.pojo.SensorData;

import java.util.List;

public interface SensorDataService {
    List<SensorData> getData();
    int insertData(SensorData sensorData);
}
