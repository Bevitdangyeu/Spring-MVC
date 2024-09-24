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
						<c:forEach var="image" items="${ product.listImage }" varStatus="status">
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
					                  	 <select name="size" id="size100" class="form-control"style="display:inline-block; width: 95%;border-radius: 5px" >
					                  	  <option selected>Chọn size</option>
						                  <c:forEach var="size" items="${product.listSize }">
						                  	<option value="${size }">${size }</option>
						                  </c:forEach>       
						                  </select>
						              </div>
						               <div class="select-wrap"  style="display:inline-block; width: 50%;">
						                    <div style="display:inline-block; width: 5%;" class="icon"><span class="ion-ios-arrow-down"></span></div>
						                   <select name="color" id="color100" class="form-control" style="display:inline-block; width: 95%;border-radius: 5px">
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
				             	<input style="width:15%;display:inline-block; border-radius: 5px" type="number" id="quantity100" name="quantity" class="quantity form-control input-number" value="1" min="1" max="100">   	
				          	</div>
		          			<div class="w-100"></div>
				          	<div class="col-md-12">
				          		<p style="color: #000;">${product.quantity } piece available</p>
				          	</div>
	          		</div>
	          			<input type="hidden" id="idProduct100" value="${product.productId }">
	          			<button  type="submit" id="addToCart100" class="btn" style="background-color: black;border-radius:30px; color:black;width:150px;padding:10px">Add to Cart</button>
	          			<button type="submit" id="buyNow" class="btn btn-primary" style="background-color: black;border-radius:30px; color:black;width:150px;height:70px">Buy now</button>
	          		
	          		<!-- <p><a href="cart.html" class="btn btn-black py-3 px-5 mr-2">Add to Cart</a><a href="cart.html" class="btn btn-primary py-3 px-5">Buy now</a></p> -->
	    		</div>
    		</div>

    	</div>
    </section>
   <!--  phần các sản phẩm liên quan -->
   <section class="py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5">
              <h2 class="fw-bolder mb-4">Related products</h2>
    		<div class="row">
              
                <c:forEach var="item" items="${Related }" varStatus="status">
                	<div class="col-sm-12 col-md-6 col-lg-3 ftco-animate d-flex">
    				<div class="product d-flex flex-column">
    					<a href="#" class="img-prod"><img class="img-fluid" src="${item.image }" alt="Colorlib Template">
    						<span class="status">50% Off</span>
    						<div class="overlay"></div>
    					</a>
    					<div class="text py-3 pb-4 px-3">
    						<div class="d-flex">
    							<div class="cat">
		    						<span>Lifestyle</span>
		    					</div>
		    					<div class="rating">
	    							<p class="text-right mb-0">
	    								<a href="#"><span class="ion-ios-star-outline"></span></a>
	    								<a href="#"><span class="ion-ios-star-outline"></span></a>
	    								<a href="#"><span class="ion-ios-star-outline"></span></a>
	    								<a href="#"><span class="ion-ios-star-outline"></span></a>
	    								<a href="#"><span class="ion-ios-star-outline"></span></a>
	    							</p>
	    						</div>
	    					</div>
    						<h3>
    						<c:url var="detail" value="/public/product/detail">
    							<c:param name="id" value="${item.productId }"></c:param>
    							<c:param name="caterogyId" value="${item.categoryId }"></c:param>
    						</c:url>
    						<a href='${ detail}'>${item.productName }</a>
    						</h3>
  							<div class="pricing">
	    						<p class="price"><span class="mr-2 price-dc">$120.00</span><span class="price-sale">${item.prince }</span></p>
	    					</div>
	    					<p class="bottom-area d-flex px-6">	
	    						<div class="btn-group custom-dropdown">
								    <button style="width:220px; text-align:center" type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
								        Chọn
								    </button>
								    <div class="dropdown-menu" style="min-width: 14rem;border-radius: 10px;top:35px;left:2px" >
								            <!-- Dropdown for Size -->
								            <div class="form-group" style="padding-left:10px;padding-right:10px;">
								                <label for="size">Chọn kích thước</label>
								                <select style="border-radius: 10px;height:35px ;width:100%;font-size: 14px;padding-left:20px" class="size" id="size${status.index }" name="size">
								                    <option selected>Kích thước</option>
								                    <c:forEach var="sizeItem" items="${item.listSize}">
								                        <option value="${sizeItem}">${sizeItem}</option>
								                    </c:forEach>
								                </select>
								            </div>
								
								            <!-- Dropdown for Color -->
								            <div class="form-group"  style="padding-left:10px;padding-right:10px;">
								                <label for="color">Chọn màu sắc</label>
								                <select style="border-radius: 10px;height:35px;width:100%;font-size: 14px;padding-left:20px" class="color" aria-label="Default select example" id="color${status.index }" name="color">
								                    <option selected>Màu sắc</option>
								                    <c:forEach var="colorItem" items="${item.listColor}">
								                        <option value="${colorItem}">${colorItem}</option>
								                    </c:forEach>
								                </select>
								            </div>
											<div class="form-group" style="padding-left:10px;padding-right:10px;">
								               <label  for="filebutton">SỐ LƯỢNG:</label>
				             					<input style="border-radius:10px;height:35px;width:50%;font-size: 14px;padding-left:20px" type="number" id="quantity${status.index }" name="quantity" class="quantity input-number" value="1" min="1" max="100">
								            </div>
								            <!-- Add to Cart Button -->
								            <div class="card-footer p-10 pt-0 border-top-0 bg-transparent">
								                <div class="text-center">
								                    <button style="width:150px; margin:10px" type="submit" class="btn btn-primary" id="addToCart${status.index }">ADD TO CART</button>
								                </div>
								           
								                <div class="text-center">
								                    <button style="width:150px; margin:10px"  type="submit" class="btn btn-primary" id="buyNow">BUY NOW</button>
								                </div>
								            </div>
								      
								    </div>
								</div>
		
	    					</p>
	    						<p  class="bottom-area d-flex px-3">
	    						<!-- <a href="#" id="AddToCart" class="add-to-cart text-center py-2 mr-1"><span>Add to cart <i class="ion-ios-add ml-1"></i></span></a>
    							<a href="#" class="buy-now text-center py-2">Buy now<span><i class="ion-ios-cart ml-1"></i></span></a> -->
	    						</p>
    					</div>
    				</div>
    			</div>
    			<input type="hidden" id="idProduct${status.index }" name="product" value="${item.productId  }">
                </c:forEach>
    		</div>
            </div>
        </section>
    
    <script type="text/javascript">
    $('button[id^="addToCart"]').click(function () {
   	 		var index = $(this).attr('id').replace('addToCart', '');
			var productId=$('#idProduct'+index).val();
			var sl=$('#quantity'+index).val();
			var color=$('#color'+index).val();
			var size=$('#size'+index).val();
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
   		$(document).ready(function() {
   		    $('.dropdown-menu ').click(function() {
   		    	event.stopPropagation();
   		    });
   		});
    </script>
</body>
</html>