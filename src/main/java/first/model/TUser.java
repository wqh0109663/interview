package first.model;

import com.jfinal.plugin.activerecord.Model;

/**
 * @author wqh
 * @date 18-10-1
 */
public class TUser extends Model<TUser> {
    public static  TUser tUser = new TUser().dao();

    private TUser dao() {
        return new TUser();
    }

    public boolean save(int id ,String realName , Integer age,String remark) {
        TUser byId = findById(id);
        if (byId != null){
            byId.set("realName",realName).set("age",age).set("remark",remark).update();
        }
        else {
            new TUser().set("id",id).set("realName",realName).set("age",age).set("remark",remark).save();
        }
        return false;
    }
    public TUser findById(Integer id){
        return tUser.findFirst("select * " +
                "from user where id = ?",id);
    }
    public int getCountUId(){
        return find("select age from user").size();

    }

}
