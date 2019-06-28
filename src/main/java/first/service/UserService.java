package first.service;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Record;
import first.model.LogUser;
import first.model.TUser;
import first.model.User;

import java.sql.SQLException;

/**
 * @author wqh
 * @date 18-9-30
 */
public class UserService {
    public  synchronized boolean register (final String realName,
                                           final Integer age, final String remark,
                                           final String loginName, final String pwd)  {

        boolean bl = Db.tx(new IAtom() {
            @Override
            public boolean run() throws SQLException {

                int id = new TUser().getCountUId()+1;
                int userId = new User().getCountUserId()+1;
                Record user = new Record().set("id",id).set("realName",realName).set("age",age).set("remark",remark);
                boolean save1 = Db.save("user", "id", user);
                //int a = 1 / 0;验证两张表同事
                Record login = new Record().set("userId", userId).set("loginName", loginName).set("pwd", pwd);
                boolean save = Db.save("login_user", "userId", login);

                return save && save1;
            }
        });
        return false;
    }

    public  synchronized boolean log_reg(String addr,int userId) {
        int countLogId = new LogUser().getCountLogId()+1;
        System.out.println(countLogId);
        return new LogUser().save(""+countLogId,userId,addr);
    }


}
