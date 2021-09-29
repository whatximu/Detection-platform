package cn.edu.whatximu.repairs.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface RootEntiretyFormService {

    /**
     * 得到Form全部内容和进度
     * @param request
     * @return
     */
    JSONObject getFormAndResult(JSONObject request);

}
