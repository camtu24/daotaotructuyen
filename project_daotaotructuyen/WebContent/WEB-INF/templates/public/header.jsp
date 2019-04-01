<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<title>RS-1200 Prototype 50</title>
<meta charset="iso-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${defines.urlPublic }/css/main.css" rel="stylesheet" type="text/css" media="all">
<link href="${defines.urlPublic }/css/mediaqueries.css" rel="stylesheet" type="text/css" media="all">
<!--[if lt IE 9]>
<link href="layout/styles/ie/ie8.css" rel="stylesheet" type="text/css" media="all">
<script src="layout/scripts/ie/css3-mediaqueries.min.js"></script>
<script src="layout/scripts/ie/html5shiv.min.js"></script>
<![endif]-->
<!-- Slider -->
<link href="${defines.urlPublic }/css/responsiveslides.css" rel="stylesheet" type="text/css" media="all">
<script src="https://www.paypal.com/sdk/js?client-id=AXQEEMs8T-54WgCddK4fDVct5_XEH57YTvUCmu90maYznMwWScQfnLyxrFUitO0M7j9aMepdLtA5sxCa"></script>
</head>
<body class="">
<div class="wrapper row1">
  <header id="header" class="full_width clear">
    <div id="hgroup">
      <h1><a href="index.html">RS-1200 Prototype 50</a></h1>
      <h2>Free Responsive Template</h2>
    </div>
    <div id="header-contact">
    	<div class="login">
			<a href="${pageContext.request.contextPath }/login" target="_blank"><span class="text_login"> <i class="icon icon-off"></i> Login</span></a>
			
			| <a href="${pageContext.request.contextPath }/auth/login" target="_blank"><span class="text_login"> <i class="icon icon-off"></i> Register</span></a>
		</div>
		
      <ul class="list none">
        <li><span class="icon-envelope"></span> <a href="#">info@domain.com</a></li>
        <li><span class="icon-phone"></span> +xx xxx xxxxxxxxxx</li>
      </ul>
    </div>
  </header>
</div>
<!-- ################################################################################################ -->
<div id="navbar" class="wrapper row2">
  <nav id="topnav">
    <ul class="clear">
      <li class="active"><a href="${pageContext.request.contextPath }/" title="Homepage">Homepage</a></li>
      <li><a href="#" title="Pages">Giới thiệu</a> </li>
      <li><a class="drop" href="${pageContext.request.contextPath }/danhmuckhoahoc" title="Elements">Danh mục khóa học</a>
        <ul>
        	<c:forEach items="${listS }" var="objS">
        		<c:set value="${pageContext.request.contextPath}/danhmuckhoahoc/${slugUtil.makeSlug(objS.tenChuDe)}-${objS.id_ChuDe }" var="catUrl"></c:set>
        		<li><a href="${catUrl}" title="Buttons">${objS.tenChuDe }</a></li>
        	</c:forEach>
        </ul>
      </li>
      <li><a href="#" title="Link Text">Tin tức</a></li>
      <li class="last-child"><a href="${pageContext.request.contextPath}/contact" title="A Very Long Link Text">Liên hệ </a></li>
      <c:if test="${userInfo.username != null }">
	      <li class="taikhoan" style="float:right"><a class="drop" href="#" style="padding: 14px 0 14px 15px;" title="Gallery Layouts"> User 
			<img class="img-taikhoan" src="images/demo/slider/1.jpg" alt=""></a> 
			<ul>
	          <li><a href="${pageContext.request.contextPath}/mycourses" title="Full Width Gallery">Khóa học của tôi</a></li>
	          <li><a href="${pageContext.request.contextPath}/myprofile" title="2 Column Grid">Tài khoản cá nhân</a></li>
	          <li><a href="${pageContext.request.contextPath }/logout" title="2 Column Grid + Left Sidebar">Đăng xuất</a></li>
	        </ul>
		  </li>
	  </c:if>
    </ul>
  </nav>
</div>
<script>
window.onscroll = function() {myFunction()};

var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}
</script>
<!-- content -->