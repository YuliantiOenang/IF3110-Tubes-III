package com.frexesc.model;

public class UserBean {
	private int id;
	private String username;
	private String password;
	private String email;
	private String name;
	private String telephone;
	private String address;
	private String province;
	private String city;
	private String postal;
	private int role;
	private String nocard;
	private String nacard;
	private String excard;
	private int transaction;

	public UserBean() {
		this.id = 0;
		this.username = null;
		this.password = null;
		this.email = null;
		this.name = null;
		this.telephone = null;
		this.address = null;
		this.province = null;
		this.city = null;
		this.postal = null;
		this.role = 0;
		this.nocard = null;
		this.nacard = null;
		this.excard = null;
		this.transaction = 0;
	}

	public UserBean(int id, String username, String password, String email,
			String name, String telephone, String address, String province,
			String city, String postal, int role, String nocard, String nacard,
			String excard, int transaction) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.telephone = telephone;
		this.address = address;
		this.province = province;
		this.city = city;
		this.postal = postal;
		this.role = role;
		this.nocard = nocard;
		this.nacard = nacard;
		this.excard = excard;
		this.transaction = transaction;
	}
	
	public UserBean(String username, String password, String email,
			String name, String telephone, String address, String province,
			String city, String postal, int role, String nocard, String nacard,
			String excard, int transaction) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.telephone = telephone;
		this.address = address;
		this.province = province;
		this.city = city;
		this.postal = postal;
		this.role = role;
		this.nocard = nocard;
		this.nacard = nacard;
		this.excard = excard;
		this.transaction = transaction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getNocard() {
		return nocard;
	}

	public void setNocard(String nocard) {
		this.nocard = nocard;
	}

	public String getNacard() {
		return nacard;
	}

	public void setNacard(String nacard) {
		this.nacard = nacard;
	}

	public String getExcard() {
		return excard;
	}

	public void setExcard(String excard) {
		this.excard = excard;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public int getTransaction() {
		return transaction;
	}

	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}

}
