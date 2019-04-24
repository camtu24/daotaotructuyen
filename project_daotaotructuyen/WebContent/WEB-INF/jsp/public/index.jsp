<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
	<div id="container c-slide" style="padding:0;">
	<div id="homepage" class="clear">
      <div class="two_third first" style="width:100%">
        <section class="main_slider" style="margin-bottom:50px">
          <div class="rslides_container clear">
            <ul class="rslides clear" id="rslides">
            <c:forEach items="${listSlide }" var="objS">
              <li><img src="${pageContext.request.contextPath }/files/${objS.hinhAnh}" alt=""></li>
              </c:forEach>
            </ul>
          </div>
        </section>
		<div class="noidung-slide">
			<p class="ct1">>>* KHỞI ĐẦU SỰ NGHIỆP CỦA BẠN *<<</p>
			<p class="ct2">Trở thành lập trình viên chuyên nghiệp tại Green Global</p>
			<a href="#" class="button medium black" style="margin-right:50px;font-size:20px">Xem khóa học</a>
			<a href="#" class="button medium white" style="font-size:20px">Tư vấn học</a>
		</div>
	  </div>
	</div>
	</div>
  <div id="container">
    <!-- ################################################################################################ -->
    <div id="homepage" class="clear">
      <div class="two_third first" style="width:100%">
        
        <ul class="nospace push50 clear">
          <li class="one_third first" style="border-right: 2px solid;">
            <article>
			<p class="soluong">1234</p>
               <p class="doituong">Giảng viên</p>

            </article>
          </li>
          <li class="one_third" style="border-right: 2px solid;">
            <article>
              <p class="soluong">1234</p>
              <p class="doituong">Học viên</p>
 
            </article>
          </li>
          <li class="one_third">
            <article>
             <p class="soluong">1234</p>
               <p class="doituong">Đối tác</p>
              
            </article>
          </li>
        </ul>
        <div class="divider2"></div>
		<h3 class="uudiem">Điểm ưu việt</h3>
        <ul class="nospace push50 clear" style="background-color: powderblue;">
          <li class="one_third first"  style="height: 260px;">
			<p class="ic"><span class="icon-check"></span></p>
            <article style="text-align: center; font-size: 15px;">
              
              <h2 class="font-medium nospace"><a href="#">Học theo lộ trình, có định hướng</a></h2>
              <p class="nospace">CyberSoft sẽ định hướng và đưa ra các lộ trình học tập cho nghề bạn theo đuổi. Phát triển năng lực và niềm đam mê cảm hứng lập trình của bạn.</p>
            </article>
          </li>
          <li class="one_third" style="height: 260px;">
		  <p class="ic"><span class="icon-check"></span></p>
            <article style="text-align: center; font-size: 15px;">
              
              <h2 class="font-medium nospace"><a href="#">Nền tảng, tư duy, cốt lõi trong lập trình</a></h2>
              <p class="nospace">CyberSoft cung cấp những nền tảng, giá trị tư duy cốt lõi nhất trong lập trình. Bạn sẽ tự tin trước sự thay đổi của công nghệ và môi trường làm việc.</p>
            </article>
          </li>
          <li class="one_third" style="height: 260px;">
		  <p class="ic"><span class="icon-check"></span></p>
            <article style="text-align: center; font-size: 15px;">
             
              <h2 class="font-medium nospace"><a href="#">Mài giũa bạn qua kinh nghiệm, dự án thực tế</a></h2>
              <p class="nospace">Đội ngũ Giảng viên và các Mentor là những người dày dạn kinh nghiệm qua các dự án thực tế tại các công ty lớn sẽ truyền đạt những kinh nghiệm "máu lửa" cho bạn.</p>
            </article>
          </li>
		  
		  <li class="one_third" style="height: 260px; margin-left:0">
		  <p class="ic"><span class="icon-check"></span></p>
            <article style="text-align: center; font-size: 15px;">
             
              <h2 class="font-medium nospace"><a href="#">Mài giũa bạn qua kinh nghiệm, dự án thực tế</a></h2>
              <p class="nospace">Đội ngũ Giảng viên và các Mentor là những người dày dạn kinh nghiệm qua các dự án thực tế tại các công ty lớn sẽ truyền đạt những kinh nghiệm "máu lửa" cho bạn.</p>
            </article>
          </li>
		  
		  <li class="one_third" style="height: 260px;">
		  <p class="ic"><span class="icon-check"></span></p>
            <article style="text-align: center; font-size: 15px;">
             
              <h2 class="font-medium nospace"><a href="#">Mài giũa bạn qua kinh nghiệm, dự án thực tế</a></h2>
              <p class="nospace">Đội ngũ Giảng viên và các Mentor là những người dày dạn kinh nghiệm qua các dự án thực tế tại các công ty lớn sẽ truyền đạt những kinh nghiệm "máu lửa" cho bạn.</p>
            </article>
          </li>
		  
		  <li class="one_third" style="height: 260px;">
		  <p class="ic"><span class="icon-check"></span></p>
            <article style="text-align: center; font-size: 15px;">
             
              <h2 class="font-medium nospace"><a href="#">Mài giũa bạn qua kinh nghiệm, dự án thực tế</a></h2>
              <p class="nospace">Đội ngũ Giảng viên và các Mentor là những người dày dạn kinh nghiệm qua các dự án thực tế tại các công ty lớn sẽ truyền đạt những kinh nghiệm "máu lửa" cho bạn.</p>
            </article>
          </li>
        </ul>
      </div>
      <!-- #### -->
      
    </div>
    <!-- ################################################################################################ -->
    <div class="clear"></div>
  </div>
