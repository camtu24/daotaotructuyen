<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
<div id="portfolio" class="three_quarter first">
	<div class = "category">
		<p>
			<span class="icon-tags"></span><a href="${pageContext.request.contextPath }/">Trang chủ</a> » Tin tức lập trình
		</p>
	</div><div class = "gach-dm"></div>
      <ul class="clear">
 		<c:forEach items="${listNews }" var="objNews">
 		<c:set value = "${pageContext.request.contextPath}/${slugUtil.makeSlug(objNews.tenTin)}-${objNews.id_TinTuc }.html" var="detailNUrl"></c:set>
	        <li class="one_half1 first search">
	          <article class="clear float">
	            <figure class="post-image1"><a href="${detailNUrl }">
	            	<c:if test="${not empty objNews.hinhAnh }">
                       <img src="${pageContext.request.contextPath}/files/${objNews.hinhAnh}" alt="${objNews.hinhAnh}"/>
                   	</c:if>
                   	<c:if test="${empty objNews.hinhAnh }">
                      	<img src="${defines.urlPublic}/images/laptrinh.png" style = "height:250px" alt="hinhanh"/>
				   	</c:if>
	            </a></figure>
	            <header>
	              <h2 class="blog-post-title" style="margin-bottom:10px"><a href="${detailNUrl }">${objNews.tenTin }</a></h2>
	              <div class="blog-post-meta">
	                <ul>
	                  <li class="blog-post-date">
	                  	
	                    <time datetime="2000-04-06T08:15+00:00"><strong>Đăng ngày: </strong><fmt:formatDate value="${objNews.ngayDang}" pattern="dd/MM/yyyy hh:mm:ss"/></time>
	                  </li>
	                  <li class="blog-post-date">
	                    <span><strong>Lượt xem:</strong>${objNews.luotXem }</span>
	                  </li>
	                 
	                </ul>
	              </div>
	            </header>
	            <p>${objNews.moTa }</p>
	            <footer class="read-more"><a href="${detailNUrl }">Read More &raquo;</a></footer>
	          </article>
	        </li>
		</c:forEach>
      </ul>

      <!-- ######################################################### -->
      <nav class="pagination">
        <ul>

          <li><a class="active" href="">1</a> <span style = "color:#cdcdcd">|</span></li>
 
        </ul>
      </nav> 
    </div>