package home.advert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.HomeAdvert;
import common.util.CommonUtil;

public class HomeAdvertDAOImpl implements HomeAdvertDAO {

	private Connection conn = null;
	private PreparedStatement pst = null;

	// 定义构造方法，实例化的时候完成连接的注入
	public HomeAdvertDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	// 查询记录
	public ArrayList<HomeAdvert> select(HomeAdvert advert) throws SQLException {
		// 获取guidepage表中全部数据，并以先按position字段，后按page字段升序排序
		String sql = "select * from homeadvert where 1=1 order by position,page";
		String condition = advert.getCondition();
		String limit = advert.getLimit();
		if (condition != null && !condition.equals("")) {
//			相当于模糊匹配，查找每个中的关键字
//			如果是整数类型要用'=',并且没有%号
			String cond1 = "positon = '" + condition + "%'";
			String cond2 = "productid = '" + condition + "%'";
			String cond3 = "page = '" + condition + "'";
			sql = "select * from homeadvert where " + cond1 + " or " + cond2 + " or " + cond3 + " or " + " order by position,page";
		}
		if (limit != null && !limit.equals("")) {
			sql += limit;
		}
		pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		ArrayList<HomeAdvert> advertList = new ArrayList<HomeAdvert>();
		if (rs.next()) {
			for (int i = 0; i <= rs.getRow(); i++) {
				HomeAdvert homeAdvert = new HomeAdvert();
				String positionStr = CommonUtil.getAdvertPositionContent(rs.getInt("position"));
				homeAdvert.setId(rs.getInt("id"));
				homeAdvert.setPosition(positionStr);
				homeAdvert.setProductId(rs.getInt("productid"));
				homeAdvert.setPage(rs.getInt("page"));
				homeAdvert.setImgUrl(rs.getString("imgurl"));
				advertList.add(homeAdvert);
				rs.next();
			}
		}
		return advertList;
	}

	// 插入记录
	public boolean insert(HomeAdvert advert) throws SQLException {
		try {
			String sql = "insert into homeadvert(id,position,productid,page,imgurl) values(?,?,?,?,?) ";
			pst = conn.prepareStatement(sql);
			int position = CommonUtil.getAdvertPosition(advert.getPosition());
			pst.setInt(1, advert.getId());
			pst.setInt(2, position);
			pst.setInt(3, advert.getProductId());
			pst.setInt(4, advert.getPage());
			pst.setString(5, advert.getImgUrl());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 更新记录
	public boolean update(HomeAdvert advert) throws SQLException {
		try {
			String sql = "update homeadvert set position=?,productid=?,page=?,imgurl=? where id=?";
			pst = conn.prepareStatement(sql);
			int position = CommonUtil.getAdvertPosition(advert.getPosition());
			pst.setInt(1, position);
			pst.setInt(2, advert.getProductId());
			pst.setInt(3, advert.getPage());
			pst.setString(4, advert.getImgUrl());
			pst.setInt(5, advert.getId());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 删除记录
	public boolean delete(HomeAdvert advert) throws SQLException {
		try {
			String sql = "delete from homeadvert where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, advert.getId());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public HomeAdvert findOrderInfoById(String id) throws SQLException {
		String sql = "select * from homeadvert where id=?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		HomeAdvert homeAdvert = new HomeAdvert();
		homeAdvert.setId(rs.getInt("id"));
		String positionStr = CommonUtil.getAdvertPositionContent(rs.getInt("position"));
		homeAdvert.setPosition(positionStr);
		homeAdvert.setProductId(rs.getInt("productid"));
		homeAdvert.setPage(rs.getInt("page"));
		homeAdvert.setImgUrl(rs.getString("imgurl"));
		return homeAdvert;
	}
}
