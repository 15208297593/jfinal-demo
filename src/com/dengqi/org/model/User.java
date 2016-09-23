package com.dengqi.org.model;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings({ "serial" })
public class User extends Model<User> {
	public static final User dao = new User();
	
	public User findUser(String name){
		String sql = "SELECT * from user WHERE name = ?";
		return findFirst(sql,name);
	}
}
