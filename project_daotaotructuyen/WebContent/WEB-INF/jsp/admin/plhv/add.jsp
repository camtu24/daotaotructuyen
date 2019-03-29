<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/plhv" class="tip-bottom">Danh mục</a> <a href="#" class="current">Thêm danh mục</a>
		</div>
		<h1>Danh Mục</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Thêm danh mục</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/plhv">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form  action="" role="form" method="POST">
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="form-group">
                            <label>Loại học viên</label>
                            <input class="form-control" name="loaiHocVien" value="${plhv.loaiHocVien }" style="height: 23px"> 
                            <p style="color:red">${msg1 }</p>
                            <form:errors path="plhv.loaiHocVien" cssStyle="color:red"></form:errors>       
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

