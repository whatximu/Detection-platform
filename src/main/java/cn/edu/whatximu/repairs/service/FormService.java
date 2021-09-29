package cn.edu.whatximu.repairs.service;
import com.alibaba.fastjson.JSONObject;


import org.springframework.stereotype.Service;
/**
 * @author what_ximu
 * @date 2021/5/11 7:48
 */
@Service
public interface FormService {
    JSONObject form_insert(JSONObject request);
    JSONObject list_get(JSONObject request);

    /**
     * 获取管理者初始界面表格内容
     * @param request
     * @return
     */
    JSONObject getRootTable(JSONObject request);

    /**
     * 获取人工未反馈列表
     * @param request
     * @return
     */
    JSONObject getAdminTableFalse(JSONObject request);

    /**
     * 获取人工已经反馈列表
     * @param request
     * @return
     */
    JSONObject getAdminTableTrue(JSONObject request);

    /**
     * 获取指定ID的表单
     * @param request
     * @return
     */
    JSONObject getAdminForm(JSONObject request);

    JSONObject getrepairTable(JSONObject request);

    JSONObject addRepair(JSONObject request);
}
