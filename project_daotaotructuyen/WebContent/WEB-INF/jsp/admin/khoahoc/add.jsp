<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/course" class="tip-bottom">Khóa học</a> <a href="#" class="current">Thêm khóa học</a>
		</div>
		<h1>Khóa học</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Thêm khóa học</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/course">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form action="" role="form" method="POST" enctype='multipart/form-data'>
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="row"></div>
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Tên khóa học (*)</label>
		                        <input type="text" name="tenKhoaHoc" value="${course.tenKhoaHoc }" class="form-control border-input" placeholder="Nhập tên khóa hoc" required>
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="course.tenKhoaHoc" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Chủ đề</label>
		                        <select name="id_ChuDe" class="form-control" style="width: 72%">
	                           		<c:forEach items="${listS }" var="Subj">
	                                   <option value="${Subj.id_ChuDe}">${Subj.tenChuDe }</option>
	                                </c:forEach>
		                        </select>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Học phí (*)</label>
		                        <input type="text" name="hocPhi" value="${course.hocPhi }" class="form-control border-input" placeholder="Nhập học phí" required>
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="course.hocPhi" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Hình ảnh</label>
		                        <img src="${defines.urlAdmin}/img/images.jpg" alt="hinhanh" style = "width: 200px;height:150px">
		                        <input type="file" name="hinhAnh" class="form-control border-input" >
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Video</label>
		                        <img src="${defines.urlAdmin}/img/images-video.png" alt="hinhanh" style = "width: 200px;height:150px">
		                        <input type="file" name="video" class="form-control border-input" >
		                    </div>
		                </div> 
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mục tiêu (*)</label>
		                    	<textarea name="mucTieu" style="height: 90px; width:75%" placeholder="Nhập mục tiêu" required>${course.mucTieu }</textarea>
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="course.mucTieu" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Kết quả (*)</label>
		                        <textarea name="ketQua" style="height: 90px; width:75%" placeholder="Nhập kết quả" required>${course.ketQua }</textarea>
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="course.ketQua" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mô tả (*)</label>
		                        <textarea name="mieuTa" style="height: 90px; width:75%" placeholder="Nhập kết quả" required>${course.mieuTa }</textarea>
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="course.mieuTa" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Đối tượng tham gia (*)</label>
		                        <textarea name="doiTuongThamGia" style="height: 90px; width:75%" placeholder="Nhập kết quả" required>${course.doiTuongThamGia }</textarea>
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="course.doiTuongThamGia" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="accordion" id="collapse-group">
				          <div class="accordion-group widget-box">
				            <div class="accordion-heading">
				              <div class="widget-title"> <a data-parent="#collapse-group" href="#collapseGTwo" data-toggle="collapse"> <span class="icon"><i class="icon-plus-sign"></i></span>
				                <h5>Thêm giảng viên</h5>
				                </a> </div>
				            </div>
				            <div class="collapse accordion-body" id="collapseGTwo">
				              <div class="widget-content">
				              	<c:forEach items="${listGV }" var="objGV">
				              		<input class="input-tt" type="checkbox" name="id_GiangVienT[]" value="${objGV.id_GiangVien }"/> <span class="thanhtoan"> ${objGV.hoTen}</span>
							    </c:forEach>
							  </div>
				            </div>
				          </div>
				        </div>
		                 
		                <div class="col-md4" style="width: 100%;">
		                    <div class="form-group">
		                        <label>Thông tin chung (*)</label>
		                        <textarea name="thongTinChung" style="height: 23px" class="ckeditor" rows="5" placeholder="Nhập thông tin" required>${course.thongTinChung }</textarea>
                            	<form:errors path="course.thongTinChung" cssStyle="color:red"></form:errors>
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

