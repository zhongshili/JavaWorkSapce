package common.pojo;

import java.util.ArrayList;
import java.util.List;

public class JsonRs {

	private String msg; // 响应信息
	private boolean success; // 操作是否成功
	int total;// 记录数
	private List rows = new ArrayList(0);// 记录集

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

	public int gettotal() {
		return total;
	}

	public void settotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public JsonRs(String msg, boolean success, int total, List datas) {
		this.msg = msg;
		this.success = success;
		this.total = total;
		this.rows.addAll(datas);
	}

	public JsonRs() {
		super();
	}
}
