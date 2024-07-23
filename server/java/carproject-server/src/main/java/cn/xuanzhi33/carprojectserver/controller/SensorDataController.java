package cn.xuanzhi33.carprojectserver.controller;


import cn.xuanzhi33.carprojectserver.pojo.*;
import cn.xuanzhi33.carprojectserver.service.SensorDataService;

import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
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
        long page = pageInfoDTO.getPage();
        long pageSize = pageInfoDTO.getPageSize();

        return Result.success(dataService.getPagedData(page, pageSize));
    }

    @PostMapping("/insert")
    public Result<Boolean> insertData(@Valid @RequestBody SensorDataDTO sensorDataDTO) {
        // Convert SensorDataDTO to SensorData
        // Copy properties from sensorDataDTO to sensorData
        SensorData sensorData = new SensorData();
        BeanUtils.copyProperties(sensorDataDTO, sensorData);
        Boolean res = dataService.save(sensorData);
        return Result.success(res);
    }

    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteData(@PathVariable long id) {
        return Result.success(dataService.removeById(id));
    }

    @PutMapping("/rename")
    public Result<Boolean> renameData(@Valid @RequestBody RenameDTO renameDTO) {
        long id = renameDTO.getId();
        String newName = renameDTO.getNewName();
        SensorData sensorData = new SensorData();
        sensorData.setId(id);
        sensorData.setUser(newName);
        return Result.success(dataService.updateById(sensorData));
    }

}
