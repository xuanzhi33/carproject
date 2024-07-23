package cn.xuanzhi33.carprojectserver.service;

import cn.xuanzhi33.carprojectserver.pojo.PagedSensorDataVO;
import cn.xuanzhi33.carprojectserver.pojo.SensorData;
import com.baomidou.mybatisplus.extension.service.IService;


public interface SensorDataService extends IService<SensorData> {
    PagedSensorDataVO getPagedData(long page, long pageSize);
}
