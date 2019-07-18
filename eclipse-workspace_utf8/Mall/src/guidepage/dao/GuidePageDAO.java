package guidepage.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import common.pojo.GuidePage;

public interface GuidePageDAO {
  public ArrayList<GuidePage> select(GuidePage guide) throws SQLException, ClassNotFoundException;//查询
  public boolean insert(GuidePage guide) throws SQLException;//添加
  public boolean delete(GuidePage guide) throws SQLException;//删除
  public boolean update(GuidePage guide) throws SQLException;//修改
  public GuidePage findOrderInfoById(String id) throws SQLException;//查询单条 数据
}