<!-- </div>
Footer
<div class="wrapper row2">
  <div class="clear1">
	"Chúng tôi đặt một giá trị cao về mối quan hệ của chúng tôi với mỗi và mọi khách hàng trên tất cả. 
	Chúng tôi hiểu rằng mọi doanh nghiệp đều có nét riêng và sẽ luôn nhìn bạn như vậy."
  </div>
</div><div class="wrapper row2">
  <div id="footer" class="clear">
    <div class="one_quarter foo-c">
      <h2 class="footer_title">Contact Us</h2>
      <form class="rnd5" action="#" method="post">
        <div class="form-input clear">
          <label for="ft_author">Name <span class="required">*</span><br>
            <input type="text" name="ft_author" id="ft_author" value="" size="22">
          </label>
          <label for="ft_email">Email <span class="required">*</span><br>
            <input type="text" name="ft_email" id="ft_email" value="" size="22">
          </label>
        </div>
        <div class="form-message">
          <textarea name="ft_message" id="ft_message" cols="25" rows="10"></textarea>
        </div>
        <p>
          <input type="submit" value="Submit" class="button small orange">
          &nbsp;
          <input type="reset" value="Reset" class="button small grey">
        </p>
      </form>
    </div>
	<div class="one_quarter">
      <div id="googleMap">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3833.837812198911!2d108.22229297687441!3d16.073903969253372!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314218307780e03b%3A0xf2dffa50b3ae58cb!2zMzEgxJDGsOG7nW5nIFRy4bqnbiBQaMO6LCBI4bqjaSBDaMOidSAxLCBRLiBI4bqjaSBDaMOidSwgxJDDoCBO4bq1bmcgNTUwMDAwLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1554107730208!5m2!1svi!2s" width="100%" height="425" frameborder="0" style="border:0" allowfullscreen></iframe>
		</div>
    </div>
  </div>
</div>
<div class="wrapper row4">
  <div id="copyright" class="clear">
    <p class="fl_left">Copyright &copy; 2013 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
  </div>
</div>
Scripts
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.min.js"></script>
<script>window.jQuery || document.write('<script src="layout/scripts/jquery-latest.min.js"><\/script>\
<script src="layout/scripts/jquery-ui.min.js"><\/script>')</script>
<script>jQuery(document).ready(function($){ $('img').removeAttr('width height'); });</script>
<script src="layout/scripts/responsiveslides.js-v1.53/responsiveslides.min.js"></script>
<script src="layout/scripts/jquery-mobilemenu.min.js"></script>
<script src="layout/scripts/custom.js"></script>
<script>
window.onscroll = function() {myFunction()};

var navbar = document.getElementById("navbar");
var sticky = navbar.offsetTop;

function myFunction() {
  if (window.pageYOffset >= sticky) {
    navbar.classList.add("sticky")
  } else {
    navbar.classList.remove("sticky");
  }
}
</script>
</body>
</html> -->