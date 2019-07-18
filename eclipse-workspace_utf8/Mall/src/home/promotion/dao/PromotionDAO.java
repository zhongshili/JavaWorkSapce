package home.promotion.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.HomePromotion;
import common.pojo.HomePromotionView;

public interface PromotionDAO {
  public ArrayList<HomePromotionView> select(HomePromotion promotion) throws SQLException, ClassNotFoundException;//查询
  public boolean insert(HomePromotion promotion) throws SQLException;//添加
  public boolean delete(HomePromotion promotion) throws SQLException;//删除
  public boolean update(HomePromotion promotion) throws SQLException;//修改
  public HomePromotion findOrderInfoById(int id) throws SQLException;//查询单条 数据
}