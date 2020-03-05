package com.team.houes.houesbacka.service.impl;

import com.team.houes.houesbacka.entity.Type;
import com.team.houes.houesbacka.entity.TypeExample;
import com.team.houes.houesbacka.mapper.TypeMapper;
import com.team.houes.houesbacka.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ClassName TypeServiceimpl
 * @Description
 * @Author HU
 * @Date 2020/2/25 21:36
 */
@Service
public class TypeServiceimpl implements TypeService {
    @Autowired(required = false)
    private TypeMapper typeMapper;
    @Override
    public List<Type> getType() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
