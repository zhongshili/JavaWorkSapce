package home.advert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.HomeAdvert;
import common.util.CommonUtil;

public class AdvertDAOImpl implements AdvertDAO {

	private Connection conn = null;
	private PreparedStatement pst = null;

	// 定义构造方法，实例化的时候完成连接的注入
	public AdvertDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	// 查询记录
	public ArrayList<HomeAdvert> select(HomeAdvert advert) throws SQLException {
		// 获取HomeAdvert表中全部数据，并以字段page升序排序
		String sql = "select * from homeadvert where 1=1 order by position,page";
		String condition = advert.getCondition();
		String limit = advert.getLimit();
		if (condition != null && !condition.equals("")) {
			String cond1 = "position = '" + condition + "'";
			String cond2 = "productid = '" + condition + "'";
			String cond3 = "page = '" + condition + "'";
			sql = "select * from homeadvert where " + cond1 + " or " + cond2 + " or " + cond3 + " order by position,page";
		}
		if (limit != null && !limit.equals("")) {
			sql += limit;
		}
		pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		ArrayList<HomeAdvert> advertList = new ArrayList<HomeAdvert>();
		if (rs.next()) {
			for (int i = 0; i <= rs.getRow(); i++) {
				HomeAdvert HomeAdvert = new HomeAdvert();
				HomeAdvert.setId(rs.getInt("id"));
				HomeAdvert.setPosition(CommonUtil.getAdvertPositionContent(rs.getInt("position")));
				HomeAdvert.setPage(rs.getInt("page"));
				HomeAdvert.setProductId(rs.getInt("productid"));
				HomeAdvert.setImgUrl(rs.getString("imgurl"));
				advertList.add(HomeAdvert);
				rs.next();
			}
		}
		return advertList;
	}

	// 插入记录
	public boolean insert(HomeAdvert advert) throws SQLException {
		try {
			String sql = "insert into homeadvert(id,position,page,productid,imgurl) values(?,?,?,?,?) ";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, advert.getId());
			pst.setInt(2, CommonUtil.getAdvertPosition(advert.getPosition()));
			pst.setInt(3, advert.getPage());
			pst.setInt(4, advert.getProductId());
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
			String sql = "update homeadvert set position=?,page=?,productid=?,imgurl=? where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, CommonUtil.getAdvertPosition(advert.getPosition()));
			pst.setInt(2, advert.getPage());
			pst.setInt(3, advert.getProductId());
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

	public HomeAdvert findOrderInfoById(int id) throws SQLException {
		String sql = "select * from homeadvert where id=?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		HomeAdvert HomeAdvert = new HomeAdvert();
		HomeAdvert.setId(rs.getInt("id"));
		HomeAdvert.setPosition(CommonUtil.getAdvertPositionContent(rs.getInt("position")));
		HomeAdvert.setPage(rs.getInt("page"));
		HomeAdvert.setProductId(rs.getInt("productid"));
		HomeAdvert.setImgUrl(rs.getString("imgurl"));
		return HomeAdvert;
	}
}
