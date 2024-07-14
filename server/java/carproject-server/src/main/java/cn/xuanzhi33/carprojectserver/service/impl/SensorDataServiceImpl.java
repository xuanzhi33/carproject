package cn.xuanzhi33.carprojectserver.service.impl;

import cn.xuanzhi33.carprojectserver.mapper.SensorDataMapper;
import cn.xuanzhi33.carprojectserver.pojo.PagedSensorDataVO;
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
    public PagedSensorDataVO getPagedData(int page, int pageSize) {
        PagedSensorDataVO pagedSensorDataVO = new PagedSensorDataVO();
        int offset = (page - 1) * pageSize;
        pagedSensorDataVO.setPageSize(pageSize);
        pagedSensorDataVO.setData(dataMapper.getDataByPage(pageSize, offset));
        pagedSensorDataVO.setTotal(dataMapper.getTotal());
        pagedSensorDataVO.setPage(page);
        return pagedSensorDataVO;
    }

    @Override
    public int insertData(SensorData sensorData) {
        return dataMapper.insertData(sensorData);
    }
}
