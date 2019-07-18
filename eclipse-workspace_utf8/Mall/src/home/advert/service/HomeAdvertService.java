package home.advert.service;

import common.pojo.HomeAdvert;
import common.pojo.JsonMsg;
import common.pojo.JsonRs;

public interface HomeAdvertService {
  public JsonRs selectByPage(HomeAdvert advert);//查询业务
  public JsonMsg insert(HomeAdvert advert);//添加业务
  public JsonMsg delete(HomeAdvert advert);//删除业务
  public JsonMsg update(HomeAdvert advert);//修改业务
  public HomeAdvert findOrderInfoById(String id);
}
