<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %> 
<div id="container">  
	<div>
		<ul class="items-order">
		  <li class="item-order">Đăng ký tài khoản
		  <span class="icon-chevron-right icon-large" style=" font-size: 20px; color: #ff9900;position: absolute;top: 10px;left: 378px;"></span></li>
		  <li class="item-order">Thanh toán
		  <span class="icon-chevron-right icon-large" style=" font-size: 20px; color: #ff9900;position: absolute;top: 10px;left: 378px;"></span></li>
		  <li class="item-order" style="margin-right:0">Hoàn thành</li>
		</ul>
	</div>
	<div class="dangkytc">
		<p class="dktc"><span class="icon-check"></span></p>
		<p class="dktc-p">BẠN ĐÃ ĐĂNG KÝ THÀNH CÔNG KHÓA HỌC!</p>
		<p>Bộ phận CSKH sẽ kiểm tra và thông báo đến bạn trong vòng 24h.</p>
		<a style="margin: 30px;" href="${pageContext.request.contextPath}/danhmuckhoahoc" class="button medium gradient grey">Xem thêm khóa học khác >>></a>
	</div>
</div>