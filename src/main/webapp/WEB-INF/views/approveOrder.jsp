<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:url var="ApiUrl" value="/api/bill/updateStatus"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col col-lg-8 cart-wrap ftco-animate">
	    <div class="cart-total mb-1">
	    	<c:forEach var="item" items="${list }"  varStatus="status">
	    		<div style="display:flex;width:100%;margin-right:10px;margin:20px;border:1px dashed #DDDDDD">
	    			<div class="col col-lg-3  cart-wrap ftco-animate" style="border:1px dashed #DDDDDD;margin:10px">
    				<div class="cart-total mb-2">
    				
    					<p class="d-flex">
    						<span style="width:40%" >Tên</span>
    						<span><input id="customerName" placeholder="Họ và tên:" type="text" value="${item.customerName }" style="border-radius:10px;width:100%;padding-left:10px;border:1px dashed #DDDDDD"></span>
    						
    					</p>
    					<p class="d-flex">
    						<span style="width:40%"  >Address</span>
    						<span>
    							<input id="address" placeholder="Địa chỉ:" type="text" value="${item.address }" style="border-radius:10px;width:100%;padding-left:10px;border:1px dashed #DDDDDD">
    							<input placeholder="H/Thành Phố:" type="text" value="" style="border-radius:10px;width:100%;padding-left:10px;border:1px dashed #DDDDDD;margin-top:10px">
    							<input placeholder="Tỉnh:" type="text" value="" style="border-radius:10px;width:100%;padding-left:10px;border:1px dashed #DDDDDD;margin-top:10px">
    						</span>
    					</p>
    					<p class="d-flex">
    						<span style="width:40%" >Phone</span>
    						<span><input id="phone" placeholder="Số điện thoại" type="text" value="${item.phone }" style="border-radius:10px;width:100%;padding-left:10px;border:1px dashed #DDDDDD""></span>
    					</p>
    					<hr>
    					
    				</div>
    				
    			
    			</div>
	    		<div style="display:block;margin: 10px" >
	    			<c:forEach var="i" items="${item.items }">
	    				<div class="product" style="display: flex; flex-direction: row; justify-content: space-between; margin-left: 30px 0; border: 1px dashed #DDDDDD; padding: 10px; width: 100%; height: 130px;">
						    <div style="margin-right: 30px;">
						        <input type="hidden" id="img${status.index}" value="${i.image}">
						        <img style="height: 50px; width: 50px; object-fit: cover; border-radius: 50px; border: 1px dashed #888888;" alt="" src="${i.image}">
						    </div>
						
						    <div>
						        <p class="d-flex">
						            <span style="color:#DDDDDD">Name</span>
						            <span><input value="${i.product}" id="name${status.index}" readonly style="border:none;" /></span>
						        </p>
						        <p class="d-flex">
						            <span style="color:#DDDDDD">Size</span>
						            <span><input style="border:none;" value="${i.size}" id="size${status.index}" readonly /></span>
						        </p>
						        <p class="d-flex">
						            <span style="color:#DDDDDD">Color</span>
						            <span><input style="border:none;" value="${i.color}" id="color${status.index}" readonly /></span>
						        </p>
						    </div>
						
						    <div class="d-flex justify-content-center" style="align-items: center; flex-direction: column;">
						        <p class="d-flex">
						            <span><input style="border:none;" value="${i.prince}" id="price${status.index}" readonly /></span>
						        </p>
						        <p class="d-flex">
						            <span><input style="border:none;" value="${i.quantity}" id="quantity${status.index}" readonly /></span>
						        </p>
						        <p class="d-flex">
						            <span><input style="border:none;" value="${i.total}" id="total${status.index}" readonly /></span>
						        </p>
						    </div>
						</div>
	    			</c:forEach>
	    			 
	    		</div>
	    			<button style="height:40px;margin-top:10px;width:70px" class="btn btn-primary" id="duyet${status.index }"  ><i class="fa fa-check" aria-hidden="true"></i></button>
	    			<button style="height:40px;margin-top:10px;width:70px;margin-left:5px" class="btn btn-danger" id="tuchoi${status.index }" ><i class="fa fa-times-circle" aria-hidden="true"></i></button>
	    		</div>
	    		<input type="hidden" id="billId${status.index }" value="${item.billId }">
	    		</c:forEach>
	    				<div>
		    				<p >
		    					<%-- <span style="width:100%;text-align: right;margin-right:70px;padding:10px" ><input id="totalBill" value=" Tổng tiền: ${list.totalPrice} " style="border-radius:10px;border:1px dashed #DDDDDD"/></span> --%>
		    				</p>
	    				</div>
	    				<div style="text-align: right; ">
					    <p style="width: 20%;display: inline-block;">
					     
					     <%--  '<c:url value="/public/Cart/view"/>' --%>
					    </p>
					</div>
	    				
    			</div>
    			</div>
<script type="text/javascript">
	$('button[id^="duyet"]').click(function () {
		event.preventDefault();
		var index=$(this).attr('id').replace('duyet', '');
		var status='Đang soạn hàng';
		var id=$('#billId'+index).val();
		update({billId:id,status:status})
	});
	$('button[id^="tuchoi"]').click(function () {
		event.preventDefault();
		var index=$(this).attr('id').replace('tuchoi', '');
		var status='Đã hủy';
		var id=$('#billId'+index).val();
		update({billId:id,status:status})
	});
	function update(data) {
		$.ajax({
			url:'${ApiUrl}',
			type:'post',
			data: JSON.stringify(data),
			contentType :'application/json',
			dataType: 'json',
			success: function (result) {
				window.location.href=window.location.href;
			},
			error: function (error) {
				//showToast("Edit request failed","danger");
				window.location.href=window.location.href;
				console.log(error);
			}
		});
	}
</script>
</body>
</html>