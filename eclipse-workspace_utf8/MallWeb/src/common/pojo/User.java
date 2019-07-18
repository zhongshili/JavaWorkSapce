package common.pojo;

import common.pojo.Base;

public class User extends Base{
	int id;
	String name;
	String password;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
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

  public String toString() {
    return "User [id=" + id + ", Name=" + name + ", Password=" + password
        + "]";
  }
  
  public User(int id, String name, String password) {
    super();
    this.id = id;
    this.name = name;
    this.password = password;
  }
  
  public User() {
    super();
  }

}
