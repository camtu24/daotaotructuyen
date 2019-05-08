<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/templates/taglib.jsp" %>  
<!DOCTYPE html>
<html lang="en">
<head>
<title>Đào tạo trực tuyến</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${defines.urlPublic }/css/course.css" rel="stylesheet" type="text/css" media="all">
<link href="${defines.urlAdmin }/font-awesome/css/font-awesome.css" rel="stylesheet" />
<script src="${defines.urlPublic }/js/jquery-latest.min.js"></script>
</head>
<body class="">
<div class="wrapper">
	<div id="overflow1" class="tab-content part-content">
	    <div class="tab">
		  <button class="tablinks" id="defaultOpen" onclick="openCity(event, 'courseTimeline')"><span class="icon-list-ul icon-large"></span></button>
		  <button class="tablinks" onclick="openCity(event, 'Comment')"><em style="font-size:20px;" class="icon-comments-alt"></em></button>
		  <!-- <button class="tablinks" onclick="openCity(event, 'Question')"><span class="icon-question-sign icon-large"></span></button> -->
		  <button class="tablinks" onclick="openCity(event, 'Doccument')"><span class="icon-paste icon-large"></span></button>
		</div>
			
		<div id="wrapper-left">
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
							<c:forEach items="${qthDao.getItemsByIDDM(item.id_Dmb,item.id_KhoaHoc,account.username) }" var="itemBGDH">
							<c:set value = "${pageContext.request.contextPath}/mycourse/${nameKHSl}-${item.id_KhoaHoc}-${itemBGDH.id_BaiHoc}" var="learningUrl1"></c:set>
								<tr class="content-item" data-id="45024"> <!-- active -->
									<td class="item-title">
										<a href="${learningUrl1 }"> -- ${itemBGDH.tenBaiHoc }</a>
									</td>
										<td class="item-action">
											<span class="fa fa-check" style="display: none;"></span>
										</td>
								</tr>
							</c:forEach>
							
							<c:forEach items="${lessDao.getItemsByIDDMCH(item.id_Dmb,item.id_KhoaHoc,account.username) }" var="itemBG">
								<tr class="content-item" data-id="45024"> <!-- active -->
									<td class="item-title">
										<a href="javascript:void(0)" style="opacity: 0.6"> -- ${itemBG.tenBaiHoc }</a>
									</td>
										<td class="item-action">
											<span class="fa fa-check" style="display: none;"></span>
										</td>
								</tr>
							</c:forEach>
					</c:forEach>
				</table>
		</div>
		
		<div id="Comment" class="tabcontent1 tab-pane fade in active" style="padding: 15px;">
			<div class="submit-comment">
				<form action="javascript:void(0)">
					<textarea class="form-control cmt-text" id="txtAreaSendPost"></textarea> <!--onkeypress="checkContent(event, this)"-->
					<input type="submit" class="pull-right" value="Gửi" id="btnSendPost" onclick="doComment()">
				</form>
			</div>	
			
			<div class="comment-list">
				<div class="comment-item">
				<c:forEach items="${listCmt }" var="objCmt">
					<div class="post topic" data-id="5131">
						<div class="owner-avatar">
							<c:if test="${not empty objCmt.hinhAnh }">
	                           <img src="${pageContext.request.contextPath}/files/${objCmt.hinhAnh}" />
	                       	</c:if>
	                       	<c:if test="${empty objCmt.hinhAnh }">
	                          	<img src="${defines.urlAdmin }/img/user-cmt.png">
						   	</c:if>
						</div>
						<div class="post-info">
							<div class="post-detail">
								<span class="name" style="font-weight:bold">- ${objCmt.hoTen }</span>
								<span class="created" style="font-size: 13px;">
									<fmt:formatDate value="${objCmt.ngayDang }" pattern="dd/MM/yyyy hh:mm:ss"/>
								</span>
									<span class="action">
										<span class="thumbs-up-counter"></span>
										<button class="btn btn-action" style="background: none;border: none;margin-left: 10px;" onclick="showReply(${objCmt.id_BinhLuan})">
											<em class="icon-comment-alt"></em>
										</button>
									</span>
							</div>
							<div class="post-content">${objCmt.noiDung } </div>
						</div>
					</div>
					<div class="replies rep-${objCmt.id_BinhLuan }">
						<c:forEach items="${cmtDao.getItemsByIdP(objCmt.id_BinhLuan) }" var="objScmt">
							<div class="post" data-id="1310">
								<div class="owner-avatar">
									<c:if test="${not empty objScmt.hinhAnh }">
			                           <img src="${pageContext.request.contextPath}/files/${objScmt.hinhAnh}" />
			                       	</c:if>
			                       	<c:if test="${empty objScmt.hinhAnh }">
			                          	<img src="${defines.urlAdmin }/img/user-cmt.png">
								   	</c:if>
								</div>
								<div class="post-info">
									<div class="post-detail">
										<span class="name" style="font-weight:bold">${objScmt.hoTen }</span>
										<span class="created" style="font-size: 13px;">
											<fmt:formatDate value="${objScmt.ngayDang }" pattern="dd/MM/yyyy hh:mm:ss"/>
										</span>
											<span class="action">
												<span class="thumbs-up-counter"></span>
												<button class="btn btn-action like-reply ">
													<span class="fa fa-thumbs-o-up"></span>
												</button>
												<button class="btn btn-action" onclick="showReply(this)">
													<span class="fa fa-comment-o"></span>
												</button>
													<button class="btn btn-action delete-reply">
														<span class="fa fa-trash-o"></span>
													</button>
											</span>
									</div>
									<div class="post-content">${objScmt.noiDung }</div>
								</div>
							</div>
						</c:forEach>
						<div class="post reply-action-${objCmt.id_BinhLuan }" style="display: none;">
							<div class="owner-avatar">
								<c:if test="${not empty userInfo.hinhAnh }">
		                           <img src="${pageContext.request.contextPath}/files/${userInfo.hinhAnh}" />
		                       	</c:if>
		                       	<c:if test="${empty userInfo.hinhAnh }">
		                          	<img src="${defines.urlAdmin }/img/user-cmt.png">
							   	</c:if>
							</div>
							<div class="post-info">
								<form action="javascript:void(0)">
									<div class="post-content">
										<textarea class="form-control reply-box" id="content-rep-${objCmt.id_BinhLuan }"></textarea>
										<input type="submit" class="pull-right" value="Gửi" id="btnSendPost" onclick="doRepComment(${objCmt.id_BinhLuan})">
									</div>
								</form>
							</div>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
		
		<div id="Question" class="tabcontent1 tab-pane fade in active" style="padding: 0;">
			<div class="course-title">
				JAVA1
			</div>
				
		</div>
		
		<div id="Doccument" class="tabcontent1 tab-pane fade in active" style="padding: 0;">
			<div class="course-title">
				TÀI LIỆU THAM KHẢO
			</div>
			<table class="content-list">
				<c:forEach items="${listDoc }" var="objDoc">
					<tr class="content-item  " data-id="45023">
						<td class="item-title1">
							<a href="${pageContext.request.contextPath }/download-document-${objDoc.id_KhoaHoc}-${objDoc.id_TaiLieu}">-- ${objDoc.tenTaiLieu }</a>
						</td>
					</tr>
				</c:forEach>
			</table>
				
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
			<c:if test="${lesson.loai == 'baihoc' }">
			    <div>
					<c:if test="${not empty lesson.video }">
		                <video width="100%" height="490" controls="controls">
							<source src="${pageContext.request.contextPath }/files/${lesson.video}" type="video/mp4">
							<!-- Trình duyệt của bạn không hỗ trợ thẻ video trong HTML5. -->
						</video>
				   	</c:if>
				</div>
				<div>
					${lesson.chiTiet }
				</div>
			</c:if>
			<c:if test="${lesson.loai == 'kiemtra' }">
			    <c:if test="${less.hoanThanh == 3 }">
			    	<div class="test-info">
						<img class="icon" src="${defines.urlAdmin }/img/test-icon.png" />
						<div class="title">kiểm tra</div>
						<div class="detail">
							<p>B&#224;i thi gồm <b>52</b> c&#226;u hỏi</p>
							<p>
								Thời gian l&#224;m b&#224;i:                 <b>15 phút</b>
							</p>
							<button type="submit" id="btn-lam-bai-kiem-tra" class="btn btn-start btn-expanded-width" onclick="startTest(${kid},${lesson.id_BaiHoc })">Bắt đầu l&#224;m b&#224;i</button>
						</div>
		
					</div>
			    </c:if>
			    
			    <c:if test="${less.hoanThanh == 1 }">
			    	<div class="form-question-wrapper">
						<div class="form-question-header">
							<span>Thực hiện kiểm tra</span>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="quiz-infomation">
									B&#224;i thi gồm <strong>${sizeTest }</strong> c&#226;u hỏi <br />
									Tổng điểm: <strong>10</strong><br />
									Thời gian l&#224;m b&#224;i:
										<strong>
											15 ph&#250;t
										</strong><br />
									Ng&#224;y dự thi: <strong>2/05/2019</strong> <br />
		
								</div>
							</div>
		
							<div class="col-xs-12 col-md-12">
								<div class="quiz-navigation">
									<span class="quiz-navigation-title">Danh s&#225;ch c&#226;u hỏi</span>
									<a class="visible-xs show-nav-questions" href="#" onclick="return showNav();">
										<i class="fa fa-arrow-circle-down"></i>
									</a>
									
									<ul class="list-inline list-dieu-huong-cau-hoi">
										<%-- <c:forEach items="${listTest }" var="objLT1"> --%>
										<c:forEach begin="1" end="${listTest.size() }" var="i">
											<li data-thu-tu-cau-hoi="${i}">
												<div class="quiz-navigation-item ">
													<div class="quiz-content">
														<a class="cau-hoi-dieu-huong-js"
														   onclick="return dieuHuong(this);"
														   href="#Cau-${i}">
															${i }
														</a>
													</div>
													<div class="sign-top"></div>
													<div class="sign-bottom" style=""></div>
												</div>
											</li>
											<%-- <p>${i+1}-${listTest.get(i).stt }</p> --%>
										</c:forEach>
									</ul>
									
								</div>
							</div>
							<div class="col-xs-12 col-md-12 list-quiz">
								<div class="quiz-content margin-top-10">
								<c:forEach begin="0" end="${listTest.size()-1 }" var="j">
									<div class="question" id="Cau-${j+1}">
										<div class="row">
											<div class="col-xs-12 col-md-2 reset-padding-right">
												<div class="question-info">
													<span class="question-number">C&#226;u hỏi ${j+1 }</span>
													<span>Điểm: ${listTest.get(j).diem }</span>
												</div>
											</div>
											<div class="col-xs-12 col-md-10">
												<div class="question-detail  ">
													<span class="question-name"><p>${listTest.get(j).cauHoi }</p> </span>
													<div class="answer-content ">
														<div class="cau-don-trac-nghiem-mot-lua-chon" data-ma-cau-hoi="${listTest.get(j).id_CauHoi }">
															<ul class="lst-phuong-an lst-pa-dung-sai">
																<li data-ma-cau-tra-loi="1755109">
																   
																	<div class="phuong-an-detail">
																		<input class="radUserAnswer" role="radio" aria-label="Phương &#225;n A" type="radio" name="rad-phuong-an-${listTest.get(j).id_CauHoi }" value="A" id="rdoPhuongAn-A-${listTest.get(j).id_CauHoi }" onclick="submitAnswer(${j}, this)"/>
																		<label for="rdoPhuongAn-A-${listTest.get(j).id_CauHoi }" aria-labelledby="rdoPhuongAn-A-${listTest.get(j).id_CauHoi }">A. </label>
																		<div class="margin-left">
																			<p>${listTest.get(j).option1 }</p>
																		</div>
																	</div>
																</li>
																<li data-ma-cau-tra-loi="1755110">														   
																	<div class="phuong-an-detail">
																		<input class="radUserAnswer" role="radio" aria-label="Phương &#225;n B" type="radio" name="rad-phuong-an-${listTest.get(j).id_CauHoi }" value="B" id="rdoPhuongAn-B-${listTest.get(j).id_CauHoi }" onclick="submitAnswer(${j}, this)"/>
																		<label for="rdoPhuongAn-B-${listTest.get(j).id_CauHoi }" aria-labelledby="rdoPhuongAn-B-${listTest.get(j).id_CauHoi }">B. </label>
																		<div class="margin-left">
																			<p>${listTest.get(j).option2 }</p>
																		</div>
																	</div>
																</li>
																<li data-ma-cau-tra-loi="1755111">
																	<div class="phuong-an-detail">
																		<input class="radUserAnswer" role="radio" aria-label="Phương &#225;n C" type="radio" name="rad-phuong-an-${listTest.get(j).id_CauHoi }" value="C" id="rdoPhuongAn-C-${listTest.get(j).id_CauHoi }" onclick="submitAnswer(${j}, this)"/>
																		<label for="rdoPhuongAn-C-${listTest.get(j).id_CauHoi }" aria-labelledby="rdoPhuongAn-C-${listTest.get(j).id_CauHoi }">C. </label>
																		<div class="margin-left">
																			<p>${listTest.get(j).option3 }</p>
																		</div>
																	</div>
																</li>
																<li data-ma-cau-tra-loi="1755108">
																	<div class="phuong-an-detail">
																		<input class="radUserAnswer" role="radio" aria-label="Phương &#225;n D" type="radio" name="rad-phuong-an-${listTest.get(j).id_CauHoi }" value="D" id="rdoPhuongAn-D-${listTest.get(j).id_CauHoi }" onclick="submitAnswer(${j}, this)"/>
																		<label for="rdoPhuongAn-D-${listTest.get(j).id_CauHoi }" aria-labelledby="rdoPhuongAn-D-${listTest.get(j).id_CauHoi }">D. </label>
																		<div class="margin-left">
																			<p>${listTest.get(j).option4 }</p>
																		</div>
																	</div>
																</li>
															</ul>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
								<input type="submit" id="subm" value="Nộp bài" onclick="nopBai()">
								</div>
							</div>
						</div>
					</div>
			    </c:if>
			</c:if>
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
            		<c:if test="${not empty prevLess }">
            			<c:set value = "${pageContext.request.contextPath}/mycourse/${nameKHSl}-${prevLess.id_KhoaHoc}-${prevLess.id_BaiHoc}" var="prevLess"></c:set>
            			<c:set value = "" var="style"></c:set>
            		</c:if>
            		<c:if test="${empty prevLess }">
            			<c:set value = "javascript:void(0)" var="prevLess"></c:set>
            			<c:set value = "style='opacity:0.5'" var="style"></c:set>
            		</c:if>
                    <a href="${prevLess }" ${style } title="B&#224;i học trước">
                        <span class="icon-chevron-left icon-large"></span>
                    </a>
            </div>
            <div class="col-xs-6">
            		<c:if test="${not empty nextLess }">
            			<c:set value = "${pageContext.request.contextPath}/mycourse/${nameKHSl}-${nextLess.id_KhoaHoc}-${nextLess.id_BaiHoc}" var="nextLess"></c:set>
            			<c:set value = "" var="style"></c:set>
            		</c:if>
            		<c:if test="${empty nextLess }">
            			<c:set value = "javascript:void(0)" var="nextLess"></c:set>
            			<c:set value = "style='opacity:0.5'" var="style"></c:set>
            		</c:if>
            		
                   	<a href="${nextLess }" ${style } title="B&#224;i học tiếp theo">
                        <span class="icon-chevron-right icon-large"></span>
                    </a>
            </div>
        </div>
		
		<div class="course-complete">
			<c:if test="${lesson.loai == 'baihoc' && less.hoanThanh != 2 }">
				<a href="${pageContext.request.contextPath}/mycourse/${nameKHSl}-${nextLessN.id_KhoaHoc}-${nextLessN.id_BaiHoc}" title="Qua bài">
					<span class="qua">»</span> Qua b&#224;i 
				</a>
			</c:if>
			<c:if test="${less.hoanThanh == 2 }">
				<a href="javascript:void(0)" title="Qua bài">
					<span class="qua">»</span> Đã hoàn thành 
				</a>
			</c:if>
			<c:if test="${lesson.loai == 'kiemtra' && less.hoanThanh == 1 }">
				<div id="clockdiv">
					<img alt="" src="${defines.urlPublic }/images/time-gif2.png" />
					<div>
						<span class="minutes"></span>
					</div>
					<span>:</span>
					<div>
						<span class="seconds"></span>
					</div>
				</div>
			</c:if>
		</div>

    </div>

