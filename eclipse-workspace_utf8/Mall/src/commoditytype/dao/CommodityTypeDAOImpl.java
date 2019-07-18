package commoditytype.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.pojo.CommodityType;

public class CommodityTypeDAOImpl implements CommodityTypeDAO {

	private Connection conn = null;
	private PreparedStatement pst = null;

	// 定义构造方法，实例化的时候完成连接的注入
	public CommodityTypeDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public CommodityType findOrderInfoById(CommodityType oldCommodityType) throws SQLException {
		String cond1 = "producttypename like '%" + oldCommodityType.getProductTypeName() + "%'";
		String sql = "select * from commodityproperty where " + cond1;
		pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		rs.next();
		CommodityType commodityType = new CommodityType();
		commodityType.setProductTypeId(rs.getInt("producttypeid"));

		commodityType.setProductTypeName(rs.getString("producttypename"));
		return commodityType;
	}

}
