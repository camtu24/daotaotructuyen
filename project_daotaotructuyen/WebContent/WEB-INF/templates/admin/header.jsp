<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<title>Quản trị hệ thống</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/bootstrap.min.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/uniform.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/select2.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/matrix-style.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/matrix-media.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/fullcalendar.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/jquery.gritter.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/colorpicker.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/datepicker.css" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/bootstrap-wysihtml5.css" />
<link href="${defines.urlAdmin }/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="${defines.urlAdmin }/css/jquery.gritter.css" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

<script src="${defines.urlAdmin }/js/jquery.min.js"></script> 
<script src="${defines.urlAdmin }/js/jquery.validate.js"></script>
<script src="${defines.urlAdmin}/js/ckeditor/ckeditor.js"></script>

</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="dashboard.html">Quản trị hệ thống</a></h1>
</div>
<!--close-Header-part--> 


<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
  	<c:if test="${userInfo.username != null }">
    <li  class="dropdown" id="profile-messages" ><a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i>  <span class="text">Welcome ${userInfo.username }</span></a>
      <!-- <ul class="dropdown-menu">
        <li><a href="#"><i class="icon-user"></i> My Profile</a></li>
        <li class="divider"></li>
        <li><a href="#"><i class="icon-check"></i> My Tasks</a></li>
        <li class="divider"></li>
        <li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
      </ul> -->
    </li>
    </c:if>
    <!-- <li class="dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a class="sAdd" title="" href="#"><i class="icon-plus"></i> new message</a></li>
        <li class="divider"></li>
        <li><a class="sInbox" title="" href="#"><i class="icon-envelope"></i> inbox</a></li>
        <li class="divider"></li>
        <li><a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i> outbox</a></li>
        <li class="divider"></li>
        <li><a class="sTrash" title="" href="#"><i class="icon-trash"></i> trash</a></li>
      </ul>
    </li> -->
    <!-- <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li> -->
    <li class=""><a title="" href="${pageContext.request.contextPath}/admin/auth/logout"><i class=" icon-signout"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>
<!--close-top-Header-menu-->
<!--start-top-serch-->
<!-- <div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
</div> -->
<!--close-top-serch-->