<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="dialog_setting" class="easyui-dialog" data-options="title:'编辑推广区标题',buttons:'#btn_setting',closed:true" style="width:430px;height:330px;padding:40px 30px;">
	<div>
    <label>首页秒杀区  ：</label>
      <input id="position" class="easyui-textbox" name="position" style="width:220px;" data-options="valueField:'id',textField:'text',url:'/MallWeb/admin/json/promotion_position.json',editable:false,panelHeight:'auto'">
    </div><br/>
    <div>
    <label>活动推广1区：</label>
    <input name="page" id="page" class="easyui-textbox" style="width:220px;">
    </div><br/>
    <div>
    <label>活动推广2区：</label>
    <input name="productId" id="productId" class="easyui-textbox" style="width:220px;">
    </div><br/>
    <div>
  </div>
</div>
<!-- 对话框按钮 -->
<div id="btn_promotion">
  <a id="a_save" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveRecord()">保存</a>
  <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="javascript:$('#dialog_promotion').dialog('close')">退出</a>
</div>
