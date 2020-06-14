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
								<span class="hidden-xs">试驾信息添加</span>
							</h2>
						</div>
						<form action="TestAddServlet?id=管理员" method="post" 
							class="form-horizontal form-bordered"  enctype="multipart/form-data">

							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									试驾单号<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="t_code" class="form-control"  
									value="<%=RodomNumber.getTestNum()%>"  readonly="readonly">
									<span class="help-block"></span>
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									客户姓名<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select name='user_name' class="select-select2"
										style="width: 100%;"></select> <span class="help-block"></span>
								</div>
							</div>
							
						
							
							<div class="form-group">
							<label class="col-md-2 control-label" for="example-chosen">
									电话<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
								<select name='user_phone' class="select-select2"
										style="width: 100%;"></select> <span class="help-block"></span>
								</div>
								<label class="col-md-2 control-label" for="example-hf-password">
									车型<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									 <select name='t_car'   class="select-select2" style="width: 100%;"></select>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									试驾4S店<span class="text-danger">*</span>
								</label>
								<div class="col-md-4"  name="t_shop">
									<select name='t_shop'  class="select-select2" style="width: 100%;"></select>
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									销售专员<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									 <select name='t_normal'   class="select-select2" style="width: 30%;"></select>
								</div>
									
							</div>
							
							
							
							
							<div class="form-group">
								
								<label class="col-md-2 control-label" for="example-hf-password">
									备注<span class="text-danger">*</span>
								</label>
								<div class="col-md-10">
									<input type="text" name="comment" class="form-control" >
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
						</div>
						</div>
			
<script type="text/javascript">
$(function() {  //全部代码加载完毕进行初始化
	
	// 初始化省市区
	initCar();
	initShop();
	initEmployee();
	initUser();//客户
	$("select[name='user_name']").change(function() {

		var userName = $("select[name='user_name']").val();
		initPhone(userName);

	});

});

function initCar() {

	var firstProvCode;
	// ajax请求所有省份
	$.get("mark_and_kind", {
		method : "initCar"
			}, function(data) {
					$.each(data, function(i, d) {
						$("select[name='t_car']").append(
							"<option value='"+d.mark+d.name+"'>" + d.mark+d.name	
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
	
function initShop() {

	var firstProvCode;
	// ajax请求所有省份
	$.get("mark_and_kind", {
		method : "initShop"
			}, function(data) {
					$.each(data, function(i, d) {
						$("select[name='t_shop']").append(
							"<option value='"+d.province+d.city+d.country+d.name+"'>" + d.province+d.city+d.country+d.name
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
	
function initEmployee() {

	var firstProvCode;
	// ajax请求所有省份
	$.get("mark_and_kind", {
		method : "initEmployee"
			}, function(data) {
					$.each(data, function(i, d) {
						$("select[name='t_normal']").append(
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

function initUser() {

	var userName;
	// ajax请求所有省份
	$.get("mark_and_kind", {
		method : "initUser"
	}, function(data) {
		$.each(data, function(i, d) {
			$("select[name='user_name']").append(
					"<option value='"+d.user_name+"'>"
							+ d.user_name + "</option>");
			/* 这里的d.code和d.name是要必需对应province类code和name字段 */
		});

		// 获取第一个省份的code
		userName = data[0].user_name;
		/* 这里的.code也是要必需对应province类code字段 。
		//一个province类的json对象中包含有province：{'id':10000,'code':'410000','name':'河南省'}*/
		//一个City类的json数组对象则包含有多个json对象,
		//data[]  :[{'id':100,'code':'410100','name':'郑州市','province':'410000'},{'id':101,'code':'410800','name':'开封市','province':'410000'},
		//				{'id':102,'code':'410300','name':'洛阳市','province':'410000'}]
		// 根据第一个省份code获取对应城市列表
		//getCity(firstProvCode);
		initPhone(userName)
	}, 'json');
}


function initPhone(code) {
	// ajax请求所有省份
	$.get("mark_and_kind", {
		method : "initPhone",
		Code:     code
	}, function(data) {
		$("select[name='user_phone']").empty();
		$.each(data, function(i, d) {
			$("select[name='user_phone']").append(
					"<option value='"+d.user_phone+"'>"
							+ d.user_phone + "</option>");
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
</script>
</body>
</html>