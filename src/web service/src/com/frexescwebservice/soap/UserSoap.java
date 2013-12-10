package com.frexescwebservice.soap;

import com.frexescwebservice.model.UserBean;

public class UserSoap {
	public void register(String username, String password,
			String email, String name, String telephone, String address,
			String province, String city, String postal) {
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setName(name);
		user.setTelephone(telephone);
		user.setAddress(address);
		user.setProvince(province);
		user.setCity(city);
		user.setPostal(postal);
		user.save();
	}
}
