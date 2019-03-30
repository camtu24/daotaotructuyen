<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Đơn Hàng</a> </div>
    <h1>Đơn Hàng</h1>
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
          <form action="${pageContext.request.contextPath }/admin/order/storages" method="POST">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th></th>
                  <th>Mã</th>
                  <th>Họ Tên</th>
                  <th>Email</th>
                  <th>Số điện thoại</th>
                  <th>Ngày đăng ký</th>
                  <th>Tình trạng</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listO }" var="objO">
	                <tr class="gradeX">
	                  <td width="3.3%" >
                          <input type="checkbox" name="storage[]" value="${objO.id_Ttdk }" />
                      </td>
	                  <td style="text-align: center;">${objO.id_Ttdk }</td>
	                  <td>${objO.hoTen }</td>
	                  <td>${objO.email }</td>
	                  <td>${objO.sdt }</td>
	                  <td>
	                  	<fmt:formatDate value="${objO.ngayDangKy}" pattern="dd/MM/yyyy"/>
	                  </td>
	                  <td style="text-align: center" class="change-${objO.id_Ttdk }">
	                    <a href= "javascript:void(0)" onclick="return changeEnable(${objO.id_Ttdk },${objO.tinhTrang })">
		                    <c:if test="${objO.tinhTrang == 1 }">
	                       		<span class="label label-inactive" style="background-color : #fe892b;">Đã thanh toán</span>
	                       	</c:if>
	                       	<c:if test="${objO.tinhTrang != 1 }">
	                       		<span class="label label-inactive" style="background-color : #fe892b;">Chưa thanh toán</span>
	                       	</c:if>
                       	</a>
	                  </td>
	                  <td width="22%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <a href="${pageContext.request.contextPath }/admin/order/view/${objO.id_Ttdk}" class="btn btn-success"><i class="icon-eye-open"></i> View</a>
	                      <a href="${pageContext.request.contextPath }/admin/order/storage/${objO.id_Ttdk}" onclick="return confirm('Are you sure you want to storage this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Storage</a>
	                  </td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
            <input type="submit" style="padding-bottom: 25px;" value="Storage" class="btn btn-danger"  onclick="return confirm('Are you sure you want to storage this items?')" >
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>