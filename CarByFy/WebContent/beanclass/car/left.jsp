<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div id="sidebar">
	<!-- logo -->
	<div id="sidebar-brand" class="themed-background">
		<a href="javascript:void(0)" class="sidebar-title"> <i
			class="fa fa-cube"></i> <span class="sidebar-nav-mini-hide"><Strong>超级管理员
			</Strong> </span>
		</a>
	</div>
	<!-- END logo-->

	<!-- Wrapper for scrolling functionality -->
	<div id="sidebar-scroll">
		<!-- Sidebar Content -->
		<div class="sidebar-content">
			<!-- Sidebar Navigation -->
			<!-- 菜单开始 -->
			<ul class="sidebar-nav">
				<%-- <li>
					<a href="#" class="sidebar-nav-menu">
						<i class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="fa fa-cogs sidebar-nav-icon"></i>
						<span class="sidebar-nav-mini-hide">系统管理</span>
					</a>
					<ul>
						<li>
							<a href="<%=basePath%>account/account">账户管理</a>
						</li>
						<li>
							<a href="<%=basePath%>group/group">用户组管理</a>
						</li>
						<li>
							<a href="<%=basePath%>authority/authority">权限管理</a>
						</li>
					</ul>
				</li> --%>
				
	
				
				<li><a href="#" class="sidebar-nav-menu"> <i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">车店信息管理</span>
				</a>
					<ul>
						<li><a href="<%=basePath%>beanclass/car/shopAdd.jsp">新增车店信息</a>
						</li>
						<li><a href="ShopQueryServlet">车店信息查询</a>
						</li>
						<li><a href="ShopQueryServlet">车店信息修改</a>
						</li>
						<li><a href="ShopQueryServlet">删除车店信息</a>
						</li>
					</ul></li>
				<li><a href="#" class="sidebar-nav-menu"> <i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">管理员信息管理</span>
				</a>
					<ul>
						<li><a href="<%=basePath%>beanclass/normal_admin/normalAdd.jsp">管理员入职</a>
						</li>
						<li><a href="NormalQueryServlet">管理员信息查询</a>
						</li>
						<li><a href="NormalQueryServlet">管理员信息修改</a>
						</li>
						<li><a href="NormalQueryServlet">管理员离职</a>
						</li>
					</ul></li>


				<a href="#" class="sidebar-nav-menu"> <i
					class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
					<i class="gi gi-user sidebar-nav-icon"></i> <span
					class="sidebar-nav-mini-hide">车型信息管理</span>
				</a>
				<ul>
					<li><a href="<%=basePath%>beanclass/car/carKindAdd.jsp">车型信息添加</a>
					</li>
					<li><a href="CarKindQueryServlet">车型信息查询</a></li>
					<li><a href="CarKindQueryServlet">车型信息修改</a></li>
					<li><a href="CarKindQueryServlet">车型信息删除</a></li>
				</ul>
				</li>
				<li>
				<li><a href="#" class="sidebar-nav-menu"> <i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">车辆品牌信息</span>
				</a>
					<ul>
						<li><a href="<%=basePath%>beanclass/car/carMarkAdd.jsp">车辆品牌添加</a>
						</li>
						<li><a href="CarMarkQueryServlet">车辆品牌查询</a></li>
						<li><a href="CarMarkQueryServlet">车辆品牌修改</a></li>
						<li><a href="CarMarkQueryServlet">车辆品牌出档</a></li>
					</ul></li>


				<a href="#" class="sidebar-nav-menu"> <i
					class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
					<i class="gi gi-user sidebar-nav-icon"></i> <span
					class="sidebar-nav-mini-hide">车辆信息管理</span>
				</a>
				<ul>
					<li><a href="<%=basePath%>beanclass/car/carAdd.jsp">车辆入库</a>
					</li>
					<li><a href="CarQueryServlet">车辆信息查询</a>
					</li>
					<li><a href="CarQueryServlet">车辆信息修改</a>
					</li>
					<li><a href="CarQueryServlet">车辆出库</a>
					</li>
				</ul>
				</li>

				<a href="#" class="sidebar-nav-menu"> <i
					class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
					<i class="gi gi-user sidebar-nav-icon"></i> <span
					class="sidebar-nav-mini-hide">订单信息管理</span>
				</a>
				<ul>
					<li><a href="OrderQueryServlet?id=超级管理员">订单信息查询</a>
					</li>
				</ul>
				</li>


				<a href="#" class="sidebar-nav-menu"> <i
					class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
					<i class="gi gi-user sidebar-nav-icon"></i> <span
					class="sidebar-nav-mini-hide">绩效统计</span>
				</a>
				<ul>
					<li><a href="<%=basePath%>views/modeldialog/model_dialog.jsp">热门车型</a>
					</li>
					<li><a href="<%=basePath%>views/modeldialog/model_dialog.jsp">热门品牌</a>
					</li>
					<li><a href="<%=basePath%>views/modeldialog/model_dialog.jsp">车型销量排行</a>
					</li>
					<li><a href="<%=basePath%>views/modeldialog/model_dialog.jsp">职员业绩查询</a>
					</li>
				</ul>
				</li>
			</ul>
			<!-- 菜单结束 -->
			<!-- END Sidebar Navigation -->
		</div>
		<!-- END Sidebar Content -->
	</div>
	<!-- END Wrapper for scrolling functionality -->

	<!-- Sidebar Extra Info -->
	<div id="sidebar-extra-info"
		class="sidebar-content sidebar-nav-mini-hide">

		<div class="text-left">
			<small>2017 &copy; 凡运汽车销售有限公司</small>
		</div>
	</div>
	<!-- END Sidebar Extra Info -->
</div>
<script>
	$(function() {
		/* 获取cookie中的权限的cookie */
		var id = $.cookie("authority");
		/* 模块权限展开 */
		$("a[id='" + id + "']").attr("class", "active");
		/* 菜单权限显示 */
		$("a[id='" + id + "']").parent().parent().parent().attr("class",
				"active");

		$("a[data-event='authority_li'] , li[data-event='authority_li'] a")
				.bind("click", function() {
					$.cookie("authority", $(this).attr("id"), {
						expires : 10,
						path : '/'
					});
				});

	})
</script>
