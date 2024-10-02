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
	.hideAndShow {
	  min-width: 200px;  /* Chiều rộng tối thiểu */
  max-width: 400px;  /* Chiều rộng tối đa */
  width: 50%;  
	  display: flex; /* Tương đương với d-flex */
	  animation: fadeInUp 0.8s ease-in-out; /* Thêm animation nếu cần */
	}
	
	
</style>
</head>

	<body class="goto-here">
    <section id="home-section" class="hero">
		  <div class="home-slider owl-carousel">
	      <div class="slider-item js-fullheight">
	      	<div class="overlay"></div>
	        <div class="container-fluid p-0">
	          <div class="row d-md-flex no-gutters slider-text align-items-center justify-content-end" data-scrollax-parent="true">
	          	<img class="one-third order-md-last img-fluid" src="" alt="">
		          <div class="one-forth d-flex align-items-center ftco-animate" data-scrollax=" properties: { translateY: '70%' }">
		          	<div class="text">
		          		<span class="subheading">#New Arrival</span>
		          		<div class="horizontal">
				            <h1 class="mb-4 mt-3">Shoes Collection 2019</h1>
				            <p class="mb-4">A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country.</p>
				            
				            <p><a href="#" class="btn-custom">Discover Now</a></p>
				          </div>
		            </div>
		          </div>
	        	</div>
	        </div>
	      </div>
	    </div>
    </section>

    

    <section class="ftco-section bg-light">
    	<div class="container">
	    <div class="row justify-content-center mb-3 pb-3">
	        <div class="col-md-12 heading-section text-center ftco-animate">
	            <h2 class="mb-4">New Product Arrival</h2>
	        </div>
	        <nav style="width:1000px">
	            <ul style="justify-content: flex-end; align-items: center; display: flex;">
	                <li class="nav-item dropdown" style=" margin-left: 15px;">
	                    <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                        Tên <i class="fa fa-sort-alpha-asc" aria-hidden="true"></i>
	                    </a>
	                    <div class="dropdown-menu" style="position: absolute;" aria-labelledby="dropdown04">
	                        <a class="dropdown-item" href="shop.html"><i class="fa fa-sort-alpha-asc" aria-hidden="true"></i> A->Z</a>
	                        <a class="dropdown-item" href="product-single.html"><i class="fa fa-sort-alpha-desc" aria-hidden="true"></i> Z->A</a>
	                    </div>
	                </li>
	                <li class="nav-item dropdown" style=" margin-left: 15px;">
	                    <a class="nav-link dropdown-toggle" href="#" id="dropdown05" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                        Giá <i class="fa fa-sort-alpha-asc" aria-hidden="true"></i>
	                    </a>
	                    <div class="dropdown-menu" style="position: absolute;" aria-labelledby="dropdown05">
	                        <a class="dropdown-item" href="shop.html"><i class="fa fa-sort-numeric-asc" aria-hidden="true"></i> Thấp đến cao</a>
	                        <a class="dropdown-item" href="shop.html"><i class="fa fa-sort-numeric-desc" aria-hidden="true"></i> Cao đến thấp</a>
	                            <span>
	                                <input type="checkbox" id="filterDuoi500" class="price-checkbox" value="2" style="margin:10px">
	                            </span>
	                            Dưới 200.000đ
	                        	 <span>
	                                <input type="checkbox" id="filterDuoi500" class="price-checkbox" value="5" style="margin:10px">
	                            </span>
	                            Dưới 500.000đ
	                             <span>
	                                <input type="checkbox" id="filterDuoi500" class="price-checkbox" value="1000000" style="margin:10px">
	                            </span>
	                            Dưới 1.000.000đ
	                    </div>
	                </li>
	                 <li class="nav-item dropdown" style=" margin-left: 15px;">
	                    <a class="nav-link dropdown-toggle" href="#" id="dropdown06" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                        Tên <i class="fa fa-sort-alpha-asc" aria-hidden="true"></i>
	                    </a>
	                    <div class="dropdown-menu" style="position: absolute;" aria-labelledby="dropdown06">
	                  		<c:forEach var="item" items="${listCategory }">
	                  		   <span>
	                                <input type="checkbox" id="${item.categoryName }" class="category-checkbox" value="${item.categoryName }" style="margin:10px">
	                            </span>
	                            ${item.categoryName }
	                            <br>
	                  		</c:forEach>
	                      
	                    </div>
	                </li>
	            </ul>
	        </nav>
    </div>
