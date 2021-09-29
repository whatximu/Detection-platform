package cn.edu.whatximu.repairs.service.impl;
import cn.edu.whatximu.repairs.dao.UserMapper;
import cn.edu.whatximu.repairs.pojo.CarUser;
import cn.edu.whatximu.repairs.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public JSONObject user_check(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            String user=userMapper.user_check(request);
            CarUser carUser=userMapper.getname(request);
            if(user.equals("1")) {
                result.put("code", "1");
                result.put("msg", "操作成功！");
                result.put("data", carUser.getUsername());
                result.put("identity", carUser.getIdentity());
            }else{
                result.put("code", "0");
                result.put("msg", "操作失败！");

            }
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "查询异常！");
        }
        return result;

    }


}
