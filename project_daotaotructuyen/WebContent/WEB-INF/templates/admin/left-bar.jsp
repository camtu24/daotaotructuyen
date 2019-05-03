<!--sidebar-menu-->
<div id="sidebar"><a href="#" class="visible-phone"><i class="icon icon-home"></i> Dashboard</a>
  <ul>
    <li class="active"><a href="${pageContext.request.contextPath }/admin"><i class="icon icon-home"></i> <span>Trang chủ</span></a> </li>
    <li><a href="${pageContext.request.contextPath }/admin/orders"><i class="icon icon-list-alt"></i> <span>Đơn hàng</span><span class="label label-important" style="height:17px">${countOrder }</span></a></li>
    <li class="submenu"> <a href="#"><i class="icon icon-group"></i> <span>Quản lý tài khoản</span> <!-- <span class="label label-important">3</span> --></a>
      <ul>
        <li><a href="${pageContext.request.contextPath }/admin/qtv">Quản trị viên</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/teachers">Giảng viên</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/students">Học viên</a></li>
      </ul>
    </li>
    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Quản lý khóa học</span> <!-- <span class="label label-important">3</span> --></a>
      <ul>
        <li><a href="${pageContext.request.contextPath }/admin/subjects">Chủ đề</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/courses">Khóa học</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/class">Lớp học</a></li>
      </ul>
    </li>
    <li><a href="${pageContext.request.contextPath }/admin/contacts"><i class="icon icon-envelope-alt"></i> <span>Liên hệ</span> <span class="label label-important" style="height:17px">${countContact }</span></a></li> 
    <li><a href="${pageContext.request.contextPath }/admin/news"><i class="icon icon-globe"></i> <span>Tin tức</span></a></li>
    <li><a href="${pageContext.request.contextPath }/admin/sliders"><i class="icon icon-picture"></i> <span>Slider</span></a></li>
    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>Thông tin lưu trữ</span> <!-- <span class="label label-important">3</span> --></a>
      <ul>
        <li><a href="${pageContext.request.contextPath }/admin/courses/storage">Khóa học</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/orders/storage">Đơn hàng</a></li>
        <li><a href="${pageContext.request.contextPath }/admin/accounts/storage">Tài khoản</a></li>
      </ul>
    </li>
    
    <!-- <li class="content"> <span>Monthly Bandwidth Transfer</span>
      <div class="progress progress-mini progress-danger active progress-striped">
        <div style="width: 77%;" class="bar"></div>
      </div>
      <span class="percent">77%</span>
      <div class="stat">21419.94 / 14000 MB</div>
    </li>
    <li class="content"> <span>Disk Space Usage</span>
      <div class="progress progress-mini active progress-striped">
        <div style="width: 87%;" class="bar"></div>
      </div>
      <span class="percent">87%</span>
      <div class="stat">604.44 / 4000 MB</div>
    </li> -->
  </ul>
</div>
<!--sidebar-menu-->