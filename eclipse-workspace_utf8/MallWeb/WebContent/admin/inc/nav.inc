﻿<% String panelIndex=request.getParameter("panelIndex");%>
<div class="easyui-accordion" style="width:100%;">
	<div title="广告管理" id="advert" <%if("0".equals(panelIndex)){%> data-options="selected:true"<%}%>>
		<a href="guideManage.jsp?panelIndex=0"  class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-large-smartart'" style="width:100%;text-align:left;margin-top:5px;">引导管理</a>
		<a href="carouselManage.jsp?panelIndex=0" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip'" style="width:100%;text-align:left;margin-top:5px;">轮播管理</a>
	</div>
	<div title="首页管理" id="homepage" <%if("1".equals(panelIndex)){%> data-options="selected:true"<%}%>>
	<a href="inform.jsp?panelIndex=1" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-tip'" style="width:100%;text-align:left;margin-top:5px;">秒杀管理</a>
	<a href="admin.jsp?panelIndex=1" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-print'" style="width:100%;text-align:left;margin-top:5px;">推荐管理</a>
	</div>
	<div title="分类管理" id="guidepage" <%if("2".equals(panelIndex)){%> data-options="selected:true"<%}%>>
	</div>
	<div title="商品管理" id="guidepage" <%if("3".equals(panelIndex)){%> data-options="selected:true"<%}%>>
	</div>
	<div title="用户管理" id="guidepage" <%if("4".equals(panelIndex)){%> data-options="selected:true"<%}%>>
	</div>
</div>
<style>
 #advert a:visited{ 
	background-color:yellow;
}
</style>