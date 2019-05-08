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
      	<div class="widget-box" style="display: -webkit-box;height:32%; width: 55%">
      		<div class="info-stu">
      			<c:if test="${empty infoStu.hinhAnh }">
      			<img alt="Hình ảnh" src="${defines.urlAdmin }/img/user-cmt.png" style="width:35%"></c:if>
      			<c:if test="${not empty infoStu.hinhAnh }">
      			<img alt="Hình ảnh" src="${pageContext.request.contextPath }/files/${infoStu.hinhAnh}" style="width:35%"></c:if>
      			<div class="content-infoStu">
      				<p><strong>Họ tên:</strong> ${infoStu.hoTen }</p>
		      		<p><strong>Tên đăng nhập:</strong> ${infoStu.username }</p>
		      		<p><strong>Email:</strong> ${infoStu.email }</p>
		      		<p><strong>Địa chỉ:</strong> ${infoStu.diaChi }</p>
		      		<p><strong>Tên khóa học:</strong> ${sa.tenKhoaHoc }</p>
		      		<p><strong>Ngày ghi danh: </strong><fmt:formatDate value="${sa.ngayGhiDanh }" pattern="dd/MM/yyyy"/> </p>
      			</div>
      		</div>
      	</div>
      	
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="">
            <table class="table table-bordered">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Danh mục bài học</th>
                  <th>Thời gian</th>
                  <th>Tình trạng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listDMBG }" var="objDMBG">
	                <tr class="gradeX">
	                  <th style="text-align: center;"></th>
	                  <th>${objDMBG.tenDanhMuc }</th>
	                  <th>***</th>
	                  <th>***</th>
	                  <c:forEach items="${qthDao.getItemsByIDDM(objDMBG.id_Dmb,objDMBG.id_KhoaHoc,infoStu.username) }" var="itemBGDH">
						  <tr class="gradeX">
						  <td style="text-align: center;">${itemBGDH.id_BaiHoc }</td>
		                  <td>${itemBGDH.tenBaiHoc }</td>
		                  <td style="text-align: center;">
		                  <c:if test="${itemBGDH.hoanThanh == 2 }">
		                  <fmt:formatDate value="${itemBGDH.thoiGian }" pattern="dd/MM/yyyy hh:mm:ss"/></c:if>
		                  </td>
		                  <td style="text-align: center;">
		                  	<c:choose>
		                  		<c:when test="${itemBGDH.hoanThanh == 2 }"><span style="color:#00d627">Đã hoàn thành</span>  </c:when>
		                  		<c:when test="${itemBGDH.hoanThanh == 1 }"><span style="color:#fe892b"> Chưa hoàn thành </span></c:when>
		                  		<c:otherwise><span style="color:red"> Chưa bắt đầu </span></c:otherwise>
		                  	</c:choose>
		                  </td>
		                  </tr>
					  </c:forEach>
					  
					  <c:forEach items="${lessDao.getItemsByIDDMCH(objDMBG.id_Dmb,objDMBG.id_KhoaHoc,infoStu.username) }" var="itemBG">
						<tr class="gradeX">
						<td style="text-align: center;">${itemBG.id_BaiHoc }</td>
		                <td>${itemBG.tenBaiHoc }</td>
		                <td></td>
		                <td style="text-align: center; color:red" > Chưa bắt đầu </td>
		                </tr>
					  </c:forEach>
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
