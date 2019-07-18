package home.promotion.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.HomePromotion;
import common.pojo.HomePromotionView;
import common.pojo.JsonMsg;
import common.pojo.JsonRs;
import common.util.DButil;
import home.promotion.dao.PromotionDAOImpl;

public class PromotionServiceImpl implements PromotionService {

	/* 查询业务 */
	public JsonRs selectByPage(HomePromotion promotion) {
		Connection conn = DButil.getConnection();
		PromotionDAOImpl promotionDAO = new PromotionDAOImpl(conn);
		try {
			ArrayList<HomePromotionView> promotionViewList = new ArrayList<HomePromotionView>();
			promotionViewList = promotionDAO.select(promotion);// 返回记录集
			int total = promotionViewList.size();// 获取记录数
			conn.commit();
			return new JsonRs("查询成功", true, total, promotionViewList);
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
	public HomePromotion findOrderInfoById(int id) {
		Connection conn = DButil.getConnection();
		PromotionDAOImpl promotionDAO = new PromotionDAOImpl(conn);
		HomePromotion promotion = null;
		try {
			promotion = promotionDAO.findOrderInfoById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				DButil.closeConnection(conn);
			}
		}
		return promotion;
	}

	/* 添加业务 */
	public JsonMsg insert(HomePromotion promotion) {
		Connection conn = DButil.getConnection();
		PromotionDAOImpl promotionDAO = new PromotionDAOImpl(conn);
		try {
			promotionDAO.insert(promotion);
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
	public JsonMsg update(HomePromotion promotion) {
		Connection conn = DButil.getConnection();
		PromotionDAOImpl promotionDAO = new PromotionDAOImpl(conn);
		try {
			promotionDAO.update(promotion);
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
	public JsonMsg delete(HomePromotion promotion) {
		Connection conn = DButil.getConnection();
		PromotionDAOImpl promotionDAO = new PromotionDAOImpl(conn);
		try {
			promotionDAO.delete(promotion);
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