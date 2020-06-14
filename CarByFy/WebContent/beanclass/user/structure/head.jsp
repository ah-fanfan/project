<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--[if IE 9]>         <html class="no-js lt-ie10" lang="en"> <![endif]-->
<!--[if gt IE 9]><!-->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta charset="utf-8">

<title>凡运汽车后台管理系统</title>
<!-- Icons -->
<!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
<link rel="shortcut icon"
	href="<%=basePath%>img/favicon.png">
<link rel="apple-touch-icon"
	href="<%=basePath%>img/icon57.png" sizes="57x57">
<link rel="apple-touch-icon"
	href="<%=basePath%>img/icon72.png" sizes="72x72">
<link rel="apple-touch-icon"
	href="<%=basePath%>img/icon76.png" sizes="76x76">
<link rel="apple-touch-icon"
	href="<%=basePath%>img/icon114.png"
	sizes="114x114">
<link rel="apple-touch-icon"
	href="<%=basePath%>img/icon120.png"
	sizes="120x120">
<link rel="apple-touch-icon"
	href="<%=basePath%>img/icon144.png"
	sizes="144x144">
<link rel="apple-touch-icon"
	href="<%=basePath%>img/icon152.png"
	sizes="152x152">
<link rel="apple-touch-icon"
	href="<%=basePath%>img/icon180.png"
	sizes="180x180">
<!-- END Icons -->

<!-- Stylesheets -->
<!-- Bootstrap is included in its original form, unaltered -->
<link rel="stylesheet"
	href="<%=basePath%>css/bootstrap.min.css">

<!-- Related styles of various icon packs and plugins -->
<link rel="stylesheet"
	href="<%=basePath%>css/plugins.css">


<!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
<link rel="stylesheet"
	href="<%=basePath%>css/main.css">

<!-- Include a specific file here from css/themes/ folder to alter the default theme of the template -->

<!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
<link rel="stylesheet"
	href="<%=basePath%>css/themes.css">
<!-- END Stylesheets -->
<!-- Modernizr (browser feature detection library) -->
<script
	src="<%=basePath%>js/vendor/modernizr-3.3.1.min.js">
	
</script>
<script type="text/javascript"
	src="<%=basePath%>my97/WdatePicker.js"></script>

<!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
<script
	src="<%=basePath%>js/vendor/jquery-2.2.4.min.js">
	
</script>
<script
	src="<%=basePath%>js/vendor/jquery.cookie.js">
	
</script>
<script
	src="<%=basePath%>js/vendor/bootstrap.min.js">
	
</script>
<script src="<%=basePath%>js/plugins.js">
	
</script>
<script src="<%=basePath%>js/app.js">
	
</script>
<script src="<%=basePath%>js/upload.js">
	
</script>
<script src="<%=basePath%>js/store.js">
	
</script>

<script src="<%=basePath%>js/echart/echarts.js">
	
</script>
<script src="<%=basePath%>js/validate.js">
	
</script>
<script
	src="<%=basePath%>artDialog/dist/dialog.js?skin=default"></script>
<script type="text/javascript">
	$(function() {
		//根据是否传递了提示消息的参数，判断是否在页面提示信息
		var operation_msg = $.cookie("operation_msg");
		if (operation_msg != null && operation_msg != "null") {
			var d = dialog({
				title : '消息',
				content : operation_msg,
			});

			d.showModal();
			setTimeout(function() {
				d.close().remove();
			}, 2500);

			//删除cookie
			$.cookie("operation_msg", null, {
				path : '/'
			});
		}
	});
</script>
</head>