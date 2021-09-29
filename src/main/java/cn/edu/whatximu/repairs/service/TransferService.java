package cn.edu.whatximu.repairs.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface TransferService {

    JSONObject updateTransfer(JSONObject request);

}
