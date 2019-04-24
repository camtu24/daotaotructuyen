<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Liên hệ</a> </div>
    <h1>Liên Hệ</h1>
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
          <form action="${pageContext.request.contextPath }/admin/contact/delete" method="POST">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th></th>
                  <th>ID</th>
                  <th>Họ Tên</th>
                  <th>Nội dung</th>
                  <th>Email</th>
                  <th>Số điện thoại</th>
                  <th>Ngày liên hệ</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listCCX }" var="objCX">
	                <tr class="gradeX">
	                  <td width="3.3%" >
                          <input type="checkbox" name="delete[]" value="${objCX.id_LienHe }" />
                      </td>
	                  <td style="text-align: center;"><strong>${objCX.id_LienHe }</strong></td>
	                  <td><strong>${objCX.hoTen }</strong></td>
	                  <td><strong>${slugUtil.substringWord(objCX.noiDung,30)}</strong></td>
	                  <td><strong>${objCX.email }</strong></td>
	                  <td style="font-weight:600">${objCX.SDT }</td>
	                  <td>
	                  	<strong><fmt:formatDate value="${objCX.ngayLienHe}" pattern="dd/MM/yyyy hh:mm:ss"/></strong>
	                  </td>
	                  <td width="22%" style="text-align: center;">
	                      <a href="${pageContext.request.contextPath }/admin/contact/view/${objCX.id_LienHe}" class="btn btn-success"><i class="icon-eye-open"></i> View</a>
	                      <a href="${pageContext.request.contextPath }/admin/contact/storage/${objCX.id_LienHe}" onclick="return confirm('Are you sure you want to delete this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Delete</a>
	                  </td>
	                </tr>
                </c:forEach>
                
                <c:forEach items="${listCDX }" var="objDX">
	                <tr class="gradeX">
	                  <td width="3.3%" >
                          <input type="checkbox" name="delete[]" value="${objDX.id_LienHe }" />
                      </td>
	                  <td style="text-align: center;">${objDX.id_LienHe }</td>
	                  <td>${objDX.hoTen }</td>
	                  <td>${slugUtil.substringWord(objDX.noiDung,30)}</td>
	                  <td>${objDX.email }</td>
	                  <td>${objDX.SDT }</td>
	                  <td>
	                  	<fmt:formatDate value="${objDX.ngayLienHe}" pattern="dd/MM/yyyy hh:mm:ss"/>
	                  </td>
	                  <td width="22%" style="text-align: center;">
	                      <a href="${pageContext.request.contextPath }/admin/contact/view/${objDX.id_LienHe}" class="btn btn-success"><i class="icon-eye-open"></i> View</a>
	                      <a href="${pageContext.request.contextPath }/admin/contact/del/${objDX.id_LienHe}" onclick="return confirm('Are you sure you want to delete this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Delete</a>
	                  </td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
            <input type="submit" style="padding-bottom: 25px;" value="Delete" class="btn btn-danger"  onclick="return confirm('Are you sure you want to delete this items?')" >
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>