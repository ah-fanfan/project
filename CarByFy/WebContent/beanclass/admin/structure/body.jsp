<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--[if IE 9]>         <html class="no-js lt-ie10" lang="en"> <![endif]-->
<!--[if gt IE 9]><!-->
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html class="no-js" lang="en">
<!--<![endif]-->
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<meta charset="utf-8">

<title>凡运汽车后台管理系统</title>
<!-- Icons -->
<!-- The following icons can be replaced with your own, they are used by desktop and mobile browsers -->
<link rel="shortcut icon" href="<%=basePath%>img/favicon.png">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon57.png"
	sizes="57x57">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon72.png"
	sizes="72x72">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon76.png"
	sizes="76x76">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon114.png"
	sizes="114x114">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon60.png"
	sizes="60x60">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon144.png"
	sizes="144x144">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon152.png"
	sizes="152x152">
<link rel="apple-touch-icon" href="<%=basePath%>img/icon180.png"
	sizes="180x180">
<!-- END Icons -->

<!-- Stylesheets -->
<!-- Bootstrap is included in its original form, unaltered -->
<link rel="stylesheet" href="<%=basePath%>css/bootstrap.min.css">

<!-- Related styles of various icon packs and plugins -->
<link rel="stylesheet" href="<%=basePath%>css/plugins.css">


<!-- The main stylesheet of this template. All Bootstrap overwrites are defined in here -->
<link rel="stylesheet" href="<%=basePath%>css/main.css">

<!-- Include a specific file here from css/themes/ folder to alter the default theme of the template -->

<!-- The themes stylesheet of this template (for using specific theme color in individual elements - must included last) -->
<link rel="stylesheet" href="<%=basePath%>css/themes.css">
<!-- END Stylesheets -->
<!-- Modernizr (browser feature detection library) -->
<script src="<%=basePath%>js/vendor/modernizr-3.3.1.min.js">
	
</script>
<script type="text/javascript" src="<%=basePath%>my97/WdatePicker.js"></script>

<!-- jQuery, Bootstrap, jQuery plugins and Custom JS code -->
<script src="<%=basePath%>js/vendor/jquery-2.2.4.min.js">
	
</script>
<script src="<%=basePath%>js/vendor/jquery.cookie.js">
	
