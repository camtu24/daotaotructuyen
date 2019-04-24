<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>

<div id="container">  
	<div>
		<ul class="items-order">
		  <li class="item-order">Đăng ký tài khoản
		  <span class="icon-chevron-right icon-large" style=" font-size: 20px; color: #adadad;position: absolute;top: 10px;left: 378px;"></span></li>
		  <li class="item-order" style="background-color: #adadad;">Thanh toán
		  <span class="icon-chevron-right icon-large" style=" font-size: 20px; color: #adadad;position: absolute;top: 10px;left: 378px;"></span></li>
		  <li class="item-order" style="background-color: #adadad;margin-right:0">Hoàn thành</li>
		</ul>
	</div>
	
	<p class="title-order">Đăng ký tài khoản</p>
	<div class="form-dangky">
		<form action="${pageContext.request.contextPath}/${nameKH}-${kid }/dangky/step2" class="login active" method="post">
			<h3 class="h3-dangky"> ĐĂNG KÝ </h3>
			<div class="block-tt">
				<label>Họ và tên (*):</label> 
				<input type="text" name="hoTen" placeholder="Nguyễn Văn A" required/>
			</div>
			
			<div class="block-tt">
				<label>Username (*):</label> 
				<input type="text" name="username" placeholder="anguyen" required/>
				<p style="color:red">${msg1 }</p>
			</div>
			<div class="block-tt">
				<label>Password (*): </label>
				<input type="password" name="password" placeholder="******" required/>
			</div>
			
			<div class="block-tt">
				<label>Email (*):</label> 
				<input type="text" name="email" placeholder="anguyen@gmail.com" required/>
			</div>
			
			<div class="block-tt">
				<label>Số điện thoại (*):</label> 
				<input type="text" name="sdt" placeholder="0123456789" required/>
			</div>
			
			<div class="block-tt">
				<label>Địa chỉ (*):</label> 
				<input type="text" name="diaChi" placeholder="Điện Ngọc - Điện Bàn - Quảng Nam" required/>
			</div>
			<div class="bottom">	
				<input style="margin-left: 165px;" class="button small gradient orange" type="submit" value="Đăng ký"></input>
			</div>
		</form>
	</div>
	
	<p class="title-order">Thông tin khóa học</p>
	<div style="width: 60%; margin: auto;">
		<table border="1">
			 <tr class="">
			  <td> Tên khóa học</td>
			  <td>${course.tenKhoaHoc }</td>
			</tr>
			<tr class="">
			  <td> Giảng viên</td>
			  <td>${objS.tenChuDe }</td>
			</tr>
			<tr class="">
			  <td> Số bài học</td>
			  <td>${count }</td>
			</tr>
			<tr class="">
			  <td> Mô tả</td>
			  <td>${course.mieuTa }</td>
			</tr>
		</table>
	</div>
</div>