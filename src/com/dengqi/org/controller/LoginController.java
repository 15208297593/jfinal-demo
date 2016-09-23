package com.dengqi.org.controller;

import com.dengqi.org.model.User;
import com.dengqi.org.validator.LoginValidator;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.render.CaptchaRender;

public class LoginController extends Controller {
		public void index(){
			render("login1.jsp");
		}
		//用@Before进行登陆校验
		@SuppressWarnings("unused")
		@Clear
		@Before(LoginValidator.class)
		public void login(){
			String userName = getPara("username");
			String passWord = getPara("inputPassword");
			//String randomCode = getPara("randomCode");  
			//System.out.println(userName +"****"+passWord+"***"+randomCode);
			//boolean checkCode = CaptchaRender.validate(this, randomCode.toUpperCase());  
			//System.out.println(checkCode);
			User user = User.dao.findUser(userName);
			renderText(user.toJson());
			render("error404.html");
		}
		public void img(){
			CaptchaRender img = new CaptchaRender();
			render(img);
		}
		
		
		
}
