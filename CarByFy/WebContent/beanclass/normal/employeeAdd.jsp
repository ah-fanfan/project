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
								<span class="hidden-xs">技工信息添加</span>
							</h2>
						</div>
						<form action="EmployeeAddServlet" method="post" 
							class="form-horizontal form-bordered"  enctype="multipart/form-data">

							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									职工号<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="emp_code" class="form-control"  
									value="<%=RodomNumber.getEmpNum()%>">
									<span class="help-block"></span>
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									姓名<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="emp_name" class="form-control">
									<span class="help-block"></span>
								</div>
							</div>
							
						
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									年龄<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select name="emp_age" class="select-select2"
										style="width: 100%;">
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option>
										<option value="32">32</option>
										<option value="33">33</option>
										<option value="34">34</option>
										<option value="35">35</option>

									</select>

								</div>
								<label class="col-md-2 control-label" for="example-hf-password">
									性别<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="radio" name="emp_sex" value="男"  >男&nbsp;&nbsp;&nbsp;
									<input type="radio" name="emp_sex" value="女">女
									<span class="help-block"></span>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									部门<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select name="emp_dep" class="select-select2"
										style="width: 100%;">
										<option value="销售部">销售部</option>
										<option value="行政部">行政部</option>
										<option value="财务部">财务部</option>
										<option value="售后部">售后部</option>
										<option value="市场部">市场部</option>
										<option value="项目部">项目部</option>
									</select>

								</div>
									<label class="col-md-2 control-label" for="example-chosen">
									电话<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="emp_phone" class="form-control">
									<span class="help-block"></span>
								</div>
							</div>
							
							
							
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									身份证号<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="emp_idcard" class="form-control">
									<span class="help-block"></span>
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									地址<span class="text-danger">*</span>
								</label>
								<div class="col-md-4"  name="ad_address">
									<select name='province'  class="select-select2" style="width: 30%;"></select>
	                                <select name='city'  class="select-select2" style="width: 30%;"></select>
	                                <select name='area'   class="select-select2" style="width: 30%;"></select>

								</div>
							</div>
							
					
							
							
                             <div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">照片
								</label>
								<div class="col-md-4">
									<img style="height: 240px; width: 300px;margin-left: 0px;"  id="img_1" />
									<input type="file" style="margin-left: 100px;"  name="emp_img" id="imgFile" onchange="previewImage(this,'img_1')"/>
								</div>
								<label class="col-md-2 control-label" for="example-hf-password">
									备注<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control">
									<span class="help-block"></span>
								</div>
							</div>



							<div class="form-group form-actions">
								<div class="col-md-1 col-md-offset-0"
									style="margin-left: 600px;">
									<button type="submit" id="addStudentBtn"
										class="btn btn-block btn-primary">添加</button>
								</div>
								<div class="col-md-1 col-md-offset-0" style="margin-left: 80px;">
									<button type="reset" id="addStudentBtn"
										class="btn btn-block btn-primary">重置</button>
								</div>
							</div>
							<input type="hidden" name="state" value="1">  

						</form>
<!--Ajax实现省份、学校、专业三级联动  -->
<script type="text/javascript">
$(function() {  //全部代码加载完毕进行初始化
	
	// 初始化省市区
	initAddress();

	// 更改省份后的操作//选择select标签中name='rovince'的标签
	$("select[name='province']").change(function() {

			var provCode = $("select[name='province']").val();
           
			getCity(provCode);

		});

	// 更改城市后的操作//选择select标签中name='city'的标签
	$("select[name='city']").change(function() {
		var cityCode = $("select[name='city']").val();
		getArea(cityCode);
	});

});

function initAddress() {

	var firstProvCode;
	// ajax请求所有省份
	$.get("address", {
		method : "initProvince"
			}, function(data) {
					$.each(data, function(i, d) {
						$("select[name='province']").append(
							"<option value='"+d.province+"'>" + d.province	
							+ "</option>");
			/* 这里的d.code和d.name是要必需对应province类code和name字段 */
							});

			// 获取第一个省份的code
				firstProvCode = data[0].province;
				/* 这里的.code也是要必需对应province类code字段 。
				//一个province类的json对象中包含有province：{'id':10000,'code':'410000','name':'河南省'}*/
				//一个City类的json数组对象则包含有多个json对象,
				//data[]  :[{'id':100,'code':'410100','name':'郑州市','province':'410000'},{'id':101,'code':'410800','name':'开封市','province':'410000'},
				//				{'id':102,'code':'410300','name':'洛阳市','province':'410000'}]
				// 根据第一个省份code获取对应城市列表
				getCity(firstProvCode);
		}, 'json');
	}

//获取对应城市列表（里面包括获取第一个城市的区县列表）
function getCity(provCode) {

		var firstCityCode;

		// ajax请求所有市级单位
		$.get("address", {
					method : "getCity",
					provCode : provCode
				}, function(data) {

				// 先清空城市下拉框
					$("select[name='city']").empty();

						$.each(data, function(i, d) {
						$("select[name='city']").append(
									"<option value='"+d.city+"'>" + d.city
									+ "</option>");
						/* 这里的d.code和d.name是要必需对应City类code和name字段 */
								});
		
					// 获取第一个城市的code
					firstCityCode = data[0].city;
					// 根据第一个城市code获取对应区县列表/* 这里的.code也是要必需对应City类code字段 。*/
					getArea(firstCityCode);
				}, 'json');
	}

function getArea(cityCode) {

		// ajax请求所有区县单位
		$.get("address", {
					method : "getArea",
					cityCode : cityCode
				}, function(data) {
		
					// 先清空区县下拉框
						$("select[name='area']").empty();
						$.each(data, function(i, d) {
										$("select[name='area']").append(
											"<option value='"+d.areaname+"'>" + d.areaname
											+ "</option>");
										/* 这里的d.code和d.name是要必需对应Area类code和name字段 */
									});
				}, 'json');
	}
</script>
</body>
</html>