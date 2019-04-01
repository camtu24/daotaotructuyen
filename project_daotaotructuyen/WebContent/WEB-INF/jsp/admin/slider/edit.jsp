<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/course" class="tip-bottom">Khóa học</a> <a href="#" class="current">Sửa khóa học</a>
		</div>
		<h1>Khóa học</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Sửa khóa học</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/courses">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form action="" role="form" method="POST" enctype='multipart/form-data'>
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="row"></div>
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Hình ảnh</label>
		                        
		                        <c:if test="${not empty slider.hinhAnh }">
	                           	<img src="${pageContext.request.contextPath }/files/${slider.hinhAnh}" alt="hinhanh" style = "width: 200px;height:150px">
							   	</c:if>
							   	<c:if test="${empty slider.hinhAnh }">
	                           	<img src="${defines.urlAdmin}/img/images.jpg" alt="hinhanh" style = "width: 200px;height:150px">
							   	</c:if>
		                        <input type="file" name="picture" class="form-control border-input" >
		                        
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mô tả</label>
		                    	<textarea name="moTa" style="height: 150px; width:72%;" rows="5" placeholder="Nhập mô tả">${slider.moTa }</textarea>
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="slider.moTa" cssStyle="color:red"></form:errors>
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

