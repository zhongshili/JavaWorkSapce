package common.util;

public class CommonUtil {

	public static String getAdvertPositionContent(int position) {
		String positionContent = null;
		switch (position) {
		case 0:
			positionContent = "头部轮播区";
			break;
		case 1:
			positionContent = "广告轮播1区";
			break;
		case 2:
			positionContent = "广告轮播2区";
			break;
		}
		return positionContent;
	}
	
	public static int getAdvertPosition(String positionContent) {
		int position = 0;
		switch (positionContent) {
		case "头部轮播区":
			position = 0;
			break;
		case "广告轮播1区":
			position = 1;
			break;
		case "广告轮播2区":
			position = 2;
			break;
		}
		return position;
	}
	public static String getPromotionPositionContent(int position) {
		String positionContent = null;
		switch (position) {
		case 0:
			positionContent = "秒杀区";
			break;
		case 1:
			positionContent = "活动推广1区";
			break;
		case 2:
			positionContent = "活动推广2区";
			break;
		}
		return positionContent;
	}
	
	public static int getPromotionPosition(String positionContent) {
		int position = 0;
		switch (positionContent) {
		case "秒杀区":
			position = 0;
			break;
		case "活动推广1区":
			position = 1;
			break;
		case "活动推广2区":
			position = 2;
			break;
		}
		return position;
	}
}
