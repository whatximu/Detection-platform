package cn.edu.whatximu.repairs.service.impl;

import cn.edu.whatximu.repairs.dao.TransferMapper;
import cn.edu.whatximu.repairs.service.TransferService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferMapper transferMapper;

    @Override
    public JSONObject updateTransfer(JSONObject request) {
        System.out.println(request.toString());
        transferMapper.updataTransfer(request);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", request.get("id"));
        return jsonObject;
    }
}
