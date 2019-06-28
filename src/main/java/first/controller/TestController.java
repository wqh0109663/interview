package first.controller;

import com.jfinal.core.Controller;

/**
 * @author wqh
 * @date 18-9-30
 */
public class TestController extends Controller {
    public void index() {
        render("page/login.jsp");
    }
    public void addUser(){
    }
}