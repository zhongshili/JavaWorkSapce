package common.pojo;

import java.util.ArrayList;
import java.util.List;

public class JsonMobileUserCart {

	private String msg; // 响应信息
	private boolean success; // 操作是否成功
	private int total;
	private List commodityList = new ArrayList(0);// 广告轮播数据集

	public String getMsg() {
		return msg;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	public List getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(List commodityList) {
		this.commodityList = commodityList;
	}


	
	public JsonMobileUserCart(String msg, boolean success, int total,List commodityList) {
		super();
		this.msg = msg;
		this.success = success;
		this.total = total;
		this.commodityList = commodityList;
	}

	public JsonMobileUserCart() {
		super();
	}
}
