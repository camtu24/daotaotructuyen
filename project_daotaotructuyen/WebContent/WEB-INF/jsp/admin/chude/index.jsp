<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Chủ Đề</a> </div>
    <h1>Chủ Đề</h1>
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
			<a href="${pageContext.request.contextPath }/admin/subject/add" class="button">
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
                  <th>Chủ đề</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listS }" var="objS">
              	
              		<c:choose>
              			<c:when test="${listS != null}">
			                <tr class="gradeX">
			                  <td style="text-align: center;">${objS.id_ChuDe }</td>
			                  <td>${objS.tenChuDe }</td>
			                  
			                  <td width="22%" style="text-align: center;">
			                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
			                      <a href="${pageContext.request.contextPath }/admin/subject/edit/${objS.id_ChuDe}" class="btn btn-info"><i class="icon-edit"></i> Edit</a>
			                      <a href="${pageContext.request.contextPath }/admin/subject/del/${objS.id_ChuDe}" onclick="return confirm('Are you sure you want to delete this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Delete</a>
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