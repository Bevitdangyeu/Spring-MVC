<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-md-2 bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
	 <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
          <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Quản lý thể loại</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header"> Quản Lý Thể Loại:</h6>
                        <a href='<c:url value="/admin/product"/>'
                        class="collapse-item" href="utilities-color.html">Danh sách thể loại
                        </a>
                   <!--      <a class="collapse-item" href="utilities-border.html">Thêm thể loại</a>
                        <a class="collapse-item" href="utilities-animation.html">Sửa thể loại</a>
                        <a class="collapse-item" href="utilities-other.html">Other</a> -->
                    </div>
                </div>
            </li>
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Quản lý sản phẩm</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header"> Danh mục</h6>
                        <a href='<c:url value="/admin1/product/list?page=1&totalItem=3&sortBy=name"/>'
                        class="collapse-item" href="utilities-color.html">Danh sách sản phẩm
                        </a>
                        <a href='<c:url value="/admin1/product/edit"/>'
                        class="collapse-item" href="utilities-color.html">Thêm sản phẩm
                        </a>
                   <!--      <a class="collapse-item" href="utilities-border.html">Thêm thể loại</a>
                        <a class="collapse-item" href="utilities-animation.html">Sửa thể loại</a>
                        <a class="collapse-item" href="utilities-other.html">Other</a> -->
                    </div>
                </div>
            </li>
              <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
                    aria-expanded="true" aria-controls="collapseUtilities">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>Quản lý hóa đơn</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header"> Danh mục</h6>
                        <a href='<c:url value="/admin1/bill/list?page=1&limit=2&sortBy=billId"/>'
                        class="collapse-item" href="utilities-color.html">Danh sách hóa đơn
                        </a>
                        <a href='<c:url value="/admin1/bill/edit"/>'
                        class="collapse-item" href="utilities-color.html">Thêm hóa đơn
                        </a>
                   <!--      <a class="collapse-item" href="utilities-border.html">Thêm thể loại</a>
                        <a class="collapse-item" href="utilities-animation.html">Sửa thể loại</a>
                        <a class="collapse-item" href="utilities-other.html">Other</a> -->
                    </div>
                </div>
            </li>
        </ul>
     </div>
 
</body>
</html>