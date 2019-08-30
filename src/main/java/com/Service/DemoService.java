package com.Service;

import com.Dao.DemoDao;
import com.constant.ServiceCode;
import com.entity.AppJson;
import com.entity.db.AcUser;
import com.entity.form.UserForm;
import com.entity.page.UserPage;
import com.entity.pagebean.UserPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {
    @Autowired
    private DemoDao demoDao;

    public String userlist(UserForm pageBean, AppJson json) {
        String service_code = ServiceCode.ERROR;
        if (pageBean != null) {
            if(pageBean.getPhone() != null) {
                service_code = ServiceCode.SUCCESS;
                List<AcUser> list = demoDao.getUserList();
                if(list != null && list.size() > 0) {
                    List<UserPage> items = new ArrayList<>();
                    for (AcUser item : list) {
                        UserPage page = new UserPage();
                        page.setId(item.getAu_id());
                        page.setNum(item.getAu_no());
                        page.setName(item.getAu_name());
                        page.setPhone(item.getAu_phone());
                        page.setPwd(item.getAu_pwd());
                        page.setSex(item.getAu_sex());
                        page.setEmail(item.getAu_email());
                        page.setPosition(item.getAu_position());
                        page.setUpdate_date(item.getUpdate_date());
                        page.setCreate_date(item.getCreate_date());
                        items.add(page);
                    }
                    pageBean.setData(items);
                    json.setObj(pageBean);
                }
            } else {
                service_code = ServiceCode.fail_param_error;
            }
        }
        return service_code;
    }
}
