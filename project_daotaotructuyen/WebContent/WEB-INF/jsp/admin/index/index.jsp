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
              <div class="chart"></div>
            </div>
            <div class="span3">
              <ul class="site-stats">
                <li class="bg_lh"><i class="icon-user"></i> <strong>2540</strong> <small>Total Student</small></li>
                <li class="bg_lh"><i class="icon-plus"></i> <strong>50</strong> <small>Total Teacher </small></li>
                <li class="bg_lh"><i class="icon-shopping-cart"></i> <strong>656</strong> <small>Total Order</small></li>
                <li class="bg_lh"><i class="icon-tag"></i> <strong>9540</strong> <small>Total Course</small></li>
                <li class="bg_lh"><i class="icon-repeat"></i> <strong>10</strong> <small>Total News</small></li>
                <li class="bg_lh"><i class="icon-globe"></i> <strong>8540</strong> <small>Total Class</small></li>
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