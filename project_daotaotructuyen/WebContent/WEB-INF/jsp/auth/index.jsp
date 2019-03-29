<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- <%@include file="/templates/admin/inc/header.jsp"%>

<%@include file="/templates/admin/inc/left_bar.jsp"%> --%>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
		</div>
	</div>
	<!--Action boxes-->
	  <div class="container-fluid">
	    <div class="quick-actions_homepage">
	      <ul class="quick-actions">
	        <li class="bg_lb"> <a href="<%=request.getContextPath()%>/admin/cats"> <i class="icon-dashboard"></i> Danh mục </a> </li>
	        <li class="bg_lg span3"> <a href="<%=request.getContextPath()%>/admin/news"> <i class="icon-comment-alt"></i> Bài viết</a> </li>
	        <li class="bg_ly"> <a href="<%=request.getContextPath()%>/admin/comments"> <i class="icon-comment-alt"></i> Bình luận </a> </li>
	        <li class="bg_lo"> <a href="<%=request.getContextPath()%>/admin/users"> <i class="icon-user-md"></i> Quản trị viên</a> </li>
	        <li class="bg_ls"> <a href="<%=request.getContextPath()%>/admin/advs"> <i class="icon-money"></i> Quảng cáo</a> </li>
	      </ul>
	    </div>
	  </div>
<!--End-Action boxes-->  
</div>

<%-- <%@include file="/templates/admin/inc/footer.jsp"%> --%>