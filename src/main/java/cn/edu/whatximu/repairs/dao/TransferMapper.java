package cn.edu.whatximu.repairs.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TransferMapper {

    @Update("UPDATE transfer SET statue = '3', result = #{labourDocs} WHERE id = #{id}")
    void updataTransfer(JSONObject request);

}
