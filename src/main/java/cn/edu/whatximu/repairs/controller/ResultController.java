package cn.edu.whatximu.repairs.controller;
import cn.edu.whatximu.repairs.service.ResultService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author what_ximu
 * @date 2020/12/25 19:43
 */

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public JSONObject get_state (@RequestBody JSONObject request) {
        System.out.println("得到进度信息");
        return resultService.get_state(request);


    }
    @RequestMapping(value = "/change", method = RequestMethod.POST)
    public JSONObject change (@RequestBody JSONObject request) {


        return resultService.change(request);

    }

    @RequestMapping(value = "/get_result", method = RequestMethod.POST)
    public JSONObject get_result (@RequestBody JSONObject request) {
        return resultService.get_result(request);
    }


    @RequestMapping(value = "/getAdminResult", method = RequestMethod.POST)
    public JSONObject getAdminResult(@RequestBody JSONObject requset) {
        return resultService.getAdminStatue(requset);
    }



}
