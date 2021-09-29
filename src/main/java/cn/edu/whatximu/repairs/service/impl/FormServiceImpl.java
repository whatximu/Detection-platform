package cn.edu.whatximu.repairs.service.impl;
import cn.edu.whatximu.repairs.dao.FormMapper;
import cn.edu.whatximu.repairs.dao.ResultMapper;
import cn.edu.whatximu.repairs.pojo.InformationForm;
import cn.edu.whatximu.repairs.pojo.llist;
import cn.edu.whatximu.repairs.service.FormService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author what_ximu
 * @date 2021/5/11 7:49
 */
@Repository
public class FormServiceImpl implements FormService {
    @Autowired
    private FormMapper formMapper;
    @Autowired
    private ResultMapper resultMapper;

    /**
     * from_submit
     * @param request
     * @return
     */
    @Override
    public JSONObject form_insert(JSONObject request) {

        JSONObject result=new JSONObject();

        String condition = request.get("condition").toString();
        String load=request.get("load").toString();
        String gears=request.get("gears").toString();
        String subjective=request.get("subjective").toString();



        condition =condition.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
        load = load.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
        gears = gears.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
        subjective=subjective.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");



        request.put("condition2",condition); request.put("load2",load); request.put("gears2",gears); request.put("subjective2",subjective);
        formMapper.form_insert(request);
        request.put("statue", 2);
        request.put("result", "后台正在查找结果，请耐心等待");
        formMapper.transfer(request);
        System.out.println("ending-");
        result.put("code",0);
        result.put("percent",20);

        return result;
    }

    @Override
    public JSONObject list_get(JSONObject request) {
        JSONObject result=new JSONObject();
        List<llist> lli=formMapper.get_list(request);
        result.put("list",lli);
        return result;
    }

    @Override
    public JSONObject getRootTable(JSONObject request) {
        JSONObject result=new JSONObject();
        List<llist> list=formMapper.getRootTable(request);
        result.put("rootList",list);
        return result;
    }

    @Override
    public JSONObject getAdminTableFalse(JSONObject request) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("adminListFalse", formMapper.getAdminTableFalse(request));
        return jsonObject;
    }

    @Override
    public JSONObject getAdminTableTrue(JSONObject request) {
        JSONObject jsonObject = new JSONObject();
        List<llist> list = formMapper.getAdminTableTrue(request);
        for (llist ll : list){
            String s = ll.getWay();
            if("0".equals(s)){
                ll.setWay("http://101.37.66.239:8081/images/11.png");
            }else {
                ll.setWay("http://101.37.66.239:8081/images/22.png");
            }
        }
        jsonObject.put("adminListTrue", list);
        return jsonObject;
    }

    @Override
    public JSONObject getAdminForm(JSONObject request) {
        JSONObject jsonObject = new JSONObject();
        InformationForm inf = formMapper.getForm(request);
        jsonObject.put("informationForm", JSON.toJSONString(inf));
        return jsonObject;
    }

    public JSONObject getrepairTable(JSONObject request) {
        JSONObject result=new JSONObject();
        List<llist> list=formMapper.getrepairTable(request);
        result.put("rootList",list);
        return result;
    }

    @Override
    public JSONObject addRepair(JSONObject request) {
        JSONObject jsonObject = new JSONObject();
        String refit = (String) request.get("refit");
        formMapper.addRepair(request);
        System.out.println(refit);
        if ("已完成".equals(refit)){
            resultMapper.changeState(request);
        }
        return jsonObject;
    }
}
