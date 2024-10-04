<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <c:url var="ApiUrl" value="/user/feedback/add"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="main-content" style="margin-top:100px">
	
	<div  style="margin-top:100px;display:flex">
	<div style="width:30%">
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
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <div class="collapse navbar-collapse" id="navbarSupportedContent">
			    <ul class="navbar-nav mr-auto">
			      <li class="nav-item active">
			        <a class="nav-link" href='<c:url value="/user/PurchaseHistory/ALL?customerId=${user.customerId }"/>' >TẤT CẢ <span class="sr-only">(current)</span></a>
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href='<c:url value="/user/PurchaseHistory/confirm?customerId=${user.customerId }"/>' >CHỜ XÁC NHẬN</a>
			      </li>
			     
			      <li class="nav-item">
			        <a class="nav-link " href='<c:url value="/user/PurchaseHistory/Pay?customerId=${user.customerId }"/>' >CHỜ VẬN CHUYỂN</a>
			      </li>
			      
			      <li class="nav-item">
			        <a class="nav-link " href='<c:url value="/user/PurchaseHistory/Complete?customerId=${user.customerId }"/>' > ĐÃ GIAO HÀNG</a>
			      </li>
			    </ul>
			    <form class="form-inline my-2 my-lg-0">
			      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			    </form>
		  </div>
		</nav>
	    <div class="cart-total mb-1">
	    	<c:forEach var="item" items="${list }"  varStatus="status">
	    		<div style="background-color:#F5F5F5">
	    			 <p style="padding-top:15px">
					<span style="color:#DDDDDD;padding-left:20px">Mã đơn hàng: ${item.billId} </span>
					<span style="color:#DDDDDD;padding-left:20px">Trạng thái: ${item.status} </span>
					
					</p>
	    		<div style="display:flex;width:90%;margin-right:10px;margin:20px;border:1px dashed #DDDDDD;">
	    			
	    		<div style="display:block;margin: 10px;" >
	    			<c:forEach var="i" items="${item.items }" varStatus="status1">
	    				<div class="product" style="display: flex; flex-direction: row; justify-content: space-between; margin-left: 30px 0; border: 1px dashed #DDDDDD; padding: 10px; width: 100%; height: 150px;background-color:#9FB6CD;border-radius:20px">
						    <div style="margin-right: 30px;">
						        <input type="hidden" id="img${status.index}${status1.index}" value="${i.image}">
						        <img style="height: 50px; width: 50px; object-fit: cover; border-radius: 50px; border: 1px dashed #888888;" alt="" src="${i.image}">
						    </div>
						
						    <div>
						        <p class="d-flex">
						            <span style="color:#DDDDDD">Name</span>
						            <span><input value="${i.product}" id="name${status.index}${status1.index}" readonly style="border:none;background-color:#9FB6CD" /></span>
						        </p>
						        <p class="d-flex">
						            <span style="color:#DDDDDD">Phân Loại</span>
						            <span style="color:#DDDDDD">${i.size}/${i.color}</span>
						        </p>
						        <p class="d-flex">
						            <span style="color:#DDDDDD">Số lượng</span>
						             <span><input style="border:none;background-color:#9FB6CD" value="${i.quantity}" id="quantity${status.index}${status1.index}" readonly /></span>
						        </p>
						    </div>
						
						    <div class="d-flex justify-content-center" style="align-items: center; flex-direction: column;">
						        <p class="d-flex">
						            <span><input style="border:none;background-color:#9FB6CD" value="${i.total}" id="total${status.index}${status1.index}" readonly /></span>
						        </p>
						    </div>
						</div>
						<div style="text-align: right; ">
					    <p style="width: 20%;display: inline-block;">
					    <c:url var="reviews" value="/user/reviews/add">
					    	<c:param name="id" value="${i.product }">
					    	</c:param>
					    </c:url>
					    
					    <c:if test="${item.status  =='hoàn thành'}">
					    	<a class="btn btn-primary" id="reviews${status.index}${status1.index}" href="#" data-toggle="modal" data-target="#exampleModal">ĐÁNH GIÁ</a>
					    </c:if>
					    
					    </p>
					</div>
					<input type="hidden"  value="${i.size}" id="size${status.index}${status1.index}" readonly />
					<input type="hidden" value="${i.color}" id="color${status.index}${status1.index}" readonly />
	    			</c:forEach>

	    		</div>
	    			
	    		</div>
	    		<div>
			    	<p >
			    		<span style="width:100%;text-align: right;margin-right:70px;padding:10px" ><input id="totalBill${status.index}" value=" Tổng tiền: ${item.totalPrice} " style="border-radius:10px;border:1px dashed #DDDDDD"/></span> 
			    	</p>
	    		</div>
	    		</div>
	    		</c:forEach>
	    		
	    		<div style="text-align: right; ">
				<p style="width: 20%;display: inline-block;">
					     
				<%--  '<c:url value="/public/Cart/view"/>' --%>
				</p>
			</div>
	    				
    	</div>
    </div>
	</div>
	<input type="hidden" id="customer" value="${user.customerName }">
