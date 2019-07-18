package common.pojo;


public class JsonMobileUser {

	private String msg; // 响应信息
	private boolean success; // 操作是否成功
	private User user = new User();// 单个用户数据

	public String getMsg() {
		return msg;
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

	public User getUser() {
		return user;
	}

	public void setHeadAdverts(User user) {
		this.user = user;
	}
	
	public JsonMobileUser(String msg, boolean success, User user) {
		this.msg = msg;
		this.success = success;
		this.user=user;
	}

	public JsonMobileUser() {
		super();
	}
}
