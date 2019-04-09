<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Tin tức</a> </div>
    <h1>Quản lý tin tức</h1>
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
      	<div class="">
			<a href="${pageContext.request.contextPath }/admin/news/add" class="button">
			 <span class=addtop>Thêm <i class="icon-plus"></i></span> </a>
		</div>
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Tên tin</th>
                  <th>Hình ảnh</th>
                  <th>Ngày tạo</th>
                  <th>Người tạo</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listN }" var="objN">
	                <tr class="gradeX">
	                  <td style="text-align: center;">${objN.id_TinTuc}</td>
	                  <td>${objN.tenTin}</td>
	                  <td width="17%" style="text-align: center;">
	                  	<c:if test="${not empty objN.hinhAnh }">
                           <img width="150px" src="${pageContext.request.contextPath}/files/${objN.hinhAnh}" />
                       	</c:if>
                       	<c:if test="${empty objN.hinhAnh }">
                          	<img src="${defines.urlAdmin}/img/images.jpg" alt="hinhanh" style = "width:150px">
					   	</c:if>
                      </td>
	                  <td>
	                  	<fmt:formatDate value="${objN.ngayDang}" pattern="dd/MM/yyyy"/>
	                  </td>
	                  <td width="13%">${objN.nguoiDang}</td>
	                  <td width="17%" style="text-align: center;">
	                      <a href="${pageContext.request.contextPath }/admin/news/edit/${objN.id_TinTuc}" class="btn btn-info"><i class="icon-edit"></i> Edit</a>
	                      <a href="${pageContext.request.contextPath }/admin/news/delete/${objN.id_TinTuc}" onclick="return confirm('Are you sure you want to delete this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Delete</a>
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


