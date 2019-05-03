<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %> 
<div id="container">  
    <div id="portfolio">
		<div class="category" style="width:100%">
			<p>
				<span class="icon-tags"></span>
				<a href = "${pageContext.request.contextPath}">Trang chủ</a> » Tìm kiếm
			</p>
		</div><div class="gach-dm" style="width:100%"></div>
		
		<div class = "">
			<p style="font-size: 17px">
				<c:if test="${size == 0 }">
				<span class="icon-star"> Kết quả tìm kiếm</span> » <span>Không có tin nào được tìm thấy với từ khóa <strong>${search }</strong></span>
				</c:if>
				<c:if test="${size > 0 }">
				<span class="icon-star"> Kết quả tìm kiếm</span> » <span>Có <strong>${size }</strong> tin được tìm thấy với từ khóa <strong>${search }</strong></span>
				</c:if>
			</p>
		</div>
      <ul class="clear">
      	<c:forEach items="${listKH }" var="objK">
      		<c:set value = "${pageContext.request.contextPath}/${slugUtil.makeSlug(tenChuDe)}/${slugUtil.makeSlug(objK.tenKhoaHoc)}-${objK.id_KhoaHoc }.html" var="detailUrl"></c:set>
      		<li class="one_third"  style="margin: 0 14px 35px;  border-style: double; height: 530px;">
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
	            </header>
				<div style="padding: 0 15px">
					<div class="blog-post-meta">
		                <p>Giảng viên: </p>
		              </div>
		            <p>* ${objK.mieuTa }</p>
		            <p>* Đối tượng tham gia:${objK.doiTuongThamGia }</p>
		            <footer class="read-more"><a href="${detailUrl}">Chi tiết &raquo;</a></footer>
				</div>
	            
	          </article>
	        </li>
      	</c:forEach>
      </ul>
      <!-- ####################################################################################################### -->
    </div>
</div>