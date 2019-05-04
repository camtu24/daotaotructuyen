<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="javascript:history.go(-1)" class="tip-bottom">Quản lý học viên</a> <a href="#" class="current">Cập nhật đánh giá</a>
		</div>
		<h1>Quản lý học viên</h1>
	</div>
	<div class="container-fluid"><hr>
	<c:if test="${not empty msg }">
		<script type="text/javascript">
			var msg = ${msg };
			alert(msg);
		</script>
	      <div class="alert alert-success">
			<strong>${msg }</strong>
		  </div>
	  </c:if>
		<div class="header">
			<h4 class="title">Cập nhật đánh giá</h4>
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
		                        <label>Họ tên học viên</label>
		                        <input type="text" name="hoTen" value="${infoStu.hoTen }" class="form-control border-input" disabled>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Tên khóa học</label>
		                        <input type="text" name="tenKhoaHoc" value="${sa.tenKhoaHoc }" disabled="disabled" class="form-control border-input">
		                    </div>
		                </div> 
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Ngày ghi danh</label>
		                        <input type="text" name="ngayGhiDanh" value="${sa.ngayGhiDanh }" disabled="disabled" class="form-control border-input">
		                    </div>
		                </div> 
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mức độ hoàn thành</label>
		                        <input type="text" name="mucDoHoanThanh" value="${sa.mucDoHoanThanh }%" class="form-control border-input" disabled>
                            	<form:errors path="student.password" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Điểm trung bình</label>
		                        <input type="text" name="diemTrungBinh" value="${sa.diemTrungBinh }" class="form-control border-input" disabled>
                            	<form:errors path="student.sdt" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
                        
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Số bài đã học</label>
		                        <input type="text" name="tongBaiHoc" value="${sa.tongBaiHoc }" disabled class="form-control border-input">
		                    </div>
		                </div>
		                
		                <div class="form-group">
                            <label>Đánh giá</label>
                            <textarea name="danhGia" style="height: 100px; width:86%" placeholder="Nhập đánh giá học viên">${sa.danhGia }</textarea>
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

