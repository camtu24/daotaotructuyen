<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %> 
<div id="gallery" class="three_quarter first">
      <section>
        <figure>
	       	<div class = "category">
				<p>
					<span class="icon-tags"></span>
					<a href = "${pageContext.request.contextPath}">Trang chủ</a> » Khóa học của tôi
				</p>
			</div><div class = "gach-dm"></div>
			<c:if test="${size == 0 }">
               <p>Bạn chưa đăng ký khóa học nào!</p>
               <p> » Lựa chọn ngay <a href="${pageContext.request.contextPath}/mycourse/${objMC.id_KhoaHoc}" style="color:#ff9900" >khóa học</a> phù hợp.</p>
           	</c:if>
          <ul class="clear">
          	<c:forEach items="${listMyCourse }" var="objMC">
          		<c:set value = "${pageContext.request.contextPath}/mycourse/${slugUtil.makeSlug(objMC.tenKhoaHoc)}-${objMC.id_KhoaHoc}" var="learnUrl"></c:set>
          		<li class="one_half">
					<a href="${learnUrl}">
						<c:if test="${not empty objMC.hinhAnh }">
                           <img src="${pageContext.request.contextPath}/files/${objMC.hinhAnh}" alt="${objMC.hinhAnh}"/>
                       	</c:if>
                       	<c:if test="${empty objMC.hinhAnh }">
                          	<img src="${defines.urlPublic}/images/laptrinh.png" alt="hinhanh"/>
					   	</c:if>
					</a>
					<div class="tieude">
						<p>${objMC.tenKhoaHoc }</p>
					</div>
					
					
					<div class="batdau">
						<a href="${learnUrl}" class="button small gradient black">START COURSE</a>
					</div>
				</li>
          	</c:forEach>
            
            <li class="one_half">
				<a href="#"><img src="${defines.urlPublic}/images/laptrinh.png" alt=""></a>
				<div class="tieude">
					<p>This is a W3C standards compliant free responsive</p>
				</div>
				<div class="batdau">
					<a href="${pageContext.request.contextPath}/mycourse/" class="button small gradient orange">START COURSE</a>
				</div>
			</li>
            
          </ul>

        </figure>
      </section>
      <!-- ####################################################################################################### -->
      <nav class="pagination">
        <ul>
          <li class="prev"><a href="#">&laquo; Previous</a></li>
          <li><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li class="splitter"><strong>&hellip;</strong></li>
          <li><a href="#">6</a></li>
          <li class="current"><strong>7</strong></li>
          <li><a href="#">8</a></li>
          <li class="splitter"><strong>&hellip;</strong></li>
          <li><a href="#">14</a></li>
          <li><a href="#">15</a></li>
          <li class="next"><a href="#">Next &raquo;</a></li>
        </ul>
      </nav>
    </div>