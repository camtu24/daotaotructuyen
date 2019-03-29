<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Nhóm Học Viên</a> </div>
    <h1>Nhóm Học Viên</h1>
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
			<a href="${pageContext.request.contextPath }/admin/plhv/add" class="button">
			 <span style = "width: 155px;" class=addtop>Thêm loại học viên <i class="icon-plus"></i></span> </a>
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
                  <th>Nhóm học viên</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listP }" var="objP">
              	
              		<c:choose>
              			<c:when test="${listP != null}">
			                <tr class="gradeX">
			                  <td style="text-align: center;">${objP.id_Plhv }</td>
			                  <td>${objP.loaiHocVien }</td>
			                  
			                  <td width="22%" style="text-align: center;">
			                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
			                      <a href="${pageContext.request.contextPath }/admin/plhv/edit/${objP.id_Plhv}" class="btn btn-info"><i class="icon-edit"></i> Edit</a>
			                      <a href="${pageContext.request.contextPath }/admin/plhv/del/${objP.id_Plhv}" onclick="return confirm('Are you sure you want to delete this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Delete</a>
			                  </td>
			                </tr>
	                	</c:when>
	                	<c:otherwise><tr> <td colspan="2">Chưa có dữ liệu!</td> </tr></c:otherwise>
	                </c:choose>
                </c:forEach>
                
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>