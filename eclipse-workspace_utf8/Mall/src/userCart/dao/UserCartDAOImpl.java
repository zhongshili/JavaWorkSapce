package userCart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.UserCart;

public class UserCartDAOImpl implements UserCartDAO {

	private Connection conn = null;
	private PreparedStatement pst = null;

	// 定义构造方法，实例化的时候完成连接的注入
	public UserCartDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	// 查询记录
		public ArrayList<UserCart> select(UserCart userCart) throws SQLException {
			// 获取User表中全部数据，并以字段page升序排序
			String sql = "select * from usercart where username=?";
			String condition = userCart.getCondition();
			String limit = userCart.getLimit();
			
			if (limit != null && !limit.equals("")) {
				sql += limit;
			}
			pst = conn.prepareStatement(sql);
			pst.setString(1, userCart.getUserName());
			ResultSet rs = pst.executeQuery();
			ArrayList<UserCart> userCartList = new ArrayList<UserCart>();
			if (rs.next()) {
				for (int i = 0; i <= rs.getRow(); i++) {
					UserCart newUserCart = new UserCart();
					newUserCart.setProductId(rs.getInt("productid"));
					newUserCart.setProductCounts(rs.getInt("productcounts"));
					rs.next();
					userCartList.add(newUserCart);
				}
			}
			return userCartList;
		}

	// 插入记录
	public boolean insert(UserCart userCart) throws SQLException {
		try {
			String sql = "insert into usercart(productid,username,productcounts) values(?,?,?) ";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userCart.getProductId());
			pst.setString(2, userCart.getUserName());
			pst.setInt(3, userCart.getProductCounts());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 更新记录
	public boolean update(UserCart userCart) throws SQLException {
		try {
			String sql = "update usercart set productcounts=? where productid=? and username=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userCart.getProductCounts());
			pst.setInt(2, userCart.getProductId());
			pst.setString(3, userCart.getUserName());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 删除记录
	public boolean delete(UserCart userCart) throws SQLException {
		try {
			String sql = "delete from usercart where productId=? and username=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, userCart.getProductId());
			pst.setString(2, userCart.getUserName());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public UserCart findOrderInfoByUserCart(UserCart userCart) throws SQLException {
		String sql = "select * from userCart where username=?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, userCart.getUserName());
		ResultSet rs = pst.executeQuery();
		rs.next();
		userCart.setProductId(rs.getInt("productid"));
		userCart.setProductCounts(rs.getInt("productcounts"));
		return userCart;
	}
}
