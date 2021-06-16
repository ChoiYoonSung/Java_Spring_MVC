<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<title>Sign In</title>
<%@ include file="/WEB-INF/views/include/style.jsp" %>
</head>
<body  class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>Administrator Sign In</b></a>
		</div>
		<!-- /.login-logo -->
		<div class="card">
		 <div class="card-body login-card-body">
			<p class="login-box-msg">Sign in to start your session</p>
			<form action="<%=request.getContextPath() %>/common/login.do"	method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="id" placeholder="Enter ID." value="<%-- ${pastID } --%>test">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="pwd" placeholder="Enter Password."  value="test">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-sm-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox" name="rememberMe" value="check"> Remember Me
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-sm-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
					</div>
					<!-- /.col -->
				</div>
			</form>
			<a href="#" style="font-weight:bold;">Find ID/Password</a><br> 
		</div>
		<!-- /.login-box-body -->
	  </div>	
	</div>
	<!-- /.login-box -->
	<script>
		if('${msg}') alert('${msg}');
	</script>
<%@ include file="/WEB-INF/views/include/js.jsp" %>
</body>
</html>