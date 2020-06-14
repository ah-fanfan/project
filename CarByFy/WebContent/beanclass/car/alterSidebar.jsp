<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<script type="text/javascript" src="<%=basePath%>js/validate.js"></script>
<!-- head end -->
<script type="text/javascript">
      $(function(){
    	  $("#modifyPassword").click(function(){
    		  
    		var newPsaaWord=  $(".newPsaaWord").val();
    		var confirmPassWord=  $(".confirmPassWord").val();
    		  
    		  if(newPsaaWord!=confirmPassWord){
    			  var d = dialog({
  					title : '系统提示：',
  					content : '新密码和确认密码不一致',
  					width : '220',
  				});
  				d.show();
    			return false;
    		  }
    		  if(newPsaaWord.isNull()){
    			  var d = dialog({
    					title : '系统提示：',
    					content : '密码字段不能为空',
    					width : '220',
    				});
    				d.show();
    			  return false;
    		  }
    		  if(! newPsaaWord.validateLetter()){
    			  var d = dialog({
  					title : '系统提示：',
  					content : '密码组成不合法，密码只包含数字和字母',
  					width : '220',
  				});
  				d.show();
    			  return false;
    		  }
    		  if(! newPsaaWord.varLen(6,15)){
    			  var d = dialog({
  					title : '系统提示：',
  					content : '密码长度必须是6~15位',
  					width : '220',
  				});
  				d.show();
    			  return false;
    		  }
    		  $("#modityPassword").submit();
    		  return false;
    	  });
    	  return false;
      });
</script>
<div id="sidebar-alt" tabindex="-1" aria-hidden="true">
	<!-- Toggle Alternative Sidebar Button (visible only in static layout) -->
	<a href="<%=basePath%>javascript:void(0)" id="sidebar-alt-close"
		onclick="App.sidebar('toggle-sidebar-alt');"><i
		class="fa fa-times"></i> </a>

	<!-- Wrapper for scrolling functionality -->
	<div id="sidebar-scroll-alt">
		<!-- Sidebar Content -->
		<div class="sidebar-content">
			<!-- Profile -->
			<div class="sidebar-section">
				<h2 class="text-light" onclick="App.sidebar('close-sidebar-alt');">
					密码设置
				</h2>
				<form action="<%=basePath%>account/password" method="post" id="modityPassword"
					class="form-control-borderless" >
					<div class="form-group">
						<label for="side-profile-name">
							账户
						</label>
						<input type="text" id="side-profile-name" name="account"
							class="form-control account" value="${sessionScope.account.accountName }" disabled="disabled">
					</div>
					<div class="form-group">
						<label for="side-profile-password">
							新密码
						</label>
						<input type="password" id="side-profile-password"
							name="newPsaaWord" class="form-control newPsaaWord" >
					</div>
					<div class="form-group">
						<label for="side-profile-password-confirm">
							确认密码
						</label>
						<input type="password" id="side-profile-password-confirm"
							name="password" class="form-control confirmPassWord">
					</div>
					<div class="form-group remove-margin">
						<button id="modifyPassword"  class="btn btn-effect-ripple btn-primary">
							保 存
						</button>&nbsp;&nbsp;
						 <button class="btn btn-default"
							onclick="App.sidebar('close-sidebar-alt');" type="button">
							折 叠 <i class="fa fa-share"></i>
						</button> 
						
					</div>
				</form>
			</div>
			<!-- END Profile -->

		</div>
		<!-- END Sidebar Content -->
	</div>
	<!-- END Wrapper for scrolling functionality -->
</div>