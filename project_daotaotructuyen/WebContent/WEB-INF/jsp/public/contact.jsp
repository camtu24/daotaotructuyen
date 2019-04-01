<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/templates/taglib.jsp" %>
    <div id="contact" class="clear">
    <c:if test="${not empty msg }">
	      <div class="alert alert-success">
			<strong>${msg }</strong>
			<script type="text/javascript">alert(msg)</script>
		  </div>
	  </c:if>
      <div class="contact-div one_half first">
        <h1 style="color:#fff">Liên hệ</h1>
        <p style="color:#fff">Liên hệ ngay hôm nay để được tư vấn cụ thể hơn. Đây có thể là quyết định tốt nhất về tư vấn kỹ thuật mà bạn từng thực hiện.</p>
        <div id="respond" style="color:#fff">
          <form class="rnd5" action="${pageContext.request.contextPath }/contact" method="post">
            <div class="form-input clear">
              <label for="author">Họ tên <span class="required">*</span><br>
                <input class="contact-input" type="text" name="hoTen" id="author" value="" size="22" required placeholder="Nguyễn Văn A">
              </label>
              <label for="email">Email <span class="required">*</span><br>
                <input class="contact-input" type="email" name="email" id="email" value="" size="22" required placeholder="anguyen@gmail.com">
              </label>
              <label for="email">Số điện thoại <span class="required">*</span><br>
                <input class="contact-input" type="text" name="SDT" id="sdt" value="" size="22" required placeholder="0123456789">
              </label>
            </div>
            <div class="form-message">
              <label style="margin-bottom:5px" for="noiDung">Nội dung <span class="required">*</span><br>
              </label>
              <textarea name="noiDung" id="message" cols="25" rows="10" required placeholder="Tôi có thắc mắc..."></textarea>
            </div>
            <p>
              <input type="submit" value="Submit">
              &nbsp;
              <input type="reset" value="Reset">
            </p>
          </form>
        </div>
      </div>
      <div class="one_half">
        <div class="map push50">
			<div id="googleMap">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3833.837812198911!2d108.22229297687441!3d16.073903969253372!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314218307780e03b%3A0xf2dffa50b3ae58cb!2zMzEgxJDGsOG7nW5nIFRy4bqnbiBQaMO6LCBI4bqjaSBDaMOidSAxLCBRLiBI4bqjaSBDaMOidSwgxJDDoCBO4bq1bmcgNTUwMDAwLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1554107730208!5m2!1svi!2s" width="100%" height="300" frameborder="0" style="border:0" allowfullscreen></iframe>
			</div>
		</div>
        <section class="contact_details clear">
          <h2>Liên hệ với chúng tôi</h2>
          <p>Khi chúng tôi liên hệ với một khách hàng mới, chúng tôi muốn tìm hiểu càng nhiều càng tốt về nhu cầu của khách hàng từ thời điểm bắt đầu để chúng tôi có thể có được những nhân sự tốt nhất làm việc với bạn. Vui lòng cho chúng tôi biết một vài chi tiết và cách tốt nhất để liên hệ lại với bạn. Bất kể dự án của bạn đang trong giai đoạn nào, chúng tôi luôn sẵn sàng trò chuyện.</p>
          <div class="one_half first" style="width: 100%;">
            <address>
            Company Name: Công ty TNHH MTV Tư Vấn Giải pháp Công nghệ Thông tin Toàn Cầu Xanh <br>
            Street Name &amp; Number: 31 Trần Phú, Quận Hải Châu, Thành phố Đà Nẵng, Việt Nam<br>
          
            </address>
          </div>
          <div class="one_half">
            <ul class="list none">
              <li>Tel: (+84) 2363 833 666</li>
              <li>Email: contact@greenglobal.vn</li>
            </ul>
          </div>
        </section>
      </div>
    </div>