<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:url var="filter" value="/public/home/filter"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style type="text/css">
.dropdown-submenu {
  position: relative;
}

.dropdown-submenu .dropdown-menu {
  top: 0;
  left: 100%; /* Để menu con xuất hiện bên phải của menu cha */
  margin-top: -6px;
  margin-left: -1px;
}
</style>

</head>
<body>
	 <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="index.html">Minishop</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href='<c:url value="/public/home?page=1&limit=17&sortBy=name"/>' class="nav-link">Home</a></li>
	           <li class="nav-item active"><a href='<c:url value="/user/chat?userId=${user.customerId }"/>' class="nav-link">Chat</a></li>
	          <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Catalog</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04">
              	<a class="dropdown-item" href="shop.html">Shop</a>
                <a class="dropdown-item" href="product-single.html">Single Product</a>
                <a class="dropdown-item" href="<c:url value="/public/Cart/view"/>">Cart</a>
                <a class="dropdown-item" href="checkout.html">Checkout</a>
              </div>
            </li>
	          <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
	          <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
	          <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
	          <li class="nav-item cta cta-colored"><a href="<c:url value="/public/Cart/view"/>" class="nav-link"><span style="font-size:30px" class="icon-shopping_cart"></span></a></li>
	          <li class="nav-item"><a href='<c:url value="/user/PurchaseHistory/confirm?customerId=${user.customerId }"/>' class="nav-link"><i style="font-size:20px;margin-top:4px" class="fa fa-truck" aria-hidden="true"></i></a></li>
	          <li>
	          	<form action='<c:url value="/public/home/search"/>' method="get">
	          		 <button id="btn_search" type="submit" style="border:0px;background-color: transparent"><i style="margin-top:5px;margin-left:20px "class="fa fa-search" aria-hidden="true"></i> </button>
	          		<input value="${search }" id="search" name="search" placeholder="Nhập tên sản phẩm" style="margin-top:5px; border-radius:10px;border:1px dashed #888888;background-color: transparent;color:while;outline: none;padding-left:10px"></input>
	          	</form>
	          </li>
	          
	        </ul>
	      </div>
	    </div>
	  </nav>
	  <script>
	  $(document).ready(function() {
		    // Lắng nghe sự kiện change khi checkbox thay đổi trạng thái
		    $('#filterDuoi500').on('change', function() {
		        var isChecked = $(this).is(':checked');  // Kiểm tra xem checkbox có được chọn hay không
		        var price = $(this).val();  // Lấy giá trị của checkbox

		        // Tạo đối tượng dữ liệu để gửi về server
		        var requestData = {
		        	prince: price
		        };

		        // Gửi AJAX request đến server
		        $.ajax({
		            url: '${filter}',  // Đường dẫn tới API xử lý lọc
		            method: 'POST',
		            contentType: 'application/json',
		            data: JSON.stringify(requestData),
		            success: function(htmlResponse) {
		                console.log("Received response:", htmlResponse); // Debug log
		                // Nhận kết quả từ server và cập nhật giao diện
		                var parsedHtml = $.parseHTML();
       					 $('#product-list').html(parsedHtml); // Thay thế nội dung // Ví dụ: cập nhật danh sách sản phẩm
		            },
		            error: function(xhr, status, error) {
		            	// $('#product-list').html(response); 
		                console.error('Lỗi khi gửi yêu cầu lọc:', error);
		            }
		        });
		    });
		});
	  </script>
</body>
</html>