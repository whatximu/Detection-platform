package cn.edu.whatximu.repairs.dao;

import cn.edu.whatximu.repairs.pojo.CarUser;
import com.alibaba.fastjson.JSONObject;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper  {

   @Select("select count(username) from user_signin where username=#{username} and userpwd=#{userpwd}")
   String user_check(JSONObject request);

   @Select("select username, userpwd, name, identity from user_signin where username=#{username} and userpwd=#{userpwd}")
   CarUser getname(JSONObject request);

}
