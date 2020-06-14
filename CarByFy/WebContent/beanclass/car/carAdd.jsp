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
								<span class="hidden-xs">车辆信息添加</span>
							</h2>
						</div>
						<form action="CarAddServlet" method="post" 
							class="form-horizontal form-bordered"  enctype="multipart/form-data">
							
							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									品牌<span class="text-danger">*</span>
								</label>
								<div class="col-md-4"  name="ad_address">
									<select name='mark'  class="select-select2" style="width: 30%;"></select>
								</div>
								<label class="col-md-2 control-label" for="example-chosen">
									类型<span class="text-danger">*</span>
								</label>
								<div class="col-md-4"  name="ad_address">
									<select name='kind'  class="select-select2" style="width: 30%;"></select>

								</div>
							</div>
							

							<div class="form-group">
								<label class="col-md-2 control-label" for="example-chosen">
									名称<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="name" class="form-control">
									<span class="help-block"></span>
								</div>
											<label class="col-md-2 control-label" for="example-hf-password">
									车辆配置<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select id="conf_style" name="conf_style" class="select-select2"
										data-placeholder="请选择.." style="width: 100%;">
										<option value="低配">低配</option>
										<option value="中配">中配</option>
										<option value="高配">高配</option>

									</select>
								</div>
						
							</div>
							
							<div class="form-group">
					
								<label class="col-md-2 control-label" for="example-hf-password">
									座位数<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select id="seat_num" name="seat_num" class="select-select2"
										data-placeholder="请选择.." style="width: 100%;">
										<option value="5">5座</option>
										<option value="6">6座</option>
                                        <option value="7">7座</option>
									</select>
								</div>
								<label class="col-md-2 control-label" for="example-hf-password">
									车厢数<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select id="door_num" name="door_num" class="select-select2"
										data-placeholder="请选择.." style="width: 100%;">
										<option value="2">两厢</option>
										<option value="3">三厢</option>
									</select>
								</div>
							</div>
							
							
							<div class="form-group">
								
								<label class="col-md-2 control-label" for="example-hf-password">
									座椅材质<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select id="seat_material" name="seat_material" class="select-select2"
										data-placeholder="请选择.." style="width: 100%;">
										<option value="皮质">皮质</option>
										<option value="布料">布料</option>
									</select>
								</div>
									<label class="col-md-2 control-label" for="example-hf-password">
									燃油类型<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select id="seat_num" name="fuel_type" class="select-select2"
										data-placeholder="请选择.." style="width: 100%;">
										<option value="汽油">汽油</option>
										<option value="柴油">柴油</option>
										<option value="电动">电动</option>
										<option value="插电混动">插电混动</option>
										<option value="油电混动">油电混动</option>
									</select>
								</div>
							</div>
						
						
							
                             <div class="form-group">
								<label class="col-md-2 control-label" for="example-hf-password">外观图片
								</label>
								<div class="col-md-4">
									<img style="height: 240px; width: 400px;margin-left: 0px;"  id="img_1" />
									<input type="file" style="margin-left: 100px;"  name="outimg" id="imgFile" onchange="previewImage(this,'img_1')"/>
								</div>
									<label class="col-md-2 control-label" for="example-hf-password">内饰图片
								</label>
								<div class="col-md-4">
									<img style="height: 240px; width: 400px;margin-left: 0px;"  id="img_2" />
									<input type="file" style="margin-left: 100px;"  name="inimg" id="imgFile" onchange="previewImage(this,'img_2')"/>
								</div>
							</div>
							

                         <div class="form-group">
							
								<label class="col-md-2 control-label" for="example-hf-password">
									变速箱类型<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select id="transmission_type" name="transmission_type" class="select-select2"
										data-placeholder="请选择.." style="width: 100%;">
										<option value="手动">手动</option>
										<option value="自动">自动</option>
										<option value="手自一体">手自一体</option>
									</select>
								</div>
								<label class="col-md-2 control-label" for="example-hf-password">
									导航<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select id="havenavigation" name="havenavigation" class="select-select2"
										data-placeholder="请选择.." style="width: 100%;">
										<option value="1">自带导航</option>
										<option value="0">无导航</option>
									</select>
								</div>
							</div>
							
							
						 <div class="form-group">
								
								<label class="col-md-2 control-label" for="example-hf-password">
									天窗<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<select id="havetopwindow" name="havetopwindow" class="select-select2"
										data-placeholder="请选择.." style="width: 100%;">
										<option value="1">自带天窗</option>
										<option value="0">无天窗</option>
									</select>
								</div>
								<label class="col-md-2 control-label" for="example-hf-password">
									价格<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="price" class="form-control">
									<span class="help-block"></span>
								</div>
							</div>
							
						<div class="form-group">
								
								<label class="col-md-2 control-label" for="example-hf-password">
									数量<span class="text-danger">*</span>
								</label>
								<div class="col-md-4">
									<input type="text" name="comment" class="form-control">
									<span class="help-block"></span>
								</div>
								
							<div class="form-group form-actions">
								<div class="col-md-1 col-md-offset-0"
									style="margin-left: 300px;">
									<button type="submit" id="addStudentBtn"
										class="btn btn-block btn-primary">添加</button>
								</div>
								<div class="col-md-1 col-md-offset-0" style="margin-left: 80px;">
									<button type="reset" id="addStudentBtn"
										class="btn btn-block btn-primary">重置</button>
								</div>
							</div>
								
							</div>
						
						

							
							<input type="hidden" name="state" value="1">

						

						</form>

					<script type="text/javascript">
$(function() {  //全部代码加载完毕进行初始化
	
	// 初始化省市区
	initMark();
	initKind();

});

function initMark() {

	var firstProvCode;
	// ajax请求所有省份
	$.get("mark_and_kind", {
		method : "initMark"
			}, function(data) {
					$.each(data, function(i, d) {
						$("select[name='mark']").append(
							"<option value='"+d.car_mark+"'>" + d.car_mark	
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
	
function initKind() {

	var firstProvCode;
	// ajax请求所有省份
	$.get("mark_and_kind", {
		method : "initKind"
			}, function(data) {
					$.each(data, function(i, d) {
						$("select[name='kind']").append(
							"<option value='"+d.kind_name+"'>" + d.kind_name
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
</body>
</html>