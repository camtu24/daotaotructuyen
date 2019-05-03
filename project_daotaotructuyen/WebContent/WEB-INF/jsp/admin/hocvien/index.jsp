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
      	<div class="">
			<a href="${pageContext.request.contextPath }/admin/student/add" class="button">
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
              	<c:forEach items="${listStu }" var="objS">
              	
              		<c:choose>
              			<c:when test="${listStu != null}">
			                <tr class="gradeX">
			                  <td style="text-align: center;">${objS.id_HocVien }</td>
			                  <td>${objS.hoTen }</td>
			                  <td>${objS.username }</td>
			                  <td>${objS.sdt }</td>
			                  <td>${objS.email }</td>
			                  <td style="text-align: center" class="change-${objS.id_HocVien }">
			                    <a href= "javascript:void(0)" onclick="return changeEnable(${objS.id_HocVien },${objS.enable })">
				                    <c:if test="${objS.enable == 1 }">
			                       		<img src="${defines.urlAdmin}/img/active.png" width="20px"/>
			                       	</c:if>
			                       	<c:if test="${objS.enable != 1 }">
			                       		<img src="${defines.urlAdmin}/img/disactive.png" width="20px"/>
			                       	</c:if>
		                       	</a>
			                  </td>
			                  <td width="22%" style="text-align: center;">
			                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
			                      <a href="${pageContext.request.contextPath }/admin/student/edit/${objS.id_HocVien}" class="btn btn-info"><i class="icon-edit"></i> Edit</a>
			                      <a href="${pageContext.request.contextPath }/admin/student/storage/${objS.id_HocVien}" onclick="return confirm('Are you sure you want to storage this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Storage</a>
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
<script type="text/javascript"> 
	function changeEnable(id, active){
	  $.ajax({
	    url: "${pageContext.request.contextPath}/admin/students",
	    type: 'POST',
	    cache: false,
	    data: {
	      aactive : active,
	      aid: id
	    },
	    success: function(data){
	        $(".change"+'-'+id).html(data);
	    },
	    error: function (){
	      alert('Có lỗi');
	    }
	  }); 
	}
</script>