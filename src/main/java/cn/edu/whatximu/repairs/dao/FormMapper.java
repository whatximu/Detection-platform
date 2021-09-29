package cn.edu.whatximu.repairs.dao;

import cn.edu.whatximu.repairs.pojo.InformationForm;
import cn.edu.whatximu.repairs.pojo.llist;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author what_ximu
 * @date 2021/5/11 7:52
 */
@Mapper
@Repository
public interface FormMapper {
    @Insert("insert into form values(#{id},#{webname},#{airnumer},#{reportdate},#{carbrand},#{carconfig},#{carVIN},#{ mileage},#{engineid},#{gearboxid},#{refit},#{maintain},#{desc},#{condition2},#{load2},#{operating},#{gears2},#{minrpm},#{maxrpm},#{minkph},#{maxkph},#{subjective2},#{abnormalx},#{fileList})")
    void form_insert(JSONObject request);


    @Insert("insert into transfer(id,username,statue,result) values(#{id},#{xprax},#{statue},#{result})")
    void transfer(JSONObject request);


    @Select("SELECT\n" +
            "\tform.id, \n" +
            "\tform.reportdate,\n" +
            "\tform.webname,\n" +
            "\tform.carbrand,\n" +
            "\tform.carVIN,\n" +
            "\tform.carconfig,\n" +
            "\ttransfer.way\n" +
            "FROM\n" +
            "\tform\n" +
            "\tINNER JOIN\n" +
            "\ttransfer\n" +
            "\tON \n" +
            "\t\tform.id = transfer.id\n" +
            "\t\twhere username=#{username}")
    List<llist> get_list(JSONObject request);

    @Select("SELECT form.id, form.webname, form.carbrand, form.carconfig, form.carVIN, form.reportdate FROM form")
    List<llist> getRootTable(JSONObject request);

    /**
     * 人工未反馈
     * @param request
     * @return
     */
    @Select("SELECT form.id ,form.webname,form.reportdate,form.carbrand,form.carVIN,form.carconfig ,transfer.way FROM form INNER JOIN transfer ON form.id = transfer.id WHERE statue = 2 AND way = 1")
    List<llist> getAdminTableFalse(JSONObject request);

    /**
     * 人工已经反馈
     * @param request
     * @return
     */
    @Select("SELECT form.id ,form.webname,form.reportdate,form.carbrand,form.carVIN,form.carconfig ,transfer.way  FROM form INNER JOIN transfer ON form.id = transfer.id ")
    List<llist> getAdminTableTrue(JSONObject request);

    @Select("SELECT * FROM form WHERE id =#{id}")
    InformationForm getForm(JSONObject request);

    @Select("SELECT form.id, form.webname, form.carbrand, form.carconfig, form.carVIN, form.reportdate  FROM form INNER JOIN transfer ON form.id = transfer.id WHERE statue = 3 AND transfer.username = #{username}")
    List<llist> getrepairTable(JSONObject request);

    @Insert("insert into repair(id,repairdate, repairname,repairdocs,repairload,whether) values(#{id},#{reportdate},#{carbrand},#{desc},#{load},#{refit})")
    void addRepair(JSONObject request);


}
