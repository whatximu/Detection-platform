package cn.edu.whatximu.repairs.dao;

import cn.edu.whatximu.repairs.pojo.Repair;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RepairMapper {
    @Select("select * from repair where id=#{id}")
    List<Repair> getRepairs(JSONObject request);


}
