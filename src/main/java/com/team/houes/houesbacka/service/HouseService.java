package com.team.houes.houesbacka.service;

import com.github.pagehelper.PageInfo;
import com.team.houes.houesbacka.entity.House;
import com.team.houes.houesbacka.util.HouesQu;
import com.team.houes.houesbacka.util.PagePrameter;

public interface HouseService {
    //发布出租房
    public int addHouse(House house);

   // 查询某用户下所有出租房支持分页
    public PageInfo<House>getHouseByUserId(Integer id, PagePrameter pagePrameter);

    //删除
    public int deletHouse(String id);

    //查询浏览信息
    public PageInfo<House>getByHouse(HouesQu houesQu);

}
