package com.dengqi.org.config;


import com.dengqi.org.controller.HelloController;
import com.dengqi.org.controller.LoginController;
import com.dengqi.org.controller.UserController;
import com.dengqi.org.model.User;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

public class DemoConfig extends JFinalConfig{

	@Override
	public void configConstant(Constants me) {
			me.setDevMode(true);
			me.setViewType(ViewType.JSP);
	}

	@Override
	public void configRoute(Routes me) {
			me.add("/hello",HelloController.class);
			me.add("/user",UserController.class);
			me.add("/login",LoginController.class,"/static");
	}

	@Override
	public void configPlugin(Plugins me) {
		loadPropertyFile("JFconfig.txt");
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("url"),getProperty("username"),getProperty("password"));
		me.add(c3p0Plugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user","id", User.class);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}
	/*public static void main(String[] args) {
		JFinal.start("src/main/WebContent", 8080, "/",5);
	}*/
	
}
