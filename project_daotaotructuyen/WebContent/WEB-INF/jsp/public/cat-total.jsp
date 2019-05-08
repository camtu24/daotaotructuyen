<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %>   
    <div id="portfolio" class="three_quarter first">
    
      <c:forEach items="${listS }" var="objS">
      	<div class = "danhmuc">
			<p><a href=""> <span class="icon-tags"></span>  ${objS.tenChuDe }</a></p>
		</div>
		<ul class="clear">
      		<c:forEach items="${courDao.getItemsByC(objS.id_ChuDe) }" var="objK">
      			<c:set value = "${pageContext.request.contextPath}/${slugUtil.makeSlug(objS.tenChuDe)}/${slugUtil.makeSlug(objK.tenKhoaHoc)}-${objK.id_KhoaHoc }.html" var="detailUrl"></c:set>
      			<li class="one_half"  style="margin: 0 9px;">
		          <article class="clear">
		            <figure class="post-image">
						<a href="${detailUrl}">
							<c:if test="${not empty objK.hinhAnh }">
	                           <img src="${pageContext.request.contextPath}/files/${objK.hinhAnh}" style = "height:250px" alt="${objK.hinhAnh}"/>
	                       	</c:if>
	                       	<c:if test="${empty objK.hinhAnh }">
	                          	<img src="${defines.urlPublic}/images/laptrinh.png" style = "height:250px" alt="hinhanh"/>
						   	</c:if>
						</a>
					</figure>
		            <header>
		              <div class="tieude">
							<p>${objK.tenKhoaHoc }</p>
						</div>
		              <div class="blog-post-meta" style="color:#ff9900;font-size: 1.2em;">
		                <p>Học phí: ${objK.hocPhi }VND</p>
		              </div>
		            </header>
		            <p>* ${objK.mieuTa }</p>
		            <p>* Đối tượng tham gia:${objK.doiTuongThamGia }</p>
		            <footer class="read-more"><a href="${detailUrl}">Chi tiết &raquo;</a></footer>
		          </article>
		        </li>
      		</c:forEach>
	      </ul>
	      <a href="${pageContext.request.contextPath}/danhmuckhoahoc/${slugUtil.makeSlug(objS.tenChuDe)}-${objS.id_ChuDe }" class="button small grey">Xem tất cả »</a>
      </c:forEach>
      
      <!-- ####################################################################################################### -->

    </div>