package first.model;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Model;

import java.util.Date;

/**
 * @author wqh
 * @date 18-10-1
 */
public class LogUser extends Model<LogUser> {
    public static LogUser loguser = new LogUser().dao();

    private LogUser dao() {
        return new LogUser();
    }

    public boolean save(String logId, Integer userId, String addr) {
        LogUser user = findByUserId(userId);
        if (StrKit.notBlank(logId)) {
            return new LogUser().set("logId", logId).set("userId", userId).set("regIp", addr).set("regTime", new Date()).save();
        }

        return false;
    }

    private LogUser findByUserId(Integer userId) {
        return loguser.findFirst("select * from reg_log where userId = ?", userId);
    }

    public int getCountLogId() {
        return find("select userId from  reg_log").size();
    }

}
