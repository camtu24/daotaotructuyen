<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/news" class="tip-bottom">Tin tức</a> <a href="#" class="current">Sửa tin tức</a>
		</div>
		<h1>Tin tức</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Sửa tin tức</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/news">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form action="" role="form" method="POST" enctype='multipart/form-data'>
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="row"></div>
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Tên tin</label>
		                        <input type="text" name="tenTin" value="${news.tenTin }" class="form-control border-input" placeholder="Nhập tên tin" required>
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="news.tenTin" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Mô tả</label>
		                        <input type="text" name="moTa" value="${news.moTa }" class="form-control border-input" placeholder="Nhập mô tả" required>
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="news.moTa" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
		                <div class="col-md4">
		                    <div class="form-group">
		                        <label>Hình ảnh</label>
		                        <c:if test="${not empty news.hinhAnh }">
		                           	<img src="${pageContext.request.contextPath }/files/${news.hinhAnh}" alt="hinhanh" style = "width: 200px;height:150px">
								   	</c:if>
								   	<c:if test="${empty news.hinhAnh }">
		                           	<img src="${defines.urlAdmin}/img/images.jpg" alt="hinhanh" style = "width: 200px;height:150px">
							   	</c:if>
		                        <input type="file" name="hinhAnh" class="form-control border-input" >
		                    </div>
		                </div>
		                
		                <div class="col-md4" style="width:100%">
		                    <div class="form-group">
		                        <label>Chi tiết</label>
		                    	<textarea name="chiTiet" class="ckeditor" placeholder="Nhập chi tiết" required>${news.chiTiet }</textarea>
		                    	<p style="color:red">${msg1 }</p>
                            	<form:errors path="news.chiTiet" cssStyle="color:red"></form:errors>
		                    </div>
		                </div>
		                
                        <div class="form-group">
                            <input style="margin-top: 586px;" type="submit" value="Thực hiện" class="btn btn-primary">
                        </div> 
                    </form>
				</div>
			</div>
		</div>
	</div>
</div>