</div>

<!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Đánh Giá Sản Phẩm</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Add your form or content here -->
                    <form>
                    	<div class="product" style="display: flex; flex-direction: row; justify-content: space-between; margin-left: 30px 0; border: 1px dashed #DDDDDD; padding: 10px; width: 100%; height: 150px;background-color:#9FB6CD;border-radius:20px">
						    <div style="margin-right: 30px;">
						        <input type="hidden" id="image" value="">
						        <img id="previewImage" style="height: 50px; width: 50px; object-fit: cover; border-radius: 50px; border: 1px dashed #888888;" alt="" src="">
						    </div>
						
						    <div style="height:140px">
						        <p class="d-flex">
						            <span><input value="" id="nameProduct" readonly style="border:none;background-color:#9FB6CD;" /></span>
						        </p>
						        <p class="d-flex">
						            <span><input style="border:none;background-color:#9FB6CD" value="" id="sizeProduct" readonly />
						            </span>
						        </p>
						        <p class="d-flex">
						            <span style="color:#DDDDDD"></span>
						             <span><input style="border:none;background-color:#9FB6CD" value="" id="colorProduct" readonly /></span>
						        </p>
						    </div>
						</div>
                        <div class="form-group">
                           <div class="select-wrap"  style="display:inline-block; width: 50%;">
						           <label for="rating">CHỌN MỨC ĐỘ HÀI LÒNG</label>
							          <select name="star" id="star" class="form-control" style="display:inline-block; width: 95%;border-radius: 5px">
							          		<option selected>OPEN</option>
							           		<option value="1">Rất tệ (1 sao)</option>
							                <option value="2">Không hài lòng (2 sao)</option>
							                <option value="3">Bình thường (3 sao) </option>
			                                <option value="4">Hài lòng (4 sao)</option>
			                                <option value="5">Rất hài lòng(5 sao)</option>
			                               
							          </select>
					              </div>
                        </div>
                        <div class="form-group">
                            <label for="feedback">Nhận xét của bạn</label>
                            <textarea class="form-control" id="feedback" rows="3"></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button id="Cancel" type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                    <button id="ok" type="button" class="btn btn-primary">Gửi Đánh Giá</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Include Bootstrap JS and jQuery -->
  <!--   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function() {
        $('a[id^="reviews"]').click(function () {
    		var index=$(this).attr('id').replace('reviews', '');
    		var productName=$('#name'+index).val();
    		var img=$('#img'+index).val();
    		var color=$('#color'+index).val();
    		var size=$('#size'+index).val();
    		const previewImage = document.getElementById('previewImage');
    		previewImage.src = img;
    		$('#nameProduct').val(productName);
    		$('#sizeProduct').val("M");
    		$('#colorProduct').val("Trắng");
    		
    	});
        $('#ok').click(function name() {
        	var productName=$('#nameProduct').val();
    		var color=$('#colorProduct').val();
    		var sizeColor=$('#sizeProduct').val()+"/"+$('#colorProduct').val();
    		var star=$('#star').val();
    		var Description=$('#feedback').val();
    		var customer=$('#customer').val();
    		add({customer:customer,product:productName,sizeColor:sizeColor,star:star,description:Description});
		});
        function  add(data) {
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
    });
    
    </script>
</body>
</html>