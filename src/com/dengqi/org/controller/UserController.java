package com.dengqi.org.controller;

import com.dengqi.org.model.User;
import com.jfinal.core.Controller;

public class UserController extends Controller {
		public void index(){
			renderText("’‚ «UserController");
		}
		public void jsonUser(){
			String name =getPara("name");
			renderJson(User.dao.findUser(name));
		}
}
