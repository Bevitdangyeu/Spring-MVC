<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
  

        </ul>
</body>
</html>