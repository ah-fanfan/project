
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<!-- <meta name="viewport" content="width=device-width,initial-scale=1"> -->
<title>登录</title>
<link rel="stylesheet" href="auth.css">
<script type="text/javascript">
	function getCode() {
		var obj = document.getElementById("imgObj");
		obj.src = "${pageContext.request.contextPath}/code?date=" + new Date();

	}
</script>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>登录</title>
</head>
<body>
	<div class="lowin">
		<div class="lowin-brand">
			<img src="img/kodinger.jpg" alt="logo">
		</div>
		<div class="lowin-wrapper">
			<div class="lowin-box lowin-login">
				<div class="lowin-box-inner">
					<form action="LoginServlet" method="post">
						<p>凡运汽车销售商城欢迎您！！！</p>
						<div class="lowin-group">
							<label>账号 </label> <input type="text" autocomplete="" name="adCode"
								class="lowin-input">
						</div>
						<div class="lowin-group">
							<label>密码 <a href="#" class="forgot-link">忘记密码？</a></label> 
							<input type="password" name="adPsw" autocomplete="current-password"
								class="lowin-input">
						</div>


						<div class="lowin-group password-group">
							<label> <a href="#" class="forgot-link">看不清？</a></label> <label class="layui-form-label">验证码 </label> <input
								type="text" name="yzm"   style="padding:15px 20px; border-radius:3px; width: 70%;  "  class="lowin-input"> <img id="imgObj"
								src="${pageContext.request.contextPath }/code" alt="加载失败，请刷新页面"
								onclick="getCode()"  style="height: 100% ;border-radius:3px; ">
						</div>

						<button class="lowin-btn login-btn">登录</button>

						<div class="text-foot">
							没有注册账号？ <a href="beanclass/user/register.jsp" class="register-link">去注册新账号</a>
						</div>
					</form>
				</div>
			</div>


		</div>

		<footer class="lowin-footer"> 版权归 @凡运汽车销售有限公司 所有 <a
			href="http://www.cssmoban.com/" target="_blank" title="模板之家">凡运汽车销售</a>
		<a href="http://www.cssmoban.com/" title="网上商城" target="_blank">网上商城</a>
		</footer>
	</div>


</body>
</html>