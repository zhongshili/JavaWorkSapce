package common.pojo;


public class JsonMobileCommodity {

	private String msg; // 响应信息
	private boolean success; // 操作是否成功
	private Commodity commodity = new Commodity();// 单个用户数据

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

	public Commodity getCommodity() {
		return commodity;
	}

	public void setHeadAdverts(Commodity commodity) {
		this.commodity = commodity;
	}
	
	public JsonMobileCommodity(String msg, boolean success, Commodity commodity) {
		this.msg = msg;
		this.success = success;
		this.commodity=commodity;
	}

	public JsonMobileCommodity() {
		super();
	}
}
