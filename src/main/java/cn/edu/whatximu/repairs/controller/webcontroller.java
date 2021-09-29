package cn.edu.whatximu.repairs.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author what_ximu
 * @date 2020/12/24 10:59
 */
@Controller
public class webcontroller {
    @RequestMapping("/")
    public String test(){
        return "index";
    }
}
