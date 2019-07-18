package commodity.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.Commodity;

public interface CommodityDAO {
  public ArrayList<Commodity> select(Commodity commodity) throws SQLException, ClassNotFoundException;//查询
  public boolean insert(Commodity commodity) throws SQLException;//添加
  public boolean delete(Commodity commodity) throws SQLException;//删除
  public boolean update(Commodity commodity) throws SQLException;//修改
  public Commodity findOrderInfoById(Commodity commodity) throws SQLException;//查询单条 数据
}