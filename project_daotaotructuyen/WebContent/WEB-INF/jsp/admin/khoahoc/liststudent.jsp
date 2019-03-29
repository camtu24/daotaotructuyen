<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Danh sách</a> </div>
    <h1>Danh sách</h1>
  </div>
  <div class="container-fluid">
  	<c:if test="${not empty msg }">
	      <div class="alert alert-success">
			<strong>${msg }</strong>
		  </div>
	  </c:if>
    <hr>
        <div class="tab">
		  <button class="tablinks" id="defaultOpen" onclick="openCity(event, 'hocvien')">Học viên</button>
		  <button class="tablinks" onclick="openCity(event, 'giangvien')">Giảng viên</button>
		  <button class="tablinks" onclick="openCity(event, 'quantrivien')">Quản trị viên</button>
		</div>
    
    <div id="hocvien" class="tabcontent1 row-fluid">
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
                  <th>Giới tính</th>
                  <th>Ngày sinh</th>
                  <th>Ngày ghi danh</th>
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
	                  <td style="text-align: center;">${objS.gioiTinh }</td>
	                  <td style="text-align: center;">
	                  	<fmt:formatDate value="${objS.ngaySinh}" pattern="dd/MM/yyyy"/>
                      </td>
                      <td style="text-align: center;">
	                  	<fmt:formatDate value="${objS.ngayGhiDanh}" pattern="dd/MM/yyyy"/>
                      </td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    
    <div id="giangvien" class="tabcontent1 row-fluid">
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
                  <th>Giới tính</th>
                  <th>Ngày sinh</th>
                  <th>Ngày ghi danh</th>
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
	                  <td style="text-align: center;">${objT.gioiTinh }</td>
	                  <td style="text-align: center;">
	                  	<fmt:formatDate value="${objT.ngaySinh}" pattern="dd/MM/yyyy"/>
                      </td>
                      <td style="text-align: center;">
	                  	<fmt:formatDate value="${objT.ngayGhiDanh}" pattern="dd/MM/yyyy"/>
                      </td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
    
    <div id="quantrivien" class="tabcontent1 row-fluid">
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
                  <th>Ngày ghi danh</th>
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
	                  <td style="text-align: center;">
	                  	<fmt:formatDate value="${objQ.ngayGhiDanh}" pattern="dd/MM/yyyy"/>
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