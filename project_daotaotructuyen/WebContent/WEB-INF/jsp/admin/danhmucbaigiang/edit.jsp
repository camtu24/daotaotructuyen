<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/course/${kid }/cats" class="tip-bottom">Danh mục bài giảng</a> <a href="#" class="current">Sửa danh mục bài giảng</a>
		</div>
		<h1>Danh mục bài giảng</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Sửa danh mục bài giảng</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/course/${kid }/cats">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form  action="" role="form" method="POST">
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="form-group">
                            <label>Tên danh mục bài giảng</label>
                            <input class="form-control" name="tenDanhMuc" value="${cat.tenDanhMuc }" style="height: 23px"> 
                            <p style="color:red">${msg1 }</p>
                            <form:errors path="cat.tenDanhMuc" cssStyle="color:red"></form:errors>       
                        </div>
                        
                        <div class="form-group">
	                        <label>Level</label>
	                        <select name="id_Level" class="form-control" style="width: 100%">
                           		<c:forEach items="${listL }" var="level">
                                   <option value="${level.id_Level}">${level.level }</option>
                                </c:forEach>
	                        </select>
	                    </div>
                        
                        <div class="form-group">
                            <label>Mô tả</label>
                            <textarea name="moTaChung" id="moTaChung" class="ckeditor" style="height: 23px" rows="3">${cat.moTaChung }</textarea>
                            <p style="color:red">${msg1 }</p>
                            <form:errors path="cat.moTaChung" cssStyle="color:red"></form:errors>       
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

