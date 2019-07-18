<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- 核心样式文件 --%>
<link rel="stylesheet" type="text/css"
	href="../easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../easyui/demo/demo.css">
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<title>电商平台后台管理系统</title>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north'"
			style="height: 80px; width: 100%;">
			<!-- html中的引入文件 -->
			<%@include file="inc/header.inc"%>
		</div>
		<!-- 左侧导航 -->
		<div data-options="region:'west'" title='功能导航' style="width: 200px;">
			<%@include file="inc/nav.inc"%>
		</div>
		<!-- 主体部分 -->
		<div data-options="region:'center',title:'广告管理  | 引导管理'">
			<%@include file="inc/guidepage/guide_field.inc"%>
			<%@include file="inc/guidepage/guide_dialog.inc"%>
		</div>
	</div>
</body>
<script src="Plupload/js/plupload.full.min.js"></script>
<script src="dist/qiniu.js"></script>
<%-- 自定义脚本  --%>
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
<script>
	
</script>
</html>