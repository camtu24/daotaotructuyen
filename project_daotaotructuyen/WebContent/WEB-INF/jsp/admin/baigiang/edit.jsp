<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/${cid }/lessons" class="tip-bottom">Bài giảng</a> <a href="#" class="current">Thêm bài giảng</a>
		</div>
		<h1>Bài giảng</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Thêm bài giảng</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/${cid }/lessons">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form  action="" role="form" method="POST" enctype='multipart/form-data'>
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="form-group">
                            <label>Tên bài giảng</label>
                            <input class="form-control" name="tenBaiHoc" value="${lesson.tenBaiHoc }" style="height: 23px" required> 
                            <p style="color:red">${msg1 }</p>
                            <form:errors path="lesson.tenBaiHoc" cssStyle="color:red"></form:errors>       
                        </div>
                        
                        <div class="col-md4">
	                        <div class="form-group">
	                            <label>Mô tả</label>
	                            <textarea name="moTa" style="height: 140px;width:72%" rows="3" required>${lesson.moTa }</textarea>
	                        </div>
                        </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Video</label>
		                        <c:if test="${not empty lesson.video }">
			                        <video width="200" height="150"  controls>
									<source src="${pageContext.request.contextPath }/files/${lesson.video}" type="video/mp4">
									<!-- Trình duyệt của bạn không hỗ trợ thẻ video trong HTML5. -->
									</video>
							   	</c:if>
		                        <c:if test="${empty lesson.video }">
	                           	<img src="${defines.urlAdmin}/img/images-video.png" alt="video" style = "width: 200px;height:150px">
							   	</c:if>
							   	
							   	<input type="file" name="video" class="form-control border-input" >
		                    </div>
		                </div>
                        
                        <div class="form-group" style="width:100%">
                            <label>Nội dung</label>
                            <textarea name="chiTiet" class="ckeditor" style="height: 23px" rows="3">${lesson.chiTiet }</textarea>
                            <p style="color:red">${msg1 }</p>
                            <form:errors path="lesson.chiTiet" cssStyle="color:red"></form:errors>       
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

