package common.pojo;

public class JsonMsg {

	private String msg; // 响应信息
	private boolean success; // 操作是否成功

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

	public JsonMsg(String msg, boolean success) {
		this.msg = msg;
		this.success = success;
	}

	public JsonMsg() {
		super();
	}
}
