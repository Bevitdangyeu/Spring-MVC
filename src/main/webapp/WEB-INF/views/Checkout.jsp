<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <c:url var="ApiUrl" value="/api/bill/add"></c:url>
          <c:url var="NewUrl" value="/public/Cart/view"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<section class="ftco-section ftco-cart">
			<div class="checkout" style="display: flex;" >
				<!-- <div class="row"> -->
    		<!-- 	<div class="col-md-12 ftco-animate"> -->
				<!-- <div class="row justify-content-start d-flex"> -->
    			<div class="col col-lg-3  cart-wrap ftco-animate" style="">
    				<div class="cart-total mb-1">
    					<h3>Thông tin khách hàng</h3>
    					<p class="d-flex">
    						<span style="width:30%" >Tên</span>
    						<span><input id="customerName" placeholder="Họ và tên:" type="text" value="" style="border-radius:10px;width:130%;padding-left:10px;border:1px dashed #DDDDDD"></span>
    						
    					</p>
    					<p class="d-flex">
    						<span style="width:30%"  >Địa chỉ</span>
    						<span>
    							<input id="address" placeholder="Địa chỉ:" type="text" value="" style="border-radius:10px;width:130%;padding-left:10px;border:1px dashed #DDDDDD">
    							<input placeholder="Huyện/Thành Phố:" type="text" value="" style="border-radius:10px;width:130%;padding-left:10px;border:1px dashed #DDDDDD;margin-top:10px">
    							<input placeholder="Tỉnh:" type="text" value="" style="border-radius:10px;width:130%;padding-left:10px;border:1px dashed #DDDDDD;margin-top:10px">
    						</span>
    					</p>
    					<p class="d-flex">
    						<span style="width:30%" >Số điện thoại</span>
    						<span><input id="phone" placeholder="Số điện thoại" type="text" value="" style="border-radius:10px;width:130%;padding-left:10px;border:1px dashed #DDDDDD""></span>
    					</p>
    					<hr>
    					<p class="d-flex total-price">
    						<span style="width:30%" >Ghi chú</span>
    						<span>$17.60</span>
    					</p>
    				</div>
    				
    			
    			</div>
    			<div class="col col-lg-8 cart-wrap ftco-animate">
	    			<div class="cart-total mb-1">
	    				<h3>Thông tin sản phẩm</h3>
	    				<c:forEach var="item" items="${checkout.items }"  varStatus="status">
	    					<div class="product" style="display:flex;margin:15px;border:1px dashed #DDDDDD;padding:10px">
	    						<div style="margin-right:30px">
		    						<input type="hidden" id="img${status.index}" value="${item.image  }">
		    							<img style="height:100px;width:100px ;object-fit: cover;border-radius:50px;border:1px dashed  #888888;" alt="" src="${item.image }">
	    							
	    						</div>
	    						<div style="width:40%" >
	    							<p style="margin:5px" class="d-flex">
	    								<span style="width:30%;color:#DDDDDD" >Name</span>
	    								<span style="width:70%" ><input value="${item.product }" id="name${status.index}" readonly style="border:none"  /></span>
	    							</p>
	    							<p style="margin:5px" class="d-flex">
	    								<span style="width:30%;color:#DDDDDD" >Size</span>
	    								<span style="width:70%" ><input style="border:none" value="${item.size }" id="size${status.index}" readonly /></span>
	    							</p>
	    							<p style="margin:5px" class="d-flex">
	    								<span style="width:30%;color:#DDDDDD" >Color</span>
	    								<span style="width:70%" ><input style="border:none" value="${item.color }" id="color${status.index}" readonly /></span>
	    							</p>
	    						</div>
	    						<div class="d-flex justify-content-center " style=" align-items: center;">
	    							<p style="margin-left:30px;text-align: center;" class="d-flex">
	    								<span ><input style="border:none" value="${item.prince}" id="price${status.index}" readonly /></span>
	    							</p>
	    							<p style="margin-left:30px;text-align: center;" class="d-flex">
	    								<span ><input style="border:none" value="${item.quantity }" id="quantity${status.index}" readonly /></span>
	    							</p>
	    							<p style="margin-left:30px;text-align: center;" class="d-flex">
	    								<span ><input style="border:none" value="${item.total }" id="total${status.index}" readonly /></span>
	    							</p>
	    						</div>
	    						
	    					</div>
	    				</c:forEach>
	    				<div>
		    				<p >
		    					<span style="width:100%;text-align: right;margin-right:70px;padding:10px" ><input id="totalBill" value=" Tổng tiền: ${checkout.totalPrice} " style="border-radius:10px;border:1px dashed #DDDDDD"/></span>
		    				</p>
	    				</div>
	    				<div style="text-align: right; ">
					    <p style="width: 20%;display: inline-block;">
					      <a class="btn btn-primary" id="checkout" href="#" >ĐẶT HÀNG</a>
					     <%--  '<c:url value="/public/Cart/view"/>' --%>
					    </p>
					</div>
	    				
    			</div>
    			</div>
    				
    		</div>
    		
</section>
<script type="text/javascript">

	$("#checkout").click(function (event) {
		event.preventDefault();
		var listProduct=[];
		var employee=1;
		var customerName=$('#customerName').val();
		var address=$('#address').val();
		var phoneNumber=$('#phone').val();
		var totalBill=$('#totalBill').val();
			$(".product").each(function() {
		        var name = $(this).find("input[id^='name']").val(); // Tìm input có id bắt đầu bằng 'name'
		        var size = $(this).find("input[id^='size']").val(); // Tìm input có id bắt đầu bằng 'size'
		        var color = $(this).find("input[id^='color']").val(); // Tìm input có id bắt đầu bằng 'color'
		        var price = $(this).find("input[id^='price']").val(); // Tìm input có giá trị bắt đầu bằng 'x'        
		        var quantity = $(this).find("input[id^='quantity']").val(); // Tìm input có giá trị bắt đầu bằng 'x'
		        var img = $(this).find("input[id^='img']").val();
		        var total=$(this).find("input[id^='total']").val();
		        var product={product:name,quantity:quantity,prince:price,size:size,color:color,image:img,total:total};
		        listProduct.push(product);
	});
		add({employeeID:employee,customerName:customerName,address:address,phone:phoneNumber,items:listProduct});
		
	});
	function add(data) {
		$.ajax({
			url:'${ApiUrl}',
			type:'post',
			data: JSON.stringify(data),
			contentType :'application/json',
			dataType: 'json',
			success: function (result) {
				window.location.href='${NewUrl}'
			},
			error: function (error) {
				//showToast("Edit request failed","danger");
				window.location.href='${NewUrl}'
				console.log(error);
			}
		});
	};
</script>
</body>
</html>