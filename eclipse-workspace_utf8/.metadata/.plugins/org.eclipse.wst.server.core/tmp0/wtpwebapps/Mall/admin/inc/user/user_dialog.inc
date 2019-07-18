<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="dialog_user" class="easyui-dialog" data-options="title:'编辑广告页数据',buttons:'#btn_user',closed:true" style="width:430px;height:330px;padding:20px 30px;">

	<div>
		该功能不允许操作
	</div>
<!-- 对话框按钮 -->
<div id="btn_user">
  <!-- <a id="a_save" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveRecord()">保存</a> -->
  <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="javascript:$('#dialog_user').dialog('close')">退出</a>
</div>
