package common.pojo;

import common.pojo.Base;

public class User extends Base{
	int id;
	String userName;
	String name;
	String password;
	String sex;
	int age;
	float wealthy;
	String phone;
	String address;
	String userImg;
  
  public String getUserImg() {
		return userImg;
	}


	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}


public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public float getWealthy() {
		return wealthy;
	}


	public void setWealthy(float wealthy) {
		this.wealthy = wealthy;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


public User() {
    super();
  }

}
