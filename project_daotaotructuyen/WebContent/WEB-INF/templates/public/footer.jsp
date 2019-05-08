<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Footer -->
<div class="wrapper row2">
  <div class="clear1">
	"Chúng tôi đặt một giá trị cao về mối quan hệ của chúng tôi với mỗi và mọi khách hàng trên tất cả. 
	Chúng tôi hiểu rằng mọi doanh nghiệp đều có nét riêng và sẽ luôn nhìn bạn như vậy."
  </div>
</div>
<div class="wrapper row2">
  <div id="footer" class="clear">
    <div class="one_quarter foo-c">
      <h2 class="footer_title">Contact Us</h2>
      <form class="rnd5" action="${pageContext.request.contextPath }/contact" method="post">
        <div class="form-input clear">
          <label for="ft_author">Name <span class="required">*</span><br>
            <input type="text" name="hoTen" id="ft_author" required value="" size="22">
          </label>
          <label for="ft_email">Số điện thoại <span class="required">*</span><br>
            <input type="text" name="SDT" id="ft_email" required value="" size="22">
          </label>
          <label for="ft_email">Email <span class="required">*</span><br>
            <input type="email" name="email" id="ft_email" required value="" size="22">
          </label>
        </div>
        <div class="form-message">
          <textarea name="noiDung" id="ft_message" cols="25" rows="10" required placeholder="Nội dung"></textarea>
        </div>
        <p>
          <input type="submit" value="Submit" class="button small orange">
          &nbsp;
          <input type="reset" value="Reset" class="button small grey">
        </p>
      </form>
    </div>
	<div class="one_quarter" style="margin: 0 0 0 5%">
      <div id="googleMap">
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3833.837812198911!2d108.22229297687441!3d16.073903969253372!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x314218307780e03b%3A0xf2dffa50b3ae58cb!2zMzEgxJDGsOG7nW5nIFRy4bqnbiBQaMO6LCBI4bqjaSBDaMOidSAxLCBRLiBI4bqjaSBDaMOidSwgxJDDoCBO4bq1bmcgNTUwMDAwLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1554107730208!5m2!1svi!2s" width="100%" height="485" frameborder="0" style="border:0" allowfullscreen></iframe>
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
<!-- Scripts -->
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.min.js"></script>
<script>window.jQuery || document.write('<script src="layout/scripts/jquery-latest.min.js"><\/script>\
<script src="layout/scripts/jquery-ui.min.js"><\/script>')</script>
<script>jQuery(document).ready(function($){ $('img').removeAttr('width height'); });</script>
<script src="${defines.urlPublic }/js/responsiveslides.min.js"></script>
<script src="${defines.urlPublic }/js/jquery-mobilemenu.min.js"></script>
<script src="${defines.urlPublic }/js/custom.js"></script>
</body>
</html>