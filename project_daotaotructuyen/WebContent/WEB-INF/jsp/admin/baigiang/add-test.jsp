<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/${cid }/lessons" class="tip-bottom">Bài giảng</a> <a href="#" class="current">Thêm bài kiểm tra</a>
		</div>
		<h1>Bài kiểm tra</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Thêm bài kiểm tra</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/${cid }/lessons">Quay lại </a></h5>
	        	<div class="col-md4">
                    <div class="form-group">
                        <a href="" class="btn btn-info"><i class="icon-download-alt"></i> Tập tin mẫu</a>
                    </div>
                </div>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form  action="" role="form" method="POST" enctype='multipart/form-data'>
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="form-group">
                            <label>Tiêu đề (*)</label>
                            <input class="form-control" name="tenBaiHoc" value="${lesson.tenBaiHoc }" style="height: 23px" required> 
                            <p style="color:red">${msg1 }</p>
                            <form:errors path="lesson.tenBaiHoc" cssStyle="color:red"></form:errors>       
                        </div>
                        
                        <div class="col-md4">
		                    <div class="form-group">
		                        <label>Thêm từ tập tin</label>
		                        <input type="file" name="test" class="form-control border-input" required>
		                    </div>
		                </div>
		                
                        <div style="margin-top:80px" class="form-group">
                            <input type="submit" value="Thực hiện" class="btn btn-primary">
                        </div> 
                    </form>
				</div>
			</div>
		</div>
	</div>
</div>

