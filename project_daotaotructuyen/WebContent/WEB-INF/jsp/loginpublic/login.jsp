<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ include file="/templates/taglib.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
    <head>
        <title>Đăng nhập</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="description" content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
        <meta name="keywords" content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript"/>
		<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon"/>
        <link rel="stylesheet" type="text/css" href="${defines.urlPublic }/loginpublic/css/style.css" />
		<script src="${defines.urlPublic }/loginpublic/js/cufon-yui.js" type="text/javascript"></script>
		<script src="${defines.urlPublic }/loginpublic/js/ChunkFive_400.font.js" type="text/javascript"></script>
		<script type="text/javascript">
			Cufon.replace('h1',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h2',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h3',{ textShadow: '1px 1px #000'});
			Cufon.replace('.back');
		</script>
    </head>
    <body>
	    <c:if test="${not empty msg }">
			<script type="text/javascript">alert("${msg}")</script>
		  </c:if>
    
		<div class="wrapper">
			<h1>WELLCOME!!!</h1>
			<h2>Technological progress has merely provided us with more <span>efficient</span> means for going <span>backwards</span>.</h2>
			<!-- <h2>When IT programmed = <span>Google & Stackoverflow, Github, ... & Ctrl + C & Ctrl + V</span></h2>-->
			<div class="content">
				<div id="form_wrapper" class="form_wrapper">
					<form class="login active" action="${pageContext.request.contextPath}/login" method="post">
						<h3>Login</h3>
						<div>
							<label>Username:</label>
							<input type="text" name="username" value="" placeholder="Username" required />
						</div>
						<div>
							<label>Password: <a href="${pageContext.request.contextPath}/forgot" rel="forgot_password" class="forgot linkform">Forgot your password?</a></label>
							<input type="password" name="password" value="" placeholder="******" required />
						</div>
						<div class="bottom">
							<!-- <div class="remember"><input type="checkbox" /><span>Keep me logged in</span></div> -->
							<input type="submit" name="submit" value="Login" />
							<a href="register.html">You don't have an account yet? Register here</a>
							<div class="clear"></div>
						</div>
					</form>
					
				</div>
				<div class="clear"></div>
			</div>
			
		</div>
		

		<!-- The JavaScript -->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>

    </body>
</html>