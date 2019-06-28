package model;


import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * @author wqh
 * @date 18-9-30
 */
public class User extends Model<User> {
    public static  User dao = new User().dao();

    private User dao() {
        return new User();
    }
    public boolean save(int userId,String loginName , String pwd ){
        User user = findByUserId(userId);
        if (user!=null){
            user.set("userId",userId);
            user.set("loginName",loginName);
            user.set("pwd",pwd);
            return user.update();
        }
        else {
            if (StrKit.notBlank(""+userId)) {
              return   new User().set("userId",userId).set("loginName", loginName).set("pwd", pwd).save();
            }
        }
        return false;
    }

    public User findByUserId(int userId) {
        return dao.findFirst("select userId,loginName,pwd " +
                "from login_user where userId = ?",userId);
    }
    public List<User> findByNameAndPwd(String loginName, String pwd){
        return dao.find("select * from login_user where loginName= ? and pwd = ?",loginName,pwd);
    }
    public Integer getUserIdByName(String loginName){
        User user = dao().findFirst("select * from login_user where loginName= ?",loginName);
        return user.get("userId");
    }
    public int getCountUserId(){
        return find("select loginName from login_user").size();
    }

}
