package com.frexescwebservice.soap;

import com.frexescwebservice.model.BarangUserBean;

public class BarangUserSoap {
	public void addCart(long id_item, long id_user, int total_item,
			String description) {
		BarangUserBean barangUser = new BarangUserBean();
		barangUser.setId_item(id_item);
		barangUser.setId_user(id_user);
		barangUser.setStatus(0);
		barangUser.setTotal_item(total_item);
		barangUser.setDescription(description);
		barangUser.save();
	}
}
