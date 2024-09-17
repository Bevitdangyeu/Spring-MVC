<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:url var="NewURL" value="/admin1/bill/edit"></c:url>
    <c:url var="ApiUrl" value="/api/bill/add"></c:url>
     <c:url var="ApiUrlDelete" value="/api/bill/delete"></c:url>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left:100px;margin-top:30px">
			<fieldset>
		
		<!-- Form Name -->
		<legend>BILLS</legend>
		
		<!-- Text input-->
		
		<!-- Text input-->
		<div class="form-group- row">
		  <label class="col-md-4 control-label" for="customerName">CUSTOMER NAME</label>  
		  <div class="col-md-8" >
		  <input value="${bill.customerName }" id="customerName" name="customerName" placeholder="CUSTOMER NAME" class="form-control input-md" required="" type="text" />	    
		  </div>
		</div>	
		<div class="form-group- row" style="margin-top:10px">
		  <label class="col-md-4 control-label" for="employeeID">EMPLOYEE ID</label>  
		  <div class="col-md-8">
		  <input value="${bill.employeeID }" id="employeeID" name="employeeID" placeholder=" EMPLOYEE ID" class="form-control input-md" required="" type="text" />	    
		  </div>
		</div>	
		
		<!-- tại đây sẽ hiển thị phần thêm sản phẩm -->
		<c:if test="${ empty bill.billId }">
		
			<div class="form-group row">
			  <label class="col-md-4 control-label" for="singlebutton"></label>
			  <div class="col-md-8">
			    <button style="margin-top:20px;margin-bottom:20px" type="button" id="addProduct" name="addProduct" class="btn btn-primary">Thêm sản phẩm</button>
			  </div>
			</div>
			<div class="form-group row" >
			
				<div id="product-container">
				
					<!-- Nơi các mục nhập sản phẩm mới sẽ được thêm vào -->
				</div>
				
			</div>
		</c:if>
		<c:if test="${not empty bill.billId }">
		<div class="form-group- row" style="margin-top:20px">
			<label class="col-md-4 control-label" for="employeeID">THÔNG TIN SẢN PHẨM</label>  
			<div class="col-md-8">
				<div class="product">
					<table class="table">
					<thead class="thead-primary">
					<tr class="text-center"> 
						<th style="width:300px">Product Name</th>
						<th style="width:150px">Price</th>
						<th style="width:100px">Quantity</th>
					<!-- 	<th style="width:150px">TotalPrice</th> -->
					</tr>
					</thead>
					 <tbody>
					 <tr class="text-center">
					 	 <td class="product-name">
							<div class="input-group mb-1">
								<c:forEach var="name" items="${bill.product }" varStatus="statusProduct">
									<button id="btn_delete${statusProduct.index }" type="button" style=" border: none; cursor: pointer;background: none;margin-top:10px">
										<span><i style="color:#0099CC" class="fa fa-trash" aria-hidden="true"></i></span>
									</button>
									
									<input value="${name}"  list="suggestions" id="productName${statusProduct.index}" name="productName" placeholder=" PRODUCT NAME" class="productName" onchange="updatePrice(this,'product','price')" style="margin-top:10px;margin-left:10px;border-radius:10px; border-width: 1px; text-align: center;height:40px; width:80%">
								 	  <datalist id="suggestions">
						                 <c:forEach var="item" items="${product}">
						                     <option value="${item.productName}" data-price="${item.prince}" >${productName}</option>
						                 </c:forEach>
						              </datalist>	  
						              <br> 
						     
								</c:forEach>
							</div>
						</td> 
						<td class="price">
							<div class="input-group mb-1">
								<c:forEach var="price" items="${bill.prince }" varStatus="statusPrice">
									        	
									<input readonly type="text" class="price" value="${price}" id="price${statusPrice.index}" name="prince" style="margin-top:10px;border-radius:10px; border-width: 1px; text-align: center;height:40px; width:80%"/>
										       
								</c:forEach>
							</div>
						</td> 
						<td class="quantity">
							<div class="input-group mb-1">
								<c:forEach var="quantity" items="${bill.quantity }" varStatus="statusQuantity">
									        	
									<input  type="text" class="quantity" value="${quantity}" id="quantity${statusQuantity.index}" name="quantity" style="margin-top:10px;border-radius:10px; border-width: 1px; text-align: center;height:40px; width:80%"/>
										       
								</c:forEach>
							</div>
						</td> 
						<%-- <td class="total">
							<div class="input-group mb-1">
								<c:forEach var="total" items="${bill.total }" varStatus="statusTotal">
									        	
									<input readonly  type="text" value="${total}" id="total${statusQuantity.index}" name="total" style="margin-top:10px;border-radius:10px; border-width: 1px; text-align: center;height:40px; width:80%" onchange="updatePrice(this)"/>
										       
								</c:forEach>
							</div>
						</td>  --%>
						
					</tr>
					</tbody>
					</table>
				</div>
			</div>
			</div>
			<!-- Thêm sản phẩm mới -->
			<div class="form-group row">
			  <label class="col-md-4 control-label" for="singlebutton"></label>
			  <div class="col-md-8">
			    <button style="margin-top:20px;margin-bottom:20px" type="button" id="addProduct" name="addProduct" class="btn btn-primary">Thêm sản phẩm</button>
			  </div>
			</div>
			<div class="form-group row" >
			
				<div id="product-container">
				
					<!-- Nơi các mục nhập sản phẩm mới sẽ được thêm vào -->
				</div>
				
			</div>
		</c:if>
	<input type="hidden" name="billId" id="id" value="${bill.billId}">
		<!-- Button -->
		<div class="form-group row">
		  <label class="col-md-4 control-label" for="singlebutton"></label>
		  <div class="col-md-8">
		    <button type="submit"id="EditButton" name="EditButton" class="btn btn-primary">Button</button>
		  </div>
		</div>
		</fieldset>
