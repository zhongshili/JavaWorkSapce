package common.pojo;

import common.pojo.Base;

public class UserCart extends Base{
	String userName;
	int productId;
	int productCounts;
	
 

public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public int getProductId() {
		return productId;
	}



	public void setProductId(int productId) {
		this.productId = productId;
	}



	public int getProductCounts() {
		return productCounts;
	}



	public void setProductCounts(int productCounts) {
		this.productCounts = productCounts;
	}



public UserCart() {
    super();
  }

}