</div>
    	<div class="container">
    		
    		<div class="row" >
    			<c:forEach var="item" items="${list }" varStatus="status">
    				<div class="hideAndShow" style="width:280px">
    				<div class=" product col-sm-12 col-md-6 col-lg-3 ftco-animate d-flex" style="min-width:280px;max-height:500px;min-height:499px" >
    				
    				<div class=" d-flex flex-column">
    					
    						<a href="#" class="img-prod"><img class="img-fluid" src="${item.image }" alt="Colorlib Template" style="height:300px;width:300px;object-fit: cover">
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
    						<c:set var="dataPrice" value="" />
								<c:if test="${item.prince < 200000}">
								    <c:set var="dataPrice" value="2" />
								</c:if>
								<c:if test="${item.prince < 500000 and item.prince > 200000}">
								    <c:set var="dataPrice" value="5" />
								</c:if>
  							<div class="pricing">
	    						<p class="price"><span class="mr-2 price-dc">$120.00</span><span data-price="${dataPrice }" class="price-sale">${item.prince }</span></p>
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
    			<input type="hidden"  class="dataCate" value="${item.categoryName  }" data-category="${item.categoryName }" >
    			<input type="hidden" id="product${status.index }" name="product" value="${item.productId  }">
    			</div>
    			</c:forEach>
    			
    		</div>
    	</div>
    </section>

    <section class="ftco-section ftco-deal bg-primary">
    	<div class="container">
    		<div class="row">
    			<div class="col-md-6">
    				<img src="images/prod-1.png" class="img-fluid" alt="">
    			</div>
    			<div class="col-md-6">
    				<div class="heading-section heading-section-white">
    					<span class="subheading">Deal of the month</span>
	            <h2 class="mb-3">Deal of the month</h2>
	          </div>
    				<div id="timer" class="d-flex mb-4">
						  <div class="time" id="days"></div>
						  <div class="time pl-4" id="hours"></div>
						  <div class="time pl-4" id="minutes"></div>
						  <div class="time pl-4" id="seconds"></div>
						</div>
						<div class="text-deal">
							<h2><a href="#">Nike Free RN 2019 iD</a></h2>
							<p class="price"><span class="mr-2 price-dc">$120.00</span><span class="price-sale">$80.00</span></p>
							<ul class="thumb-deal d-flex mt-4">
								<li class="img" style="background-image: url(images/product-6.png);"></li>
								<li class="img" style="background-image: url(images/product-2.png);"></li>
								<li class="img" style="background-image: url(images/product-4.png);"></li>
							</ul>
						</div>
    			</div>
    		</div>
    	</div>
    </section>

    <section class="ftco-section testimony-section">
      <div class="container">
        <div class="row">
        	<div class="col-lg-5">
        		<div class="services-flow">
        			<div class="services-2 p-4 d-flex ftco-animate">
        				<div class="icon">
        					<span class="flaticon-bag"></span>
        				</div>
        				<div class="text">
	        				<h3>Free Shipping</h3>
	        				<p class="mb-0">Separated they live in. A small river named Duden flows</p>
        				</div>
        			</div>
        			<div class="services-2 p-4 d-flex ftco-animate">
        				<div class="icon">
        					<span class="flaticon-heart-box"></span>
        				</div>
        				<div class="text">
	        				<h3>Valuable Gifts</h3>
	        				<p class="mb-0">Separated they live in. A small river named Duden flows</p>
	        			</div>
        			</div>
        			<div class="services-2 p-4 d-flex ftco-animate">
        				<div class="icon">
        					<span class="flaticon-payment-security"></span>
        				</div>
        				<div class="text">
	        				<h3>All Day Support</h3>
	        				<p class="mb-0">Separated they live in. A small river named Duden flows</p>
	        			</div>
        			</div>
        			<div class="services-2 p-4 d-flex ftco-animate">
        				<div class="icon">
        					<span class="flaticon-customer-service"></span>
        				</div>
        				<div class="text">
	        				<h3>All Day Support</h3>
	        				<p class="mb-0">Separated they live in. A small river named Duden flows</p>
	        			</div>
        			</div>
        		</div>
        	</div>
          <div class="col-lg-7">
          	<div class="heading-section ftco-animate mb-5">
	            <h2 class="mb-4">Our satisfied customer says</h2>
	            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in</p>
	          </div>
            <div class="carousel-testimony owl-carousel">
              <div class="item">
                <div class="testimony-wrap">
                  <div class="user-img mb-4" style="background-image: url(images/person_1.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text">
                    <p class="mb-4 pl-4 line">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    <p class="name">Garreth Smith</p>
                    <span class="position">Marketing Manager</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap">
                  <div class="user-img mb-4" style="background-image: url(images/person_2.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text">
                    <p class="mb-4 pl-4 line">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    <p class="name">Garreth Smith</p>
                    <span class="position">Interface Designer</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap">
                  <div class="user-img mb-4" style="background-image: url(images/person_3.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text">
                    <p class="mb-4 pl-4 line">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    <p class="name">Garreth Smith</p>
                    <span class="position">UI Designer</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap">
                  <div class="user-img mb-4" style="background-image: url(images/person_1.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text">
                    <p class="mb-4 pl-4 line">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    <p class="name">Garreth Smith</p>
                    <span class="position">Web Developer</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap">
                  <div class="user-img mb-4" style="background-image: url(images/person_1.jpg)">
                    <span class="quote d-flex align-items-center justify-content-center">
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text">
                    <p class="mb-4 pl-4 line">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    <p class="name">Garreth Smith</p>
                    <span class="position">System Analyst</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
