package userCart.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import commodity.dao.CommodityDAOImpl;
import common.pojo.UserCart;
import common.pojo.Commodity;
import common.pojo.JsonMobileUserCart;
import common.pojo.JsonMsg;
import common.util.DButil;
import userCart.dao.UserCartDAOImpl;

public class UserCartServiceImpl implements UserCartService {

	/* 查询业务 */
	public JsonMobileUserCart selectByUserCart(UserCart oldUserCart) {
		Connection conn = DButil.getConnection();
		UserCartDAOImpl userCartDAO = new UserCartDAOImpl(conn);
		CommodityDAOImpl commoditytDAO = new CommodityDAOImpl(conn);
		ArrayList<Commodity> commodityList = new ArrayList<Commodity>();
		try {
			ArrayList<UserCart> userCartList = new ArrayList<UserCart>();
			userCartList = userCartDAO.select(oldUserCart);// 返回记录集
			for(UserCart userCart:userCartList) {
				Commodity commodity = new Commodity();
				commodity.setProductId(userCart.getProductId());
				commodity=commoditytDAO.findOrderInfoById(commodity);
				commodity.setProductConuts(userCart.getProductCounts());
				commodityList.add(commodity);
			}
			conn.commit();
//			自动封装成json数据格式
			return new JsonMobileUserCart("查询成功", true,commodityList.size(), commodityList);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return new JsonMobileUserCart("查询失败", false,0,null);
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}

	/* 添加业务 */
	public JsonMsg insert(UserCart userCart) {
		Connection conn = DButil.getConnection();
		UserCartDAOImpl userCartDAO = new UserCartDAOImpl(conn);
		try {
			userCartDAO.insert(userCart);
			conn.commit();
			return new JsonMsg("添加成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return new JsonMsg("添加失败", false);
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}

	/* 更新业务 */
	public JsonMsg update(UserCart userCart) {
		Connection conn = DButil.getConnection();
		UserCartDAOImpl userCartDAO = new UserCartDAOImpl(conn);
		try {
			userCartDAO.update(userCart);
			conn.commit();
			return new JsonMsg("更新成功", true);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return new JsonMsg("更新失败", false);
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}

	/* 删除业务 */
	public JsonMsg delete(UserCart userCart) {
		Connection conn = DButil.getConnection();
		UserCartDAOImpl userCartDAO = new UserCartDAOImpl(conn);
		try {
			userCartDAO.delete(userCart);
			conn.commit();
			return new JsonMsg("删除成功", true);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return new JsonMsg("删除失败", false);
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}
}