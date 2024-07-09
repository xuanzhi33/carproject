package cn.xuanzhi33.carprojectserver.service.impl;

import cn.xuanzhi33.carprojectserver.mapper.SensorDataMapper;
import cn.xuanzhi33.carprojectserver.pojo.SensorData;
import cn.xuanzhi33.carprojectserver.service.SensorDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataServiceImpl implements SensorDataService {

    private final SensorDataMapper dataMapper;

    public SensorDataServiceImpl(SensorDataMapper dataMapper) {
        this.dataMapper = dataMapper;
    }

    @Override
    public List<SensorData> getData() {
        return dataMapper.getData();
    }

    @Override
    public int insertData(SensorData sensorData) {
        return dataMapper.insertData(sensorData);
    }
}
