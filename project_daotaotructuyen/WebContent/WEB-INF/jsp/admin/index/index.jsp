<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="${pageContext.request.contextPath }/admin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li style="min-width: 15.474%;" class="bg_lb"> <a href="${pageContext.request.contextPath }/admin/orders"> <i class="icon-list-alt"></i>  Đơn hàng </a> </li>
        <!-- <li class="bg_lg span3"> <a href="charts.html"> <i class="icon-signal"></i> <span class="label label-success">101</span> Charts</a> </li> -->
        <li style="min-width: 15.474%;" class="bg_ly"> <a href="${pageContext.request.contextPath }/admin/students"> <i class="icon-user"></i> Học viên </a> </li>
        <li style="min-width: 15.474%;" class="bg_lo"> <a href="${pageContext.request.contextPath }/admin/teachers"> <i class="icon-user"></i> Giảng viên</a> </li>
        <li style="min-width: 15.474%;" class="bg_ls"> <a href="${pageContext.request.contextPath }/admin/courses"> <i class="icon-th-list"></i> Khóa học</a> </li>
        <li style="min-width: 15.474%;" class="bg_ls"> <a href="${pageContext.request.contextPath }/admin/contact"> <i class="icon-envelope-alt"></i> Liên hệ</a> </li>
        <li style="min-width: 15.474%;" class="bg_ls"> <a href="${pageContext.request.contextPath }/admin/news"> <i class="icon-globe"></i> Tin tức</a> </li>
      </ul>
    </div>
<!--End-Action boxes-->    

<!--Chart-box-->    
    <div class="row-fluid">
      <div class="widget-box">
        <div class="widget-title bg_lg"><span class="icon"><i class="icon-signal"></i></span>
          <h5>Site Analytics</h5>
        </div>
        <div class="widget-content" style="height: 390px;">
          <div class="row-fluid">
            <div class="span9">
              <div class="chart">
              	<script src="https://code.highcharts.com/highcharts.js"></script>
				<script src="https://code.highcharts.com/modules/data.js"></script>
				<script src="https://code.highcharts.com/modules/drilldown.js"></script>
				<div id="container" style="min-width: 310px; height: 350px; margin: 0 auto"></div>
				<script src="${defines.urlAdmin }/js/chart.js"></script>
              </div>
            </div>
            <div class="span3">
              <ul class="site-stats">
                <li class="bg_lh"><i class="icon-user"></i> <strong>30</strong> <small>Học viên</small></li>
                <li class="bg_lh"><i class="icon-plus"></i> <strong>10</strong> <small>Giảng viên </small></li>
                <li class="bg_lh"><i class="icon-shopping-cart"></i> <strong>15</strong> <small>Đơn hàng</small></li>
                <li class="bg_lh"><i class="icon-tag"></i> <strong>12</strong> <small>Khóa học</small></li>
                <li class="bg_lh"><i class="icon-repeat"></i> <strong>5</strong> <small>Lớp học</small></li>
                <li class="bg_lh"><i class="icon-globe"></i> <strong>7</strong> <small>Tin tức</small></li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
<!--End-Chart-box--> 
  </div>
</div>

<!--end-main-container-part-->