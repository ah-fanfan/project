<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<header class="navbar navbar-inverse navbar-fixed-top">
	<!-- Left Header Navigation -->
	<ul class="nav navbar-nav-custom">
		<!-- Main Sidebar Toggle Button -->
		<li><a href="javascript:void(0)"
			onclick="App.sidebar('toggle-sidebar');this.blur();"> <i
				class="fa fa-ellipsis-v fa-fw animation-fadeInRight"
				id="sidebar-toggle-mini"></i> <i
				class="fa fa-bars fa-fw animation-fadeInRight"
				id="sidebar-toggle-full"></i>
		</a></li>
		<!-- END Main Sidebar Toggle Button -->

		<!-- Header Link -->
		<li class="hidden-xs animation-fadeInQuick">
			<a><strong>凡运汽车后台管理系统</strong></a>
		</li>
		<!-- END Header Link -->
	</ul>
	<!-- END Left Header Navigation -->

	<!-- Right Header Navigation -->
	<ul class="nav navbar-nav-custom pull-right">
		<!-- Header Link -->
		<li class="hidden-xs animation-fadeInQuick">
            <a>尊敬的<strong>${admin.ad_name}(超级管理员)，</strong>凡运汽车销售公司欢迎您！</a>
		</li>
		<!-- END Header Link -->

		<!-- User Dropdown -->
		<li class="dropdown">
		<a href="javascript:void(0)" class="dropdown-toggle" data-toggle="dropdown">
			<img src="<%=basePath%>img/placeholders/avatars/avatar9.jpg" alt="avatar">
		</a>
			<ul class="dropdown-menu dropdown-menu-right">
				<li class="dropdown-header"><strong>账号</strong></li>
				<li class="divider">
				<li>
				<li><a href="javascript:void(0)"
					onclick="App.sidebar('toggle-sidebar-alt');"> <i
						class="gi gi-settings fa-fw pull-right"></i> 密码设置
				</a></li>
				<li><a href="<%=basePath%>exist/ExistServlet"> <i
						class="fa fa-power-off fa-fw pull-right"></i> 安全退出
				</a></li>
			</ul></li>
		<!-- END User Dropdown -->
	</ul>
	<!-- END Right Header Navigation -->
</header>