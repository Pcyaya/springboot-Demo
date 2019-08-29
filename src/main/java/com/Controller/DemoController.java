package com.Controller;



import com.Service.DemoService;
import com.constant.AppCode;
import com.constant.ServiceCode;
import com.entity.AppJson;
import com.entity.pagebean.UserPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {
    @Autowired
    private DemoService service;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public AppJson user(UserPageBean pageBean){
        AppJson json = new AppJson();
        String appcode = service.user(pageBean, json);
        if(AppCode.codeMap.containsKey(appcode)) {
            //原码返回
            json.setSuccess(appcode);
            if(!AppCode.SUCCESS.equals(appcode)) {
                json.setMsg(AppCode.codeMap.get(appcode));
            }
        } else if(ServiceCode.successMap.containsKey(appcode)) {
            //请求成功码
            json.setSuccess(AppCode.SUCCESS);
            json.setMsg(ServiceCode.successMap.get(appcode));
        } else if(ServiceCode.failMap.containsKey(appcode)) {
            //转码错误码
            json.setSuccess(AppCode.ERROR);
            json.setMsg(ServiceCode.failMap.get(appcode));
        }
        return json;
    }
}
