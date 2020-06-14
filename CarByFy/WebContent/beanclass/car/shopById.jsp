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
								<span class="hidden-xs">车店信息详情</span>
							</h2>
						</div>
						<form action="CarKindUpdateServlet" method="post"
							class="form-horizontal form-bordered">

							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									编号<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
								<input type="hidden" name="id" class="form-control"
										value=${shop.id } autocomplete="off" > <span class="help-block">
									<input type="text" name="idd" class="form-control"
										placeholder=${shop.id }  > <span class="help-block"></span>
								</div>
							</div>




							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
								   省份<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="${shop.province }"> <span class="help-block"></span>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
								   市区<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="${shop.city }"> <span class="help-block"></span>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
								   县域<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="${shop.country }"> <span class="help-block"></span>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
								   详细地址<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="${shop.detail_address }"> <span class="help-block"></span>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
								   名称<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="${shop.name }"> <span class="help-block"></span>
								</div>
							</div>

                       <div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">4S店图片
								</label>
								<div class="col-md-4">
									<img style="height: 240px; width: 240px;margin-left: 0px;"  src="beanclass${shop.img} "/>
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">
									备注<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="${shop.comment }"> <span class="help-block"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">
									状态<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									
										<c:if test="${shop.state==1 }">
											<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="营业车店"> <span class="help-block"></span>
							
										</c:if>
										<c:if test="${shop.state==0 }">
											
									<input type="text" name="comment" class="form-control"
										placeholder="未营业车店"> <span class="help-block"></span>
								
										</c:if> 
									</select>
								</div>
							</div>


						</form>

						<!--Ajax实现省份、学校、专业三级联动  -->
						<script type="text/javascript">
							
						</script>
</body>
</html>