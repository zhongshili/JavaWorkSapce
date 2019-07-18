package userCart.dao;
import java.sql.SQLException;

import common.pojo.UserCart;

public interface UserCartDAO {
  public boolean insert(UserCart userCart) throws SQLException;//添加
  public boolean delete(UserCart userCart) throws SQLException;//删除
  public boolean update(UserCart ususerCarter) throws SQLException;//修改
  public UserCart findOrderInfoByUserCart(UserCart userCart) throws SQLException;//查询单条 数据
}