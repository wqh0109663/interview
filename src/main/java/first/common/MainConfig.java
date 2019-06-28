package first.common;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import first.controller.LoginContraler;
import first.controller.RegisterController;
import first.controller.TestController;
import first.model.LogUser;
import first.model.TUser;
import first.model.User;

/**
 * @author wqh
 * @date 18-9-30
 */
public class MainConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        me.setViewType(ViewType.JSP);
        me.setDevMode(true);
    }
    @Override
    public void configRoute(Routes me) {
        me.add("/", TestController.class);
        me.add("/login", LoginContraler.class);
        me.add("/register", RegisterController.class);
    }
    @Override
    public void configInterceptor(Interceptors me) {
    }
    @Override
    public void configHandler(Handlers me) {
    }
    @Override
    public void configPlugin(Plugins me) {
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://nierjia.com:3306/mianshi?characterEncoding=utf8&useSSL=false&useUnicode=true", "mianshi", "mianshi");
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(arp);
        arp.addMapping("login_user","userId", User.class);
        arp.addMapping("user", "id",TUser.class);
        arp.addMapping("reg_log","logId", LogUser.class);
    }
}
