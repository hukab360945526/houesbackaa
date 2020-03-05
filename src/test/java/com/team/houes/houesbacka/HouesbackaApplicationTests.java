package com.team.houes.houesbacka;

import com.team.houes.houesbacka.entity.District;
import com.team.houes.houesbacka.entity.DistrictExample;
import com.team.houes.houesbacka.entity.Users;
import com.team.houes.houesbacka.entity.UsersExample;
import com.team.houes.houesbacka.mapper.DistrictMapper;
import com.team.houes.houesbacka.mapper.UsersMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HouesbackaApplicationTests {
    @Autowired(required = false)
    private DistrictMapper districtMapper;
    @Autowired(required = false)
    private UsersMapper usersMapper;
    @Test
   public void contextLoads() {
        List<District>list=districtMapper.selectByExample(new DistrictExample());
        System.out.println("这是"+list.size());
        List<Users>list1=usersMapper.selectByExample(new UsersExample());
        System.out.println("z"+list1.size());
    }

}
