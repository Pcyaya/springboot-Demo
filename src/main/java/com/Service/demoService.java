package com.Service;

import com.Dao.demoDao;
import com.constant.ServiceCode;
import com.entity.AppJson;
import com.entity.PageBean;
import com.entity.db.AcUser;
import com.entity.pagebean.UserPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class demoService {
    @Autowired
    private demoDao dao;

    public String user(UserPageBean pageBean,AppJson json) {
        String service_code = ServiceCode.ERROR;
        if (pageBean != null) {
            if(pageBean.getPhone() != null) {
                service_code = ServiceCode.SUCCESS;
                AcUser user = dao.getPhoneOneKey(pageBean.getPhone());
                json.setObj(user);
            } else {
                service_code = ServiceCode.fail_param_error;
            }
        }
        return service_code;
    }
}
