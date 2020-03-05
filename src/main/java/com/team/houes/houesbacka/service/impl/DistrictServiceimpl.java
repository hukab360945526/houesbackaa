package com.team.houes.houesbacka.service.impl;

import com.team.houes.houesbacka.entity.District;
import com.team.houes.houesbacka.entity.DistrictExample;
import com.team.houes.houesbacka.mapper.DistrictMapper;
import com.team.houes.houesbacka.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DistrictServiceimpl
 * @Description
 * @Author HU
 * @Date 2020/2/25 21:34
 */
@Service
public class DistrictServiceimpl implements DistrictService {
    @Autowired(required = false)
    private DistrictMapper districtMapper;

    @Override
    public List<District> getDist() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
