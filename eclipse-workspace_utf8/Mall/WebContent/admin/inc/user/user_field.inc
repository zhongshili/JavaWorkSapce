﻿<!-- 轮播广告管理页面的数据表格 -->
﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table id="dg_user" class="easyui-datagrid" 
       data-options="singleSelect:true,fit:true,toolbar:'#tb',
       pagination:true,pageSize:30,pageList:[10,20,30,50,100],
       onHeaderContextMenu:createGridHeaderContextMenu,
       loadMsg:'数据正在努力加载，请稍后...'" >
  <thead>
    <tr>
      <th data-options="field:'selector',checkbox:true"></th>
      <th data-options="field:'id',width:40,align:'center',hidden:true">编号</th>
      <th data-options="field:'userName',width:200,align:'center'">用户名</th>
      <th data-options="field:'name',width:100,align:'center'">姓名</th>
      <th data-options="field:'sex',width:100,align:'center'">性别</th>
      <th data-options="field:'age',width:100,align:'center'">年纪</th>
      <th data-options="field:'address',width:350,align:'center'">收获地址</th>
      <th data-options="field:'phone',width:200,align:'center'">电话号码</th>
      <th data-options="field:'wealthy',width:100,align:'center'">余额(元)</th>
      <th data-options="field:'userImg',width:350,align:'center'">图片地址</th>
    </tr>
  </thead>
</table>

﻿<!-- 工具栏 -->
<div id="tb" style="padding:5px;">
  <input class="easyui-textbox" style="width:160px;" id="title" data-options="prompt:'区域/顺序号/商品编号'"/>
  <a id="btn_Query" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
  <a id="btn_Add" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
  <a id="btn_Edit" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改</a>
  <a id="btn_Del" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</a>
</div>