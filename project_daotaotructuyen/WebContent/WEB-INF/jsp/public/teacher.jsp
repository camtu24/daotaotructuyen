<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %> 
<div id="container">
<div id="portfolio">
	<div class="doingugv">
		<h2 >ĐỘI NGŨ GIẢNG VIÊN</h2>
		<p>Đội ngũ giảng viên là các Senior đang làm tại công ty giàu kinh nghiệm thực tế, truyển đạt tốt và tận tâm.
		chương trình học cũng như phương pháp dạy luôn được cải tiến để đảm bảo học viên học tốt nhất, code thuần thục và phân tích tốt, 
		có việc ngay sau khi học.</p>
	</div>
      <ul class="clear">
      	<c:forEach items="${listTea }" var="objTea">
	        <li class="one_third" style="margin: 0 20px 35px;">
	          <article class="clear">
	            <figure class="post-image">
	            	<c:if test="${not empty objTea.hinhAnh }">
                       <img style = "width:360px" src="${pageContext.request.contextPath}/files/${objTea.hinhAnh}" />
                   	</c:if>
                   	<c:if test="${empty objTea.hinhAnh }">
                      	<img src="${defines.urlAdmin}/img/images.jpg" alt="hinhanh" style = "width:360px">
				   	</c:if>
	            </figure>
	            <header>
	              <h2 class="blog-post-title"><a href="#">${objTea.hoTen }</a></h2>
	            </header>
	            <p>* Chức vụ: ${objTea.chucVu }</p>
	            <p>* Chuyên môn chính:${objTea.chuyenMonChinh }</p>
	            <p>${objTea.moTaThem }</p>
	          </article>
	        </li>
        </c:forEach>
      </ul>
      <!-- ####################################################################################################### -->
</div>
</div>