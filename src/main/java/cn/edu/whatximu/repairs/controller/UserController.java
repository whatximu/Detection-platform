package cn.edu.whatximu.repairs.controller;



import cn.edu.whatximu.repairs.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/UNDO")

public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/user_check", method = RequestMethod.POST)
    public JSONObject user_check(@RequestBody JSONObject request) {
        System.out.println(request.toString());
//        System.out.println(request);
        JSONObject jsonObject = userService.user_check(request);
        return jsonObject;
    }





}

