package com.team.houes.houesbacka.controller;

import com.team.houes.houesbacka.entity.Type;
import com.team.houes.houesbacka.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName TypeController
 * @Description
 * @Author HU
 * @Date 2020/2/25 21:49
 */
@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;

    @CrossOrigin(value = "*",allowCredentials = "true")//解决跨域
    @RequestMapping("/getTypes")
    public List<Type>getTypes(){
        return typeService.getType();
    }
}
