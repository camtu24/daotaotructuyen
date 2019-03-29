<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Tour du lịch</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/bootstrap.min.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/matrix-login.css" />
<link href="${defines.urlAdmin }/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
<%-- <script src="${defines.urlAdmin }/js/jquery-3.2.1.min.js"></script>
<script src="${defines.urlAdmin }/js/jquery.validate.min.js"></script> --%>

</head>
<body>

	<div id="loginbox">
		<form id="loginform" class="form-vertical" action="${pageContext.request.contextPath}/admin/auth/login" method="post">
			<div class="control-group normal_text">
				<h3>
					<img src="${defines.urlAdmin }/img/logo1.png" alt="Logo" />
				</h3>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_lg"><i class="icon-user"></i></span>
						<input type="text" name="username" value="" placeholder="Username" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_ly"><i class="icon-lock"></i></span>
						<input type="password" name="password" value="" placeholder="Password" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<input class="submit-login" name="submit" type="submit" value="Đăng nhập" /> 
			</div>
		</form>
	</div>

<%-- <script src="<%=request.getContextPath()%>/templates/admin/js/jquery.min.js"></script> --%>
<script src="${defines.urlAdmin }/js/matrix.login.js"></script>
</body>
</html>
