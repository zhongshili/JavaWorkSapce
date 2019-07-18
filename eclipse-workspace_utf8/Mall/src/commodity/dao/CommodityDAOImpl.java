package commodity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.Commodity;

public class CommodityDAOImpl implements CommodityDAO {

	private Connection conn = null;
	private PreparedStatement pst = null;

	// 定义构造方法，实例化的时候完成连接的注入
	public CommodityDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	// 查询记录
	public ArrayList<Commodity> select(Commodity commodity) throws SQLException {
		// 获取Commodity表中全部数据，并以字段page升序排序
		String sql = "select * from commodity where producttypeid=?";
		int condition = commodity.getProductTypeId();
		String limit = commodity.getLimit();
		System.out.println(condition);
		if (condition==0) {
//			相当于模糊匹配，查找每个中的关键字
//			String cond1 = "productshopname like '%" + condition + "%'";
//			String cond2 = "producttitle like '%" + condition + "%'";
//			sql = "select * from commodity where " + cond1 + " or " + cond2;
			sql = "select * from commodity";
			pst = conn.prepareStatement(sql);
		}else {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, commodity.getProductTypeId());
		}
		if (limit != null && !limit.equals("")) {
			sql += limit;
		}
		ResultSet rs = pst.executeQuery();
		ArrayList<Commodity> commodityList = new ArrayList<Commodity>();
		if (rs.next()) {
			for (int i = 0; i <= rs.getRow(); i++) {
				Commodity newCommodity = new Commodity();
				newCommodity.setProductId(rs.getInt("productid"));
				newCommodity.setProductPrice(rs.getFloat("productprice"));
				newCommodity.setProductTitle(rs.getString("producttitle"));
				newCommodity.setProductCarriage(rs.getString("productcarriage"));
				newCommodity.setProductAddressRigger(rs.getString("productaddressrigger"));
				newCommodity.setProductSendCredit(rs.getInt("productsendcredit"));
				newCommodity.setProductShopName(rs.getString("productshopname"));
				newCommodity.setProductShopUrl(rs.getString("productshopurl"));
				newCommodity.setProductImg(rs.getString("productimg"));
				newCommodity.setInventory(rs.getInt("inventory"));
				newCommodity.setProductTypeId(rs.getInt("producttypeid"));
				commodityList.add(newCommodity);
				rs.next();
			}
		}
		return commodityList;
	}

	// 插入记录
	public boolean insert(Commodity commodity) throws SQLException {
		try {
			String sql = "insert into commodity(productid,productprice,producttitle,productcarriage,productaddressrigger,productsendcredit,productshopname,productshopurl,inventory,producttypeid,productimg) values(?,?,?,?,?,?,?,?,?,?,?) ";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, commodity.getProductId());
			pst.setFloat(2, commodity.getProductPrice());
			pst.setString(3, commodity.getProductTitle());
			pst.setString(4, commodity.getProductCarriage());
			pst.setString(5, commodity.getProductAddressRigger());
			pst.setInt(6, commodity.getProductSendCredit());
			pst.setString(7, commodity.getProductShopName());
			pst.setString(8, commodity.getProductShopUrl());
			pst.setInt(9, commodity.getInventory());
			pst.setInt(10, commodity.getProductTypeId());
			pst.setString(11, commodity.getProductImg());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 更新记录
	public boolean update(Commodity commodity) throws SQLException {
		try {
			Commodity newCommodity=findOrderInfoById(commodity);
			newCommodity.setProductPrice(commodity.getProductPrice());
			newCommodity.setProductTitle(commodity.getProductTitle());
			newCommodity.setProductTypeId(commodity.getProductTypeId());
			newCommodity.setProductImg(commodity.getProductImg());
			String sql = "update commodity set productprice=?,producttitle=?,productcarriage=?,productaddressrigger=?,productsendcredit=?,productshopname=?,productshopurl=?,inventory=?,producttypeid=?,productimg=? where productid=?";
			pst = conn.prepareStatement(sql);
			pst.setFloat(1, newCommodity.getProductPrice());
			pst.setString(2, newCommodity.getProductTitle());
			pst.setString(3, newCommodity.getProductCarriage());
			pst.setString(4, newCommodity.getProductAddressRigger());
			pst.setInt(5, newCommodity.getProductSendCredit());
			pst.setString(6, newCommodity.getProductShopName());
			pst.setString(7, newCommodity.getProductShopUrl());
			pst.setInt(8, newCommodity.getInventory());
			pst.setInt(9, newCommodity.getProductTypeId());
			pst.setString(10, newCommodity.getProductImg());
			pst.setInt(11, newCommodity.getProductId());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 删除记录
	public boolean delete(Commodity commodity) throws SQLException {
		try {
			String sql = "delete from commodity where productid=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, commodity.getProductId());
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Commodity findOrderInfoById(Commodity oldCommodity) throws SQLException {
		String sql = "select * from commodity where productid=?";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, oldCommodity.getProductId());
		ResultSet rs = pst.executeQuery();
		rs.next();
		Commodity commodity = new Commodity();
		commodity.setProductId(rs.getInt("productid"));
		commodity.setProductPrice(rs.getFloat("productprice"));
		commodity.setProductTitle(rs.getString("producttitle"));
		commodity.setProductCarriage(rs.getString("productcarriage"));
		commodity.setProductAddressRigger(rs.getString("productaddressrigger"));
		commodity.setProductSendCredit(rs.getInt("productsendcredit"));
		commodity.setProductShopName(rs.getString("productshopname"));
		commodity.setProductShopUrl(rs.getString("productshopurl"));
		commodity.setProductImg(rs.getString("productimg"));
		commodity.setInventory(rs.getInt("inventory"));
		commodity.setProductTypeId(rs.getInt("producttypeid"));
		return commodity;
	}

}
