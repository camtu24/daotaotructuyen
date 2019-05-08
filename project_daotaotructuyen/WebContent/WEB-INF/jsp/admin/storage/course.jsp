<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Khóa học</a> </div>
    <h1>Lưu trữ khóa học</h1>
  </div>
  <div class="container-fluid">
  	<c:if test="${not empty msg }">
	      <div class="alert alert-success">
			<strong>${msg }</strong>
		  </div>
	  </c:if>
    <hr>
    
    <div class="row-fluid">
      <div class="span12">

        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Tên khóa học</th>
                  <th>Hình ảnh</th>
                  <th>Học phí</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listC }" var="objC">
	                <tr class="gradeX">
	                  <td style="text-align: center;">${objC.id_KhoaHoc}</td>
	                  <td>${objC.tenKhoaHoc}</td>
	                  <td style="text-align: center;">
	                  	<c:if test="${not empty objC.hinhAnh }">
                           <img width="150px" src="${pageContext.request.contextPath}/files/${objC.hinhAnh}" />
                       	</c:if>
                       	<c:if test="${empty objC.hinhAnh }">
                          	<img src="${defines.urlAdmin}/img/images.jpg" alt="hinhanh" style = "width:150px;height:85px">
					   	</c:if>
                      </td>
	                  <td>${objC.hocPhi}</td>

	                  <td width="29%" style="text-align: center;">
	                      <a href="${pageContext.request.contextPath }/admin/course/view/${objC.id_KhoaHoc}" class="btn btn-info"><i class="icon-eye-open"></i> View</a>
	                      <a href="${pageContext.request.contextPath }/admin/course/restore/${objC.id_KhoaHoc}" class="btn btn-success"><i class="icon-refresh"></i> Restore</a>
	                      <a href="${pageContext.request.contextPath }/admin/course/delete/${objC.id_KhoaHoc}" onclick="return confirm('Are you sure you want to delete this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Delete</a>
	                  </td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

