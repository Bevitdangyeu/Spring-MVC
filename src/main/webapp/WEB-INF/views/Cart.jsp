<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:url var="ApiUrlDelete" value="/api/cart/remove"></c:url>
     <c:url var="ApiUrl" value="/public/checkout/add"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="ftco-section ftco-cart">
			<div class="container">
				<div class="row">
    			<div class="col-md-12 ftco-animate">
    				<div class="cart-list">
	    				<table class="table">
						    <thead class="thead-primary">
						      <tr class="text-center">
						      	<th>Chọn</th>
						        <th>&nbsp;</th>
						        <th>&nbsp;</th>
						        <th>Product</th>
						        <th>Size</th>
						        <th>Color</th>
						        <th>Price</th>
						        <th>Quantity</th>
						        <th>Total</th>
						      </tr>
						    </thead>
						    <tbody>
						    	<c:forEach var="product" items="${cart.list }" varStatus="status">
						    	<tr class="text-center">
						    		<td><input type="checkbox" id="${status.index}" class="product-checkbox" value="${product.product.productName}" ></td>
						    		<td class="product-remove" ><button id="deleteProduct${status.index}" style="background-color: transparent; border: none;width:25px;height:10px"><span style="color:red;font-size: 30px;" class="ion-ios-close"></span></button></td>
							   <!--      <td class="product-remove"><a href="#"><span class="ion-ios-close"></span></a></td> -->
							        <td class="image-prod">
							        	<input type="hidden" value="${product.product.image }" id="img${status.index}" > <img  src="${product.product.image}" style="width:80px;height:100px; object-fit: cover;" ></input>
							        </td>
							        <td class="product-name">
							        	<input type="text" id="productName${status.index}"value="${product.product.productName }" style="text-align:center;border-radius:10px;font-weight: bold;width:150px;height:45px;border:0px" readonly>
							        </td>
							        <td class="Size">
							        	<input type="text" id="size${status.index}" value="${product.size }" style="text-align:center;border-radius:10px;height:45px;border:0px" readonly>
							        </td>
							        <td class="Color">
							        	<input type="text" id="color${status.index}"value="${product.color }" style="text-align:center;border-radius:10px;150px;height:45px;border:0px" readonly>
							        </td>
							        <td class="price">
							        	<input type="text" id="price${status.index}" value="${product.product.prince }"  style="text-align:center;border-radius:10px;width:150px;height:45px;border:0px" readonly>
							        </td>						        
							        <td class="quantity">
							        	<div class="input-group mb-3">
						             	<input type="number" id="quantity${status.index}" name="quantity" class="quantity form-control input-number" value="${product.soLuong }" min="1" max="100">
						          	</div>
						          </td>
				        
							        <td class="total">$4.90</td>
							        
						      </tr><!-- END TR-->
						      <input type="hidden" value="${ product.productId}" id="product${status.index}">
						    	</c:forEach>
			     
						    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
    		<div class="row justify-content-start">
    			<div class="col col-lg-5 col-md-6 mt-5 cart-wrap ftco-animate">
    				<!-- <div class="cart-total mb-3">
    					<h3>Cart Totals</h3>
    					<p class="d-flex">
    						<span>Subtotal</span>
    						<span>$20.60</span>
    					</p>
    					<p class="d-flex">
    						<span>Delivery</span>
    						<span>$0.00</span>
    					</p>
    					<p class="d-flex">
    						<span>Discount</span>
    						<span>$3.00</span>
    					</p>
    					<hr>
    					<p class="d-flex total-price">
    						<span>Total</span>
    						<span>$17.60</span>
    					</p>
    				</div> -->
    				<p class="text-center"><a id="checkout" href="#" class="btn btn-primary py-3 px-3">Proceed to Checkout</a></p>
    			</div>
    		</div>
			</div>
		</section>
	<script type="text/javascript">
	$('button[id^="deleteProduct"]').click(function () {
		var index=$(this).attr('id').replace('deleteProduct', '');
		var id=$('#product'+index).val();
		var sizeP=$('#size'+index).val();
		var colorP=$('#color'+index).val();
		deleteProduct({productId:id,size:sizeP,color:colorP})
	});
	function deleteProduct(data) {
		$.ajax({
			url:'${ApiUrlDelete}',
			type:'DELETE',
			data: JSON.stringify(data),
			contentType :'application/json',
			dataType: 'json',
			success: function(result) {
			    console.log("Result from server:", result);
			    // Chuyển hướng về trang hiện tại với tham số id
			    var currentUrl = window.location.href;
			 //   var newUrl = currentUrl.split('?')[0] + '?id=' + result;
			    window.location.href = currentUrl;
			},
			error: function (error) {
				//showToast("Edit request failed","danger");
				console.log(error);
			}
		})
	}
	
	$('#checkout').click(function (event) {
		event.preventDefault();
		 var customerName='user';
		 var employee=1; 
		 var items=[];
		 /* var productName = $('.product-checkbox:checked').map(function() {
	            return this.value;
	     }).get(); */
		 var checkedIds = $('.product-checkbox:checked').map(function() {
	            return this.id;
	        }).get();
		/*  productName.forEach(function(id) {
			    listIds.push(id);
		});							 */	
		 checkedIds.forEach(function(id) {
			   var productName=$('#productName'+id).val();
			   var size=$('#size'+id).val();
			   var color=$('#color'+id).val();
			   var sl=$('#quantity'+id).val();
			   var price=$('#price'+id).val();
			   var image=$('#img'+id).val();
			   var item={product:productName,quantity:sl,prince:price,size:size,color:color,image:image}
			   items.push(item)
			});
		 /* add({customerName:customerName,employeeID:employee,product:productName,quantity:listQuantity,prince:listPrice,size:listSize,color:listColor,image:listImage}); */
		 add({items:items})
		 });
	function add(data) {
		$.ajax({
			url:'${ApiUrl}',
			type:'post',
			data: JSON.stringify(data),
			contentType :'application/json',
			dataType: 'json',
			success: function(response) {
	            // Điều hướng đến trang JSP mới sau khi nhận phản hồi thành công
	            window.location.href = '/public/checkout/confirm';
	        },
	        error: function(error) {
	        	 window.location.href = '/SpringMVC2/public/checkout/confirm';
	            console.log(error);
	        }
		});
	};
	</script>	
</body>
</html>