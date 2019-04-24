<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %>  
<div class="one_third">
        <div class="tab-wrapper clear">
          <ul class="tab-nav clear">
            <li><a href="#tab-1">Khóa học mới</a></li>
            <li><a href="#tab-2">Bài viết mới</a></li>
          </ul>
          <div class="tab-container">
            <!-- Tab Content -->
            <div id="tab-1" class="tab-content clear">
            	<c:forEach items="${list3Course }" var="obj3C">
            	<c:set value = "${pageContext.request.contextPath}/${slugUtil.makeSlug(obj3C.tenChuDe)}/${slugUtil.makeSlug(obj3C.tenKhoaHoc)}-${obj3C.id_KhoaHoc }.html" var="detailUrl3C"></c:set>
	            	<article class="clear push20">
		                <div class="imgl">
		                	<c:if test="${obj3C.hinhAnh != null}">
		                	<a href = "${detailUrl3C }"><img src="${pageContext.request.contextPath }/files/${obj3C.hinhAnh}" alt="no-image"/></a>
		                	</c:if>
		                	<c:if test="${obj3C.hinhAnh == null}">
		                	<a href = "${detailUrl3C }"><img src="${defines.urlAdmin }/img/images.jpg" alt="no-image"/></a>
		                	</c:if>
		                </div>
		                <h2 class="font-medium nospace"><a href="${detailUrl3C }">${obj3C.tenKhoaHoc }</a></h2>
		                <div class="blog-post-meta">
		                <ul>
		                  <li class="blog-post-date">
		                    <time><strong>Số lượng: </strong>${courDao.countItemsDSHVByIDKH(obj3C.id_KhoaHoc) } học viên</time>
		                  </li>
		                  <li class="blog-post-cats">
		                  	<a href="${pageContext.request.contextPath}/danhmuckhoahoc/${slugUtil.makeSlug(obj3C.tenChuDe)}-${obj3C.id_ChuDe }">${obj3C.tenChuDe }
		                  </a></li>
		                </ul>
		                </div>
		              </article>
	               <div class = "gach"></div>
               </c:forEach>
            </div>
            <!-- ## TAB 2 ## -->
            <div id="tab-2" class="tab-content clear">
            	<c:forEach items="${list3News }" var="obj3N">
            	<c:set value = "${pageContext.request.contextPath}/${slugUtil.makeSlug(obj3N.tenTin)}-${obj3N.id_TinTuc }.html" var="detail3NUrl"></c:set>
	            	<article class="clear push20">
		                <div class="imgl">
		                	<c:if test="${obj3N.hinhAnh != null}">
		                	<a href = "${detail3NUrl }"><img src="${pageContext.request.contextPath }/files/${obj3N.hinhAnh}" alt="no-image"/></a>
		                	</c:if>
		                	<c:if test="${obj3N.hinhAnh == null}">
		                	<a href = "${detail3NUrl }"><img src="${defines.urlAdmin }/img/images.jpg" alt="no-image"/></a>
		                	</c:if>
		                </div>
		                <h2 class="font-medium nospace"><a href="${detail3NUrl }">${obj3N.tenTin }</a></h2>
		                <div class="blog-post-meta">
		                <ul>
		                  <li class="blog-post-date">
		                    <time><strong>Đăng ngày: </strong>${obj3N.ngayDang }</time>
		                  </li>
		                  <li class="blog-post-cats">Lượt xem: <a href="javascript:void(0)">${obj3N.luotXem }</a></li>
		                </ul>
		                </div>
		              </article>
	               <div class = "gach"></div>
               </c:forEach>
            </div>
            <!-- / Tab Content -->
          </div>
        </div>
        <div class="clear push30"></div>
        
        <div class="divider2"></div>
        
        <section class="calltoaction opt1 clear">
		  <div class="three_quarter first" style="width: 100%;">
			<h1 style="font-size: 1.8em">Call To Action Here</h1>
			<p>Aliquatjusto quisque nam consequat doloreet vest orna partur scetur portortis nam. Metadipiscing eget facilis elit sagittis felisi eger id justo maurisus convallicitur.</p>
		  </div>
		  <div class="one_quarter" style="width: 100%; margin-top: 15px"><a href="${pageContext.request.contextPath }" class="button large gradient orange">Contact Us Today</a></div>
		</section>
		
        <div class="divider2"></div>
        
        <div class="clear">
          <h2 class="nospace font-medium push20">Hình ảnh công ty</h2>
          <ul class="nospace spacing clear">
            <li class="one_half first"><a href="#"><img src="${defines.urlPublic }/images/demo/150x150.gif" alt=""></a></li>
            <li class="one_half"><a href="#"><img src="${defines.urlPublic }/images/demo/150x150.gif" alt=""></a></li>
            <li class="one_half first"><a href="#"><img src="${defines.urlPublic }/images/demo/150x150.gif" alt=""></a></li>
            <li class="one_half"><a href="#"><img src="${defines.urlPublic }/images/demo/150x150.gif" alt=""></a></li>
          </ul>
        </div>
      </div>