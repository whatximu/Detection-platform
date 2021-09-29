package cn.edu.whatximu.repairs.controller;

import cn.edu.whatximu.repairs.service.FormService;
import com.alibaba.fastjson.JSONObject;
import com.power.common.util.RandomUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * @author UNDO_XPra  and  What_Ximu
 * @date 2021/5/11 7:47
 */
@RestController
@RequestMapping("/form")
public class FormController {
    @Autowired
    private FormService formService;

    /**
     * form_insert
     * @param request
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public JSONObject updateGood(@RequestBody JSONObject request) {

        String id=(String) RandomUtil.randomNumbers(9);
        request.put("id",id);
        System.out.println(request);
        return formService.form_insert(request);



    }



    /**
     *
     * @param file
     * @param SavePath
     * @return
     * @throws IllegalStateException
     */

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String savaVideotest(@RequestParam("file") MultipartFile file, @RequestParam String SavePath)
            throws IllegalStateException {
        Map<String,String> resultMap = new HashMap<>();
        try{
            //获取文件后缀，因此此后端代码可接收一切文件，上传格式前端限定
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1)
                    .toLowerCase();
            // 重构文件名称
            System.out.println("前端传递的保存路径："+SavePath);
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            System.out.println("重构文件名防止上传同名文件："+newVidoeName);
            //保存视频
            File fileSave = new File(SavePath, newVidoeName);
            file.transferTo(fileSave);
            //构造Map将视频信息返回给前端
            //视频名称重构后的名称
            resultMap.put("newVidoeName",newVidoeName);
            //正确保存视频则设置返回码为200
            resultMap.put("resCode","200");
            //返回视频保存路径
            String a=SavePath + "/" + newVidoeName;
            resultMap.put("VideoUrl",SavePath + "/" + newVidoeName+"/"+newVidoeName);
            return  a;

        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            //保存视频错误则设置返回码为400
            resultMap.put("resCode","400");
            return  "400";

        }
    }




    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public JSONObject list(@RequestBody JSONObject request) {
        return formService.list_get(request);
    }

    @RequestMapping(value = "/rootList", method = RequestMethod.POST)
    public JSONObject rootList(@RequestBody JSONObject jsonObject){
        return formService.getRootTable(jsonObject);
    }

    @RequestMapping(value = "/adminListFalse", method = RequestMethod.POST)
    public JSONObject adminListFalse(@RequestBody JSONObject jsonObject) {
        return formService.getAdminTableFalse(jsonObject);
    }

    @RequestMapping(value = "/adminListTrue", method = RequestMethod.POST)
    public JSONObject adminListTrue(@RequestBody JSONObject jsonObject) {
        System.out.println("-----------------------------------------");
        return formService.getAdminTableTrue(jsonObject);
    }

    @RequestMapping(value = "/adminForm", method = RequestMethod.POST)
    public JSONObject adminForm(@RequestBody JSONObject request){
        return formService.getAdminForm(request);
    }

    @RequestMapping("/downloadFile")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String path = request.getParameter("path");
        System.out.println(path);
        // 读到流中
        InputStream inputStream = new FileInputStream(path);// 文件的存放路径
        response.reset();
        response.setContentType("application/octet-stream");
        String filename = new File(path).getName();
        response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        //从输入流中读取一定数量的字节，并将其存储在缓冲区字节数组中，读到末尾返回-1
        while ((len = inputStream.read(b)) > 0) {
            outputStream.write(b, 0, len);
        }
        inputStream.close();
    }

    @RequestMapping(value = "fileupdata", method = RequestMethod.POST)
    public JSONObject fileUpdata(@RequestBody JSONObject request){
        JSONObject jsonObject = new JSONObject();
        System.out.println(request.get("fileList"));
        Random random = new Random();
        int a = random.nextInt(39);
        String axa=Integer.toString(a);
        jsonObject.put("abnormalx", axa);
        return jsonObject;
    }

    @RequestMapping(value = "/repairList", method = RequestMethod.POST)
    public JSONObject repairList(@RequestBody JSONObject request) {
        return formService.getrepairTable(request);
    }

    @RequestMapping(value = "/addRepair", method=RequestMethod.POST)
    public JSONObject addRepair(@RequestBody JSONObject request){
        return formService.addRepair(request);
    }

}
