﻿<% String panelIndex=request.getParameter("panelIndex");%>
<div class="easyui-accordion" style="width:100%;">
	<div title="引导页管理" id="advert" <%if("0".equals(panelIndex)){%> data-options="selected:true"<%}%>>
		<a href="guideManage.jsp?panelIndex=0"  class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-large-smartart'" style="width:100%;text-align:left;margin-top:5px;">引导管理</a>
	</div>
	<div title="首页管理" id="homepage" <%if("1".equals(panelIndex)){%> data-options="selected:true"<%}%>>
	<a href="advertManage.jsp?panelIndex=1" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip'" style="width:100%;text-align:left;margin-top:5px;">广告管理</a>
	<a href="promotionManage.jsp?panelIndex=1" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-print'" style="width:100%;text-align:left;margin-top:5px;">推荐管理</a>
	</div>
	<div title="分类管理" id="guidepage" <%if("2".equals(panelIndex)){%> data-options="selected:true"<%}%>>
	</div>
	<div title="商品管理" id="commodity" <%if("3".equals(panelIndex)){%> data-options="selected:true"<%}%>>
	<a href="commodityManage.jsp?panelIndex=1" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip'" style="width:100%;text-align:left;margin-top:5px;">产品管理</a>
	</div>
	<div title="用户管理" id="user" <%if("4".equals(panelIndex)){%> data-options="selected:true"<%}%>>
	<a href="userManage.jsp?panelIndex=1" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip'" style="width:100%;text-align:left;margin-top:5px;">用户管理</a>
	</div>
</div>
<style>
 #advert a:visited{ 
	background-color:yellow;
}
</style>