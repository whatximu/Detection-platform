package cn.edu.whatximu.repairs.dao;
import cn.edu.whatximu.repairs.pojo.describe;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Mapper
public interface ResultMapper {
    @Select("select statue from transfer where username=#{username} and id=#{id}")
    String  get_state(JSONObject request);

    @Select("select way from transfer where username=#{username} and id=#{id}")
    String  get_way(JSONObject request);

    @Select("SELECT state,info FROM machine ")
    List<describe> get_info1(JSONObject request);

    @Select("SELECT state,info FROM artificial ")
    List<describe> get_info2(JSONObject request);

    @Update("update transfer set result=123 where username=#{username} and id=#{id} ")
    void update_result(JSONObject request);

    @Select("select result from transfer  where username=#{username} and id=#{id} ")
    String get_result(JSONObject request);

    @Update("update transfer set way=1 where username=#{username} and id=#{id}")
    void  change_way(JSONObject request);

    @Update("update transfer set statue=statue where username=#{username} and id=#{id}")
    void  change_state(JSONObject request);

    @Update("update transfer set statue=5 where id=#{id}")
    void  changeState(JSONObject request);

    @Select("select statue from transfer where id=#{id}")
    String  getState(JSONObject request);

    @Select("select way from transfer where id=#{id}")
    String  getWay(JSONObject request);

    @Select("SELECT result FROM transfer WHERE id = #{id}")
    String getResult(JSONObject request);

    @Insert(
            "INSERT INTO order_id VALUES(#{type},#{kg},#{price},#{Code},#{order_id});"
    )
    void insertOrder_id(@Param("type") String type, @Param("kg") String kg, @Param("price") float price, @Param("Code") String Code, @Param("order_id") String order_id);

    @Insert(
            "INSERT INTO transfer VALUES(#{order_id},#{Rid},#{Uid});"
    )
    void insertransfer(@Param("order_id") String order_id, @Param("Rid") String Rid, @Param("Uid") String Uid);

}