<!-- Scripts -->
<script type="text/javascript"></script>
<script type="text/javascript">
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


	////////////////////////////////////////////////////
	function showReply(idCmt){  
	   $(".reply-action-"+idCmt).slideToggle();
	}

	////////////////////////////////////////////////////

</script>

<script>
 	function doComment(){
       var content_tmp = $('#txtAreaSendPost').val();
       var id_less = ${lesson.id_BaiHoc};
       var hoTen = "${userInfo.hoTen}";
       var hinhAnh = "${userInfo.hinhAnh}"
       console.log(content_tmp)
       $('#txtAreaSendPost').val('');
       if(content_tmp==""){
    	   alert('Vui lòng nhập bình luận!');
       }else{
    	   $.ajax({
    			url:'${pageContext.request.contextPath}/comments',
    			type: 'POST',
    			cache:false,
    			data:{
    				acontent : content_tmp,
    				aid : id_less,
    				ahoten: hoTen,
    				ahinhanh: hinhAnh
    			},
    			success:function(data){
    				$('.comment-list').html(data);
    			},
    			error:function(){
    				alert('Có lỗi');
    			}
    		});
       }
 	}
 	
 	function doRepComment(idCmt){
 		var id_cmt = idCmt;
       var content_tmp = $('#content-rep-'+idCmt).val();
       var id_less = ${lesson.id_BaiHoc};
       var hoTen = "${userInfo.hoTen}";
       var hinhAnh = "${userInfo.hinhAnh}"
       console.log(content_tmp)
       $('#content-rep').val('');
       if(content_tmp==""){
    	   alert('Vui lòng nhập nội dung bình luận!');
       }else{
    	   $.ajax({
    			url:'${pageContext.request.contextPath}/repcomments',
    			type: 'POST',
    			cache:false,
    			data:{
    				aidCmt : id_cmt,
    				acontent : content_tmp,
    				aidLess : id_less,
    				ahoten: hoTen,
    				ahinhanh: hinhAnh
    			},
    			success:function(data){
    				$('.rep-'+idCmt).html(data);
    			},
    			error:function(){
    				alert('Có lỗi');
    			}
    		});
       }
 	}
 	
 </script>
 
