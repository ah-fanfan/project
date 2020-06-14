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
			class="fa fa-cube"></i> <span class="sidebar-nav-mini-hide"><Strong>${admin.ad_code }
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
						class="sidebar-nav-mini-hide">技工信息管理</span>
				</a>
					<ul>
						<li><a href="<%=basePath%>beanclass/normal/employeeAdd.jsp">技工信息添加</a>
						</li>
						<li><a href="EmployeeQueryServlet">技工信息查询</a></li>
						<li><a href="EmployeeQueryServlet">技工信息修改</a></li>
						<li><a href="EmployeeQueryServlet">技工信息删除</a></li>
					</ul></li>
				<li><a href="#" class="sidebar-nav-menu"> <i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">用户信息管理</span>
				</a>
					<ul>
						<li><a href="UserQueryServlet">用户信息查询</a></li>
						<li><a href="UserQueryServlet">用户信息修改</a></li>
						<li><a href="UserQueryServlet">用户信息删除</a></li>
					</ul></li>
				<li><a href="#" class="sidebar-nav-menu"> <i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">试驾信息管理</span>
				</a>
					<ul>
						<li><a href="<%=basePath%>beanclass/normal/testAdd.jsp">预约试驾</a>
						</li>
						<li><a href="TestQueryServlet">试驾信息查询</a></li>
						<li><a href="TestQueryServlet">试驾信息修改</a></li>
						<li><a href="TestQueryServlet">试驾信息删除</a></li>
					</ul></li>
				<li><a href="#" class="sidebar-nav-menu"> <i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">售车信息管理</span>
				</a>
					<ul>
						<li><a href="<%=basePath%>beanclass/normal/orderAdd.jsp">新增售车订单</a>
						</li>
						<li><a href="OrderQueryServlet?id=管理员">售车订单查询</a></li>
						<li><a href="OrderQueryServletid=管理员">售车订单删除</a></li>
					</ul></li>

				<li><a href="#" class="sidebar-nav-menu"> <i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">我的业绩</span>
				</a>
					<ul>
						<li><a href="<%=basePath%>views/modeldialog/model_dialog.jsp">售车统计</a>
						</li>
						<li><a href="<%=basePath%>views/modeldialog/model_dialog.jsp">工资明细</a>
						</li>
					</ul></li>
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
			<small>2020 &copy;凡运汽车销售有限公司</small>
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