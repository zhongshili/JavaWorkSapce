package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.User;

public class UserDAOImpl implements UserDAO {

	private Connection conn = null;
	private PreparedStatement pst = null;

	// 定义构造方法，实例化的时候完成连接的注入
	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	// 查询记录
	public ArrayList<User> select(User user) throws SQLException {
		// 获取User表中全部数据，并以字段page升序排序
		String sql = "select * from user where 1=1";
		String condition = user.getCondition();
		String limit = user.getLimit();
		if (condition != null && !condition.equals("")) {
//			相当于模糊匹配，查找每个中的关键字
			String cond1 = "username like '%" + condition + "%'";
			String cond2 = "name like '%" + condition + "%'";
			sql = "select * from User where " + cond1 + " or " + cond2;
		}
		if (limit != null && !limit.equals("")) {
			sql += limit;
		}
		pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		ArrayList<User> userList = new ArrayList<User>();
		if (rs.next()) {
			for (int i = 0; i <= rs.getRow(); i++) {
				User newUser = new User();
				newUser.setAddress(rs.getString("address"));
				newUser.setAge(rs.getInt("age"));
				newUser.setName(rs.getString("name"));
				newUser.setPassword(rs.getString("password"));
				newUser.setUserName(rs.getString("username"));
				newUser.setUserImg(rs.getString("userimg"));
				newUser.setPhone(rs.getString("phone"));
				newUser.setSex(rs.getString("sex"));
				userList.add(newUser);
				rs.next();
			}
		}
		return userList;
	}

	// 插入记录
	public boolean insert(User user) throws SQLException {
		try {
			String sql = "insert into user(username,name,password,sex,age,phone,address,userimg) values(?,?,?,?,?,?,?,?) ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getName());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getSex());
			pst.setInt(5, user.getAge());
			pst.setString(6, user.getPhone());
			pst.setString(7, user.getAddress());
			pst.setString(8, user.getUserImg());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 更新记录
	public boolean update(User user) throws SQLException {
		try {
			String sql = "update user set phone=?,address=? where username=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getPhone());
			pst.setString(2, user.getAddress());
			pst.setString(3, user.getUserName());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 删除记录
	public boolean delete(User user) throws SQLException {
		try {
			String sql = "delete from user where username=?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUserName());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public User findOrderInfoById(User oldUser) throws SQLException {
		String sql = "select * from user where phone=? and password=?";
		pst = conn.prepareStatement(sql);
		pst.setString(1, oldUser.getPhone());
		pst.setString(2, oldUser.getPassword());
		ResultSet rs = pst.executeQuery();
		rs.next();
		User user = new User();
		user.setAddress(rs.getString("address"));
		user.setAge(rs.getInt("age"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setUserName(rs.getString("username"));
		user.setUserImg(rs.getString("userimg"));
		user.setPhone(rs.getString("phone"));
		user.setSex(rs.getString("sex"));
		return user;
	}
}
