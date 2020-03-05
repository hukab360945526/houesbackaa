package com.team.houes.houesbacka.service.impl;

import com.team.houes.houesbacka.entity.Street;
import com.team.houes.houesbacka.entity.StreetExample;
import com.team.houes.houesbacka.mapper.StreetMapper;
import com.team.houes.houesbacka.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName StreetServiceimpl
 * @Description
 * @Author HU
 * @Date 2020/2/25 21:35
 */
@Service
public class StreetServiceimpl implements StreetService {
    @Autowired(required = false)
    private StreetMapper streetMapper;
    @Override
    public List<Street> getStreet(Integer did) {
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria= streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did);
        return streetMapper.selectByExample(streetExample);
    }
}
