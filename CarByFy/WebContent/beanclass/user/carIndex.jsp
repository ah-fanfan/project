<%@page import="com.cxsw.web.pojo.Car"%>
<%@page import="com.cxsw.web.service.CarService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<!-- head -->
<jsp:include page="structure/head.jsp"></jsp:include>

<!-- head end -->
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
				<!-- END Header -->
				<!-- Page content正文内容这里开始 -->
				<!-- Page content -->
				<!--
                        Available classes when #page-content-sidebar is used:

                        'inner-sidebar-left'      for a left inner sidebar
                        'inner-sidebar-right'     for a right inner sidebar
                    -->
				

					<div id="page-content" style="padding: 0px; margin-top: 60px;">
						<!--  
                        <img alt="image" src="img/placeholders/photos/body3.jpg"  style="width: 100%">
                          <img alt="image" src="img/placeholders/photos/body1.jpg"  style="width: 100%">
</div>
-->
                     <c:forEach items="${carPage.list}" var="car">
							<div class="col-lg-6" >
								<a href="CarByIdServlet?id=${car.id },详情" class="widget animation-fadeInQuick"
									data-toggle="modal">
									<div class="widget-image widget-image-xs"  style="width: 700px;height: 400px; ">
										<img src="beanclass/${car.outimg }" alt="image"
											style="width: 100%; height: 100%;">
										<div class="widget-image-content"  style="width: 700px;height: 400px; ">
											<div class="pull-right text-light-op">
												<strong>${car.mark}   ${car.name } 外观</strong>
												
												<div class="text-dark push-bit">销量指数</div>
												<div class="text-warning">
													<i class="fa fa-2x fa-star"></i> <i
														class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
													<i class="fa fa-2x fa-star"></i> <i
														class="fa fa-2x fa-star-half-o"></i>
												</div>
												<div style="margin-top: 250px;">
												<h4 class="widget-heading text-light">
													<strong>了解详情</strong>
												</h4>
												</div>
											</div>
										</div>
									</div>

								</a>
							</div>

							<div class="col-lg-6  " style="margin-top: 0px;">
								<a href="CarByIdServlet?id=${car.id },详情" class="widget animation-fadeInQuick"
									data-toggle="modal">
									<div class="widget-image widget-image-xs" style="width: 700px;height: 400px; ">
										<img src="beanclass/${car.inimg }" alt="image"
											style="width: 100%; height: 100%;">
										<div class="widget-image-content" style="width: 700px;height: 400px; ">
											<div class="pull-right text-light-op">
												<strong>${car.mark}   ${car.name } 内饰</strong>
											</div>
											<div style="margin-top: 330px;">
												<h4 class="widget-heading text-light">
													<strong>广汽本田直营4S店</strong>
												</h4>
												</div>
										</div>
									</div>

								</a>
							</div>
			
				</c:forEach>
						<div class="text-right"
							style="margin-top: 0px; margin-left: -10px">
							<ul class="pagination">
								<li><a style="margin-left: -500px;">第${carPage.pageNumber}页</a></li>
								<li><a href="javascript:void(0) " onclick="shouye()">首页</a></li>
								<li><a href="javascript:void(0) " onclick="shangyiye()">上一页</a></li>
								<li><a href="javascript:void(0) " onclick="xiayiye()">下一页</a></li>
								<li><a href="javascript:void(0) " onclick="weiye()">尾页</a></li>
							</ul>
						</div>



			</div>
			<!-- END Page Content -->
			<!-- END Page Content内容到这里结束 -->
			<!-- END Main Container -->
		</div>
		<!-- END Page Container -->
	</div>
	</div>
	<!-- END Page Wrapper -->
</body>
<script type="text/javascript">
function shangyiye(){
	var totalPage = ${carPage.totalPage};
	var page = ${carPage.pageNumber};
	if(page==1){
		var d = dialog({
			title : '系统提示',
			content : "已经是首页了！！！"
		});
		d.show();
		setTimeout(function() {
			d.close().remove();
		}, 2500);
		return;
	}else{
		 window.location.href="./CarQueryByUserServlet?pageNumber="+${carPage.pageNumber-1}+"&&pageSize=6";
	}
 }
 function xiayiye(){
		var totalPage = ${carPage.totalPage};
		var page = ${carPage.pageNumber};
		if(page== totalPage){
			var d = dialog({
				title : '系统提示',
				content : "已经是尾页了！！！"
			});
			d.show();
			setTimeout(function() {
				d.close().remove();
			}, 2500);
			return;
		}else{
			 window.location.href="./CarQueryByUserServlet?pageNumber="+${carPage.pageNumber+1}+"&&pageSize=6";
		}
	 }
 function shouye(){
		var totalPage = ${carPage.totalPage};
		var page = ${carPage.pageNumber};
		if(page== 1){
			var d = dialog({
				title : '系统提示',
				content : "已经是首页了！！！"
			});
			d.show();
			setTimeout(function() {
				d.close().remove();
			}, 2500);
			return;
		}else{
			 window.location.href="./CarQueryByUserServlet?pageNumber=1&&pageSize=6";
		}
	 }
 function weiye(){
		var totalPage = ${carPage.totalPage};
		var page = ${carPage.pageNumber};
		if(page== totalPage){
			var d = dialog({
				title : '系统提示',
				content : "已经是尾页了！！！"
			});
			d.show();
			setTimeout(function() {
				d.close().remove();
			}, 2500);
			return;
		}else{
			 window.location.href="./CarQueryByUserServlet?pageNumber="+totalPage+"&&pageSize=6";
		}
	 }
</script>

</html>