package com.dengqi.org.validator;

import com.dengqi.org.model.User;
import com.jfinal.core.Controller;
import com.jfinal.render.CaptchaRender;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);//设这短路校验 ,即只要有一个条件验证不通过就退出验证
		validateRequired("username", "nameMsg", "请输入用户名!");
		validateRequired("inputPassword", "inputPasswordMsg", "请输入密码!");
		validateRequired("randomCode", "codeMsg", "请输入验证码!");
		//validateRequiredString("randomCode", "codeMsg", "验证码不能为空!");
		String userName = c.getPara("username");
		String passWord = c.getPara("inputPassword");
		String inputRandomCode = c.getPara("randomCode");
		System.out.println(userName+passWord+inputRandomCode);
		System.out.println(CaptchaRender.validate(c, inputRandomCode.toUpperCase()));
		if (!CaptchaRender.validate(c, inputRandomCode.toUpperCase())){
			addError("errorCodeMsg", "验证码输入不正确,请重新输入!");
		}
		
		User user = User.dao.findUser(userName);
		if(user == null){
			addError("errorAcountMsg", "用户名或密码错误");
			}else if(!user.getStr("password").equals(passWord)){
				addError("errorAcountMsg", "用户名或密码错误");
			}
	}

	@Override
	protected void handleError(Controller c) {
			c.keepPara("username");
			c.keepPara("inputPassword");
			c.render("login1.jsp");
	}

}
