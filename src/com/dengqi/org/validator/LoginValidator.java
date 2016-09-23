package com.dengqi.org.validator;

import com.dengqi.org.model.User;
import com.jfinal.core.Controller;
import com.jfinal.render.CaptchaRender;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);//�����·У�� ,��ֻҪ��һ��������֤��ͨ�����˳���֤
		validateRequired("username", "nameMsg", "�������û���!");
		validateRequired("inputPassword", "inputPasswordMsg", "����������!");
		validateRequired("randomCode", "codeMsg", "��������֤��!");
		//validateRequiredString("randomCode", "codeMsg", "��֤�벻��Ϊ��!");
		String userName = c.getPara("username");
		String passWord = c.getPara("inputPassword");
		String inputRandomCode = c.getPara("randomCode");
		System.out.println(userName+passWord+inputRandomCode);
		System.out.println(CaptchaRender.validate(c, inputRandomCode.toUpperCase()));
		if (!CaptchaRender.validate(c, inputRandomCode.toUpperCase())){
			addError("errorCodeMsg", "��֤�����벻��ȷ,����������!");
		}
		
		User user = User.dao.findUser(userName);
		if(user == null){
			addError("errorAcountMsg", "�û������������");
			}else if(!user.getStr("password").equals(passWord)){
				addError("errorAcountMsg", "�û������������");
			}
	}

	@Override
	protected void handleError(Controller c) {
			c.keepPara("username");
			c.keepPara("inputPassword");
			c.render("login1.jsp");
	}

}
