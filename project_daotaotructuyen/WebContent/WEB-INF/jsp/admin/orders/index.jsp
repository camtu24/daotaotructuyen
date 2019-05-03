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
                  <th>Ngày đăng ký mua</th>
                  <th>Tình trạng</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listOCX }" var="objOCX">
	                <tr class="gradeX">
	                  <td width="3.3%" >
                          <input type="checkbox" name="storage[]" value="${objOCX.id_Ttdk }" />
                      </td>
	                  <td style="text-align: center;"><strong>${objOCX.id_Ttdk }</strong></td>
	                  <td><strong>${objOCX.hoTen }</strong></td>
	                  <td><strong>${objOCX.email }</strong></td>
	                  <td><strong>${objOCX.sdt }</strong></td>
	                  <td>
	                  	<strong><fmt:formatDate value="${objOCX.ngayDangKy}" pattern="dd/MM/yyyy hh:mm:ss"/></strong>
	                  </td>
	                  <td style="text-align: center" class="change-${objOCX.id_Ttdk }">
	                    <a href= "javascript:void(0)" onclick="return changeEnable(${objOCX.id_Ttdk },${objOCX.tinhTrang })">
		                    <c:if test="${objOCX.tinhTrang == 1 }">
	                       		<img src="${defines.urlAdmin}/img/order-1.PNG"/>
	                       	</c:if>
	                       	<c:if test="${objOCX.tinhTrang != 1 }">
	                       		<img src="${defines.urlAdmin}/img/order-2.PNG" height="30px"/>
	                       	</c:if>
                       	</a>
	                  </td>
	                  <td width="22%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <a href="${pageContext.request.contextPath }/admin/order/view/${objOCX.id_Ttdk}" class="btn btn-success"><i class="icon-eye-open"></i> View</a>
	                      <a href="${pageContext.request.contextPath }/admin/order/storage/${objOCX.id_Ttdk}" onclick="return confirm('Are you sure you want to storage this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Storage</a>
	                  </td>
	                </tr>
                </c:forEach>
                
                <c:forEach items="${listODX }" var="objODX">
	                <tr class="gradeX">
	                  <td width="3.3%" >
                          <input type="checkbox" name="storage[]" value="${objODX.id_Ttdk }" />
                      </td>
	                  <td style="text-align: center;">${objODX.id_Ttdk }</td>
	                  <td>${objODX.hoTen }</td>
	                  <td>${objODX.email }</td>
	                  <td>${objODX.sdt }</td>
	                  <td>
	                  	<fmt:formatDate value="${objODX.ngayDangKy}" pattern="dd/MM/yyyy hh:mm:ss"/>
	                  </td>
	                  <td style="text-align: center" class="change-${objODX.id_Ttdk }">
	                    <a href= "javascript:void(0)" onclick="return changeEnable(${objODX.id_Ttdk },${objODX.tinhTrang })">
		                    <c:if test="${objODX.tinhTrang == 1 }">
	                       		<img src="${defines.urlAdmin}/img/order-1.PNG"/>
	                       	</c:if>
	                       	<c:if test="${objODX.tinhTrang != 1 }">
	                       		<img src="${defines.urlAdmin}/img/order-2.PNG" height="30px"/>
	                       	</c:if>
                       	</a>
	                  </td>
	                  <td width="22%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <a href="${pageContext.request.contextPath }/admin/order/view/${objODX.id_Ttdk}" class="btn btn-success"><i class="icon-eye-open"></i> View</a>
	                      <a href="${pageContext.request.contextPath }/admin/order/storage/${objODX.id_Ttdk}" onclick="return confirm('Are you sure you want to storage this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Storage</a>
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
<script type="text/javascript"> 
	function changeEnable(id, active){
	  $.ajax({
	    url: "${pageContext.request.contextPath}/admin/orders",
	    type: 'POST',
	    cache: false,
	    data: {
	      aactive : active,
	      aid: id
	    },
	    success: function(data){
	        $(".change"+'-'+id).html(data); /* alert(id); */
	    },
	    error: function (){
	      alert('Có lỗi');
	    }
	  }); 
	  /* alert("Thành công") */
	}
</script>