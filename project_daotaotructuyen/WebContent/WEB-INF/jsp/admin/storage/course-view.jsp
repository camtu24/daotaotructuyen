<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">Học Viên</a> </div>
    <h1>
    <a href="javascript:history.go(-1)" style="padding: 5px 10px" class="btn button"><i class="icon-hand-left"></i> Quay về</a> <br>
    Quản lý học viên</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
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
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${listDMBG }" var="objDMBG">
	                <tr class="gradeX">
	                  <th style="text-align: center;"></th>
	                  <th>${objDMBG.tenDanhMuc }</th>
	                  <c:forEach items="${lessDao.getItemsByIDDM(objDMBG.id_Dmb,objDMBG.id_KhoaHoc,0) }" var="itemBGDH">
						  <tr class="gradeX">
						  <td style="text-align: center;">${itemBGDH.id_BaiHoc }</td>
		                  <td>${itemBGDH.tenBaiHoc }</td>
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
