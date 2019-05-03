<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %> 
<div id="container">  
	<div>
		<ul class="items-order">
		  <li class="item-order">Đăng ký tài khoản
		  <span class="icon-chevron-right icon-large" style=" font-size: 20px; color: #ff9900;position: absolute;top: 10px;left: 378px;"></span></li>
		  <li class="item-order">Thanh toán
		  <span class="icon-chevron-right icon-large" style=" font-size: 20px; color: #adadad;position: absolute;top: 10px;left: 378px;"></span></li>
		  <li class="item-order" style="background-color: #adadad;margin-right:0">Hoàn thành</li>
		</ul>
	</div>
	<div class = "thaoluan"></div>
	
	  <form action="${pageContext.request.contextPath}/${nameKH}-${kid }/dangky/step3" method="post" style="background-color: whitesmoke;">
	  	<p class="title-order">Chọn phương thức thanh toán</p>
		<input class="input-tt" type="radio" name="id_ThanhToan" value="1" checked/> <span class="thanhtoan"> Thanh toán trực tiếp</span>
           <input class="input-tt" type="radio" name="id_ThanhToan" value="2"/> <span class="thanhtoan"> Chuyển khoản Ngân hàng</span>
           <input class="input-tt" type="radio" name="id_ThanhToan" value="3"/> <span class="thanhtoan"> Paypal</span>
	  
	<div>
		<div class="noidung-tt">
			<p style="text-align:center; padding: 15px 0;border-bottom: 1px solid;"><span class="icon-tag icon-large"></span>  Mô tả</p>
			<p style="padding-bottom: 20px"> Học viên lựa chọn thanh toán trực tiếp sẽ đến công ty và thanh toán với bộ phận nhân sự.
			Khóa học sẽ được kích hoạt sau khi bạn thanh toán.<br>
				Địa chỉ công ty: 31 Trần Phú, Quận Hải Châu, Thành phố Đà Nẵng, Việt Nam
			</p>
		</div>
		<div class="noidung-tt" style="position: absolute;left: 473px; width: 25%;">
			<p style="text-align:center; padding: 15px 0;border-bottom: 1px solid;"><span class="icon-tag icon-large"></span>  Mô tả</p>
			<p style="padding-bottom: 20px">
				Khóa học sẽ được kích hoạt sau khi quản trị viên kiểm tra tài khoản và xác nhận việc thanh toán của bạn thành công. (Thời gian kiểm tra và xác nhận tài khoản ít nhất là 12 giờ) <br>
				Bạn có thể đến bất kỳ ngân hàng nào ở Việt Nam (hoặc sử dụng Internet Banking) để chuyển tiền theo thông tin bên dưới:<br>
				• Số tài khoản: 0011 1199 08009.<br>
				• Chủ tài khoản: Công ty TNHH MTV Tư Vấn Giải pháp Công nghệ Thông tin Toàn Cầu Xanh.<br>
				• Ngân hàng: Ngân hàng Đông Á, Ngũ Hành Sơn, Thành phố Đà Nẵng./br>
				Ghi chú khi chuyển khoản:<br>
				• Tại mục "Ghi chú" khi chuyển khoản, bạn ghi rõ: Số điện thoại - Họ và tên - Email đăng ký học - Tên khóa học.<br>
				• Ví dụ: 0909090909 - Hoang Thi Cam Tu - camtu.qn24@gmail.com - JAVA TU A - Z<br>
			</p>
		</div>
		<div class="noidung-tt" style="position: absolute;left: 874px; width: 25%">
			<p style="text-align:center; padding: 15px 0;border-bottom: 1px solid;"><span class="icon-tag icon-large"></span>  Mô tả</p>
			<p style="padding-bottom: 20px">Khóa học sẽ được kích hoạt sau khi quản trị viên kiểm tra tài khoản và xác nhận việc thanh toán của bạn thành công.
			 (Thời gian kiểm tra và xác nhận tài khoản ít nhất là 12 giờ) <br>
			 Click chọn biểu tượng bên dưới để tiến hành thanh toán.
			 </p>
			<div id="paypal-button-container"></div>
		</div>
	</div>

	<p class="title-order">Thông tin mua hàng</p>
	<div style="width: 60%;    margin: auto;">
		<table border="1">
			 <tr class="">
			  <td> Họ và Tên</td>
			  <td>${userInfo.hoTen }${TTDK.hoTen }</td>
			</tr>
			<tr class="">
			  <td> Tên đăng nhập</td>
			  <td>${userInfo.username }${TTDK.username }</td>
			</tr>
			<tr class="">
			  <td> Email</td>
			  <td>${userInfo.email }${TTDK.email }</td>
			</tr>
			<tr class="">
			  <td> Số điện thoại</td>
			  <td>${userInfo.sdt }${TTDK.sdt }</td>
			</tr>
			<tr class="">
			  <td> Địa chỉ</td>
			  <td>${userInfo.diaChi }${TTDK.diaChi }</td>
			</tr>
		</table>
	</div>
	
	<p class="title-order">Thông tin khóa học</p>
	<div style="width: 60%;    margin: auto;">
		
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
			<tr class="">
			  <td> Học phí</td>
			  <td>${course.hocPhi }</td>
			</tr>
		</table>
	</div>
	
	<input style="margin: 30px 0 0px 513px;" class="button medium gradient orange" type="submit" value="Hoàn thành >>>"></input>
	</form>
	<script>
	  paypal.Buttons({
	    createOrder: function(data, actions) {
	      // Set up the transaction
	     // var priceVND = ${course.hocPhi};
	      var priceUSD = ${priceUSD}
	      console.log({ 'data': priceUSD });
	      return actions.order.create({
	        purchase_units: [{
	          amount: {
	            value: priceUSD
	          }
	        }]
	      });
	    }
	  }).render('#paypal-button-container');
	</script>
</div>