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
								<span class="hidden-xs">车型信息回显</span>
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
										value=${carKind.id } autocomplete="off" > <span class="help-block">
									<input type="text" name="idd" class="form-control"
										placeholder=${carKind.id }  > <span class="help-block"></span>
								</div>
							</div>




							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									车型名称<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
										<select name="kind_name"  class="select-select2"  style="width: 100%;">
						                  <option value="${carKind.kind_name}" selected="">${carKind.kind_name}</option>
						                    <option value="小型车" >小型车</option>
						                  <option value="紧凑型车">紧凑型车</option>
						                  <option value="中型车">中型车</option>
						                  <option value="越野车">越野车</option>
						                  <option value="SUV">SUV</option>
						                  <option value="商务车">商务车</option>
					                </select>
										
								</div>
							</div>




							<div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">
									备注<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										value="${carKind.comment }"> <span class="help-block"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">
									状态<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select id="state" name="state" class="select-select2"
										data-placeholder="请选择.." style="width: 100%;">
										<c:if test="${carKind.state==1 }">
											<option value="1" selected="selected"> 1--新增车型</option>
											<option value="0">0--暂无车型</option>
										</c:if>
										<c:if test="${carKind.state==0 }">
											<option value="1"> 1--新增车型</option>
											<option value="0" selected="selected">0--暂无车型</option>
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