<c:if test="${lesson.loai == 'kiemtra' && less.hoanThanh == 1 }">

<script src="${defines.urlPublic }/js/counttime.js"></script>

 <script type="text/javascript">
	//list đáp án
	var answers = ${listDA};
	console.log({ 'data': answers });
	
</script>
 
 <script>
 	var useranswers = new Array();
 	function startTest(kid, lid){
		  $.ajax({
		    url: "${pageContext.request.contextPath}/mycourse/startTest",
		    type: 'POST',
		    cache: false,
		   	data: {
		      akid : kid,
		      alid: lid
		    },
		    success: function(response){
		        if(response == 1){
		        	window.location.href = '${pageContext.request.contextPath}/mycourse/${nameKHSl}-'+kid+'-'+lid;
		        }
		    },
		    error: function (){
		      alert('Có lỗi');
		    }
		  }); 
	}
 	
 	function submitAnswer(questionId, obj) {
 		var c = ${sizeTest };
	    useranswers[questionId] = obj.value;
	    useranswers[c] = null;
	} 
 	
 	function nopBai() {
        nopBaiVaKetThuc(0);
        return false;
    }

 	function nopBaiVaKetThuc(isTimeOut) {
 		alert("data:"+isTimeOut)
		var answered = 0;
 		var maDe = ${lesson.id_BaiHoc};
        var kid = ${kid};
        var nextLessN = ${nextLessN.id_KhoaHoc};
		useranswersCount = useranswers.length;
		for(i=0; i < useranswersCount; i++){
			if(useranswers[i] != null){
				answered++;
			}
			//alert("data:" + useranswers[i])
		}
		console.log({ 'data': useranswers });
		if (answered != useranswersCount && isTimeOut == 0) {
            var thongBao = "Bạn đã trả lời "+answered+ "/"+useranswersCount+". Bạn có muốn nộp bài không?";
            var resultConfirm = confirm(thongBao);
            
            if (resultConfirm == true) {
                 $.ajax({
                    url: '${pageContext.request.contextPath}/mycourse/saveTest',
                    type: 'POST',
                    cache: false,
                    data: { 
                    	listanswers: useranswers
                    },
                    success: function (response) {
                    	if (response == 1) {
                            $.ajax({
                               url: '${pageContext.request.contextPath}/mycourse/finishTest',
                               type: 'POST',
                               cache: false,
                               data: { 
                               	amaDe: maDe,
                               	akid: kid
                               },
                               success: function (response) {
                            	   if(response < 50){
                            		   alertMsg = "Bạn chưa đạt bài kiểm tra!!! \n";
                            		   alertMsg +="Bạn trả lời đúng " + response + "%. \nBạn có muốn làm lại không? ";
                            		   var resultConfirm1 = confirm(alertMsg);
                            		   if(resultConfirm1 == true){
                            			   startTest(kid,maDe);
                            		   }else{
                            			   window.location.href = '${pageContext.request.contextPath}/mycourse/${nameKHSl}-'+kid+'-'+maDe;
                            		   }
                            	   }else{
                            		   alert("Chúc mừng bạn đã đạt bài kiểm tra!!!");
                            	   }
                               },
                               error: function () {
                                     console.log("Lỗi gởi dữ liệu lên server")
                               }
                           });
                       }else {
                           alert('Lỗi khi nộp bài vui lòng thử lại');
                       }
                    },
                    error: function () {
                          console.log("Lỗi gởi dữ liệu lên server")
                    }
                });

            }
        }else{
        	// Nếu thực hiện tất cả rồi thì nộp luôn
        	console.log("hello")
        	$.ajax({
                url: '${pageContext.request.contextPath}/mycourse/saveTest',
                type: 'POST',
                cache: false,
                data: { 
                	listanswers: useranswers
                },
                success: function (response) {
                	if (response == 1) {
                        $.ajax({
                           url: '${pageContext.request.contextPath}/mycourse/finishTest',
                           type: 'POST',
                           cache: false,
                           data: { 
                           	amaDe: maDe,
                           	akid: kid
                           },
                           success: function (response) {
                        	   if(response < 50){
                        		   alertMsg = "Bạn chưa đạt bài kiểm tra!!! \n";
                        		   alertMsg +="Bạn trả lời đúng " + response + "%. \nBạn có muốn làm lại không? ";
                        		   var resultConfirm1 = confirm(alertMsg);
                        		   if(resultConfirm1 == true){
                        			   startTest(kid,maDe);
                        		   }else{
                        			   window.location.href = '${pageContext.request.contextPath}/mycourse/${nameKHSl}-'+kid+'-'+maDe;
                        		   }
                        	   }else{
                        		   //alert("Chúc mừng bạn đã đạt bài kiểm tra!!!");
                        		   window.location.href = '${pageContext.request.contextPath}/mycourse/${nameKHSl}-'+kid+'-'+nextLessN;
                        	   }
                           },
                           error: function () {
                                 console.log("Lỗi gởi dữ liệu lên server")
                           }
                       });
                   }else {
                       alert('Lỗi khi nộp bài vui lòng thử lại');
                   }
                },
                error: function () {
                      console.log("Lỗi gởi dữ liệu lên server")
                }
            });
        }
    }
 </script>
 </c:if>
</body>
</html>