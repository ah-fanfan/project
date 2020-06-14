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
			class="fa fa-cube"></i> <span class="sidebar-nav-mini-hide"><Strong>${user.user_phone}
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

				<li><a href="CarQueryByUserServlet" class="sidebar-nav-menu">
						<i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">买新车</span>
				</a>
				<ul>
						<li><a href="CarQueryByUserServlet">在售车型</a></li>
						<li><a href="CarBySelectServlet">条件选车</a></li>
						<li><a href="<%=basePath%>beanclass/user/orderAdd.jsp">在线下单</a>
						</li>
					</ul></li>




				<li><a href="#" class="sidebar-nav-menu"> <i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">试驾业务</span>
				</a>
					<ul>
						<li><a
							href="TestByPhoneServlet?user_phone=${ user.user_phone}">查询我的试驾信息</a>
						</li>
						<li><a href="<%=basePath%>beanclass/user/testAdd.jsp">预约试驾</a>
						</li>
						<li><a
							href="TestByPhoneServlet?user_phone=${ user.user_phone}">删除我的试驾信息</a>
						</li>
					</ul></li>

				<li><a href="<%=basePath%>beanclass/user/testAdd.jsp"
					class="sidebar-nav-menu"> <i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">我的订单</span>
				</a>
					<ul>
						<li><a
							href="OrderByIdCardServlet?user_idcard=${user.user_idcard} ">历史订单</a>
						</li>
					</ul> <a href="#" class="sidebar-nav-menu"> <i
						class="fa fa-chevron-left sidebar-nav-indicator sidebar-nav-mini-hide"></i>
						<i class="gi gi-user sidebar-nav-icon"></i> <span
						class="sidebar-nav-mini-hide">统计</span>
				</a>
					<ul>
						<li><a href="CarQueryByUserServlet">热门车型</a>
						</li>
						<li><a href="CarCountServlet?id=${user.user_idcard}">车型销量排行</a>
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
