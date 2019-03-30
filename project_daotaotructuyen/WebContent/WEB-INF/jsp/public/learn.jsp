<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<title>RS-1200 Prototype 50</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${defines.urlAdmin }/css/course.css" rel="stylesheet" type="text/css" media="all">
<link href="${defines.urlAdmin }/font-awesome/css/font-awesome.css" rel="stylesheet" />

</head>
<body class="">
<div class="wrapper">
	<div id="overflow1" class="tab-content part-content">
		    <div class="tab">
			  <button class="tablinks" id="defaultOpen" onclick="openCity(event, 'courseTimeline')"><span class="icon-list-ul icon-large"></span></button>
			  <button class="tablinks" onclick="openCity(event, 'Comment')"><em style="font-size:20px;" class="icon-comments-alt"></em></button>
			  <button class="tablinks" onclick="openCity(event, 'Question')"><span class="icon-question-sign icon-large"></span></button>
			  <button class="tablinks" onclick="openCity(event, 'Doccument')"><span class="icon-paste icon-large"></span></button>
			</div>
		<div id="courseTimeline" class="tabcontent1 tab-pane fade in active" style="padding: 0;">
			<div class="course-title">
				${nameKH }
			</div>
			<table class="content-list">
				<c:forEach items="${listDMBG }" var="item">
					<tr class="content-item  " data-id="45023">
						<td class="item-title1">
							<a href="javascript:void(0)">${item.tenDanhMuc }</a>
						</td>
							<td class="item-action">
								<span class="fa fa-check" style="display: none;"></span>
							</td>
					</tr>
					<c:forEach items="${lessDao.getItemsByIDDM(item.id_Dmb,item.id_KhoaHoc) }" var="itemBG">
					<c:set value = "${pageContext.request.contextPath}/mycourse/${slugUtil.makeSlug(nameKH)}-${item.id_KhoaHoc}-${itemBG.id_BaiHoc}" var="learningUrl"></c:set>
						<tr class="content-item  active" data-id="45024">
							<td class="item-title">
								<a href="${learningUrl }"> -- ${itemBG.tenBaiHoc }</a>
							</td>
								<td class="item-action">
									<span class="fa fa-check" style="display: none;"></span>
								</td>
						</tr>
					</c:forEach>
					
					<tr class="content-item  " data-id="45025">
						<td class="item-title">
							<a href="/course/content/45025">bai 3</a>
						</td>
							<td class="item-action">
								<span class="fa fa-check" style="display: none;"></span>
							</td>
					</tr>
					<tr class="content-item  " data-id="45026">
						<td class="item-title">
							<a href="/course/content/45026">bai 4</a>
						</td>
							<td class="item-action">
								<span class="fa fa-check" style="display: none;"></span>
							</td>
					</tr>
				</c:forEach>
			</table>
	</div>
	
	<div id="Comment" class="tabcontent1 tab-pane fade in active" style="padding: 0;">
			<div class="course-title">
				JAVA1
			</div>
			<table class="content-list">
				<tr class="content-item  " data-id="45023">
					<td class="item-title">
						<a href="/course/content/45023">bai 1</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>
				<tr class="content-item  active" data-id="45024">
					<td class="item-title">
						<a href="/course/content/45024">bai 2</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>
				<tr class="content-item  " data-id="45025">
					<td class="item-title">
						<a href="/course/content/45025">bai 3</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>
				<tr class="content-item  " data-id="45026">
					<td class="item-title">
						<a href="/course/content/45026">bai 4</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>

			</table>
	</div>
	
	<div id="Question" class="tabcontent1 tab-pane fade in active" style="padding: 0;">
			<div class="course-title">
				JAVA1
			</div>
			<table class="content-list">
				
				<tr class="content-item  " data-id="45023">
					<td class="item-title">
						<a href="/course/content/45023">bai 1</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>
				<tr class="content-item  active" data-id="45024">
					<td class="item-title">
						<a href="/course/content/45024">-- bai 2</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>
				<tr class="content-item  " data-id="45025">
					<td class="item-title">
						<a href="/course/content/45025">-- bai 3</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>
				<tr class="content-item  " data-id="45026">
					<td class="item-title">
						<a href="/course/content/45026">-- bai 4</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>

			</table>
	</div>
	
	<div id="Doccument" class="tabcontent1 tab-pane fade in active" style="padding: 0;">
			<div class="course-title">
				JAVA1
			</div>
			<table class="content-list">
				<tr class="content-item  " data-id="45023">
					<td class="item-title">
						<a href="/course/content/45023">bai 1</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>
				<tr class="content-item  active" data-id="45024">
					<td class="item-title">
						<a href="/course/content/45024">bai 2</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>
				<tr class="content-item  " data-id="45025">
					<td class="item-title">
						<a href="/course/content/45025">bai 3</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>
				<tr class="content-item  " data-id="45026">
					<td class="item-title">
						<a href="/course/content/45026">bai 4</a>
					</td>
						<td class="item-action">
							<span class="fa fa-check" style="display: none;"></span>
						</td>
				</tr>

			</table>
	</div>
	
	</div>
	
	<div id="full" class="style-newspaper" id="readOverlay">
		<div class="header-newspaper">
			<a class="closebtn" href="javascript:void(0)" onclick="openNav()"><span style="font-size:14px;margin-right: 5px;color:#fff" class="icon-circle-arrow-left icon-large"></span></a>
			<a class="closebtn" href="javascript:void(0)" onclick="closeNav()"><span style="font-size:14px;margin-right: 5px;color:#fff" class="icon-circle-arrow-right icon-large"></span></a>
			<h3 class="title-couser">TIÊU ĐỀ BÀI HỌC</h3>
			<a class="goback" href="javascript:history.go(-1)" title=""> <span class="icon-remove icon-large"></span> </a>
		</div>
		<div id="overflow2" class="margin-wide size-medium" id="readInner">
			<h1>Tốt nhất c&aacute;c trang web đ&agrave;o tạo trực tuyến</h1>

			<div>
				<div class="entry-content">
				<p>Nếu bạn l&agrave; người mới ở đ&acirc;y, bạn c&oacute; thể muốn đăng k&yacute; của t&ocirc;i <a href="https://www.techtantri.com/vi/feed/">RSS feed</a>. Cảm ơn đ&atilde; gh&eacute; thăm!</p>

				<p>T&ocirc;i đ&atilde; bi&ecirc;n soạn một danh s&aacute;ch c&aacute;c 10 trang web đ&agrave;o tạo trực tuyến tốt nhất m&agrave; sẽ cho ph&eacute;p bạn để đ&agrave;o tạo cho m&igrave;nh theo tốc độ của ri&ecirc;ng bạn. C&aacute;ch thức m&agrave; c&aacute;c trang web được liệt k&ecirc; kh&ocirc;ng theo bất kỳ thứ tự ưu thế. Để c&oacute; sự c&ocirc;ng bằng, đạn được sử dụng thay v&igrave; con số. Một số c&aacute;c trang web cung cấp c&aacute;c kh&oacute;a học miễn ph&iacute; v&agrave; một số đề nghị trả c&aacute;c kh&oacute;a học. Chất lượng của c&aacute;c kh&oacute;a học gương mẫu. T&ocirc;i đ&atilde; đăng k&yacute; c&ugrave;ng một l&uacute;c hoặc kh&aacute;c v&agrave;o c&aacute;c trang web ngoại trừ &#39;totaltraining.com&rsquo; &amp; &#39;Teachertraining.com&#39;. T&ocirc;i đ&atilde; đi triệt để th&ocirc;ng qua t&agrave;i liệu học của họ. N&oacute; xứng đ&aacute;ng l&agrave; bao gồm trong số mười trang đ&agrave;o tạo trực tuyến đầu tốt nhất.</p>

				<p>Ra khỏi 10 trang web đ&agrave;o tạo trực tuyến tốt nhất alison.com, dontfeartheinternet.com, microsoftvirtualacademy.com, teachertraining.com v&agrave; w3schools.com cung cấp hướng dẫn đ&agrave;o tạo miễn ph&iacute;. Udemy.com l&agrave; đặc biệt. Tuy nhi&ecirc;n, đ&oacute; l&agrave; trả tiền thu&ecirc; bao, n&oacute; cũng cung cấp một v&agrave;i hướng dẫn trực tuyến ho&agrave;n to&agrave;n miễn ph&iacute;. hơn nữa, một khi bạn ho&agrave;n th&agrave;nh c&aacute;c hướng dẫn miễn ph&iacute;, c&aacute;c kh&oacute;a học miễn ph&iacute; bổ sung được th&ecirc;m v&agrave;o con m&egrave;o của bạn. Lynda.com l&agrave; một trong những trang web đ&agrave;o tạo trực tuyến NHẤT rằng bạn đ&atilde; bao giờ c&oacute; thể t&igrave;m thấy. Video2Brain.com kh&ocirc;ng xa ph&iacute;a sau.</p>

				<p>Bạn c&oacute; thể thấy 12 trang web đ&agrave;o tạo trực tuyến v&agrave; một trang web e-book được liệt k&ecirc; ở đ&acirc;y, trong khi, ti&ecirc;u đề của b&agrave;i viết n&agrave;y n&oacute;i Ten Best Online trang web Đ&agrave;o tạo. n&oacute; l&agrave; tốt để dưới cam kết v&agrave; hơn cung cấp!!! hơn thế nữa, khi t&ocirc;i đi qua trang web cung cấp gi&aacute;o dục chất lượng cao với gi&aacute; cả phải chăng đăng k&yacute;, họ chắc chắn sẽ được bao gồm ở đ&acirc;y.</p>

				<h2>12 c&aacute;c trang web để đạt được tổng số th&agrave;nh c&ocirc;ng</h2>

				<p><a href="https://www.techtantri.com/vi/best-online-training-websites/"><img alt="Bàn phím máy tính - Thế giới trong tầm tay của bạn! The Best Online trang web Đào tạo" class="alignright wp-image-166 size-full" height="188" src="https://www.techtantri.com/tantri/wp-content/uploads/2014/12/2014-12-15-1287-e1418591635990.jpg" width="250" /></a></p>

				<h4><em>Đi! C&oacute; được cho m&igrave;nh được đ&agrave;o tạo v&agrave; bắt kịp với thế giới&hellip; Bạn sẽ kh&ocirc;ng bị tụt hậu.</em></h4>

				<h2>Một Bonus cho bạn&ndash; đọc Anywhere, Bất cứ l&uacute;c n&agrave;o</h2>

				<p>L&agrave;m thế n&agrave;o về giải tr&iacute; cho m&igrave;nh một số tiểu thuyết. L&atilde;ng mạn cho m&aacute;i của bạn v&agrave; phi hư cấu để gi&uacute;p bạn t&igrave;m kiếm th&ocirc;ng tin từ tự lực để tăng trưởng biz. Tải eBook miễn ph&iacute; cho cuộc sống! Chuyến thăm &ldquo;<a href="http://www.free-ebooks.net/" rel="nofollow noopener" target="_blank" title="Tải về miễn phí Fiction, Sức khỏe, Lãng mạn và nhiều ebooks hơn">www.free-ebooks.net</a>&rdquo; H&atilde;y kh&aacute;m ph&aacute; ho&agrave;n to&agrave;n mới, t&aacute;c giả v&agrave; nh&agrave; văn độc lập đ&oacute; l&agrave; chắc chắn tăng l&ecirc;n pep bạn l&ecirc;n.</p>

				<p><strong>Điều li&ecirc;n quan:</strong><a href="https://www.techtantri.com/vi/top-5-free-online-graphic-design-software-and-graphic-design-resources/" title="Hàng đầu 5 Phần mềm thiết kế đồ họa trực tuyến &amp; Tài nguyên">Miễn ph&iacute; phần mềm thiết kế đồ họa trực tuyến &amp; nguồn lực thiết kế đồ họa</a></p>

				<h3>&nbsp;</h3>

				<h3>Bạn muốn biết 5 C&aacute;c bước để Wealth &amp; Sự th&agrave;nh c&ocirc;ng</h3>

				<p><br />
				<a href="https://heston.leadpages.co/leadbox/140ee6e73f72a2%3A167ec6723b46dc/5717424225648640/" rel="noopener" target="_blank">Click v&agrave;o đ&acirc;y để &quot;Top 5 Keys để gi&agrave;u c&oacute; v&agrave; th&agrave;nh c&ocirc;ng&rdquo;</a></p>
				</div>
			</div>
		</div>
	</div>
