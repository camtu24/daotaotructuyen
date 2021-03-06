<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/students" class="tip-bottom">Học viên</a> <a href="#" class="current">Thêm học viên</a>
		</div>
		<h1>Học Viên</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Thêm học viên</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/students">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form  action="" role="form" method="POST" enctype='multipart/form-data'>
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Họ tên (*)</label>
		                        <input type="text" name="hoTen" value="${student.hoTen }" class="form-control border-input" placeholder="Nhập họ tên">
                            	<form:errors path="student.hoTen" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Tên đăng nhập (*)</label>
		                        <input type="text" name="username" value="${student.username }" class="form-control border-input" placeholder="Tên đăng nhập">
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="student.username" cssStyle="color:red"></form:errors>
		                    </div>
		                </div> 
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mật khẩu (*)</label>
		                        <input type="password" name="password" value="" class="form-control border-input" placeholder="Tên đăng nhập">
                            	<form:errors path="student.password" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Số điện thoại (*)</label>
		                        <input type="text" name="sdt" value="${student.sdt }" class="form-control border-input" placeholder="Tên đăng nhập">
                            	<form:errors path="student.sdt" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Email (*)</label>
		                        <input type="email" name="email" value="${student.email }" class="form-control border-input" placeholder="Tên đăng nhập">
                            	<form:errors path="student.email" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Địa chỉ</label>
		                        <input type="text" name="diaChi" value="${student.diaChi }" class="form-control border-input" placeholder="Tên đăng nhập">
                            	<form:errors path="student.diaChi" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Hình ảnh</label>
		                        <img src="${defines.urlAdmin}/img/user.png" alt="hinhanh" style = "width: 100px;height:100px">
		                        <input type="file" name="hinhAnh" class="form-control border-input" >
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Giới tính</label>
		                        <select name="gioiTinh" class="form-control" style="width: 74%">
                                   <option value="nam">Nam</option>
                                   <option value="nu">Nữ</option>
		                        </select>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Ngày sinh</label>
		                        <input type="date" name="ngaySinh" value="${student.ngaySinh }" class="form-control border-input" placeholder="Tên đăng nhập">
                            	<form:errors path="student.ngaySinh" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
			                <div class="form-group">
	                            <label>Trình độ học vấn</label>
	                            <textarea name="trinhDoHocVan" style="height: 60px; width: 72%">${student.trinhDoHocVan }</textarea>
	                        </div>
                        </div>
                        
                        <div class="col-md4">
	                        <div class="form-group">
	                            <label>Mô tả</label>
	                            <textarea name="moTaThem" style="height: 60px; width: 72%">${student.moTaThem }</textarea>
	                        </div>
                        </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Nhóm học viên</label>
		                        <select name="id_Plhv" class="form-control" style="width: 74%">
	                           		<c:forEach items="${listH }" var="objH">
	                                   <option value="${objH.id_Plhv}">${objH.loaiHocVien }</option>
	                                </c:forEach>
		                        </select>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Role</label>
		                        <select name="id_Role" class="form-control" style="width: 74%">
	                           		<c:forEach items="${listRoles }" var="role">
	                                   <option value="${role.id_Role}">${role.name }</option>
	                                </c:forEach>
		                        </select>
		                    </div>
		                </div>
                    
                        <div class="form-group">
                            <input type="submit" value="Thực hiện" class="btn btn-primary">
                        </div> 
                    </form>
				</div>
			</div>
		</div>
	</div>
</div>

