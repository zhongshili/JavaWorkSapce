package userCart.service;

import common.pojo.UserCart;
import common.pojo.JsonMobileUserCart;
import common.pojo.JsonMsg;

public interface UserCartService {
  public JsonMobileUserCart selectByUserCart(UserCart userCart);//查询业务
  public JsonMsg insert(UserCart userCart);//添加业务
  public JsonMsg delete(UserCart userCart);//删除业务
  public JsonMsg update(UserCart userCart);//修改业务
//  public UserCart findOrderInfoById(UserCart userCart);
}
