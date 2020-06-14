<%@page import="com.cxsw.web.util.RodomNumber"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>新用户注册</title>
<!-- Standard Favicon -->
<link rel="stylesheet" href="static/auth.css">
<link rel="icon" type="image/x-icon" href="static/images//favicon.ico" />

<!-- For iPhone 4 Retina display: -->
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="static/images//apple-touch-icon-114x114-precomposed.png">

<!-- For iPad: -->
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="static/images//apple-touch-icon-72x72-precomposed.png">

<!-- For iPhone: -->
<link rel="apple-touch-icon-precomposed"
	href="static/images//apple-touch-icon-57x57-precomposed.png">

<!-- Library - Google Font Familys -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i|Roboto+Slab:100,300,400,700"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="static/libraries/lightslider/lightslider.min.css" />

<link rel="stylesheet" type="text/css"
	href="static/revolution/css/settings.css">

<!-- RS5.0 Layers and Navigation Styles -->
<link rel="stylesheet" type="text/css"
	href="static/revolution/css/layers.css">
<link rel="stylesheet" type="text/css"
	href="static/revolution/css/navigation.css">


<!-- Library - Bootstrap v3.3.5 -->
<link rel="stylesheet" type="text/css" href="static/libraries/lib.css">

<!-- Custom - Theme CSS -->
<link rel="stylesheet" type="text/css" href="static/style.css">
<link rel="stylesheet" type="text/css" href="static/css/plugins.css">
<link rel="stylesheet" type="text/css"
	href="static/css/navigation-menu.css">
<link rel="stylesheet" type="text/css" href="static/css/shortcode.css">
<link href="<%=basePath%>/static/layui/css/layui.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>/static/layui/layui.js"></script>

<style type="text/css">
.divForm {
	position: absolute; /*绝对定位*/
	width: 800px;
	height: 200px;
	text-align: center; /*(让div中的内容居中)*/
	top: 35%;
	left: 50%;
	margin-top: -200px;
	margin-left: -150px;
}
</style>
<script type="text/javascript">
	function getCode() {
		var obj = document.getElementById("imgObj");
		obj.src = "${pageContext.request.contextPath}/code?date=" + new Date();

	}
</script>
</head>
<body data-offset="200" data-spy="scroll" data-target=".ow-navigation">

	<div class="divForm">
		<form class="layui-form" action="UserRegisterServlet" method="POST"
			style="padding-top: 60px;" enctype="multipart / form-data">

			<div class="layui-form-item">
				<label class="layui-form-label">证件号</label>
				<div class="layui-input-inline">
					<input type="text" name="user_idcard" lay-verify="title"
						autocomplete="off" " class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-inline">
					<input type="text" name="user_psw" lay-verify="title"
						autocomplete="off" value="<%=RodomNumber.getCustomerPsw()%>"
						class="layui-input" readonly="readonly">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">姓名</label>
				<div class="layui-input-inline">
					<input type="text" name="user_name" lay-verify="title"
						autocomplete="off" placeholder="请输入姓名" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-inline">
					<input type="radio" name="user_sex" value="男" title="男"> <input
						type="radio" name="user_sex" value="女" title="女">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">年龄</label>
				<div class="layui-input-inline">
					<input type="text" name="user_age" lay-verify="title"
						autocomplete="off" placeholder="请输入年龄" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-inline">
					<select name="province">
						<option value="">请选择省</option>
						<option value="四川省" selected="">四川省</option>
						<option value="云南省">云南省</option>
						<option value="重庆市">重庆市</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="city">
						<option value="">请选择市</option>
						<option value="成都市">成都市</option>
						<option value="绵阳市">绵阳市</option>
						<option value="昆明市">昆明市</option>
						<option value="丽江市">丽江市</option>
						<option value="江津区">江津区</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="area">
						<option value="">请选择县/区</option>
						<option value="武侯区">武侯区</option>
						<option value="锦江区">锦江区</option>
						<option value="双楠区">双楠区</option>
						<option value="天府新区">天府新区</option>
						<option value="官渡区">官渡区</option>
						<option value="双福街道">双福街道</option>
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">电话</label>
				<div class="layui-input-inline">
					<input type="text" name="user_phone" lay-verify="title"
						autocomplete="off" placeholder="请输入电话" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">销售顾问</label>
				<div class="layui-input-inline">
					<select name='comment' class="select-select2" style="width: 100%;"></select>
					<span class="help-block"></span>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">验证码 </label>
				<div class="layui-input-inline">
					<!-- <input type="text" name="yzm"
						style="padding: 15px 20px; border-radius: 0px; width: 30%;"
						class="lowin-input"> -->
					<input type="text" name="yzm" lay-verify="title" autocomplete="off"
						placeholder="请输入验证码" class="layui-input">
				</div>
				<img id="imgObj" src="${pageContext.request.contextPath }/code"
					alt="加载失败，请刷新页面" onclick="getCode()"
					style="height: 100%; border-radius: 3px; margin-left: -400px">
			</div>
			<div class="layui-form-item" style="margin-left: -500px";>
				<button type="submit" class="layui-btn" lay-submit=""
					lay-filter="demo1">立即注册</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>

		</form>
	</div>
</body>
<script>
	layui
			.use(
					[ 'form', 'layedit', 'laydate' ],
					function() {
						var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

						//创建一个编辑器
						var editIndex = layedit.build('LAY_demo_editor');
						//表单赋值
						layui.$('#LAY-component-form-setval').on('click',
								function() {
									form.val('example', {
										"username" : "贤心" // "name": "value"
										,
										"password" : "123456",
										"interest" : 1,
										"like[write]" : true //复选框选中状态
										,
										"close" : true //开关状态
										,
										"sex" : "女",
										"desc" : "我爱 layui"
									});
								});
						//表单取值
						layui.$('#LAY-component-form-getval').on('click',
								function() {
									var data = form.val('example');
									alert(JSON.stringify(data));
								});

					});
</script>
<script type="text/javascript">
	$(function() { //全部代码加载完毕进行初始化

		// 初始化省市区
		initEmployee();

	});
	function initEmployee() {

		var firstProvCode;
		// ajax请求所有省份
		$.get("mark_and_kind", {
			method : "initEmployee"
		}, function(data) {
			$.each(data, function(i, d) {
				$("select[name='comment']").append(
						"<option value='"+d.emp_name+"'>" + d.emp_name
								+ "</option>");
				/* 这里的d.code和d.name是要必需对应province类code和name字段 */
			});

			// 获取第一个省份的code
			//firstProvCode = data[0].province;
			/* 这里的.code也是要必需对应province类code字段 。
			//一个province类的json对象中包含有province：{'id':10000,'code':'410000','name':'河南省'}*/
			//一个City类的json数组对象则包含有多个json对象,
			//data[]  :[{'id':100,'code':'410100','name':'郑州市','province':'410000'},{'id':101,'code':'410800','name':'开封市','province':'410000'},
			//				{'id':102,'code':'410300','name':'洛阳市','province':'410000'}]
			// 根据第一个省份code获取对应城市列表
			//getCity(firstProvCode);
		}, 'json');
	}

	//获取对应城市列表（里面包括获取第一个城市的区县列表）
</script>
</html>