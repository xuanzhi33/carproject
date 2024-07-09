package cn.xuanzhi33.carprojectserver.mapper;

import cn.xuanzhi33.carprojectserver.pojo.SensorData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SensorDataMapper {
    @Select("select * from sensor_data")
    List<SensorData> getData();

    @Insert("insert into sensor_data(user, data) values(#{user}, #{data})")
    int insertData(SensorData sensorData);
}
