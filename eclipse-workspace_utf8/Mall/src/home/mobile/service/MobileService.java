package home.mobile.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.HomeAdvert;
import common.pojo.HomePromotion;
import common.pojo.HomePromotionView;
import common.pojo.JsonMobile;
import common.util.DButil;
import home.advert.dao.AdvertDAOImpl;
import home.promotion.dao.PromotionDAOImpl;

public class MobileService {

	/* 查询业务 */
	public JsonMobile selectAll() {
		Connection conn = DButil.getConnection();
		PromotionDAOImpl promotionDAO = new PromotionDAOImpl(conn);
		AdvertDAOImpl advertDAO = new AdvertDAOImpl(conn);
		try {
			// 1. 分别取出广告表和推荐的数据集
			ArrayList<HomePromotionView> promotionViewList = new ArrayList<HomePromotionView>();
			ArrayList<HomeAdvert> homeAdvertList = new ArrayList<HomeAdvert>();
			HomePromotion promotion = new HomePromotion();
			HomeAdvert advert = new HomeAdvert();
			promotion.setCondition("");
			advert.setCondition("");
			promotionViewList = promotionDAO.select(promotion);// 返回推荐表数据集
			homeAdvertList = advertDAO.select(advert);// 返回广告表数据集
			conn.commit();

			// 对两张表的数据重新封装发给APP端
			ArrayList<HomeAdvert> headAdvertList = new ArrayList<HomeAdvert>();
			ArrayList<HomeAdvert> firstAdvertList = new ArrayList<HomeAdvert>();
			ArrayList<HomeAdvert> secondAdvertList = new ArrayList<HomeAdvert>();
			for (HomeAdvert homeAdvert : homeAdvertList) {
				if (homeAdvert.getPosition() == "头部轮播区") {
					headAdvertList.add(homeAdvert);
				} else if (homeAdvert.getPosition() == "广告轮播1区") {
					firstAdvertList.add(homeAdvert);
				} else if (homeAdvert.getPosition() == "广告轮播2区") {
					secondAdvertList.add(homeAdvert);
				}
			}

			ArrayList<HomePromotionView> seckills = new ArrayList<HomePromotionView>();
			ArrayList<HomePromotionView> firstPromotions = new ArrayList<HomePromotionView>();
			ArrayList<HomePromotionView> secondPromotions = new ArrayList<HomePromotionView>();
			for (HomePromotionView homePromotionVeiw : promotionViewList) {
				if (homePromotionVeiw.getPosition() == "秒杀区") {
					seckills.add(homePromotionVeiw);
				} else if (homePromotionVeiw.getPosition() == "活动推广1区") {
					firstPromotions.add(homePromotionVeiw);
				} else if (homePromotionVeiw.getPosition() == "活动推广2区") {
					secondPromotions.add(homePromotionVeiw);
				}
			}
			return new JsonMobile("查询成功", true, headAdvertList, firstAdvertList, secondAdvertList, seckills,
					firstPromotions, secondPromotions);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return new JsonMobile("查询失败", false, null,null,null,null,null,null);
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}
}