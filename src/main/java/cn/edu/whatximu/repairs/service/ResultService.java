package cn.edu.whatximu.repairs.service;

import com.alibaba.fastjson.JSONObject;

import org.springframework.stereotype.Service;


@Service
public interface ResultService {
    /**
     * 获取状态 根据 id （demo）  后续根据 id及订单id
     * @param request
     * @return
     */
    JSONObject get_state(JSONObject request);

    /**
     * demo用,定时修改状态
     * @param request
     * @return
     */
    JSONObject change(JSONObject request);

    /**
     *
     * @param request
     * @return
     */
    JSONObject get_result(JSONObject request);

    /**
     * 根据ID获取处理进度
     * @param request
     * @return
     */
    JSONObject getAdminStatue(JSONObject request);

}
