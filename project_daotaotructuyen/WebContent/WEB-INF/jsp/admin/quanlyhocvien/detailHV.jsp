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
      	<div class="widget-box" style="display: -webkit-box;height:25%; width: 50%">
      		<div class="info-stu">
      			<c:if test="${empty student.hinhAnh }">
      			<img alt="Hình ảnh" src="${defines.urlAdmin }/img/user-cmt.png"></c:if>
      			<c:if test="${not empty student.hinhAnh }">
      			<img alt="Hình ảnh" src="${pageContext.request.contextPath }/files/${student.hinhAnh}"></c:if>
      			<div class="content-infoStu">
      				<p><strong>Họ tên:</strong> ${student.hoTen }</p>
		      		<p><strong>Tên đăng nhập:</strong> ${student.username }</p>
		      		<p><strong>Email:</strong> ${student.email }</p>
		      		<p><strong>Địa chỉ:</strong> ${student.diaChi }</p>
      			</div>
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
                  <th>Tên khóa học</th>
                  <th>Mức độ hoàn thành</th>
                  <th>Điểm trung bình</th>
                  <th>Đánh giá</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listCourse }" var="objC">
	                <tr class="gradeX">
	                  <td style="text-align: center;">${objC.id_KhoaHoc }</td>
	                  <td>${objC.tenKhoaHoc }</td>
	                  <td width="22%">
	                  	<div class="content"  style="padding:0; position: relative;">
					      <div  style="background-color: gainsboro;" class="progress progress-mini active progress-striped">
					        <div style="width:  ${objC.mucDoHoanThanh }%;" class="bar"></div>
					      </div>
					      <span class="mucDoHoanThanh">${objC.mucDoHoanThanh }%</span>
					    </div>
	                  </td>
	                  <td style="text-align: center;">
	                  	<a href="${pageContext.request.contextPath }//admin/detail-score/${objC.id_KhoaHoc }" title="Chi tiết điểm">
	                 	 ${objC.diemTrungBinh }</a>
	                  </td>
	                  <td style="text-align: center;">
	                  	<c:if test="${empty objC.danhGia}"> ----***---- </c:if>
	                  	<c:if test="${not empty objC.danhGia}"> ${objC.danhGia } </c:if>
	                  </td>
	                  <td width="22%" style="text-align: center;">
	                      <a href="${pageContext.request.contextPath }/admin/management-student/update/${student.username }-${objC.id_Dghv}" class="btn btn-success"><i class="icon-edit"></i> Cập nhật</a>
	                      <a href="${pageContext.request.contextPath }/admin/management-student/detail/${student.username }-${objC.id_KhoaHoc}-${objC.id_Dghv}" class="btn btn-info"><i class="icon-eye-open"></i> Chi tiết</a>
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
