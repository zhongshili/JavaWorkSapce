<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="dialog_advert" class="easyui-dialog" data-options="title:'编辑广告页数据',buttons:'#btn_advert',closed:true" style="width:430px;height:330px;padding:20px 30px;">
	<div>
		<input name="id" id="id" type="hidden">
	</div>  
	<div>
    <label>广告区域：</label>
      <input name="position" id="position" class="easyui-combobox" style="width:220px;" 
    		  data-options="valueField:'id',textField:'text',url:'/Mall/admin/json/advert_position.json',editable:false,panelHeight:'auto'">
    </div><br/>
    <div>
    <label>显示顺序：</label>
    <input name="page" id="page" class="easyui-textbox" style="width:220px;">
    </div><br/>
    <div>
    <label>商品编号：</label>
    <input name="productId" id="productId" class="easyui-textbox" style="width:220px;">
    </div><br/>
    <div id="container">
    <label>广告图片：</label>
    <!-- 显示文件名的文本框 -->
    <input id="imgName" class="easyui-textbox" style="width:220px;" readonly="readonly">
    <!-- 处理图片的url -->
    <input name="imgUrl" id="imgUrl" type="hidden">
    <button type="button" id="pickfiles" style="font-size:12px;display: inline">选择文件</button>
    </div>
  </div>
</div>
<!-- 对话框按钮 -->
<div id="btn_advert">
  <a id="a_save" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveRecord()">保存</a>
  <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="javascript:$('#dialog_advert').dialog('close')">退出</a>
</div>
