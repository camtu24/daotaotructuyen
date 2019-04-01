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
						<tr class="content-item" data-id="45024"> <!-- active -->
							<td class="item-title">
								<a href="${learningUrl }"> -- ${itemBG.tenBaiHoc }</a>
							</td>
								<td class="item-action">
									<span class="fa fa-check" style="display: none;"></span>
								</td>
						</tr>
					</c:forEach>
				</c:forEach>
			</table>
	</div>
	
	<div id="Comment" class="tabcontent1 tab-pane fade in active" style="padding: 0;">
			<div class="course-title">
				JAVA1
			</div>
			
	</div>
	
	<div id="Question" class="tabcontent1 tab-pane fade in active" style="padding: 0;">
			<div class="course-title">
				JAVA1
			</div>
			
	</div>
	
	<div id="Doccument" class="tabcontent1 tab-pane fade in active" style="padding: 0;">
			<div class="course-title">
				JAVA1
			</div>
			
	</div>
	
	</div>
	
	<div id="full" class="style-newspaper" id="readOverlay">
		<div class="header-newspaper">
			<a class="closebtn" href="javascript:void(0)" onclick="openNav()"><span style="font-size:14px;margin-right: 5px;color:#fff" class="icon-circle-arrow-left icon-large"></span></a>
			<a class="closebtn" href="javascript:void(0)" onclick="closeNav()"><span style="font-size:14px;margin-right: 5px;color:#fff" class="icon-circle-arrow-right icon-large"></span></a>
			<h3 class="title-couser">${lesson.tenBaiHoc }</h3>
			<a class="goback" href="${pageContext.request.contextPath}/mycourses" title=""> <span class="icon-remove icon-large"></span> </a>
		</div>
		<div id="overflow2" class="margin-wide size-medium" id="readInner">
		    <div>
				<c:if test="${not empty lesson.video }">
	                <video width="100%" height="490"  controls>
						<source src="${pageContext.request.contextPath }/files/${lesson.video}" type="video/mp4">
						<!-- Trình duyệt của bạn không hỗ trợ thẻ video trong HTML5. -->
					</video>
			   	</c:if>
			</div>
			<div>
				${lesson.chiTiet }
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
                        <span class="icon-chevron-left icon-large"></span>
                    </a>
            </div>
            <div class="col-xs-6">
                   <a href="" title="B&#224;i học tiếp theo">
                        <span class="icon-chevron-right icon-large"></span>
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