package com.team.houes.houesbacka.mapper;

import com.team.houes.houesbacka.entity.House;
import com.team.houes.houesbacka.entity.HouseExample;
import com.team.houes.houesbacka.util.HouesQu;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //通过用户编号查询当前用户下的出租房
    List<House> getHouseByUser(Integer id);

    //查询浏览信息
    List<House>getHouesBr(HouesQu houesQu);


}