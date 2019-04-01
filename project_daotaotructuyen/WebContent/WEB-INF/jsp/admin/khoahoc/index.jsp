<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Khóa học</a> </div>
    <h1>Quản lý khóa học</h1>
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
			<a href="${pageContext.request.contextPath }/admin/course/add" class="button">
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
                  <th>Tên khóa học</th>
                  <th>Hình ảnh</th>
                  <th>Học phí</th>
                  <!-- <th>Người tạo</th> -->
                  <th>Danh sách học viên</th>
                  <th>Trạng thái</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listC }" var="objC">
	                <tr class="gradeX">
	                  <td style="text-align: center;">${objC.id_KhoaHoc}</td>
	                  <td>
	                 	<a href="${pageContext.request.contextPath }/admin/course/${objC.id_KhoaHoc}/cats">${objC.tenKhoaHoc}</a>
	                  </td>
	                  <td style="text-align: center;">
	                  	<c:if test="${not empty objC.hinhAnh }">
                           <img width="150px" src="${pageContext.request.contextPath}/files/${objC.hinhAnh}" />
                       	</c:if>
                       	<c:if test="${empty objC.hinhAnh }">
                          	<img src="${defines.urlAdmin}/img/images.jpg" alt="hinhanh" style = "width:150px">
					   	</c:if>
                      </td>
	                  <td>${objC.hocPhi}</td>
	                  <%-- <td>${objC.nguoiTao}</td> --%>
	                  <td width="13%" style="text-align: center;">
	                 	 <a href="${pageContext.request.contextPath }/admin/course/liststudent/${objC.id_KhoaHoc}"><i class="icon icon-inbox"></i></a>
	                  </td>
	                  <td style="text-align: center" class="change-${objC.id_KhoaHoc }">
	                    <a href= "javascript:void(0)" onclick="return changeEnable(${objC.id_KhoaHoc },${objC.phatHanh })">
		                    <c:if test="${objC.phatHanh == 1 }">
	                       		<span class="label label-inactive" style="background-color : #00d627;">Đã phát hành</span>
	                       	</c:if>
	                       	<c:if test="${objC.phatHanh != 1 }">
	                       		<span class="label label-inactive" style="background-color : #fe892b;">Chưa phát hành</span>
	                       	</c:if>
                       	</a>
	                  </td>
	                  <td width="22%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <a href="${pageContext.request.contextPath }/admin/course/edit/${objC.id_KhoaHoc}" class="btn btn-info"><i class="icon-edit"></i> Edit</a>
	                      <a href="${pageContext.request.contextPath }/admin/course/storage/${objC.id_KhoaHoc}" onclick="return confirm('Are you sure you want to delete this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Storage</a>
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
<script type="text/javascript"> 
	function changeEnable(id, active){
	  $.ajax({
	    url: "${pageContext.request.contextPath}/admin/courses",
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

