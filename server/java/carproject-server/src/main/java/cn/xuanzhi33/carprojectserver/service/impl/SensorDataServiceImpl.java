package cn.xuanzhi33.carprojectserver.service.impl;

import cn.xuanzhi33.carprojectserver.mapper.SensorDataMapper;
import cn.xuanzhi33.carprojectserver.pojo.PagedSensorDataVO;
import cn.xuanzhi33.carprojectserver.pojo.SensorData;
import cn.xuanzhi33.carprojectserver.service.SensorDataService;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SensorDataServiceImpl extends ServiceImpl<SensorDataMapper, SensorData> implements SensorDataService {

    @Override
    public PagedSensorDataVO getPagedData(long page, long pageSize) {
        // MP 分页
        Page<SensorData> sensorDataPage = new Page<>(page, pageSize);
        // 查询
        sensorDataPage.addOrder(OrderItem.desc("id"));
        page(sensorDataPage);
        List<SensorData> records = sensorDataPage.getRecords();
        PagedSensorDataVO pagedSensorDataVO = new PagedSensorDataVO();
        pagedSensorDataVO.setData(records);
        pagedSensorDataVO.setPageSize(pageSize);
        pagedSensorDataVO.setPage(page);
        pagedSensorDataVO.setTotal(sensorDataPage.getTotal());
        return pagedSensorDataVO;
    }

}
