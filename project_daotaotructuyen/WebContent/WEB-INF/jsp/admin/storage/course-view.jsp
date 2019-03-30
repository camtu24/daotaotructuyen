<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/course" class="tip-bottom">Khóa học</a> <a href="#" class="current">Xem khóa học</a>
		</div>
		<h1>Khóa học</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Xem khóa học</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/courses/storage">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form action="" role="form" method="POST">
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="row"></div>
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Tên khóa học (*)</label>
		                        <input type="text" name="tenKhoaHoc" value="${course.tenKhoaHoc }" class="form-control border-input" placeholder="Nhập họ tên">
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Thông tin chung (*)</label>
		                        <input type="text" name="thongTinChung" value="${course.thongTinChung }" class="form-control border-input" placeholder="Tên đăng nhập">
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Chủ đề</label>
		                        <select name="id_ChuDe" class="form-control" style="width: 100%">
	                           		<c:forEach items="${listS }" var="Subj">
	                                   <option value="${Subj.id_ChuDe}">${Subj.tenChuDe }</option>
	                                </c:forEach>
		                        </select>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Học phí (*)</label>
		                        <input type="text" name="hocPhi" value="${course.hocPhi }" class="form-control border-input" placeholder="Tên đăng nhập">
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
		                        <input type="file" name="hinhAnh" class="form-control border-input" >
		                        
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Video</label>
		                        <c:if test="${not empty course.video }">
			                        <video width="200" height="150"  controls>
									<source src="${pageContext.request.contextPath }/files/${course.video}" type="video/mp4">
									<!-- Trình duyệt của bạn không hỗ trợ thẻ video trong HTML5. -->
									</video>
							   	</c:if>
		                        <c:if test="${empty course.video }">
	                           	<img src="${defines.urlAdmin}/img/images-video.png" alt="video" style = "width: 200px;height:150px">
							   	</c:if>
							   	
		                        <input type="file" name="video" class="form-control border-input" >
		                    </div>
		                </div> 
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mục tiêu (*)</label>
		                        <input type="text" name="mucTieu" value="${course.mucTieu }" class="form-control border-input" placeholder="Tên đăng nhập">
		                    </div>
		                </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Kết quả (*)</label>
		                        <input type="text" name="ketQua" value="${course.ketQua }" class="form-control border-input" placeholder="Tên đăng nhập">
		                    </div>
		                </div>
		                
                    </form>
				</div>
			</div>
		</div>
	</div>
</div>

