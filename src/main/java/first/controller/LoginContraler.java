package first.controller;

import com.jfinal.core.Controller;
import first.model.User;

import java.util.List;

/**
 * @author wqh
 * @date 18-9-30
 */
public class LoginContraler extends Controller {
    public void index() {
        List<User> users = User.dao.findByNameAndPwd(getPara("loginName"), getPara("pwd"));
        if (users.size() > 0) {
            setSessionAttr("userInfo", users.get(0));
            render("page/index.jsp");
        } else {
            render("page/login.jsp");
        }

    }

}