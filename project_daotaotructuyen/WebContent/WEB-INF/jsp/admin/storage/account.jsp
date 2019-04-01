<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Học Viên</a> </div>
    <h1>Học viên</h1>
  </div>
  <div class="container-fluid">
  	<c:if test="${not empty msg }">
	      <div class="alert alert-success">
			<strong>${msg }</strong>
		  </div>
	  </c:if>
    <hr>
    
    <div class="tab">
	  <button class="tablinks" id="defaultOpen" onclick="openCity(event, 'Hocvien')">Học viên</button>
	  <button class="tablinks" onclick="openCity(event, 'Giangvien')">Giảng viên</button>
	  <button class="tablinks" onclick="openCity(event, 'Quantri')">Quản trị viên</button>
	</div>
    <div id="Hocvien" class="tabcontent1 row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>Data table</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Học Tên</th>
                  <th>Username</th>
                  <th>Số điện thoại</th>
                  <th>Địa chỉ</th>
                  <th>Email</th>
                  <th>Chức năng</th>
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
	                  <td>${objS.diaChi }</td>
	                  <td width="22%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <a href="${pageContext.request.contextPath }/admin/student/view/${objS.id_HocVien}" class="btn btn-success"><i class="icon-eye-open"></i> View</a>
	                      <a href="${pageContext.request.contextPath }/admin/student/restore/${objS.id_HocVien}" class="btn btn-primary"><i class="icon-refresh"></i> Restore</a>
	                  </td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
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
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Họ Tên</th>
                  <th>Username</th>
                  <th>Số điện thoại</th>
                  <th>Email</th>
                  <th>Địa chỉ</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listTea }" var="objT">
	                <tr class="gradeX">
	                  <td style="text-align: center;">${objT.id_GiangVien }</td>
	                  <td>${objT.hoTen }</td>
	                  <td>${objT.username }</td>
	                  <td>${objT.sdt }</td>
	                  <td>${objT.email }</td>
	                   <td>${objT.diaChi }</td>
	                  <td width="22%" style="text-align: center;">
	                      <a href="${pageContext.request.contextPath }/admin/teacher/view/${objT.id_GiangVien}" class="btn btn-success"><i class="icon-eye-open"></i> View</a>
	                      <a href="${pageContext.request.contextPath }/admin/teacher/restore/${objT.id_GiangVien}" class="btn btn-primary"><i class=" icon-refresh"></i> Restore</a>
	                  </td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
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
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Họ Tên</th>
                  <th>Username</th>
                  <th>Số điện thoại</th>
                  <th>Email</th>
                  <th>Chức năng</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listQtv }" var="objQ">
	                <tr class="gradeX">
	                  <td style="text-align: center;">${objQ.id_Qtv }</td>
	                  <td>${objQ.hoTen }</td>
	                  <td>${objQ.username }</td>
	                  <td>${objQ.sdt }</td>
	                  <td>${objQ.email }</td>
	                  <td width="15%" style="text-align: center;">
	                      <!-- <a href="" class="btn btn-success"><i class="icon-eye-open"></i> View</a> -->
	                      <a href="${pageContext.request.contextPath }/admin/qtv/view/${objQ.id_Qtv}" class="btn btn-success"><i class="icon-eye-open"></i> Edit</a>
	                      <a href="${pageContext.request.contextPath }/admin/qtv/restore/${objQ.id_Qtv}" class="btn btn-primary"><i class=" icon-refresh"></i> Restore</a>
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