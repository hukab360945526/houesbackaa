package com.team.houes.houesbacka.controller;

import com.team.houes.houesbacka.entity.Street;
import com.team.houes.houesbacka.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName StreetController
 * @Description
 * @Author HU
 * @Date 2020/2/25 21:49
 */
@RestController
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("/getStreet")
    @CrossOrigin(value = "*",allowCredentials = "true")
    public List<Street>getStreet(Integer did){
        return streetService.getStreet(did);
    }
}
