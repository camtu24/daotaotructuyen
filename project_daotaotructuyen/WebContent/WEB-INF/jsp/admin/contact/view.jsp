<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/students" class="tip-bottom">Đơn Hàng</a> <a href="#" class="current">Xem Đơn Hàng</a>
		</div>
		<h1>Xem Đơn Hàng</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Xem Đơn Hàng</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="javascript:history.go(-1)">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form  action="" role="form" method="POST">
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Họ tên</label>
		                        <input type="text" disabled="disabled" value="${contact.hoTen }" class="form-control border-input" placeholder="Nhập họ tên">
                            	<form:errors path="student.hoTen" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Số điện thoại</label>
		                        <input type="text" disabled="disabled" value="${contact.SDT }" class="form-control border-input" placeholder="Tên đăng nhập">
                            	<form:errors path="student.password" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Email</label>
		                        <input type="email" disabled="disabled" value="${contact.email }" class="form-control border-input">
                            	<form:errors path="student.email" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Ngày liên hệ</label>
		                        <input type="text" disabled="disabled" value="${contact.ngayLienHe }" class="form-control border-input">
		                    </div>
		                </div>
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Nội dung</label>
		                        <textarea name="noiDung" disabled="disabled" style="height: 90px;width:100%">${contact.noiDung }</textarea>
		                    </div>
		                </div>
                    
                    </form>
				</div>
			</div>
		</div>
	</div>
</div>

