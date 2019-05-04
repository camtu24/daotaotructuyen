<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Học Viên</a> </div>
    <h1>Quản lý học viên</h1>
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
                  <!-- <th>ID</th> -->
                  <th>Họ Tên</th>
                  <th>Số điện thoại</th>
                  <th>Email</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listStu }" var="objS">
	                <tr class="gradeX">
	                  <%-- <td style="text-align: center;">${objS.id_HocVien }</td> --%>
	                  <td>${objS.hoTen }</td>
	                  <td>${objS.sdt }</td>
	                  <td>${objS.email }</td>
	                  
	                  <td width="22%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <a href="${pageContext.request.contextPath }/admin/management/student/s/${objS.username }-${objS.id_HocVien}" class="btn btn-info"><i class="icon-edit"></i> Chi tiết</a>
	                  </td>
	                </tr>
                </c:forEach>
                
                <c:forEach items="${listTea }" var="objT">
	                <tr class="gradeX">
	                  <%-- <td style="text-align: center;">${objS.id_HocVien }</td> --%>
	                  <td>${objT.hoTen }</td>
	                  <td>${objT.sdt }</td>
	                  <td>${objT.email }</td>
	                  
	                  <td width="22%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <a href="${pageContext.request.contextPath }/admin/management/student/t/${objT.username }-${objT.id_GiangVien}" class="btn btn-info"><i class="icon-edit"></i> Chi tiết</a>
	                  </td>
	                </tr>
                </c:forEach>
                
                <c:forEach items="${listQtv }" var="objQ">
	                <tr class="gradeX">
	                  <%-- <td style="text-align: center;">${objS.id_HocVien }</td> --%>
	                  <td>${objQ.hoTen }</td>
	                  <td>${objQ.sdt }</td>
	                  <td>${objQ.email }</td>
	                  
	                  <td width="22%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <a href="${pageContext.request.contextPath }/admin/management/student/q/${objQ.username }-${objQ.id_Qtv}" class="btn btn-info"><i class="icon-edit"></i> Chi tiết</a>
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
