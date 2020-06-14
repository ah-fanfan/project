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



					<div class="row">
						<div class="col-lg-6  ">
							<a href="#modal-package" class="widget animation-fadeInQuick"
								data-toggle="modal">
								<div class="widget-image widget-image-xs">
									<img src="img/placeholders/photos/body7.jpg" alt="image"
										style="width: 100%; height: 100%;">
									<div class="widget-image-content">
										<div class="pull-right text-light-op">
											<strong>年终大惠</strong>
											<h2 class="widget-heading text-light">
												<strong>广汽本田直营4S店</strong>
											</h2>
											<div class="text-dark push-bit">销量指数</div>
											<div class="text-warning">
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star-half-o"></i>
											</div>
										</div>
									</div>
								</div>

							</a>
						</div>

						<div class="col-lg-6  " style="margin-top: 0px;">
							<a href="#modal-package" class="widget animation-fadeInQuick"
								data-toggle="modal">
								<div class="widget-image widget-image-xs">
									<img src="img/placeholders/photos/body8.jpg" alt="image"
										style="width: 100%; height: 100%;">
									<div class="widget-image-content">
										<div class="pull-right text-light-op">
											<strong>年终大惠</strong>
											<h2 class="widget-heading text-light">
												<strong>广汽本田皓影</strong>
											</h2>
											<div class="text-dark push-bit">销量指数</div>
											<div class="text-warning">
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star-half-o"></i>
											</div>
										</div>
									</div>
								</div>

							</a>
						</div>
					</div>


					<div class="row">
						<div class="col-lg-6  ">
							<a href="#modal-package" class="widget animation-fadeInQuick"
								data-toggle="modal">
								<div class="widget-image widget-image-xs">
									<img src="img/placeholders/photos/body3.jpg" alt="image"
										style="width: 100%; height: 100%;">
									<div class="widget-image-content">
										<div class="pull-right text-light-op">
											<strong>年终大惠</strong>
											<h2 class="widget-heading text-light">
												<strong>广汽本田sport EV</strong>
											</h2>
											<div class="text-dark push-bit">销量指数</div>
											<div class="text-warning">
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star-half-o"></i>
											</div>
										</div>
									</div>
								</div>

							</a>
						</div>

						<div class="col-lg-6  " style="margin-top: 0px;">
							<a href="#modal-package" class="widget animation-fadeInQuick"
								data-toggle="modal">
								<div class="widget-image widget-image-xs">
									<img src="img/placeholders/photos/body4.jpg" alt="image"
										style="width: 100%; height: 100%;">
									<div class="widget-image-content">
										<div class="pull-right text-light-op">
											<strong>年终大惠</strong>
											<h2 class="widget-heading text-light">
												<strong>广汽本田飞度FIT</strong>
											</h2>
											<div class="text-dark push-bit">销量指数</div>
											<div class="text-warning">
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star-half-o"></i>
											</div>
										</div>
									</div>
								</div>

							</a>
						</div>
					</div>




					<div class="row">
						<div class="col-lg-6  " style="margin-top: -20px;">
							<a href="#modal-package" class="widget animation-fadeInQuick"
								data-toggle="modal">
								<div class="widget-image widget-image-xs">
									<img src="img/placeholders/photos/body1.jpg" alt="image"
										style="width: 100%; height: 100%;">
									<div class="widget-image-content">
										<div class="pull-right text-light-op">
											<strong>年终大惠</strong>
											<h2 class="widget-heading text-light">
												<strong>广汽本田奥德赛</strong>
											</h2>
											<div class="text-dark push-bit">销量指数</div>
											<div class="text-warning">
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star-half-o"></i>
											</div>
										</div>
									</div>
								</div>

							</a>
						</div>

						<div class="col-lg-6  " style="margin-top: -20px;">
							<a href="#modal-package" class="widget animation-fadeInQuick"
								data-toggle="modal">
								<div class="widget-image widget-image-xs">
									<img src="img/placeholders/photos/body2.jpg" alt="image"
										style="width: 100%; height: 100%;">
									<div class="widget-image-content">
										<div class="pull-right text-light-op">
											<strong>年终大惠</strong>
											<h2 class="widget-heading text-light">
												<strong>广汽本田冠道</strong>
											</h2>
											<div class="text-dark push-bit">销量指数</div>
											<div class="text-warning">
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star-half-o"></i>
											</div>
										</div>
									</div>
								</div>

							</a>
						</div>
					</div>



					<div class="row">
						<div class="col-lg-6  " style="margin-top: -20px;">
							<a href="#modal-package" class="widget animation-fadeInQuick"
								data-toggle="modal">
								<div class="widget-image widget-image-xs">
									<img src="img/placeholders/photos/body5.jpg" alt="image"
										style="width: 100%; height: 100%;">
									<div class="widget-image-content">
										<div class="pull-right text-light-op">
											<strong>年终大惠</strong>
											<h2 class="widget-heading text-light">
												<strong>广汽本田凌派</strong>
											</h2>
											<div class="text-dark push-bit">销量指数</div>
											<div class="text-warning">
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star-half-o"></i>
											</div>
										</div>
									</div>
								</div>

							</a>
						</div>

						<div class="col-lg-6  " style="margin-top: -20px;">
							<a href="#modal-package" class="widget animation-fadeInQuick"
								data-toggle="modal">
								<div class="widget-image widget-image-xs">
									<img src="img/placeholders/photos/body6.jpg" alt="image"
										style="width: 100%; height: 100%;">
									<div class="widget-image-content">
										<div class="pull-right text-light-op">
											<strong>年终大惠</strong>
											<h2 class="widget-heading text-light">
												<strong>广汽本田缤智</strong>
											</h2>
											<div class="text-dark push-bit">销量指数</div>
											<div class="text-warning">
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star"></i> <i class="fa fa-2x fa-star"></i>
												<i class="fa fa-2x fa-star-half-o"></i>
											</div>
										</div>
									</div>
								</div>

							</a>
						</div>
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

</html>