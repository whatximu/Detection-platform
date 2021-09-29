package cn.edu.whatximu.repairs.service.impl;

import cn.edu.whatximu.repairs.dao.RepairMapper;
import cn.edu.whatximu.repairs.dao.ResultMapper;
import cn.edu.whatximu.repairs.pojo.Repair;
import cn.edu.whatximu.repairs.pojo.describe;
import cn.edu.whatximu.repairs.service.ResultService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;


@Repository

public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultMapper resultMapper;

    @Autowired
    private RepairMapper repairMapper;

    @Override
    public JSONObject get_state(JSONObject request) {
        int percent = 0;
        JSONObject result = new JSONObject();
        String state = resultMapper.get_state(request);
        String way = resultMapper.get_way(request);
        int s1 = Integer.parseInt(state);
        int w1 = Integer.parseInt(way);
        if (s1 == 2 && w1 == 1) {
            resultMapper.update_result(request);
            System.out.println("人工-反馈");
        } else if (s1 == 1 && w1 == 0) {
            resultMapper.update_result(request);
            System.out.println("机器-反馈");
        }
        if (way.equals("0")) {

            percent = (int) (((s1 + 1) * 100) / 5);
            List<describe> describe = resultMapper.get_info1(request);
            result.put("code", state);
            result.put("active_percent", percent);
            result.put("describe", describe);
            System.out.println(describe);
        } else if (way.equals("1")) {

            percent = (int) (((s1 + 1) * 100) / 6);
            List<describe> describe = resultMapper.get_info2(request);
            result.put("code", state);
            result.put("active_percent", percent);
            result.put("describe", describe);

            System.out.println(describe);
        }
        List<Repair> listRepair = repairMapper.getRepairs(request);
        System.out.println(listRepair);
        result.put("listRepair", listRepair);
        return result;
    }

    @Override
    public JSONObject change(JSONObject request) {
        JSONObject result = new JSONObject();
        String state = resultMapper.get_state(request);
        String way = resultMapper.get_way(request);
        int s1 = Integer.parseInt(state);
        int w1 = Integer.parseInt(way);

        if (w1 == 0 && s1 == 1) {
            Random random = new Random();
            int a = random.nextInt(10);
            if (a > 5) {
                resultMapper.change_way(request);
            }
            resultMapper.change_state(request);
        } else if (s1 != 1 && w1 == 1 && s1 < 5) {
            resultMapper.change_state(request);
        } else if (s1 != 1 && w1 == 0 && s1 < 4) {
            resultMapper.change_state(request);
        }

        return null;

    }

    /*    @Override
        public JSONObject get_result(JSONObject request) {
            JSONObject result = new JSONObject();
            String state = resultMapper.get_state(request);
            String way = resultMapper.get_way(request);
            int s1 = Integer.parseInt(state);
            int w1 = Integer.parseInt(way);

            if (w1 == 0 && s1 >= 2) {
                result.put("way", "检测结果");
                String resulta = resultMapper.get_result(request);
                result.put("result", resulta);

            } else if (w1 == 1 && s1 >= 3) {
                result.put("way", "检测结果");
                String resulta = resultMapper.get_result(request);
                result.put("result", resulta);
            } else  {
                result.put("way", "请耐心等待");

                result.put("result", "辛苦");
            }
     return result;
        }*/
    @Override
    public JSONObject get_result(JSONObject request) {
        JSONObject result = new JSONObject();
        String state = resultMapper.get_state(request);
        String way = resultMapper.get_way(request);
        int s1 = Integer.parseInt(state);
        int w1 = Integer.parseInt(way);

        result.put("way", "检测结果");
        String resulta = resultMapper.get_result(request);
        result.put("result", resulta);

        return result;
    }

    @Override
    public JSONObject getAdminStatue(JSONObject request) {
        JSONObject jsonObject = new JSONObject();
        String statue = resultMapper.getState(request);
        String result = resultMapper.getResult(request);
        System.out.println("人工反馈");
        List<describe> describe = resultMapper.get_info2(request);

        jsonObject.put("statue", statue);

        System.out.println(statue);
        System.out.println(describe.size());

        int num = (int) (Integer.parseInt(statue) * 100 / describe.size());
        if (num > 100) {
            num = 100;
        }
        System.out.println(num);

        List<Repair> listRepair = repairMapper.getRepairs(request);
        System.out.println(listRepair);
        jsonObject.put("listRepair", listRepair);


        jsonObject.put("percent", num);
        jsonObject.put("describe", JSON.toJSONString(describe));
        System.out.println(JSON.toJSONString(describe));
        jsonObject.put("resultt", result);
        return jsonObject;
    }
}



