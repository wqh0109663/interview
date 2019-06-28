package first.controller;

import com.jfinal.core.Controller;
import first.model.User;
import first.service.UserService;

/**
 * @author wqh
 * @date 18-9-30
 */
public class RegisterController extends Controller {
    public void index() {
        String loginName = getPara("loginName");
        String realName = getPara("realName");
        Integer age = getParaToInt("age");
        String remark = getPara("remark");
        String pwd = getPara("pwd");
        String addr = getPara("addr");
        boolean register = false;
        try {
            register = new UserService().register(realName, age, remark, loginName, pwd);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            int userId = 0;
            System.out.println(new User().getCountUserId());
            if (register) {
                userId = new User().getCountUserId();
            } else {
                userId = new User().getCountUserId() + 1;
            }
            new UserService().log_reg(addr, userId);
            render("page/login.jsp");

        }
    }
}
