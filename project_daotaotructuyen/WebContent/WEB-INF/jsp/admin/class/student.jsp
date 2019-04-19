<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> 
    <a href="${pageContext.request.contextPath }/admin/class" class="tip-bottom">Lớp học</a> <a href="#" class="current">Danh sách</a> </div>
    <h1>
     <a href="${pageContext.request.contextPath }/admin/class" style="padding: 5px 10px" class="btn button"><i class="icon-hand-left"></i> Quay về</a> <br>
    Danh sách <br>
   
    </h1>
    
  </div>
  <div class="container-fluid">
  	<c:if test="${not empty msg }">
	      <div class="alert alert-success">
			<strong>${msg }</strong>
		  </div>
	  </c:if>
    <hr>
        <div class="tab">
		  <button id="defaultOpen" class="tablinks" onclick="openCity(event, 'Hocvien')">Học viên thường</button>
		  <button class="tablinks" onclick="openCity(event, 'Hocviennb')">Học viên nội bộ</button>
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
           <form action="${pageContext.request.contextPath }/admin/class/students/${idClass }/addhv/2" method="POST">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Họ Tên</th>
                  <th>Username</th>
                  <th>Số điện thoại</th>
                  <th>Email</th>
                  <th>Thêm</th>
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
		                  		<c:set var="checked" value=""></c:set>
		              			<c:choose>
                           			<c:when test="${not empty dsDao.getItemByIDHV(objS.id_HocVien, idClass)}">
                           				<c:set var="checked" value="checked"></c:set>
	                           		</c:when>
	                           		<c:otherwise>
	                           			<c:set var="checked" value=""></c:set>
	                           		</c:otherwise>
                           		</c:choose>
                              <input type="checkbox" name="them[]" value="${objS.id_HocVien }" ${checked}/>
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
           <form action="${pageContext.request.contextPath }/admin/class/students/${idClass }/addhv/1" method="POST">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Họ Tên</th>
                  <th>Username</th>
                  <th>Số điện thoại</th>
                  <th>Email</th>
                  <th>Thêm</th>
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
		                  		<c:set var="checked" value=""></c:set>
		              			<c:choose>
                           			<c:when test="${not empty dsDao.getItemByIDHV(objSnb.id_HocVien, idClass)}">
                           				<c:set var="checkedhv" value="checked"></c:set>
	                           		</c:when>
	                           		<c:otherwise>
	                           			<c:set var="checkedhv" value=""></c:set>
	                           		</c:otherwise>
                           		</c:choose>
                              <input type="checkbox" name="them[]" value="${objSnb.id_HocVien }" ${checkedhv }/>
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
           <form action="${pageContext.request.contextPath }/admin/class/students/${idClass }/addgv" method="POST">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                 	 <th>ID</th>
	                  <th>Họ Tên</th>
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
                  			<c:set var="checked" value=""></c:set>
	              			<c:choose>
                       			<c:when test="${not empty dsDao.getItemByIDGV(objTea.id_GiangVien, idClass)}">
                       				<c:set var="checkedgv" value="checked"></c:set>
                        		</c:when>
                        		<c:otherwise>
                        			<c:set var="checkedgv" value=""></c:set>
                        		</c:otherwise>
                       		</c:choose>
                            <input type="checkbox" name="them[]" value="${objTea.id_GiangVien }" ${checkedgv }/>
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
           <form action="${pageContext.request.contextPath }/admin/class/students/${idClass }/addqtv" method="POST">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Họ Tên</th>
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
	                  		<c:set var="checked" value=""></c:set>
	              			<c:choose>
                       			<c:when test="${not empty dsDao.getItemByIDQTV(objQtv.id_Qtv, idClass)}">
                       				<c:set var="checkedqtv" value="checked"></c:set>
                        		</c:when>
                        		<c:otherwise>
                        			<c:set var="checkedqtv" value=""></c:set>
                        		</c:otherwise>
                       		</c:choose>
                             <input type="checkbox" name="them[]" value="${objQtv.id_Qtv }" ${checkedqtv }/>
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