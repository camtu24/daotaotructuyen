<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/teachers" class="tip-bottom">Giảng viên</a> <a href="#" class="current">Sửa giảng viên</a>
		</div>
		<h1>Giảng Viên</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Sửa giảng viên</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/teachers">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form  action="" role="form" method="POST" enctype='multipart/form-data'>
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Họ tên (*)</label>
		                        <input type="text" name="hoTen" value="${teacher.hoTen }" class="form-control border-input" placeholder="Nhập họ tên" required>
                            	<form:errors path="teacher.hoTen" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Tên đăng nhập (*)</label>
		                        <input type="text" name="username" value="${teacher.username }" class="form-control border-input" disabled="disabled" placeholder="Tên đăng nhập">
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="teacher.username" cssStyle="color:red"></form:errors>
		                    </div>
		                </div> 
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mật khẩu (*)</label>
		                        <input type="password" name="password" value="" class="form-control border-input" placeholder="Nhập mật khẩu">
                            	<form:errors path="student.password" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Số điện thoại (*)</label>
		                        <input type="text" name="sdt" value="${teacher.sdt }" class="form-control border-input" placeholder="Nhập số điện thoại" required>
                            	<form:errors path="teacher.sdt" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Email (*)</label>
		                        <input type="email" name="email" value="${teacher.email }" class="form-control border-input" placeholder="Nhập email" required>
                            	<form:errors path="teacher.email" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Địa chỉ</label>
		                        <input type="text" name="diaChi" value="${teacher.diaChi }" class="form-control border-input" placeholder="Nhập địa chỉ" required>
                            	<form:errors path="teacher.diaChi" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Hình ảnh</label>
		                        <c:if test="${not empty teacher.hinhAnh }">
	                           	<img src="${pageContext.request.contextPath }/files/${teacher.hinhAnh}" alt="${teacher.hinhAnh}" style = "width: 150px;height:110px">
							   	</c:if>
							   	<c:if test="${empty teacher.hinhAnh }">
	                           	<img src="${defines.urlAdmin}/img/user.jpg" alt="hinhanh" style = "width: 150px;height:110px">
							   	</c:if>
		                        <input type="file" name="hinhAnh" class="form-control border-input" >
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Giới tính</label>
		                        <select name="gioiTinh" class="form-control" style="width: 74%">
                                   <c:set var="gioitinh" value="nam"></c:set>
		                       			<c:choose>
		                           			<c:when test="${student.gioiTinh == gioitinh}">
		                           				<c:set var="selectedN" value="selected = 'selected'"></c:set>
			                           		</c:when>
			                           		<c:otherwise>
			                           			<c:set var="selectedNu" value="selected = 'selected'"></c:set>
			                           		</c:otherwise>
		                           		</c:choose>
                                   <option ${selectedN } value="nam">Nam</option>
                                   <option ${selectedNu } value="nu">Nữ</option>
		                        </select>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Ngày sinh</label>
		                        <input type="date" name="ngaySinh" value="${teacher.ngaySinh }" class="form-control border-input" required>
                            	<form:errors path="teacher.ngaySinh" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
			                <div class="form-group">
	                            <label>Chức vụ</label>
	                            <textarea name="chucVu" style="height: 90px;width:72%" required>${teacher.chucVu }</textarea>
	                        </div>
                        </div>
                        
                        <div class="col-md4">
	                        <div class="form-group">
	                            <label>Mô tả</label>
	                            <textarea name="moTaThem" style="height: 90px;width:72%">${teacher.moTaThem }</textarea>
	                        </div>
                        </div>
                        
                        <div class="col-md4">
	                        <div class="form-group">
	                            <label>Bằng cấp</label>
	                            <textarea name="bangCap" style="height: 90px;width:72%" >${teacher.bangCap }</textarea>
	                        </div>
                        </div>
                        
                        <div class="col-md4">
                        <div class="form-group">
                            <label>Chuyên môn chính</label>
                            <textarea name="chuyenMonChinh" style="height: 90px;width:72%" required>${teacher.chuyenMonChinh }</textarea>
                        </div>
                        </div>
                        
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Role</label>
		                        <select name="id_Role" class="form-control" style="width: 74%">
	                           		<c:set var="id_role" value="${teacher.id_Role }"></c:set>
	                           		<c:forEach items="${listRoles }" var="role">
	                           			<c:choose>
		                           			<c:when test="${role.id_Role == id_role}">
		                           				<c:set var="selected" value="selected = 'selected'"></c:set>
			                           		</c:when>
			                           		<c:otherwise>
			                           			<c:set var="selected" value=""></c:set>
			                           		</c:otherwise>
		                           		</c:choose>
	                                   <option ${selected } value="${role.id_Role}">${role.name }</option>
	                                </c:forEach>
		                        </select>
		                    </div>
		                </div>
                    
                        <div class="form-group">
                            <input style="margin-top:90px" type="submit" value="Thực hiện" class="btn btn-primary">
                        </div> 
                    </form>
				</div>
			</div>
		</div>
	</div>
</div>

