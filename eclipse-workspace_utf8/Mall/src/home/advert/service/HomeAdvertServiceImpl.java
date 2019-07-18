package home.advert.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.HomeAdvert;
import common.pojo.JsonMsg;
import common.pojo.JsonRs;
import common.util.DButil;
import home.advert.dao.HomeAdvertDAOImpl;

public class HomeAdvertServiceImpl implements HomeAdvertService {

	/* 查询业务 */
	public JsonRs selectByPage(HomeAdvert advert) {
		Connection conn = DButil.getConnection();
		HomeAdvertDAOImpl advertDAO = new HomeAdvertDAOImpl(conn);
		try {
			ArrayList<HomeAdvert> advertList = new ArrayList<HomeAdvert>();
			advertList = advertDAO.select(advert);// 返回记录集
			int total = advertList.size();// 获取记录数
			conn.commit();
//			自动封装成json数据格式
			return new JsonRs("查询成功", true, total, advertList);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return new JsonRs("查询失败", false, 0, null);
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
	}

	// 查询单条数据
	public HomeAdvert findOrderInfoById(String id) {
		Connection conn = DButil.getConnection();
		HomeAdvertDAOImpl advertDAO = new HomeAdvertDAOImpl(conn);
		HomeAdvert advert = null;
		try {
			advert = advertDAO.findOrderInfoById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
		return advert;
	}

	/* 添加业务 */
	public JsonMsg insert(HomeAdvert advert) {
		Connection conn = DButil.getConnection();
		HomeAdvertDAOImpl advertDAO = new HomeAdvertDAOImpl(conn);
		try {
			advertDAO.insert(advert);
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
	public JsonMsg update(HomeAdvert advert) {
		Connection conn = DButil.getConnection();
		HomeAdvertDAOImpl advertDAO = new HomeAdvertDAOImpl(conn);
		try {
			advertDAO.update(advert);
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
	public JsonMsg delete(HomeAdvert advert) {
		Connection conn = DButil.getConnection();
		HomeAdvertDAOImpl advertDAO = new HomeAdvertDAOImpl(conn);
		try {
			advertDAO.delete(advert);
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