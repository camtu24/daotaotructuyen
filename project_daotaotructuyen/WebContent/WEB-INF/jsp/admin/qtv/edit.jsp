<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/qtv" class="tip-bottom">Quản trị viên</a> <a href="#" class="current">Sửa quản trị viên</a>
		</div>
		<h1>Quản Trị Viên</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Sửa quản trị viên</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/qtv">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form  action="" role="form" method="POST" enctype='multipart/form-data'>
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Họ tên (*)</label>
		                        <input type="text" name="hoTen" value="${qtv.hoTen }" class="form-control border-input" placeholder="Nhập họ tên" required>
                            	<form:errors path="qtv.hoTen" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Tên đăng nhập (*)</label>
		                        <input type="text" name="username" value="${qtv.username }" class="form-control border-input" placeholder="Tên đăng nhập" disabled="disabled">
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="qtv.username" cssStyle="color:red"></form:errors>
		                    </div>
		                </div> 
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mật khẩu (*)</label>
		                        <input type="password" name="password" value="" class="form-control border-input" placeholder="Tên đăng nhập" required>
                            	<form:errors path="qtv.password" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Số điện thoại (*)</label>
		                        <input type="text" name="sdt" value="${qtv.sdt }" class="form-control border-input" placeholder="Tên đăng nhập" required>
                            	<form:errors path="qtv.sdt" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Địa chỉ (*)</label>
		                        <input type="text" name="sdt" value="${qtv.diaChi }" class="form-control border-input" placeholder="Tên đăng nhập" required>
                            	<form:errors path="qtv.diaChi" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Email (*)</label>
		                        <input type="email" name="email" value="${qtv.email }" class="form-control border-input" placeholder="Tên đăng nhập" required>
                            	<form:errors path="qtv.email" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Hình ảnh</label>
		                        <c:if test="${not empty qtv.hinhAnh }">
	                           	<img src="${pageContext.request.contextPath }/files/${qtv.hinhAnh}" alt="hinhanh" style = "width: 150px;height:150px">
							   	</c:if>
							   	<c:if test="${empty qtv.hinhAnh }">
	                           	<img src="${defines.urlAdmin}/img/user.jpg" alt="hinhanh" style = "width: 150px;height:150px">
							   	</c:if>
		                        <input type="file" name="hinhAnh" class="form-control border-input" >
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Role</label>
		                        <select name="id_Role" class="form-control" style="width: 100%">
		                        <c:set var="id_role" value="${qtv.id_Role }"></c:set>
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
                            <input type="submit" value="Thực hiện" class="btn btn-primary">
                        </div> 
                    </form>
				</div>
			</div>
		</div>
	</div>
</div>

