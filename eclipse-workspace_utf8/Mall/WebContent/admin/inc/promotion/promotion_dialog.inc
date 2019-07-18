<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="dialog_promotion" class="easyui-dialog" data-options="title:'编辑广告轮播数据',buttons:'#btn_promotion',closed:true" style="width:430px;height:330px;padding:40px 30px;">
	<div>
		<input name="id" id="id" type="hidden">
	</div>  
	<div>
    <label>推广区域：</label>
      <input id="position" class="easyui-combobox" name="position" style="width:220px;" data-options="valueField:'id',textField:'text',url:'/Mall/admin/json/promotion_position.json',editable:false,panelHeight:'auto'">
    </div><br/>
    <div>
    <label>图片位置：</label>
    <input name="page" id="page" class="easyui-textbox" style="width:220px;">
    </div><br/>
    <div>
    <label>商品编号：</label>
    <input name="productId" id="productId" class="easyui-textbox" style="width:220px;">
    </div><br/>
    <div>
    <div id="container">
    <label>推广图片：</label>
    <!-- 显示文件名的文本框 -->
    <input id="imgName" class="easyui-textbox" style="width:220px;" readonly="readonly">
    <!-- 处理图片的url -->
    <input name="imgUrl" id="imgUrl" type="hidden">
    <button type="button" id="pickfiles" style="font-size:12px;display: inline">选择文件</button>
    </div>
  </div>
</div>
<!-- 对话框按钮 -->
<div id="btn_promotion">
  <a id="a_save" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveRecord()">保存</a>
  <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="javascript:$('#dialog_promotion').dialog('close')">退出</a>
</div>
