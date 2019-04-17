<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Danh mục khóa học</a> </div>
    <h1>Quản lý danh mục khóa học</h1>
  </div>
  <div class="container-fluid">
  	<c:if test="${not empty msg }">
	      <div class="alert alert-success">
			<strong>${msg }</strong>
		  </div>
	  </c:if>
    <hr>
    
    <div class="tab">
	  <button class="tablinks" id="defaultOpen" onclick="openCity(event, 'Khoahoc')">Khóa học</button>
	  <button class="tablinks" onclick="openCity(event, 'Hocvien')">Học viên thường</button>
	  <button class="tablinks" onclick="openCity(event, 'Hocviennb')">Học viên nội bộ</button>
	  <button class="tablinks" onclick="openCity(event, 'Giangvien')">Giảng viên</button>
	  <button class="tablinks" onclick="openCity(event, 'Quantri')">Quản trị viên</button>
	</div>
    <br> <br>
    <div id="Khoahoc" class="tabcontent1 row-fluid">
      <div class="span12">
      	<div class="">
			<a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/add" class="button">
			 <span style = "width: 200px;" class=addtop>Thêm danh mục bài giảng <i class="icon-plus"></i></span> </a>
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
                  <th>Tên danh mục bài giảng</th>
                  <th>Mô tả</th>
                  <th>Ngày tạo</th>
                  <th>Người tạo</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listDM }" var="objDM">
	                <tr class="gradeX">
	                  <td style="text-align: center;">${objDM.id_Dmb}</td>
	                  <td width="18%">
	                  <a href="${pageContext.request.contextPath }/admin/course/${objDM.id_KhoaHoc}/cat/${objDM.id_Dmb}/lessons">${objDM.tenDanhMuc}</a>
	                  </td>
	                  <td width="">${slugUtil.substringWord(objDM.moTaChung,150)}</td>
	                  <td style="text-align: center;">
	                  	<fmt:formatDate value="${objDM.ngayTao}" pattern="dd/MM/yyyy"/>
                      </td>
	                  <td>${objDM.nguoiTao}</td>
	                  <td width="22%" style="text-align: center;">
	                      <a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/edit/${objDM.id_Dmb}" class="btn btn-info"><i class="icon-edit"></i> Edit</a>
	                      <a href="${pageContext.request.contextPath }/admin/course/${kid }/cat/delTemp/${objDM.id_Dmb}" onclick="return confirm('Are you sure you want to delete this item?')" class="btn btn-danger"><i class="icon-remove-sign"></i> Delete</a>
	                  </td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    
    <div id="Hocvien" class="tabcontent1 row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
	          <form action="${pageContext.request.contextPath }/admin/course/${kid }/ghidanhhocvien" method="POST">
	          	<table class="table table-bordered data-table">
	              <thead>
	                <tr>
	                  <th>ID</th>
	                  <th>Học Tên</th>
	                  <th>Username</th>
	                  <th>Số điện thoại</th>
	                  <th>Email</th>
	                  <th>Ghi danh</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<c:forEach items="${listStu }" var="objS">
		                <tr class="gradeX">
		                  <td style="text-align: center;">${objS.id_HocVien }</td>
		                  <td>${objS.hoTen }</td>
		                  <td>${objS.username }</td>
		                  <td>${objS.sdt }</td>
		                  <td>${objS.email }</td>
		                  <td style="text-align: center;">
                              <input type="checkbox" name="ghidanh[]" value="${objS.id_HocVien }" />
                          </td>
		                </tr>
	                </c:forEach>
	              </tbody>
	            </table>
	            
	            <input type="submit" value="Lưu" class="btn btn-danger">
	          </form>
          </div>
        </div>
      </div>
    </div>
    
    <div id="Hocviennb" class="tabcontent1 row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
	          <form action="${pageContext.request.contextPath }/admin/course/${kid }/ghidanhhocvien" method="POST">
	          	<table class="table table-bordered data-table">
	              <thead>
	                <tr>
	                  <th>ID</th>
	                  <th>Học Tên</th>
	                  <th>Username</th>
	                  <th>Số điện thoại</th>
	                  <th>Email</th>
	                  <th>Ghi danh</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<c:forEach items="${listStunb }" var="objSnb">
		                <tr class="gradeX">
		                  <td style="text-align: center;">${objSnb.id_HocVien }</td>
		                  <td>${objSnb.hoTen }</td>
		                  <td>${objSnb.username }</td>
		                  <td>${objSnb.sdt }</td>
		                  <td>${objSnb.email }</td>
		                  <td style="text-align: center;">
                              <input type="checkbox" name="ghidanh[]" value="${objSnb.id_HocVien }" />
                          </td>
		                </tr>
	                </c:forEach>
	              </tbody>
	            </table>
	            
	            <input type="submit" value="Lưu" class="btn btn-danger">
	          </form>
          </div>
        </div>
      </div>
    </div>
    
    <div id="Giangvien" class="tabcontent1 row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
	          <form action="${pageContext.request.contextPath }/admin/course/${kid }/ghidanhgiangvien" method="POST">
	          	<table class="table table-bordered data-table">
	              <thead>
	                <tr>
	                  <th>ID</th>
	                  <th>Học Tên</th>
	                  <th>Username</th>
	                  <th>Số điện thoại</th>
	                  <th>Email</th>
	                  <th>Ghi danh</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<c:forEach items="${listTea }" var="objTea">
		                <tr class="gradeX">
		                  <td style="text-align: center;">${objTea.id_GiangVien }</td>
		                  <td>${objTea.hoTen }</td>
		                  <td>${objTea.username }</td>
		                  <td>${objTea.sdt }</td>
		                  <td>${objTea.email }</td>
		                  <td style="text-align: center;">
                              <input type="checkbox" name="ghidanh[]" value="${objTea.id_GiangVien }" />
                          </td>
		                </tr>
	                </c:forEach>
	              </tbody>
	            </table>
	            
	            <input type="submit" value="Lưu" class="btn btn-danger">
	          </form>
          </div>
        </div>
      </div>
    </div>
    
    <div id="Quantri" class="tabcontent1 row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
	          <form action="${pageContext.request.contextPath }/admin/course/${kid }/ghidanhqtv" method="POST">
	          	<table class="table table-bordered data-table">
	              <thead>
	                <tr>
	                  <th>ID</th>
	                  <th>Học Tên</th>
	                  <th>Username</th>
	                  <th>Số điện thoại</th>
	                  <th>Email</th>
	                  <th>Ghi danh</th>
	                </tr>
	              </thead>
	              <tbody>
	              	<c:forEach items="${listQtv }" var="objQtv">
		                <tr class="gradeX">
		                  <td style="text-align: center;">${objQtv.id_Qtv }</td>
		                  <td>${objQtv.hoTen }</td>
		                  <td>${objQtv.username }</td>
		                  <td>${objQtv.sdt }</td>
		                  <td>${objQtv.email }</td>
		                  <td style="text-align: center;">
                              <input type="checkbox" name="ghidanh[]" value="${objQtv.id_Qtv }" />
                          </td>
		                </tr>
	                </c:forEach>
	              </tbody>
	            </table>
	            
	            <input type="submit" value="Lưu" class="btn btn-danger">
	          </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent1");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
//Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>