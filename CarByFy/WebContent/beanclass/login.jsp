<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<!DOCTYPE html>
<!--[if IE 9]>         
<html class="no-js lt-ie10" lang="en"> <![endif]-->
<!--[if gt IE 9]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>

<meta charset="utf-8">
<title>凡运汽车后台管理系统</title>
<meta name="author" content="pixelcave">
<meta name="robots" content="noindex, nofollow">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Icons -->
<!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
<link rel="shortcut icon" href="<%=basePath%>img/favicon.png">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon57.png" sizes="57x57">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon72.png" sizes="72x72">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon76.png" sizes="76x76">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon114.png" sizes="114x114">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon120.png" sizes="120x120">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon144.png" sizes="144x144">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon152.png" sizes="152x152">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon180.png" sizes="180x180">
<!-- END Icons -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<!-- Stylesheets -->
<!-- Bootstrap is included in its original form, unaltered -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">

<!-- Related styles of various icon packs and plugins -->
<link rel="stylesheet" href="<%=basePath%>css/plugins.css">

<!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
<link rel="stylesheet" href="<%=basePath%>css/main.css">

<!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
<link rel="stylesheet" href="<%=basePath%>css/themes.css">
<!-- END Stylesheets -->
<script src="<%=basePath%>js/vendor/jquery-2.2.4.min.js"></script>
<script src="<%=basePath%>assets/bootstrap/js/bootstrap.min.js"></script>
<!-- 登录背景图片加载 -->
<%-- <script src="<%=basePath%>/assets/js/jquery.backstretch.min.js"></script>
<script src="<%=basePath%>/assets/js/scripts.js"></script> --%>

<!--[if lt IE 10]>
    <script src="<%=basePath%>assets/js/placeholder.js"></script>
<![endif]-->
<script src="<%=basePath%>js/vendor/jquery.cookie.js">
	
</script>
<script src="<%=basePath%>artDialog/dist/dialog.js?skin=default"></script>
<script type="text/javascript">
</script>
</head>
<body>
<!-- Full Background -->
        <!-- For best results use an image with a resolution of 1280x1280 pixels (prefer a blurred image for smaller file size) -->
        <img src="<%=basePath %>img/login2_full_bg.jpg" alt="Full Background" class="full-bg animation-pulseSlow">
        <!-- END Full Background -->

	<!-- Login Container -->
	<div id="login-container">
		<!-- Login Header -->
		<h1
			class="h3 text-light text-center push-top-bottom animation-slideDown">
			<i class="fa fa-cube"></i> <strong>凡运汽车后台管理系统</strong>
		</h1>
		<!-- END Login Header -->

		<!-- Login Block -->
		<div class="block animation-fadeInQuickInv">
			<!-- Login Title -->
			<div class="block-title">
				<h2>后台登录界面</h2>
			</div>
			<!-- END Login Title -->

			<!-- Login Form -->
			<!-- 登录表单 -->
			<form id="form-login" action="<%=basePath%>LoginServlet" method="post"
				class="form-horizontal">
				<div class="form-group">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
							<input type="text" name="adCode"  class="form-control" placeholder="请输入您的账号...">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>
							<input type="password" name="adPsw" class="form-control" placeholder="请输入您的密码...">
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
					<div class="col-xs-8">
					</div>
					<div class="col-xs-4 text-right"  style="margin-left: -50px;">
						<button type="submit" class="btn btn-effect-ripple btn-sm btn-primary"  style="margin-left: -200px;">
							<i class="fa fa-check"></i> 登录
						</button>
						<button type="reset" class="btn btn-effect-ripple btn-sm btn-primary"   style="margin-left: 100px;">
							<i class="fa fa-check"></i> 取消
						</button>
					</div>
				</div>
			</form>
			<!-- END Login Form -->
		</div>
		<!-- END Login Block -->

		<!-- Footer -->
		<footer class="text-muted text-center animation-pullUp">
			<small>2020&copy; 凡运汽车销售有限公司</small>
		</footer>
		<!-- END Footer -->
	</div>
	<!-- END Login Container -->

</body>
<script type="text/javascript">

</script>
</html>