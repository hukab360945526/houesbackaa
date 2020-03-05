package com.team.houes.houesbacka.controller;

import com.github.pagehelper.PageInfo;
import com.team.houes.houesbacka.entity.House;
import com.team.houes.houesbacka.entity.Users;
import com.team.houes.houesbacka.service.HouseService;
import com.team.houes.houesbacka.util.FileUploadUtil;
import com.team.houes.houesbacka.util.HouesQu;
import com.team.houes.houesbacka.util.PagePrameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HouseController
 * @Description
 * @Author HU
 * @Date 2020/2/25 21:48
 */
@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;
    //添加
    @RequestMapping("/fabuHouse")
    @CrossOrigin(value = "*",allowCredentials ="true")
    public String fabuHouse(House house, HttpSession session,
                            @RequestParam(value = "pfile",required = false)
                                    MultipartFile pfile ){
        try {
            //设置文件存储位置
            String path="D:\\xx";
            //调用工具类实现上传
            String fliename= FileUploadUtil.upload(pfile,path);
            //1.1 设置出租房的编号   利用时间毫秒数
            house.setId(System.currentTimeMillis()+"");
            //登入实现啦，获取登入人的编号
            Users users=(Users) session.getAttribute("logininfo");
            house.setUserId(users.getId());
            //3.设置保存文件的路径
            house.setPath(fliename);
            houseService.addHouse(house);
            return "{\"result\":1}";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":0}";
    }

    //接收用户请求获取当前页的数据
    @RequestMapping("/getHouseByPage")
    @CrossOrigin(value = "*",allowCredentials = "true")
    public Map<String,Object>getHouseByPage(PagePrameter pagePrameter,HttpSession session){
        pagePrameter.setPageSize(4);
        Users users=(Users) session.getAttribute("logininfo");
        PageInfo<House>pageInfo=houseService.getHouseByUserId(users.getId(),pagePrameter);
        Map<String,Object>map=new HashMap<>();
        map.put("totalPage",pageInfo.getPages());//封装总页
        map.put("rows",pageInfo.getList());//封装当前页的记录
        return map;
    }

    //删除
    @RequestMapping("/deleHouse")
    @CrossOrigin(value = "*",allowCredentials = "true")
    public String deleHouse(String id ,String filename){
       int temp=houseService.deletHouse(id);
       if(temp>0){
           File file=new File("d:\\xx\\"+filename);
           if (file.exists()){
               file.delete();//删除
           }
           return "{\"result\":1}";
       }
       return "{\"result\":0}";
    }

    //查询浏览信息
    @RequestMapping("/searchHouse")
    @CrossOrigin(value = "*",allowCredentials = "true")
    public Map<String,Object>searchHouse(HouesQu houesQu){
        PageInfo<House> pageInfo=houseService.getByHouse(houesQu);
        Map<String,Object>map=new HashMap<>();
        map.put("totalPage",pageInfo.getPages());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
