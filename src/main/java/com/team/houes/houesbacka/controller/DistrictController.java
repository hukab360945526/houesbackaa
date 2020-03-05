package com.team.houes.houesbacka.controller;

import com.team.houes.houesbacka.entity.District;
import com.team.houes.houesbacka.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DistrictController
 * @Description
 * @Author HU
 * @Date 2020/2/25 21:48
 */
@RestController
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/getDistrict")
    @CrossOrigin(value = "*",allowCredentials = "true")
    public List<District>getDistrict(){
        return districtService.getDist();
    }
}
