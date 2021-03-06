<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<title>Đào tạo trực tuyến</title>
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
      <h2><a href="index.html"><img alt="Đào trực trực tuyến Green Global" src="${defines.urlPublic }/images/logo-tcx.png"></a></h2>
    </div>
    <div id="header-contact">
    	<div class="login">
			<a href="${pageContext.request.contextPath }/login" target="_blank"><span class="text_login"> <i class="icon icon-off"></i> Login</span></a>
			
			<%-- | <a href="${pageContext.request.contextPath }/auth/login" target="_blank"><span class="text_login"> <i class="icon icon-off"></i> Register</span></a> --%>
		</div>
		
      <ul class="list none" style="color:#ff9900">
        <li><span class="icon-envelope"></span> <a style="color:#ff9900" href="${pageContext.request.contextPath }/contact">contact@greenglobal.vn</a></li>
        <li><span class="icon-phone"></span> (+84) 2363 833 666</li>
      </ul>
    </div>
  </header>
</div>
<!-- ################################################################################################ -->
<div id="navbar" class="wrapper row2">
  <nav id="topnav">
    <ul class="clear">
      <li class="active"><a href="${pageContext.request.contextPath }/" title="Homepage">Homepage</a></li>
      <!-- <li><a href="#" title="Pages">Giới thiệu</a> </li> -->
      <li><a class="drop" href="${pageContext.request.contextPath }/danhmuckhoahoc" title="Categories Course">Danh mục khóa học</a>
        <ul>
        	<c:forEach items="${listS }" var="objS">
        		<c:set value="${pageContext.request.contextPath}/danhmuckhoahoc/${slugUtil.makeSlug(objS.tenChuDe)}-${objS.id_ChuDe }" var="catUrl"></c:set>
        		<li><a href="${catUrl}" title="Buttons">${objS.tenChuDe }</a></li>
        	</c:forEach>
        </ul>
      </li>
      <li><a href="${pageContext.request.contextPath}/teacher" title="Teacher">Giảng viên</a></li>
      <li><a href="${pageContext.request.contextPath}/news" title="News">Tin tức</a></li>
      <li><a href="${pageContext.request.contextPath}/contact" title="Contact">Liên hệ </a></li>
      <li class="last-child">
	      <a href="javascript:void(0)" title="Search" class="openBtn" onclick="openSearch()">
	      	<span class="icon-search icon-large"></span>
	      </a>
	  </li>
      <c:if test="${userInfo.username != null }">
	      <li class="taikhoan" style="float:right">
	      <a class="drop" href="#" style="padding: 14px 0 14px 15px;" title="User"> ${userInfo.username } 
	      	<c:if test="${userInfo.hinhAnh != null }">
	      		<img class="img-taikhoan" src="${pageContext.request.contextPath }/files/${userInfo.hinhAnh }" alt="">
	      	</c:if>
			<c:if test="${userInfo.hinhAnh == null }">
	      		<img class="img-taikhoan" src="${defines.urlPublic }/images/user-cmt.png" alt="">
	      	</c:if>
			</a> 
			<ul>
	          <li><a href="${pageContext.request.contextPath}/mycourses" title="Full Width Gallery">Khóa học của tôi</a></li>
	          <c:if test="${userInfo.id_Role == 3 }">
	          <li><a href="${pageContext.request.contextPath}/myprofile" title="2 Column Grid">Tài khoản cá nhân</a></li>
	          </c:if>
	          <li><a href="${pageContext.request.contextPath }/logout" title="2 Column Grid + Left Sidebar">Đăng xuất</a></li>
	        </ul>
		  </li>
	  </c:if>
    </ul>
  </nav>
  <div id="myOverlay" class="overlay">
	  <span class="closebtn" onclick="closeSearch()" title="Close Overlay">×</span>
	  <div class="overlay-content">
	    <form action="${pageContext.request.contextPath}/search" method="POST">
	      <input type="text" value="${search }" placeholder="Search.." name="search">
	      <button type="submit"><span class="icon-search icon-large"></span></button>
	    </form>
	  </div>
	</div>
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
<script>
function openSearch() {
  document.getElementById("myOverlay").style.display = "block";
}

function closeSearch() {
  document.getElementById("myOverlay").style.display = "none";
}
</script>
<!-- content -->