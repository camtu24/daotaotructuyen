<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Slider</a> </div>
    <h1>Slider</h1>
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
			<a href="${pageContext.request.contextPath }/admin/slider/add" class="button">
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
                  <th>Hình ảnh</th>
                  <th>Mô tả</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listS }" var="objS">
	                <tr class="gradeX">
	                  <td style="text-align: center;">${objS.id_Slide}</td>
	                  <td style="text-align: center;">
	                  	<c:if test="${not empty objS.hinhAnh }">
                           <img width="300px" src="${pageContext.request.contextPath}/files/${objS.hinhAnh}" />
                       	</c:if>
                       	<c:if test="${empty objS.hinhAnh }">
                          	<img src="${defines.urlAdmin}/img/images.jpg" alt="hinhanh" style = "width:150px">
					   	</c:if>
                      </td>
                      <td>${objS.moTa}</td>
	                  <td width="22%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <a href="${pageContext.request.contextPath }/admin/slider/edit/${objS.id_Slide}" class="btn btn-info"><i class="icon-edit"></i> Edit</a>
	                      <a href="${pageContext.request.contextPath }/admin/slider/del/${objS.id_Slide}" onclick="return confirm('Are you sure you want to delete this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Delete</a>
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

