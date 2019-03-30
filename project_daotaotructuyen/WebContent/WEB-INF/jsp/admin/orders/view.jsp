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
                        <div>
                        	<h4>Thông tin người mua</h4>
                        </div>
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Họ tên</label>
		                        <input type="text" disabled="disabled" value="${order.hoTen }" class="form-control border-input" placeholder="Nhập họ tên">
                            	<form:errors path="student.hoTen" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Tên đăng nhập</label>
		                        <input type="text" name="" value="${order.username }" disabled="disabled" class="form-control border-input" placeholder="Tên đăng nhập">
                            	<form:errors path="student.username" cssStyle="color:red"></form:errors>
		                    </div>
		                </div> 
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Số điện thoại</label>
		                        <input type="text" disabled="disabled" value="${order.sdt }" class="form-control border-input" placeholder="Tên đăng nhập">
                            	<form:errors path="student.password" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Email</label>
		                        <input type="email" disabled="disabled" value="" class="form-control border-input" placeholder="Tên đăng nhập">
                            	<form:errors path="student.email" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Địa chỉ</label>
		                        <input type="text" disabled="disabled" value="${order.diaChi }" class="form-control border-input" placeholder="Tên đăng nhập">
                            	<form:errors path="student.diaChi" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Ngày đăng ký</label>
		                        <input type="date" disabled="disabled" value="${order.ngayDangKy }" class="form-control border-input" placeholder="Tên đăng nhập">
		                    </div>
		                </div>
		                <hr>
		                
		                <div>
                        	<h4>Thông tin khoá học</h4>
                        </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Tên khóa học</label>
		                        <input type="text" disabled="disabled" value="${course.tenKhoaHoc }" class="form-control border-input" placeholder="Nhập họ tên">
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mô tả</label>
		                        <input type="text" disabled="disabled" value="${course.mieuTa }" class="form-control border-input" placeholder="Tên đăng nhập">
		                    </div>
		                </div>
		                
		                <%-- <div class="col-md4">
		                    <div class="form-group" style="width:72%">
		                        <label>Chủ đề</label>
		                        <select name="id_ChuDe" disabled="disabled" class="form-control" style="width: 100%">
	                           		<c:forEach items="${listS }" var="Subj">
	                                   <option value="${Subj.id_ChuDe}">${Subj.tenChuDe }</option>
	                                </c:forEach>
		                        </select>
		                    </div>
		                </div> --%>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Học phí</label>
		                        <input type="text" disabled="disabled" value="${course.hocPhi }" class="form-control border-input" placeholder="Tên đăng nhập">
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Hình ảnh</label>
		                        
		                        <c:if test="${not empty course.hinhAnh }">
	                           	<img src="${pageContext.request.contextPath }/files/${course.hinhAnh}" alt="hinhanh" style = "width: 200px;height:150px">
							   	</c:if>
							   	<c:if test="${empty course.hinhAnh }">
	                           	<img src="${defines.urlAdmin}/img/images.jpg" alt="hinhanh" style = "width: 200px;height:150px">
							   	</c:if>
		                        <input disabled="disabled" type="file" name="hinhAnh" class="form-control border-input" >
		                        
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mục tiêu</label>
		                        <input type="text" disabled="disabled" value="${course.mucTieu}" class="form-control border-input" placeholder="Tên đăng nhập">
		                    </div>
		                </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Kết quả</label>
		                        <input type="text" disabled="disabled" value="${course.ketQua}" class="form-control border-input" placeholder="Tên đăng nhập">
		                    </div>
		                </div>
                    
                    </form>
				</div>
			</div>
		</div>
	</div>
</div>

