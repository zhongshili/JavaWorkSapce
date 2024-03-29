﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="dialog_guide" class="easyui-dialog" data-options="title:'编辑引导页数据',buttons:'#btn_guide',closed:true" style="width:430px;height:330px;padding:20px 30px;">
	<div>
		<input name="id" id="id" type="hidden">
	</div>  
	<div>
    <label>标　　题：</label>
      <input name="adTitle" id="adTitle" class="easyui-textbox" style="width:220px;">
    </div><br/>
    <div>
    <label>左侧广告：</label>
    <input name="adLeft" id="adLeft" class="easyui-textbox" style="width:220px;">
    </div><br/>
    <div>
    <label>右侧广告：</label>
    <input name="adRight" id="adRight" class="easyui-textbox" style="width:220px;">
    </div><br/>
    <div>
    <div>
    <label>页　　码：</label>
    <input name="page" id="page" class="easyui-textbox" style="width:220px;">
    </div><br/>
    <div id="container">
    <label>背景图片：</label>
    <!-- 显示文件名的文本框 -->
    <input id="imgName" class="easyui-textbox" style="width:220px;" readonly="readonly">
    <!-- 处理图片的url -->
    <input name="imgUrl" id="imgUrl" type="hidden">
    <button type="button" id="pickfiles" style="font-size:12px;display: inline">选择文件</button>
    </div>
  </div>
</div>
<!-- 对话框按钮 -->
<div id="btn_guide">
  <a id="a_save" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveRecord()">保存</a>
  <a class="easyui-linkbutton" data-options="iconCls:'icon-no'" onclick="javascript:$('#dialog_guide').dialog('close')">退出</a>
</div>
