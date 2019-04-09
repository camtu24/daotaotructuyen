<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>

<div id="portfolio" class="three_quarter first">

    <div class = "category">
		<p>
			<span class="icon-tags"></span><a href = "${pageContext.request.contextPath }/">Trang chủ</a> » <a href = "${pageContext.request.contextPath }/news">Tin tức</a>
		</p>
	</div><div class = "gach-dm"></div>
      <ul class="clear">
        <li class="one_half1 first">
          <article class="clear">
            <figure class="post-image">
            	<c:if test="${not empty news.hinhAnh }">
                   <img src="${pageContext.request.contextPath}/files/${news.hinhAnh}" alt="${news.hinhAnh}"/>
               	</c:if>
            </figure>
            <header>
              <h2 class="blog-post-title">${news.tenTin }</h2>
              <div class="blog-post-meta">
                <ul>
                  <li class="blog-post-date">
                  	
                    <time datetime="2000-04-06T08:15+00:00"><strong>Đăng ngày: </strong><fmt:formatDate value="${news.ngayDang}" pattern="dd/MM/yyyy hh:mm:ss"/></time>
                  </li>
                  <li class="blog-post-date">
                    <span><strong>Lượt xem:</strong> ${news.luotXem }</span>
                  </li>
                </ul>
              </div>
            </header>
            <p>${news.moTa }</p>
            <p>${news.chiTiet }</p>
          </article>
        </li>
      </ul>
	  	<!-- ################################################################################################ -->
				<!------------------TIN LIÊN QUAN--------------->		
			<div class = "thaoluan"></div>
			<div class = "tongtinlq">
				<h3><i class = "icon-star"></i>  Tin tức khác</h3><div class="gach-tin"></div>
				<ul class="clear" style="margin-bottom:35px">
					<c:forEach items="${listTTK }" var="objTK">
						<c:set value = "${pageContext.request.contextPath}/${slugUtil.makeSlug(objTK.tenTin)}-${objTK.id_TinTuc }.html" var="detailTKUrl"></c:set>
	    				<li class="one_half1 first search">
						  <article class="clear float" style="margin-bottom: 10px">
							<div class="gach_img">
								<figure class="post-image2"><a href="${detailTKUrl }">
									<c:if test="${not empty objTK.hinhAnh }">
				                       <img src="${pageContext.request.contextPath}/files/${objTK.hinhAnh}" alt="${objNews.hinhAnh}"/>
				                   	</c:if>
				                   	<c:if test="${empty objTK.hinhAnh }">
				                      	<img src="${defines.urlPublic}/images/laptrinh.png" style = "height:250px" alt="hinhanh"/>
								   	</c:if>
								</a></figure>
							</div>
							<header>
							  <h2 class="h2-tlq" ><a href="${detailTKUrl }">${objTK.tenTin }</a></h2>
							  <div class="blog-post-meta" style="margin-bottom:-8px">
								<ul>
				                  <li class="blog-post-date">
				                  	
				                    <time datetime="2000-04-06T08:15+00:00"><strong>Đăng ngày: </strong><fmt:formatDate value="${objTK.ngayDang}" pattern="dd/MM/yyyy hh:mm:ss"/></time>
				                  </li>
				                  <li class="blog-post-date">
				                    <span><strong>Lượt xem:</strong> ${objTK.luotXem }</span>
				                  </li>
				                </ul>
							  </div>
							</header>
							<p>${objTK.moTa }</p>
							<footer class="read-more" style="margin-right: 50px;margin-top:-10px"><a href="${detailTKUrl }">Read More &raquo;</a></footer>
						  </article>
						</li>
					</c:forEach>
				  </ul>
      
			</div>
		<!------------------ END TIN LIÊN QUAN--------------->	

	  </div>