package home.promotion.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import common.pojo.HomePromotion;
import common.pojo.HomePromotionView;
import common.util.CommonUtil;

public class PromotionDAOImpl implements PromotionDAO {

	private Connection conn = null;
	private PreparedStatement pst = null;

	// 定义构造方法，实例化的时候完成连接的注入
	public PromotionDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	// 查询记录
	public ArrayList<HomePromotionView> select(HomePromotion promotion) throws SQLException {
		String sql = "select homepromotion.id AS id,homepromotion.position AS position,homepromotion.imgurl AS imgurl,"
				+ "homepromotion.productid AS productid,homepromotion.page AS page,homesetting.title AS title "
				+ "from (homepromotion join homesetting) where (homepromotion.position = homesetting.position) order by position,page ";
		String condition = promotion.getCondition();
		String limit = promotion.getLimit();
		if (condition != null && !condition.equals("")) {
			String cond1 = "position = '" + condition + "'";
			String cond2 = "productid = '" + condition + "'";
			String cond3 = "page = '" + condition + "'";
			sql = "select homepromotion.id AS id,homepromotion.position AS position,homepromotion.imgurl AS imgurl,"
					+ "homepromotion.productid AS productid,homepromotion.page AS page,homesetting.title AS title "
					+ "from (homepromotion join homesetting) where (homepromotion.position = homesetting.position) and (" + cond1 + " or " + cond2 + " or " + cond3 + ") order by position,page";
		}
		if (limit != null && !limit.equals("")) {
			sql += limit;
		}
		pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		ArrayList<HomePromotionView> promotionViewList = new ArrayList<HomePromotionView>();
		if (rs.next()) {
			for (int i = 0; i <= rs.getRow(); i++) {
				HomePromotionView homePromotionView = new HomePromotionView();
				homePromotionView.setId(rs.getInt("id"));
				homePromotionView.setPosition(CommonUtil.getPromotionPositionContent(rs.getInt("position")));
				homePromotionView.setProductId(rs.getInt("productid"));
				homePromotionView.setPage(rs.getInt("page"));
				homePromotionView.setTitle(rs.getString("title"));
				homePromotionView.setImgUrl(rs.getString("imgurl"));
				promotionViewList.add(homePromotionView);
				rs.next();
			}
		}
		return promotionViewList;
	}

	// 插入记录
	public boolean insert(HomePromotion promotion) throws SQLException {
		System.out.println(new Gson().toJson(promotion));
		try {
			String sql = "insert into homepromotion(id,position,page,productid,imgurl) values(?,?,?,?,?) ";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, promotion.getId());
			pst.setInt(2, CommonUtil.getPromotionPosition(promotion.getPosition()));
			pst.setInt(3, promotion.getPage());
			pst.setInt(4, promotion.getProductId());
			pst.setString(5, promotion.getImgUrl());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 更新记录
	public boolean update(HomePromotion promotion) throws SQLException {
		try {
			String sql = "update homepromotion set position=?,page=?,productid=?,imgurl=? where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, CommonUtil.getPromotionPosition(promotion.getPosition()));
			pst.setInt(2, promotion.getPage());
			pst.setInt(3, promotion.getProductId());
			pst.setString(4, promotion.getImgUrl());
			pst.setInt(5, promotion.getId());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 删除记录
	public boolean delete(HomePromotion promotion) throws SQLException {
		try {
			String sql = "delete from homepromotion where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, promotion.getId());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public HomePromotion findOrderInfoById(int id) throws SQLException {
		String sql = "select * from homepromotion where id=?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		HomePromotion homePromotion = new HomePromotion();
		homePromotion.setId(rs.getInt("id"));
		homePromotion.setPosition(CommonUtil.getPromotionPositionContent(rs.getInt("position")));
		homePromotion.setProductId(rs.getInt("productid"));
		homePromotion.setPage(rs.getInt("page"));
		homePromotion.setImgUrl(rs.getString("imgurl"));
		return homePromotion;
	}
}
