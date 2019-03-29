<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
			<a href="${pageContext.request.contextPath }/admin/subjects" class="tip-bottom">Chủ đề</a> <a href="#" class="current">Thêm chủ đề</a>
		</div>
		<h1>Chủ đề</h1>
	</div>
	<div class="container-fluid"><hr>
		<div class="header">
			<h4 class="title">Thêm chủ đề</h4>
		</div>
		<div class="widget-box">
			<div class="widget-title"> <span class="icon"> <i class="icon-circle-arrow-left"></i> </span>
	            <h5> <a href="${pageContext.request.contextPath }/admin/subjects">Quay lại </a></h5>
	        </div>
			<div class="container-fluid">
				<div class="col-lg-12 col-md-12">
					<form  action="" role="form" method="POST">
                        <input type="hidden" name="_token" value="m539dWkPFPEJAeF2eToltGS7PJ8G2tMDWdAbRFwf">
                        <div class="form-group">
                            <label>Tên chủ đề</label>
                            <input class="form-control" name="tenChuDe" value="${subject.tenChuDe }" style="height: 23px"> 
                            <p style="color:red">${msg1 }</p>
                            <form:errors path="subject.tenChuDe" cssStyle="color:red"></form:errors>       
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

