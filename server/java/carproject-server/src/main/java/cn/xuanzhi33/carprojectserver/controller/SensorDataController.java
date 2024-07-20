package cn.xuanzhi33.carprojectserver.controller;


import cn.xuanzhi33.carprojectserver.pojo.*;
import cn.xuanzhi33.carprojectserver.service.SensorDataService;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class SensorDataController {

    private final SensorDataService dataService;

    public SensorDataController(SensorDataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping("/get")
    public Result<PagedSensorDataVO> getData(@Valid @RequestBody PageInfoDTO pageInfoDTO) {
        int page = pageInfoDTO.getPage();
        int pageSize = pageInfoDTO.getPageSize();

        return Result.success(dataService.getPagedData(page, pageSize));
    }

    @PostMapping("/insert")
    public Result<Integer> insertData(@Valid @RequestBody SensorDataDTO sensorDataDTO) {
        // Convert SensorDataDTO to SensorData
        // Copy properties from sensorDataDTO to sensorData
        SensorData sensorData = new SensorData();
        BeanUtils.copyProperties(sensorDataDTO, sensorData);
        int lines = dataService.insertData(sensorData);
        return Result.success(lines);
    }

    @DeleteMapping("/delete/{id}")
    public Result<Integer> deleteData(@PathVariable int id) {
        return Result.success(dataService.deleteData(id));
    }

}