</script>
<script src="<%=basePath%>js/vendor/bootstrap.min.js">
	
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
<script src="<%=basePath%>artDialog/dist/dialog.js?skin=default"></script>
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
<body style="margin-top: 60px;">

	<div class="row">
		<div class="col-lg-6  ">
			<a href="#modal-package" class="widget animation-fadeInQuick"
				data-toggle="modal">
				<div class="widget-image widget-image-xs">
					<img src="img/placeholders/photos/body7.jpg" alt="image"
						style="width: 100%; height: 100%;">
					<div class="widget-image-content">
						<div class="pull-right text-light-op">
							<strong>年终大惠</strong>
							<h2 class="widget-heading text-light">
								<strong>广汽本田直营4S店</strong>
							</h2>
							<div class="text-dark push-bit">销量指数</div>
							<div class="text-warning">
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star-half-o"></i>
							</div>
						</div>
					</div>
				</div>

			</a>
		</div>

		<div class="col-lg-6  " style="margin-top: 0px;">
			<a href="#modal-package" class="widget animation-fadeInQuick"
				data-toggle="modal">
				<div class="widget-image widget-image-xs">
					<img src="img/placeholders/photos/body8.jpg" alt="image"
						style="width: 100%; height: 100%;">
					<div class="widget-image-content">
						<div class="pull-right text-light-op">
							<strong>年终大惠</strong>
							<h2 class="widget-heading text-light">
								<strong>广汽本田皓影</strong>
							</h2>
							<div class="text-dark push-bit">销量指数</div>
							<div class="text-warning">
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star-half-o"></i>
							</div>
						</div>
					</div>
				</div>

			</a>
		</div>
	</div>


	<div class="row">
		<div class="col-lg-6  ">
			<a href="#modal-package" class="widget animation-fadeInQuick"
				data-toggle="modal">
				<div class="widget-image widget-image-xs">
					<img src="img/placeholders/photos/body3.jpg" alt="image"
						style="width: 100%; height: 100%;">
					<div class="widget-image-content">
						<div class="pull-right text-light-op">
							<strong>年终大惠</strong>
							<h2 class="widget-heading text-light">
								<strong>广汽本田sport EV</strong>
							</h2>
							<div class="text-dark push-bit">销量指数</div>
							<div class="text-warning">
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star-half-o"></i>
							</div>
						</div>
					</div>
				</div>

			</a>
		</div>

		<div class="col-lg-6  " style="margin-top: 0px;">
			<a href="#modal-package" class="widget animation-fadeInQuick"
				data-toggle="modal">
				<div class="widget-image widget-image-xs">
					<img src="img/placeholders/photos/body4.jpg" alt="image"
						style="width: 100%; height: 100%;">
					<div class="widget-image-content">
						<div class="pull-right text-light-op">
							<strong>年终大惠</strong>
							<h2 class="widget-heading text-light">
								<strong>广汽本田飞度FIT</strong>
							</h2>
							<div class="text-dark push-bit">销量指数</div>
							<div class="text-warning">
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star-half-o"></i>
							</div>
						</div>
					</div>
				</div>

			</a>
		</div>
	</div>




	<div class="row">
		<div class="col-lg-6  " style="margin-top: -20px;">
			<a href="#modal-package" class="widget animation-fadeInQuick"
				data-toggle="modal">
				<div class="widget-image widget-image-xs">
					<img src="img/placeholders/photos/body1.jpg" alt="image"
						style="width: 100%; height: 100%;">
					<div class="widget-image-content">
						<div class="pull-right text-light-op">
							<strong>年终大惠</strong>
							<h2 class="widget-heading text-light">
								<strong>广汽本田奥德赛</strong>
							</h2>
							<div class="text-dark push-bit">销量指数</div>
							<div class="text-warning">
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star-half-o"></i>
							</div>
						</div>
					</div>
				</div>

			</a>
		</div>

		<div class="col-lg-6  " style="margin-top: -20px;">
			<a href="#modal-package" class="widget animation-fadeInQuick"
				data-toggle="modal">
				<div class="widget-image widget-image-xs">
					<img src="img/placeholders/photos/body2.jpg" alt="image"
						style="width: 100%; height: 100%;">
					<div class="widget-image-content">
						<div class="pull-right text-light-op">
							<strong>年终大惠</strong>
							<h2 class="widget-heading text-light">
								<strong>广汽本田冠道</strong>
							</h2>
							<div class="text-dark push-bit">销量指数</div>
							<div class="text-warning">
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star-half-o"></i>
							</div>
						</div>
					</div>
				</div>

			</a>
		</div>
	</div>



	<div class="row">
		<div class="col-lg-6  " style="margin-top: -20px;">
			<a href="#modal-package" class="widget animation-fadeInQuick"
				data-toggle="modal">
				<div class="widget-image widget-image-xs">
					<img src="img/placeholders/photos/body5.jpg" alt="image"
						style="width: 100%; height: 100%;">
					<div class="widget-image-content">
						<div class="pull-right text-light-op">
							<strong>年终大惠</strong>
							<h2 class="widget-heading text-light">
								<strong>广汽本田凌派</strong>
							</h2>
							<div class="text-dark push-bit">销量指数</div>
							<div class="text-warning">
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star-half-o"></i>
							</div>
						</div>
					</div>
				</div>

			</a>
		</div>

		<div class="col-lg-6  " style="margin-top: -20px;">
			<a href="#modal-package" class="widget animation-fadeInQuick"
				data-toggle="modal">
				<div class="widget-image widget-image-xs">
					<img src="img/placeholders/photos/body6.jpg" alt="image"
						style="width: 100%; height: 100%;">
					<div class="widget-image-content">
						<div class="pull-right text-light-op">
							<strong>年终大惠</strong>
							<h2 class="widget-heading text-light">
								<strong>广汽本田缤智</strong>
							</h2>
							<div class="text-dark push-bit">销量指数</div>
							<div class="text-warning">
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
								<i class="fa fa-2x fa-star-half-o"></i>
							</div>
						</div>
					</div>
				</div>

			</a>
		</div>
	</div>




</body>
</head>