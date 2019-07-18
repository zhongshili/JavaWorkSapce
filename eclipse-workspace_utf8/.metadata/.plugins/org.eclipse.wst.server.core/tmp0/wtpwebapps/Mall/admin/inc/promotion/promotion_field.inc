<!-- 引导页管理页面的数据表格 -->
<table id="dg_promotion" class="easyui-datagrid" 
       data-options="singleSelect:true,fit:true,toolbar:'#tb',
       pagination:true,pageSize:30,pageList:[10,20,30,50,100],
       onHeaderContextMenu:createGridHeaderContextMenu,
       loadMsg:'数据正在努力加载，请稍后...'" >
  <thead>
    <tr>
      <th data-options="field:'selector',checkbox:true"></th>
      <th data-options="field:'id',width:40,align:'center',hidden:true">编号</th>
      <th data-options="field:'position',width:200,align:'center'">推广区域</th>
      <th data-options="field:'title',width:200,align:'center'">推广区标题</th>
      <th data-options="field:'page',width:200,align:'center'">图片位置</th>
      <th data-options="field:'productId',width:200,align:'center'">商品编号</th>
      <th data-options="field:'imgUrl',width:500,align:'center'">图片地址</th>
    </tr>
  </thead>
</table>

﻿<!-- 工具栏 -->
<div id="tb" style="padding:5px;">
  <input class="easyui-textbox" style="width:160px;" id="title" data-options="prompt:'推广区域/标题/商品编号/顺序'"/>
  <a id="btn_Query" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
  <a id="btn_Add" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
  <a id="btn_Edit" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
  <a id="btn_Del" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</a>
  <a id="btn_Set" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'">设置推广区标题</a>
</div>