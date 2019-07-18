package home.promotion.service;

import common.pojo.HomePromotion;
import common.pojo.JsonMsg;
import common.pojo.JsonRs;

public interface PromotionService {
  public JsonRs selectByPage(HomePromotion promotion);//查询业务
  public JsonMsg insert(HomePromotion promotion);//添加业务
  public JsonMsg delete(HomePromotion promotion);//删除业务
  public JsonMsg update(HomePromotion promotion);//修改业务
  public HomePromotion findOrderInfoById(int id);
}
