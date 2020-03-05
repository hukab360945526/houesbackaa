package com.team.houes.houesbacka.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.houes.houesbacka.entity.House;
import com.team.houes.houesbacka.mapper.HouseMapper;
import com.team.houes.houesbacka.service.HouseService;
import com.team.houes.houesbacka.util.HouesQu;
import com.team.houes.houesbacka.util.PagePrameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HouseServiceimpl
 * @Description
 * @Author HU
 * @Date 2020/2/25 21:35
 */
@Service
public class HouseServiceimpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUserId(Integer uid, PagePrameter pagePrameter) {
        //开启分页
        PageHelper.startPage(pagePrameter.getPage(),pagePrameter.getPageSize());
        List<House>list=houseMapper.getHouseByUser(uid);
        return new PageInfo<>(list);
    }

    //删除
    @Override
    public int deletHouse(String id) {
        return houseMapper.deleteByPrimaryKey(id);
    }

    //查询浏览信息
    @Override
    public PageInfo<House> getByHouse(HouesQu houesQu) {
        PageHelper.startPage(houesQu.getPage(),houesQu.getPageSize());
        List<House>list=houseMapper.getHouesBr(houesQu);
        return new PageInfo<>(list);
    }

}
