package cn.xuanzhi33.carprojectserver.mapper;

import cn.xuanzhi33.carprojectserver.pojo.SensorData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SensorDataMapper {
    @Select("select * from sensor_data")
    List<SensorData> getData();

    @Select("select * from sensor_data order by id desc limit #{limit} offset #{offset}")
    List<SensorData> getDataByPage(int limit, int offset);

    // 获取总数
    @Select("select count(*) from sensor_data")
    int getTotal();

    @Insert("insert into sensor_data(user, data) values(#{user}, #{data})")
    int insertData(SensorData sensorData);

    @Delete("delete from sensor_data where id = #{id}")
    int deleteData(int id);

    @Update("update sensor_data set user = #{newName} where id = #{id}")
    int renameData(int id, String newName);
}
