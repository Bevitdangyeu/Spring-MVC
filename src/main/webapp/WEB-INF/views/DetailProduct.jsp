<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    	<c:url var="CartUrl" value="/api/cart/add"/>
    	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#addToCart:hover {
    background-color: blue !important;  /* Màu nền thay đổi */
    color: yellow !important;           /* Màu chữ thay đổi */
}
</style>
</head>
<body>
	<section class="ftco-section">
    	<div class="container">
    		<div class="row">
    			<div class="col-lg-6 mb-5 ftco-animate">
    				<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
						<div class="carousel-inner">
						 <div class="carousel-item active">
							<img src="${product.image }" class="d-block w-100" alt="...">
						 </div>
						<c:forEach var="image" items="${ product.listImage }">
							<div class="carousel-item">
								<img src="${image }" class="d-block w-100" alt="...">
							</div>
 						</c:forEach>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
						  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						  <span class="sr-only">Previous</span>
						</a>
						<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
						  <span class="carousel-control-next-icon" aria-hidden="true"></span>
						  <span class="sr-only">Next</span>
						</a>
					  </div>
    			</div>
    			<div class="col-lg-6 product-details pl-md-5 ftco-animate">
    				<h3>${product.productName }</h3>
    				<div class="rating d-flex">
							<p class="text-left mr-4">
								<a href="#" class="mr-2">5.0</a>
								<a href="#"><span class="ion-ios-star-outline"></span></a>
								<a href="#"><span class="ion-ios-star-outline"></span></a>
								<a href="#"><span class="ion-ios-star-outline"></span></a>
								<a href="#"><span class="ion-ios-star-outline"></span></a>
								<a href="#"><span class="ion-ios-star-outline"></span></a>
							</p>
							<p class="text-left mr-4">
								<a href="#" class="mr-2" style="color: #000;">100 <span style="color: #bbb;">Rating</span></a>
							</p>
							<p class="text-left">
								<a href="#" class="mr-2" style="color: #000;">500 <span style="color: #bbb;">Sold</span></a>
							</p>
					</div>
    				<p class="price"><span>${product.prince }</span></p>
    				<p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
    				<p>On her way she met a copy. The copy warned the Little Blind Text, that where it came from it would have been rewritten a thousand times and everything that was left from its origin would be the word "and" and the Little Blind Text should turn around and return to its own, safe country. But nothing the copy said could convince her and so it didn’t take long until a few insidious Copy Writers ambushed her, made her drunk with Longe and Parole and dragged her into their agency, where they abused her for their.</p>
					<div class="row mt-4">
							<div class="col-md-9">
								<div class="form-group d-flex">
								    <div style="display:inline-block; width: 100%;">
						              <div class="select-wrap"  style="display:inline-block; width: 45%;">
					                  	 <div style="display:inline-block; width: 5%;" class="icon"><span class="ion-ios-arrow-down" ></span></div>
					                  	 <select name="size" id="size" class="form-control"style="display:inline-block; width: 95%;border-radius: 5px" >
					                  	  <option selected>Chọn size</option>
						                  <c:forEach var="size" items="${product.listSize }">
						                  	<option value="${size }">${size }</option>
						                  </c:forEach>       
						                  </select>
						              </div>
						               <div class="select-wrap"  style="display:inline-block; width: 50%;">
						                    <div style="display:inline-block; width: 5%;" class="icon"><span class="ion-ios-arrow-down"></span></div>
						                   <select name="color" id="color" class="form-control" style="display:inline-block; width: 95%;border-radius: 5px">
						                    <option selected>Chọn màu</option>
							                  <c:forEach var="color" items="${product.listColor }">
							                  	<option value="${color }">${color }</option>
							                  </c:forEach>       
						                  </select>
					                  </div>
					                </div>
						            </div>
							</div>
							<div class="w-100"></div>
							<div class="input-group col-md-6 d-flex">
								<label style="width:70%;display:inline-block;margin-top:5px"class="control-label" for="filebutton">CHỌN SỐ LƯỢNG:</label>
				             	<input style="width:15%;display:inline-block; border-radius: 5px" type="number" id="quantity" name="quantity" class="quantity form-control input-number" value="1" min="1" max="100">   	
				          	</div>
		          			<div class="w-100"></div>
				          	<div class="col-md-12">
				          		<p style="color: #000;">${product.quantity } piece available</p>
				          	</div>
	          		</div>
	          			<input type="hidden" id="idProduct" value="${product.productId }">
	          			<button  type="submit" id="addToCart" class="btn" style="background-color: black;border-radius:30px; color:black;width:150px;padding:10px">Add to Cart</button>
	          			<button type="submit" id="buyNow" class="btn btn-primary" style="background-color: black;border-radius:30px; color:black;width:150px;height:70px">Buy now</button>
	          		
	          		<!-- <p><a href="cart.html" class="btn btn-black py-3 px-5 mr-2">Add to Cart</a><a href="cart.html" class="btn btn-primary py-3 px-5">Buy now</a></p> -->
	    		</div>
    		</div>

    	</div>
    </section>
    <script type="text/javascript">
    	$('#addToCart').click(function () {
			var productId=$('#idProduct').val();
			var sl=$('#quantity').val();
			var color=$('#color').val();
			var size=$('#size').val();
			add({productId:productId,soLuong:sl,color:color,size:size})
		});
   		function add(data) {
   			$.ajax({
   				url:'${CartUrl}',
   				type:'post',
   				data: JSON.stringify(data) ,
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