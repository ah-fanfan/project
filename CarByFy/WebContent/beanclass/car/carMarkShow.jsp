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
<!-- head -->
<jsp:include page="head.jsp"></jsp:include>
<body>
	<div id="page-wrapper" class="page-loading">
		<!-- Preloader 页面加载动态效果-->
		<jsp:include page="preloader.jsp"></jsp:include>
		<!-- END Preloader -->

		<!-- Page Container -->
		<div id="page-container"
			class="header-fixed-top sidebar-visible-lg-full">

			<!-- 右侧弹出设置 -->
			<jsp:include page="alterSidebar.jsp"></jsp:include>
			<!-- END 右侧弹出设置 -->

			<!-- Main Sidebar包括Logo和左侧菜单和菜单下方版权声明 -->
			<jsp:include page="left.jsp"></jsp:include>
			<!-- END Main Sidebar -->

			<!-- Main Container -->
			<div id="main-container">
				<!-- Header 包括顶部中间和顶部右侧 -->
				<jsp:include page="rightHeader.jsp"></jsp:include>
				<div id="page-content">
					<div class="block">
						<div class="block-title clearfix">
							<h2>
								<span class="hidden-xs">品牌信息回显</span>
							</h2>
						</div>
						<form action="CarMarkUpdateServlet" method="post"
							class="form-horizontal form-bordered">

							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									编号<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="hidden" name="id" class="form-control"
										value=${carMark.id } autocomplete="off"> <span
										class="help-block"> <input type="text" name="idd"
										class="form-control" placeholder=${carMark.id }> <span
										class="help-block"></span>
								</div>
							</div>




							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									车型名称<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select name="car_mark" class="select-select2"
										style="width: 100%;">
										<option value="${carMark.car_mark}" selected="">${carMark.car_mark}</option>
										<option value="吉利">吉利</option>
										<option value="奇瑞">奇瑞</option>
										<option value="长安">长安</option>
										<option value="凯迪拉克">凯迪拉克</option>
										<option value="大众">大众</option>
										<option value="奥迪">奥迪</option>
										<option value="宝马">宝马</option>
										<option value="奔驰">奔驰</option>
										<option value="别克">别克</option>
										<option value="本田">本田</option>

									</select>

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">品牌图片
								</label>
								<div class="col-md-4">
									<img style="height: 240px; width: 240px; " src="beanclass${carMark.img} "    id="img_1" />
										 <input type="file" style="margin-left: 100px;"
										name="img" id="imgFile" onchange="previewImage(this,'img_1')" />
								</div>
							</div>



							<div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">
									备注<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										value="${carMark.comment }"> <span class="help-block"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">
									状态<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select id="state" name="state" class="select-select2"
										data-placeholder="请选择.." style="width: 100%;">
										<c:if test="${carMark.state==1 }">
											<option value="1" selected="selected"> 1--已增品牌</option>
											<option value="0">0--暂无品牌</option>
										</c:if>
										<c:if test="${carMark.state==0 }">
											<option value="1"> 1--已增品牌</option>
											<option value="0" selected="selected">0--暂无品牌</option>
										</c:if> s
									</select>
								</div>
							</div>

							<div class="form-group form-actions">
								<div class="col-md-1 col-md-offset-0"
									style="margin-left: 300px;">
									<button type="submit" id="addStudentBtn"
										class="btn btn-block btn-primary">修改</button>
								</div>
								<div class="col-md-1 col-md-offset-0" style="margin-left: 80px;">
									<button type="reset" id="addStudentBtn"
										class="btn btn-block btn-primary">重置</button>
								</div>
							</div>

						</form>

						<!--Ajax实现省份、学校、专业三级联动  -->
						<script type="text/javascript">
							
						</script>
</body>
</html>