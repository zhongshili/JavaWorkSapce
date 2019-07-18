package commoditytype.dao;
import java.sql.SQLException;

import common.pojo.CommodityType;

public interface CommodityTypeDAO {
  public CommodityType findOrderInfoById(CommodityType commodityType) throws SQLException;//查询单条 数据
}