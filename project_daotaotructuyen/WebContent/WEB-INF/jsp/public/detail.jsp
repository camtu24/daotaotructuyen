<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %> 
    <div id="portfolio" class="three_quarter first">
    <div class="category" style="width:100%">
		<p>
			<span class="icon-tags"></span>
			<a href = "${pageContext.request.contextPath}">Trang chủ</a> » ${course.tenKhoaHoc }
		</p>
	</div><div class="gach-dm" style="width:100%"></div>
	<div class = "thaoluan"></div>
	<div>
		<div class="ttkh">
			<h3 class="detail-kh"><em class="icon-book"></em> THÔNG TIN KHÓA HỌC</h3>
			<div>
				<c:if test="${not empty course.hinhAnh }">
                   <img src="${pageContext.request.contextPath}/files/${course.hinhAnh}" alt="${course.hinhAnh}"/>
               	</c:if>
			</div>
			<p style="font-size: 15px;">${course.mieuTa}</p>
			<p style="font-size: 15px;">
				Thống kê về độ phổ biến của ngôn ngữ lập trình cũng như mức lương và nhu cầu tuyển dụng
				các công ty </p>
			<img src="${defines.urlPublic }/images/hinh1.png" alt="">
			<img  src="${defines.urlPublic }/images/hinh2.png" alt="">
			<p style="font-size: 15px;">${course.thongTinChung}</p>
			<div>
				<c:if test="${not empty course.video }">
	                <video width="100%" height="350"  controls>
						<source src="${pageContext.request.contextPath }/files/${course.video}" type="video/mp4">
						<!-- Trình duyệt của bạn không hỗ trợ thẻ video trong HTML5. -->
					</video>
			   	</c:if>
			</div>
		</div>
		<div class="ttkh" style="height:305px">
			<h3 class="detail-kh" ><span class="icon-user icon-large"></span> ĐỐI TƯỢNG THAM GIA</h3>
			<div>
				<img class="img-doituongthamgia" src="${defines.urlPublic }/images/doituong.jpg" alt="">
				<p class="noidung-doituongthamgia">${course.doiTuongThamGia}</p>
			</div>
		</div>
		<div class="ttkh">
			<h3 class="detail-kh" ><em class="icon-bookmark"></em> Mục tiêu & Kết quả</h3>
			<div>
				<p style="font-size:17px">-----------------------------------------------------------> MỤC TIÊU <----------------------------------------------------------</p>
				<p style="font-size: 15px;">${course.mucTieu}</p>
			</div>
			<div>
				<p style="font-size:17px">-----------------------------------------------------------> KẾT QUẢ <-----------------------------------------------------------</p>
				<p style="font-size: 15px;">${course.ketQua} </p>
			</div>
		</div>
		
		<div class="ttkh">
			<h3 class="detail-kh" ><span class="icon-list-alt icon-large"></span> Lộ trình học</h3>
			<c:forEach items="${listDMBG }" var="item">
				<div>
					<h5 style="font-size:18px;">>>> ${item.tenDanhMuc }</h5>
					<p style="font-size: 15px;">${item.moTaChung }</p>
				</div>
			</c:forEach>
			<!-- <div>
				<h5 style="font-size:18px;">>>> Phần 2</h5>
				<p style="font-size: 15px;">Thực hành và hiểu sâu các công cụ lập trình/ Teamwork
				Bạn sẽ được đào tạo để trở thành một lập trình Back End chuyên nghiệp
				Được truyền kinh nghiệm "máu lửa" từ các Giảng viên chuyên nghiệp qua các dự án được lấy từ doanh nghiệp
				Được đào tạo theo một LỘ TRÌNH chuẩn hóa qua các phương pháp giảng dạy TÍCH CỰC (Active Learning)
				</p>
			</div> -->

		</div>
		<div>
			<h3 class="detail-kh" ><span class="icon-star icon-large"></span> Giảng viên</h3>
			<ul class="clear">
				<li class="one_half" style="margin: 0 9px;">
				  <article class="clear">
					<figure class="post-image"><img src="../images/demo/1200x400.gif" alt=""></figure>
					<header>
					  <h2 class="blog-post-title"><a href="#">Pellentesque Tempor Tellus</a></h2>
					  <div class="blog-post-meta">
						<ul>
						  <li class="blog-post-date">
							<time datetime="2000-04-06T08:15+00:00"><strong>Completed:</strong> 6<sup>th</sup> April 2000</time>
						  </li>
						  <li class="blog-post-cats"><a href="#">Category 1</a>, <a href="#">Category 2</a></li>
						</ul>
					  </div>
					</header>
					<p>Portortornec condimenterdum eget consectetuer condis consequam pretium pellus sed mauris enim. Puruselit mauris nulla hendimentesque elit semper nam a sapien urna sempus. Aliquatjusto quisque nam consequat doloreet vest orna partur scetur portortis nam. Metadipiscing eget facilis elit sagittis felisi eger id justo maurisus convallicitur.</p>
					
				  </article>
				</li>
				<li class="one_half" style="margin: 0 9px;">
				  <article class="clear">
					<figure class="post-image"><img src="../images/demo/1200x400.gif" alt=""></figure>
					<header>
					  <h2 class="blog-post-title"><a href="#">Pellentesque Tempor Tellus</a></h2>
					  <div class="blog-post-meta">
						<ul>
						  <li class="blog-post-date">
							<time datetime="2000-04-06T08:15+00:00"><strong>Completed:</strong> 6<sup>th</sup> April 2000</time>
						  </li>
						  <li class="blog-post-cats"><a href="#">Category 1</a>, <a href="#">Category 2</a></li>
						</ul>
					  </div>
					</header>
					<p>Portortornec condimenterdum eget consectetuer condis consequam pretium pellus sed mauris enim. Puruselit mauris nulla hendimentesque elit semper nam a sapien urna sempus. Aliquatjusto quisque nam consequat doloreet vest orna partur scetur portortis nam. Metadipiscing eget facilis elit sagittis felisi eger id justo maurisus convallicitur.</p>
					
				  </article>
				</li>
		 
			  </ul>
		</div>
		<c:if test="${account.username != null }">
			<c:set value = "${pageContext.request.contextPath}/${slugUtil.makeSlug(course.tenKhoaHoc)}-${course.id_KhoaHoc }/dangky/step2" var="orderUrl"></c:set>
		</c:if>
		<c:if test="${account.username == null }">
			<c:set value = "${pageContext.request.contextPath}/${slugUtil.makeSlug(course.tenKhoaHoc)}-${course.id_KhoaHoc }/dangky/step1" var="orderUrl"></c:set>
		</c:if>
		<a style="margin: 45px 0 10px;" href="${orderUrl}" class="button large gradient orange">ĐĂNG KÝ KHÓA HỌC NÀY >>></a>
	</div>
    </div>