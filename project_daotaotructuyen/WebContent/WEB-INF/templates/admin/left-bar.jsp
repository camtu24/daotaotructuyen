<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %> 
<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>
  	<c:if test="${active == 1 }"> <c:set var="a1" value="active"></c:set> </c:if>
    <li class="${a1 }"><a href="${pageContext.request.contextPath }/admin"><i class="icon icon-home"></i> <span>Trang chủ</span></a> </li>
    <c:if test="${active == 2 }"> <c:set var="a2" value="active"></c:set> </c:if>
    <li class="${a2 }"><a href="${pageContext.request.contextPath }/admin/orders"><i class="icon icon-list-alt"></i> <span>Đơn hàng</span><span class="label label-important" style="height:17px">${countOrder }</span></a></li>
    <c:if test="${active == 9 }"> <c:set var="a9" value="active"></c:set> </c:if>
    <li class="${a9 } submenu"> <a href="#"><i class="icon icon-group"></i> <span>Quản lý tài khoản</span> <i class="icon-caret-down" style="margin-left: 25px;"></i></a>
      <ul>
        <li><a href="${pageContext.request.contextPath }/admin/qtv">Quản trị viên</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/teachers">Giảng viên</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/students">Học viên</a></li>
      </ul>
    </li>
    <c:if test="${active == 3 }"> <c:set var="a3" value="active"></c:set> </c:if>
    <li class="submenu ${a3 }"> <a href="#"><i class="icon icon-th-list"></i> <span>Quản lý khóa học</span> <i class="icon-caret-down" style="margin-left: 25px;"></i></a>
      <ul>
        <li><a href="${pageContext.request.contextPath }/admin/subjects">Chủ đề</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/courses">Khóa học</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/class">Lớp học</a></li>
      </ul>
    </li>
    <c:if test="${active == 4 }"> <c:set var="a4" value="active"></c:set> </c:if>
    <li class="${a4 }"><a href="${pageContext.request.contextPath }/admin/management/students"><i class="icon icon-globe"></i> <span>Quản lý học viên</span></a></li>
    <c:if test="${active == 5 }"> <c:set var="a5" value="active"></c:set> </c:if>
    <li class="${a5 }"><a href="${pageContext.request.contextPath }/admin/contacts"><i class="icon icon-envelope-alt"></i> <span>Liên hệ</span> <span class="label label-important" style="height:17px">${countContact }</span></a></li> 
    <c:if test="${active == 6 }"> <c:set var="a6" value="active"></c:set> </c:if>
    <li class="${a6 }"><a href="${pageContext.request.contextPath }/admin/news"><i class="icon icon-globe"></i> <span>Tin tức</span></a></li>
    <c:if test="${active == 7 }"> <c:set var="a7" value="active"></c:set> </c:if>
    <li class="${a7 }"><a href="${pageContext.request.contextPath }/admin/sliders"><i class="icon icon-picture"></i> <span>Slider</span></a></li>
    <c:if test="${active == 8 }"> <c:set var="a8" value="active"></c:set> </c:if>
    <li class="${a8 } submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Thông tin lưu trữ</span> <i class="icon-caret-down" style="margin-left: 25px;"></i></a>
      <ul>
        <li><a href="${pageContext.request.contextPath }/admin/courses/storage">Khóa học</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/orders/storage">Đơn hàng</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/accounts/storage">Tài khoản</a></li>
      </ul>
    </li>

  </ul>
</div>
<!--sidebar-menu-->