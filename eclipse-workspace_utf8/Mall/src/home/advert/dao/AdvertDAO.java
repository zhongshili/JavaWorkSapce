package home.advert.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.HomeAdvert;

public interface AdvertDAO {
  public ArrayList<HomeAdvert> select(HomeAdvert advert) throws SQLException, ClassNotFoundException;//查询
  public boolean insert(HomeAdvert advert) throws SQLException;//添加
  public boolean delete(HomeAdvert advert) throws SQLException;//删除
  public boolean update(HomeAdvert advert) throws SQLException;//修改
  public HomeAdvert findOrderInfoById(int id) throws SQLException;//查询单条 数据
}