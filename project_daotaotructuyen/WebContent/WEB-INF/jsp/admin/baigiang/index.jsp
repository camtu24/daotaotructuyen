<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Bài giảng</a> </div>
    <h1>Quản lý bài giảng</h1>
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
			<%-- <a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/${cid }/lesson/add" class="button">
			 <span class=addtop>Thêm <i class="icon-plus"></i></span> </a> --%>
			 <div class="btn-group">
	            <button class="btn btn-primary" style="height:30px">Thêm nội dung</button>
	            <button data-toggle="dropdown" style="height:30px" class="btn btn-primary dropdown-toggle"><span class="caret"></span></button>
	            <ul style="height:62px" class="dropdown-menu">
	              <li><a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/${cid }/lesson/add"> <i class="icon-plus"></i> Bài giảng</a></li>
	              <li class="divider"></li>
	              <li><a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/${cid }/lesson/addTest"> <i class="icon-plus"></i> Bài kiểm tra</a></li>
	            </ul>
	          </div>
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
                  <th>Tên bài giảng</th>
                  <th>Ngày tạo</th>
                  <th>Người tạo</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listBG }" var="objBG">
	                <tr class="gradeX">
	                  <td style="text-align: center;">${objBG.id_BaiHoc}</td>
	                  <td>${objBG.tenBaiHoc}</td>
	                  <td style="text-align: center;">
	                  	<fmt:formatDate value="${objBG.ngayTao}" pattern="dd/MM/yyyy"/>
                      </td>
	                  <td width="15%" style="text-align: center;">${objBG.nguoiTao}</td>
	                  <td width="22%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <c:if test="${objBG.loai == 'baihoc'}">
	                      <a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/${cid }/lesson/edit/${objBG.id_BaiHoc}" class="btn btn-info"><i class="icon-edit"></i> Edit</a>
	                      </c:if>
	                      <a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/${cid }/lesson/delTemp/${objBG.id_BaiHoc}" onclick="return confirm('Are you sure you want to delete this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Delete</a>
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