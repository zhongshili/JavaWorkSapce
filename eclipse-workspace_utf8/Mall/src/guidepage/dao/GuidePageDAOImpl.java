package guidepage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.GuidePage;

public class GuidePageDAOImpl implements GuidePageDAO {

	private Connection conn = null;
	private PreparedStatement pst = null;

	// 定义构造方法，实例化的时候完成连接的注入
	public GuidePageDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	// 查询记录
	public ArrayList<GuidePage> select(GuidePage guide) throws SQLException {
		// 获取guidepage表中全部数据，并以字段page升序排序
		String sql = "select * from guidepage where 1=1 order by page";
		String condition = guide.getCondition();
		String limit = guide.getLimit();
		if (condition != null && !condition.equals("")) {
//			相当于模糊匹配，查找每个中的关键字
			String cond1 = "adtitle like '%" + condition + "%'";
			String cond2 = "adLeft like '%" + condition + "%'";
			String cond3 = "adRight like '%" + condition + "%'";
			String cond4 = "page = '" + condition + "'";
			sql = "select * from guidepage where " + cond1 + " or " + cond2 + " or " + cond3 + " or " + cond4 + " order by page";
		}
		if (limit != null && !limit.equals("")) {
			sql += limit;
		}
		pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		ArrayList<GuidePage> guideList = new ArrayList<GuidePage>();
		if (rs.next()) {
			for (int i = 0; i <= rs.getRow(); i++) {
				GuidePage guidePage = new GuidePage();
				guidePage.setId(rs.getInt("id"));
				guidePage.setAdTitle(rs.getString("adtitle"));
				guidePage.setAdLeft(rs.getString("adleft"));
				guidePage.setAdRight(rs.getString("adright"));
				guidePage.setPage(rs.getInt("page"));
				guidePage.setImgUrl(rs.getString("imgurl"));
				guideList.add(guidePage);
				rs.next();
			}
		}
		return guideList;
	}

	// 插入记录
	public boolean insert(GuidePage guide) throws SQLException {
		try {
			String sql = "insert into guidepage(id,adtitle,adleft,adright,page,imgurl) values(?,?,?,?,?,?) ";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, guide.getId());
			pst.setString(2, guide.getAdTitle());
			pst.setString(3, guide.getAdLeft());
			pst.setString(4, guide.getAdRight());
			pst.setInt(5, guide.getPage());
			pst.setString(6, guide.getImgUrl());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 更新记录
	public boolean update(GuidePage guide) throws SQLException {
		try {
			String sql = "update guidepage set adtitle=?,adleft=?,adright=?,page=?,imgurl=? where id=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, guide.getAdTitle());
			pst.setString(2, guide.getAdLeft());
			pst.setString(3, guide.getAdRight());
			pst.setInt(4, guide.getPage());
			pst.setString(5, guide.getImgUrl());
			pst.setInt(6, guide.getId());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 删除记录
	public boolean delete(GuidePage guide) throws SQLException {
		try {
			String sql = "delete from guidepage where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, guide.getId());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public GuidePage findOrderInfoById(String id) throws SQLException {
		String sql = "select * from guidepage where id=?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		rs.next();
		GuidePage guidePage = new GuidePage();
		guidePage.setId(rs.getInt("id"));
		guidePage.setAdTitle(rs.getString("adtitle"));
		guidePage.setAdLeft(rs.getString("adleft"));
		guidePage.setAdRight(rs.getString("adright"));
		guidePage.setPage(rs.getInt("page"));
		guidePage.setImgUrl(rs.getString("imgurl"));
		return guidePage;
	}
}
