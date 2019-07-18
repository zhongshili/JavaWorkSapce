package user.service;

import common.pojo.User;
import common.pojo.JsonMobileUser;
import common.pojo.JsonMsg;
import common.pojo.JsonRs;

public interface UserService {
  public JsonRs selectByPage(User user);//查询业务
  public JsonMobileUser insert(User user);//添加业务
  public JsonMsg delete(User user);//删除业务
  public JsonMsg update(User user);//修改业务
  public User findOrderInfoById(User user);
}
