<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Giảng Viên</a> </div>
    <h1>Giảng viên</h1>
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
			<a href="${pageContext.request.contextPath }/admin/teacher/add" class="button">
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
                  <th>Họ Tên</th>
                  <th>Username</th>
                  <th>Số điện thoại</th>
                  <th>Email</th>
                  <th>Hoạt động</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listTea }" var="objT">
              	
              		<c:choose>
              			<c:when test="${listTea != null}">
			                <tr class="gradeX">
			                  <td style="text-align: center;">${objT.id_GiangVien }</td>
			                  <td>${objT.hoTen }</td>
			                  <td>${objT.username }</td>
			                  <td>${objT.sdt }</td>
			                  <td>${objT.email }</td>
			                  <td style="text-align: center" class="change-${objT.id_GiangVien }">
			                    <a href= "javascript:void(0)" onclick="return changeEnable(${objT.id_GiangVien },${objT.enable })">
				                    <c:if test="${objT.enable == 1 }">
			                       		<img src="${defines.urlAdmin}/img/active.png" width="20px"/>
			                       	</c:if>
			                       	<c:if test="${objT.enable != 1 }">
			                       		<img src="${defines.urlAdmin}/img/disactive.png" width="20px"/>
			                       	</c:if>
		                       	</a>
			                  </td>
			                  <td width="22%" style="text-align: center;">
			                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
			                      <a href="${pageContext.request.contextPath }/admin/teacher/edit/${objT.id_GiangVien}" class="btn btn-info"><i class="icon-edit"></i> Edit</a>
			                      <a href="${pageContext.request.contextPath }/admin/teacher/storage/${objT.id_GiangVien}" onclick="return confirm('Are you sure you want to storage this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Storage</a>
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