package cn.edu.whatximu.repairs.controller;

import cn.edu.whatximu.repairs.service.RootEntiretyFormService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farc")
public class FormAndResultController {

    @Autowired
    private RootEntiretyFormService service;

    @RequestMapping(value = "/getFarc", method = RequestMethod.POST)
    public JSONObject getFormAndResultController(@RequestBody JSONObject request){
        System.out.println(request.get("id"));
        return service.getFormAndResult(request);
    }

}
