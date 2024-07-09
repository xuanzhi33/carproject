package cn.xuanzhi33.carprojectserver.controller;


import cn.xuanzhi33.carprojectserver.pojo.Result;
import cn.xuanzhi33.carprojectserver.pojo.SensorData;
import cn.xuanzhi33.carprojectserver.pojo.SensorDataDTO;
import cn.xuanzhi33.carprojectserver.service.SensorDataService;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SensorDataController {

    private final SensorDataService dataService;

    public SensorDataController(SensorDataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/get")
    @CrossOrigin(origins = "*")
    public Result<List<SensorData>> getData() {
        return Result.success(dataService.getData());
    }

    @PostMapping("/insert")
    @CrossOrigin(origins = "*")
    public Result<Integer> insertData(@RequestBody SensorDataDTO sensorDataDTO) {
        // Convert SensorDataDTO to SensorData
        // Copy properties from sensorDataDTO to sensorData
        SensorData sensorData = new SensorData();
        BeanUtils.copyProperties(sensorDataDTO, sensorData);
        System.out.println(sensorData);
        int lines = dataService.insertData(sensorData);
        return Result.success(lines);
    }

}
