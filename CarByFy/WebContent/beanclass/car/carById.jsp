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
								<span class="hidden-xs">车辆信息详情</span>
							</h2>
						</div>
						<form action="" method="post"
							class="form-horizontal form-bordered">

							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									编号<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="hidden" name="id" class="form-control"
										value=${car.id } autocomplete="off"> <span
										class="help-block"> <input type="text" name="idd"
										class="form-control" placeholder=${car.id }> <span
										class="help-block"></span>
								</div>
                             <label class="col-md-2 control-label" for="example-chosen">
									品牌<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="idd" class="form-control"
										placeholder=${car.mark }> <span class="help-block"></span>
								</div>
								
							</div>

							<div class="form-group">
								
								<label class="col-md-2 control-label" for="example-chosen">
									类型<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="idd" class="form-control"
										placeholder=${car.kind }> <span class="help-block"></span>
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									名称<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="${car.name }"> <span class="help-block"></span>
								</div>
								
							</div>


							<div class="form-group">
								
								<label class="col-md-2 control-label" for="example-chosen">
									配置<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder=${car.conf_style }> <span
										class="help-block"></span>
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									座位数<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="idd" class="form-control"
										placeholder="${car.seat_num}座">
								</div>

							</div>



							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									车厢数<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">

									<c:if test="${car.door_num==2 }">
										<input type="text" name="idd" class="form-control"
											placeholder="两厢车">
									</c:if>
									<c:if test="${car.door_num==3 }">
										<input type="text" name="idd" class="form-control"
											placeholder="三厢车">
									</c:if>
								</div>
									<label class="col-md-2 control-label" for="example-chosen">
									燃油类型<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="idd" class="form-control"
										placeholder=${car.fuel_type }> <span
										class="help-block"></span>
								</div>
							
							</div>











							<div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">外观图片
								</label>
								<div class="col-md-4">
									<img style="height: 240px; width: 400px; margin-left: 0px;"
										src="beanclass${car.outimg} " />
								</div>
								<label class="col-md-2 control-label" for="example-hf-password">内饰图片
								</label>
								<div class="col-md-4">
									<img style="height: 240px; width: 400px; margin-left: 0px;"
										src="beanclass${car.inimg} " />
								</div>
							</div>





							<div class="form-group">
							
								<label class="col-md-2 control-label" for="example-chosen">
									变速箱类型<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="idd" class="form-control"
										placeholder=${car.transmission_type }> <span
										class="help-block"></span>
								</div>
									<label class="col-md-2 control-label" for="example-chosen">
									导航<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<c:if test="${car.havenavigation==1 }">
										<input type="text" name="idd" class="form-control"
											placeholder="有导航">
									</c:if>
									<c:if test="${car.havenavigation==0 }">
										<input type="text" name="idd" class="form-control"
											placeholder="无导航">
									</c:if>
								</div>
							</div>




							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									座椅材质<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="idd" class="form-control"
										placeholder=${car.seat_material }> <span
										class="help-block"></span>
								</div>
							<label class="col-md-2 control-label" for="example-chosen">
									天窗<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<c:if test="${car.havetopwindow==1 }">
										<input type="text" name="idd" class="form-control"
											placeholder="有天窗">
									</c:if>
									<c:if test="${car.havetopwindow==0 }">
										<input type="text" name="idd" class="form-control"
											placeholder="无天窗">
									</c:if>
								</div>

							</div>



							<div class="form-group">
								
								<label class="col-md-2 control-label" for="example-hf-password">
									价格<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="${car.price }万元"> <span class="help-block"></span>
								</div>
								<label class="col-md-2 control-label" for="example-hf-password">
									数量<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control"
										placeholder="${car.comment }"> <span
										class="help-block"></span>
								</div>

							</div>



							<div class="form-group">
								
								<label class="col-md-2 control-label" for="example-hf-password">
									状态<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<c:if test="${car.state==1 }">
										<input type="text" name="comment" class="form-control"
											placeholder="该车型有库存">
										<span class="help-block"></span>
									</c:if>
									<c:if test="${car.state==0 }">

										<input type="text" name="comment" class="form-control"
											placeholder="该车型无库存">
										<span class="help-block"></span>

									</c:if>
								</div>
							</div>


						</form>

						<!--Ajax实现省份、学校、专业三级联动  -->
						<script type="text/javascript">
							
						</script>
</body>
</html>