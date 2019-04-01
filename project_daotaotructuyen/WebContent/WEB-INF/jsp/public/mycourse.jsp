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
          		<c:set value = "${pageContext.request.contextPath}/mycourses/${slugUtil.makeSlug(objMC.tenKhoaHoc)}-${objMC.id_KhoaHoc}" var="learnUrl"></c:set>
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
            
          </ul>

        </figure>
      </section>
    </div>