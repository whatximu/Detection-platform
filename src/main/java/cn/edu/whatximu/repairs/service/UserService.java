package cn.edu.whatximu.repairs.service;


import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whatximu
 * @since 2021-5-21
 */
@Service
public interface UserService  {
    JSONObject user_check (JSONObject request);

}