<section class="ftco-section ftco-no-pt ftco-no-pb">
			<div class="container">
				<div class="row no-gutters ftco-services">
          <div class="col-lg-4 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services p-4 py-md-5">
              <div class="icon d-flex justify-content-center align-items-center mb-4">
            		<span class="flaticon-bag"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Free Shipping</h3>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
              </div>
            </div>      
          </div>
          <div class="col-lg-4 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services p-4 py-md-5">
              <div class="icon d-flex justify-content-center align-items-center mb-4">
            		<span class="flaticon-customer-service"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Support Customer</h3>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
              </div>
            </div>    
          </div>
          <div class="col-lg-4 text-center d-flex align-self-stretch ftco-animate">
            <div class="media block-6 services p-4 py-md-5">
              <div class="icon d-flex justify-content-center align-items-center mb-4">
            		<span class="flaticon-payment-security"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Secure Payments</h3>
                <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
              </div>
            </div>      
          </div>
        </div>
			</div>
		</section>

<script type="text/javascript">
$(document).ready(function() {
	$('.price-checkbox, .category-checkbox').on('change', function() {
	    var selectedPrice = [];
	    var selectedCategory = [];

	    // Lấy các checkbox giá đã được chọn
	    $('.price-checkbox:checked').each(function() {
	        selectedPrice.push($(this).val());
	    });

	    // Lấy các checkbox danh mục đã được chọn
	    $('.category-checkbox:checked').each(function() {
	        selectedCategory.push($(this).val());
	    });

	    // Ẩn hoặc hiện các sản phẩm dựa trên cả giá và danh mục
	    $('.hideAndShow').each(function() {
	        var productPrice = $(this).find('.price-sale').data('price');
	        var productCategory = $(this).find('.dataCate').data('category');
	        
	        // Kiểm tra xem sản phẩm có thỏa mãn cả hai điều kiện không
	        var priceMatch = selectedPrice.length === 0 || selectedPrice.includes(productPrice.toString());
	        var categoryMatch = selectedCategory.length === 0 || selectedCategory.includes(productCategory.toString());

	        // Nếu cả hai điều kiện đều đúng, hiển thị sản phẩm, ngược lại ẩn đi
	        if (priceMatch && categoryMatch) {
	            $(this).show();
	        } else {
	            $(this).hide();
	        }
	    });
	});
    
}); 
$(document).ready(function() {
    $('.dropdown-menu ').click(function() {
    	event.stopPropagation();
    });
});
$('button[id^="addToCart"]').click(function () {
	var index=$(this).attr('id').replace('addToCart', '');
	var id=$('#product'+index).val();
	var sizeP=$('#size'+index).val();
	var colorP=$('#color'+index).val();
	var quantityP=$('#quantity'+index).val();
	add({productId:id,size:sizeP,color:colorP,soLuong:quantityP})
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