<%@page import="com.cxsw.web.pojo.CarKind"%>
<%@page import="com.cxsw.web.service.CarKindService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
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
								<span class="hidden-xs">技工信息查询</span>
							</h2>
						</div>
						<form action="EmployeeQueryServlet" id="studentForm" method="post">
							<div class="block-title" style="padding: 7px">
								<div class="input-group">
									<span class="input-group-btn">
										<button type="button" class="btn btn-success"
											style="margin-right: 5px" id="btn_newaccount"
											onclick="window.location='${pageContext.request.contextPath}/beanclass/normal/employeeAdd.jsp'">
											<i class="fa fa-plus"></i> 新增技工信息
										</button>
									</span> <span class="input-group-btn">
										<button name="searchBtn" type="submit"
											class="btn btn-effect-ripple btn-primary">
											<i class="fa fa-search"></i> 搜&nbsp;&nbsp;索
										</button>
									</span> <input type="hidden" name="page" id="page" /> <input
										type="text" name="key" value="${requestScope.key }"
										class="form-control" placeholder="请输入搜索关键字，如：编号、姓名、性别、年龄、地址、备注信息等">
								</div>
							</div>
						</form>
						<!-- Table Styles Content -->
						<div class="table-responsive ">
							<!--
                                Available Table Classes:
                                    'table'             - basic table
                                    'table-bordered'    - table with full borders
                                    'table-borderless'  - table with no borders
                                    'table-striped'     - striped table
                                    'table-condensed'   - table with smaller top and bottom cell padding
                                    'table-hover'       - rows highlighted on mouse hover
                                    'table-vcenter'     - middle align content vertically
                                -->
							<table id="general-table"
								class="table table-striped table-bordered table-hover table-vcenter">
								<thead>
									<tr>
										<th width="5%">编号</th>
										<th width="10%">账号</th>
										<th width="5%">姓名</th>
										<th width="5%">性别</th>
										<th width="5%">年龄</th>
										<th width="5%">部门</th>
										<th width="10%">电话</th>
										<th width="5%">身份证号</th>
										<th width="20%">地址</th>
										<th width="30%">备注</th>
										<th width="10%">状态</th>
										<th width="25%">操作功能</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${employeePage.list}" var="employee">
										<tr>
											<td><strong>${employee.id}</strong></td>
											<td>${employee.emp_code}</td>
											<td>${employee.emp_name}</td>
											<td>${employee.emp_sex}</td>
											<td>${employee.emp_age}</td>
											<td>${employee.emp_dep}</td>
											<td>${employee.emp_phone}</td>
											<td>${employee.emp_idcard}</td>
											<td>${employee.emp_address}</td>
											<td>${employee.comment}</td>
											<c:if test="${employee.state==0 }">
												<td>已离职技工</td>
											</c:if>
											<c:if test="${employee.state==1 }">
												<td>在职技工</td>
											</c:if>
											<td class="text-center"><a
												href="EmployeeByIdServlet?id=${employee.id},修改"
												class="btn btn-primary "> <i class="fa fa-cog"></i>修改
											</a>
                                             <a
												href="EmployeeByIdServlet?id=${employee.id},详情"
												class="btn btn-primary "> <i class="fa fa-cog"></i>详情
											</a>

												<button class="btn btn-primary"
													onclick="return EmployeeDelete (${employee.id})">
													<i class="fa fa-cog"></i> 删除
												</button></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- END Table Styles Content -->
						</div>

						<div class="text-right"
							style="margin-top: 0px; margin-left: -10px">
							<ul class="pagination">
								<li><a style="margin-left: -500px;">第${employeePage.pageNumber}页</a></li>
								<li><a href="javascript:void(0) " onclick="shouye()">首页</a></li>
								<li><a href="javascript:void(0) " onclick="shangyiye()">上一页</a></li>
								<li><a href="javascript:void(0) " onclick="xiayiye()">下一页</a></li>
								<li><a href="javascript:void(0) " onclick="weiye()">尾页</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- END Page Wrapper -->
				<script type="text/javascript">
 function EmployeeDelete(id){
	 if(confirm("确认删除吗") ==true){
         window.location.href="./EmployeeDelServlet?id="+id;
         var d = dialog({
 			title : '系统提示',
 			content : "删除成功！！！"
 		});
 		d.show();
 		setTimeout(function() {
 			d.close().remove();
 		}, 2500);
 		return;
     }else{
         return false;
     }
   }
 function shangyiye(){
	var totalPage = ${employeePage.totalPage};
	var page = ${employeePage.pageNumber};
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
		 window.location.href="./EmployeeQueryServlet?pageNumber="+${employeePage.pageNumber-1}+"&&pageSize=6";
	}
 }
 function xiayiye(){
		var totalPage = ${employeePage.totalPage};
		var page = ${employeePage.pageNumber};
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
			 window.location.href="./EmployeeQueryServlet?pageNumber="+${employeePage.pageNumber+1}+"&&pageSize=6";
		}
	 }
 function shouye(){
		var totalPage = ${employeePage.totalPage};
		var page = ${employeePage.pageNumber};
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
			 window.location.href="./EmployeeQueryServlet?pageNumber=1&&pageSize=6";
		}
	 }
 function weiye(){
		var totalPage = ${employeePage.totalPage};
		var page = ${employeePage.pageNumber};
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
			 window.location.href="./EmployeeQueryServlet?pageNumber="+totalPage+"&&pageSize=6";
		}
	 }
</script>
</body>
</html>