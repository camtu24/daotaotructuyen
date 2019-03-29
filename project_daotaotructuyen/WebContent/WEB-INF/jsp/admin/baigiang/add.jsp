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
                            <input class="form-control" name="tenBaiHoc" value="${lesson.tenBaiHoc }" style="height: 23px"> 
                            <p style="color:red">${msg1 }</p>
                            <form:errors path="lesson.tenBaiHoc" cssStyle="color:red"></form:errors>       
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
                            <textarea name="moTa" style="height: 23px" rows="3">${lesson.moTa }</textarea>
                        </div>
                        
                        <div class="form-group">
                            <label>Nội dung</label>
                            <textarea name="chiTiet" class="ckeditor" style="height: 23px" rows="3">${lesson.chiTiet }</textarea>
                            <p style="color:red">${msg1 }</p>
                            <form:errors path="lesson.chiTiet" cssStyle="color:red"></form:errors>       
                        </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Video</label>
		                        <input type="file" name="video" class="form-control border-input" >
		                    </div>
		                </div>
                        
                        <div class="form-group">
                            <input type="submit" value="Thêm" class="btn btn-primary">
                        </div> 
                    </form>
				</div>
			</div>
		</div>
	</div>
</div>

