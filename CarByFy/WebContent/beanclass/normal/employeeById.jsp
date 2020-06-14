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
<jsp:include page="structure/head.jsp"></jsp:include>
<body>
	<div id="page-wrapper" class="page-loading">
		<!-- Preloader 页面加载动态效果-->
		<jsp:include page="structure/preloader.jsp"></jsp:include>
		<!-- END Preloader -->

		<!-- Page Container -->
		<div id="page-container"
			class="header-fixed-top sidebar-visible-lg-full">

			<!-- 右侧弹出设置 -->
			<jsp:include page="structure/alterSidebar.jsp"></jsp:include>
			<!-- END 右侧弹出设置 -->

			<!-- Main Sidebar包括Logo和左侧菜单和菜单下方版权声明 -->
			<jsp:include page="structure/left.jsp"></jsp:include>
			<!-- END Main Sidebar -->

			<!-- Main Container -->
			<div id="main-container">
				<!-- Header 包括顶部中间和顶部右侧 -->
				<jsp:include page="structure/rightHeader.jsp"></jsp:include>
				<div id="page-content">
					<div class="block">
						<div class="block-title clearfix">
							<h2>
								<span class="hidden-xs">技工信息详情</span>
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
										value=${employee.id } autocomplete="off" > <span class="help-block">
									<input type="text" name="idd" class="form-control"
										placeholder=${employee.id }  > <span class="help-block"></span>
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									账号<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="emp_code" class="form-control"
										placeholder=${employee.emp_code }  > <span class="help-block"></span>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									姓名<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="emp_name" class="form-control"
										placeholder=${ employee.emp_name}  > <span class="help-block"></span>
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									年龄<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="emp_age" class="form-control"
										placeholder="${employee.emp_age }"> <span class="help-block"></span>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">
									性别<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
								 <c:if test="${employee.emp_sex=='男' }">
									<input type="radio" name="emp_sex" value="男" checked="checked" >男&nbsp;&nbsp;&nbsp;
									<input type="radio" name="emp_sex" value="女">女
									</c:if>
									 <c:if test="${employee.emp_sex=='女' }">
									<input type="radio" name="emp_sex" value="男" >男&nbsp;&nbsp;&nbsp;
									<input type="radio" name="emp_sex" value="女" checked="checked" >女
									</c:if>
									
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									部门<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="emp_dep" class="form-control"
										placeholder="${employee.emp_dep }"> <span class="help-block"></span>
								</div>
							</div>
							

						
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									电话<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="emp_phone" class="form-control"
										placeholder="${employee.emp_phone }"> <span class="help-block"></span>
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									地址<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="emp_address" class="form-control"
										placeholder="${employee.emp_address }"> <span class="help-block"></span>
								</div>
							</div>

                       <div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">工作照
								</label>
								<div class="col-md-4">
									<img style="height: 240px; width: 240px;margin-left: 0px;"  src="beanclass${employee.emp_img} "/>
								</div>
									<label class="col-md-2 control-label" for="example-hf-password">
									备注<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="${employee.comment }"> <span class="help-block"></span>
								</div>
								
								<div class="form-group" style="margin-top: 60px;">
								<label class="col-md-2 control-label" for="example-hf-password">
									状态<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									
										<c:if test="${employee.state==1 }">
											<div class="col-md-4">
									<input type="text" name="state" class="form-control"
										placeholder="在职技工"> <span class="help-block"></span>
							
										</c:if>
										<c:if test="${employee.state==0 }">
											
									<input type="text" name="state" class="form-control"
										placeholder="离职技工"> <span class="help-block"></span>
								
										</c:if> 
									</select>
								</div>
							</div>
								
							</div>


							

						</form>

						<!--Ajax实现省份、学校、专业三级联动  -->
						<script type="text/javascript">
							
						</script>
</body>
</html>