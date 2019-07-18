package common.pojo;

public class GuidePage extends Base {
	private int id;
	private String adTitle;
	private String adLeft;
	private String adRight;
	private int page;
	private String imgUrl;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdTitle() {
		return adTitle;
	}
	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}
	public String getAdLeft() {
		return adLeft;
	}
	public void setAdLeft(String adLeft) {
		this.adLeft = adLeft;
	}
	public String getAdRight() {
		return adRight;
	}
	public void setAdRight(String adRight) {
		this.adRight = adRight;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