</div>

<script type="text/javascript">
	// khi nhấn vào button có id là add product thì mục nhập sản phẩm sẽ hiện ra
	$(document).ready(function() {
    console.log("jQuery is loaded");
	  document.getElementById('addProduct').addEventListener('click', function() {
		  // Tạo một phần tử div mới để chứa các mục nhập sản phẩm
	       // Hai câu lệnh này tạo và cấu hình một phần tử HTML mới bằng JavaScript:
	       var productEntry = document.createElement('div');// chỉ định thẻ <div> 
	       productEntry.className = 'row product-entry';// gán class và id sẽ được áp dụng, tương đương với <div class="row product-entry"> 
	       /*  // list="suggestions" với suggestions là id của danh sách các đề xuất sẽ được hiển thị ở trường nhập liệu */
	       // Thêm mã HTML cho phần nhập thông tin sản phẩm và phần số lượng
	       //Gán nội dung HTML phức tạp cho phần tử div
	       productEntry.innerHTML = `  	
		 		  <label style="margin-top:10px;margin-bottom:10px" class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>  
		 		  <div class="col-md-8">
			 		  <input style="margin-top:10px;margin-bottom:10px" list="suggestions" id="productName1" name="product" placeholder=" PRODUCT NAME" class="form-control input-md" onchange="updatePrice(this,'product-entry','price')">
				 	  <datalist id="suggestions">
		                 <c:forEach var="item" items="${product}">
		                     <option value="${item.productName}" data-price="${item.prince}" >${productName}</option>
		                 </c:forEach>
		              </datalist>
	              
		 		  </div>
	 			
	 			<br>
	 			<label style="margin-top:10px;margin-bottom:10px" class="col-md-4 control-label" for="price">Price</label>  
		 	        <div class="col-md-8">
		 	            <input style="margin-top:10px;margin-bottom:10px" id="price1" name="price" class="form-control input-md" readonly type="text">    
		 	        </div>
				<label style="margin-top:10px;margin-bottom:10px" class="col-md-4 control-label" for="available_quantity">QUANTITY</label>  
				  <div class="col-md-8">
				  	<input style="margin-top:10px;margin-bottom:10px" id="quantity" name="quantity" placeholder="QUANTITY" class="form-control input-md" required="" type="number">    
				  </div>
				
			
	       `;
	
	       // Thêm phần tử mới vào container
	       document.getElementById('product-container').appendChild(productEntry);
	  });
	});
	function updatePrice(input, targetClass, targetField) {
	    // Lấy giá trị được nhập trong phần tử input
	    var inputId = input.id;
	    var index=inputId.replace('productName', ''); 
	    var selectedProductName = input.value;
	    // Lấy datalist gắn với input
	    var datalist = input.list;
	    
	    // Lặp qua các options trong datalist để tìm sản phẩm khớp
	    for (var i = 0; i < datalist.options.length; i++) {
	        if (datalist.options[i].value === selectedProductName) {
	            // Lấy giá từ data-price
	            var price = datalist.options[i].getAttribute('data-price');
	            
	            // Tìm phần tử cần hiển thị giá dựa trên targetClass và targetField
	            var targetInput = input.closest('.' + targetClass).querySelector('#' + targetField+index);
	            
	            // Kiểm tra nếu phần tử tồn tại và gán giá trị vào nó
	            if (targetInput) {
	                targetInput.value = price;
	            } else {
	                console.error('Không tìm thấy phần tử cần hiển thị giá.');
	            }
	            break;
	        }
	    }
	}
	  $(document).on('click', '#EditButton', function () {
		// tạo ra các mảng để chứa thông tin
		var listProduct=[];
		var listQuantity=[];	
		var listPrice=[];
		var customer=$('#customerName').val();
		var employeeId=$('#employeeID').val();
		var billId=$('#id').val();
		$(".product-entry").each(function name() {
			var name=$(this).find('#productName1').val();
			var quantity = $(this).find('#quantity').val();
			var price=$(this).find('#price1').val();
			listProduct.push(name);
			listQuantity.push(quantity);
			listPrice.push(price);
		});
		if(billId==""){			
			add({customerName:customer,employeeID:employeeId,product:listProduct,quantity:listQuantity,prince:listPrice})
		}
		else{
			var bill=$('#id').val();
			$('.productName').each(function name() {
				var name=$(this).val();
				listProduct.push(name);
			});
			$('.price').each(function name() {
				var price=$(this).val();
				if(price!=""){
					listPrice.push(price);
				}
			});
			$('.quantity').each(function name() {
				var quantity=$(this).val();
				if( quantity!=""){
					listQuantity.push(quantity);
				}
			})
			add({billId:bill,customerName:customer,employeeID:employeeId,product:listProduct,quantity:listQuantity,prince:listPrice})
		}
		
	});
	function add(data) {
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
	};
	$('button[id^="btn_delete"]').click(function name() {
		 var index = $(this).attr('id').replace('btn_delete', '');
		 // lấy giá trị từ cột productName
		 var name=$('#productName'+index).val();
		 var bill=$('#id').val();
		 deleteProduct({billId:bill,productName:name})
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
		});
	}
</script>
</body>
</html>