</div>
	<div class="footer">
        <div class="course-progress-bar">
            <div class="current-progress" >Chúc bạn học vui vẻ!!!</div>
        
            <!-- <button class="icon-graduation mobibe-no-event no-event" title="Ho&#224;n th&#224;nh">
                <span class="icon-chevron-left icon-large">
            </button> -->
		</div>
        <div class="btn-group-action nav-content">
            <div class="col-xs-6 text-right">
                    <a href="" title="B&#224;i học trước">
                        <span class="icon-chevron-left icon-large">
                    </a>
            </div>
            <div class="col-xs-6">
                   <a href="" title="B&#224;i học tiếp theo">
                        <span class="icon-chevron-right icon-large">
                    </a>
            </div>
        </div>
		
		<div class="course-complete">
			<a href="" title="Qua bài">
				<span class="qua">»</span> Qua b&#224;i 
			</a>
		</div>

    </div>

<!-- Scripts -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.min.js"></script>
<script>window.jQuery || document.write('<script src="layout/scripts/jquery-latest.min.js"><\/script>\
<script src="layout/scripts/jquery-ui.min.js"><\/script>')</script>
<script>jQuery(document).ready(function($){ $('img').removeAttr('width height'); });</script>
<%-- <script src="${defines.urlAdmin }/js/responsiveslides.js-v1.53/responsiveslides.min.js"></script>
<script src="${defines.urlAdmin }/js/jquery-mobilemenu.min.js"></script> --%>

<script>
function openNav() {
  document.getElementById("full").style.width = "100%";
  document.getElementById("overflow1").style.width = "0";
}
function closeNav() {
  document.getElementById("full").style.width = "70%";
  document.getElementById("overflow1").style.width = "30%";
}

function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent1");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
//Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
</body>
</html>