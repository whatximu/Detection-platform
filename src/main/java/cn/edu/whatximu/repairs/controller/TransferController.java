package cn.edu.whatximu.repairs.controller;

import cn.edu.whatximu.repairs.service.TransferService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping(value = "/update")
    public JSONObject updateTransfer(@RequestBody JSONObject request){
        return transferService.updateTransfer(request);
    }

}
