package cn.edu.whatximu.repairs.service.impl;

import cn.edu.whatximu.repairs.dao.FormMapper;
import cn.edu.whatximu.repairs.dao.RepairMapper;
import cn.edu.whatximu.repairs.dao.ResultMapper;
import cn.edu.whatximu.repairs.pojo.InformationForm;
import cn.edu.whatximu.repairs.pojo.Repair;
import cn.edu.whatximu.repairs.pojo.describe;
import cn.edu.whatximu.repairs.service.RootEntiretyFormService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RootEntiretyFormServiceImpl implements RootEntiretyFormService {

    @Autowired
    private FormMapper formMapper;
    @Autowired
    private ResultMapper resultMapper;
    @Autowired
    private RepairMapper repairMapper;

    @Override
    public JSONObject getFormAndResult(JSONObject request) {
        String resultIf = "";
        JSONObject jsonObject = new JSONObject();
        InformationForm informationForm = formMapper.getForm(request);
        String statue = resultMapper.getState(request);
        String way = resultMapper.getWay(request);
        String result = resultMapper.getResult(request);
        List<describe> describe = null;
        if ("0".equals(way)){
            System.out.println("后台查找成功");
            describe = resultMapper.get_info1(request);
            resultIf = "0";
        }
        if ("1".equals(way)) {
            System.out.println("人工反馈");
            describe = resultMapper.get_info2(request);
            resultIf = "1";
        }
        String str = JSON.toJSONString(informationForm);
        System.out.println(str);
        jsonObject.put("informationForm", str);
        jsonObject.put("statue", statue);
        System.out.println(statue);
        System.out.println(describe.size());
        int num = (int)(Integer.parseInt(statue)*100/describe.size());
        if (num > 100){
            num = 100;
        }
        System.out.println(num);

        List<Repair> listRepair = repairMapper.getRepairs(request);
        System.out.println(listRepair);
        jsonObject.put("listRepair", listRepair);

        jsonObject.put("percent",  num);
        jsonObject.put("describe", JSON.toJSONString(describe));
        System.out.println(JSON.toJSONString(describe));
        jsonObject.put("resultt", result);
        jsonObject.put("resultIf", resultIf);
        return jsonObject;
    }
}
