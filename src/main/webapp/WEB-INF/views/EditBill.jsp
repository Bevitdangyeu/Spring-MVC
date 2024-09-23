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
	<div style="margin-left:50px">
			<fieldset>
		
		<!-- Form Name -->
		<legend>BILLS</legend>
		
		<!-- Text input-->
		
		<!-- Text input-->
		<div class="form-group- row">
		  <label class="col-md-4 control-label" for="customerName">CUSTOMER NAME</label>  
		  <div class="col-md-8" >
		  <input value="${bill.customerName }" id="customerName" name="customerName" placeholder="CUSTOMER NAME" class="form-control input-md" required="" type="text" style="width:300px" />	    
		  </div>
		</div>	
		<div class="form-group- row" style="margin-top:10px">
		  <label class="col-md-4 control-label" for="employeeID">EMPLOYEE ID</label>  
		  <div class="col-md-8">
		  <input value="${bill.employeeID }" id="employeeID" name="employeeID" placeholder=" EMPLOYEE ID" class="form-control input-md" required="" type="text" style="width:300px" />	    
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
		<div class="col col-lg-12 cart-wrap ftco-animate" style="width:900px">
	    			<div class="cart-total mb-1" style="margin-top:30px">
	    				<h3>Thông tin sản phẩm</h3>
	    				<c:forEach var="item" items="${bill.items }"  varStatus="status">
	    					<div class="product" style="display:flex;margin:15px;border:1px dashed #DDDDDD;padding:10px">
	    						<div style="margin-right:30px">
		    						<input type="hidden" id="img${status.index}" value="${item.image  }">
		    							<img style="height:100px;width:100px ;object-fit: cover;border-radius:50px;border:1px dashed  #888888;" alt="" src="${item.image }">
	    							
	    						</div>
	    						<div  >
	    							<p style="margin:5px" class="d-flex">
	    								<span style="width:20%;color:#DDDDDD" >Name</span>
	    								<span style="width:50%" ><input value="${item.product }" id="name${status.index}"  style="border:none"  /></span>
	    							</p>
	    							<p style="margin:5px" class="d-flex">
	    								<span style="width:20%;color:#DDDDDD" >Size</span>
	    								<span style="width:50%" ><input style="border:none" value="${item.size }" id="size${status.index}"  /></span>
	    							</p>
	    							<p style="margin:5px" class="d-flex">
	    								<span style="width:20%;color:#DDDDDD" >Color</span>
	    								<span style="width:50%" ><input style="border:none" value="${item.color }" id="color${status.index}"  /></span>
	    							</p>
	    						</div>
	    						<div class="d-flex justify-content-center " style=" align-items: center;">
	    							<p style="margin-left:10px;text-align: center;width:100px" class="d-flex">
	    								<span ><input style="border:none" value="${item.prince}" id="price${status.index}"  /></span>
	    							</p>
	    							<p style="margin-left:10px;text-align: center;width:100px" class="d-flex">
	    								<span ><input style="border:none" value="${item.quantity }" id="quantity${status.index}"  /></span>
	    							</p>
	    							<p style="margin-left:10px;text-align: center;width:100px" class="d-flex">
	    								<span ><input style="border:none" value="${item.total }" id="total${status.index}"  /></span>
	    							</p>
	    						</div>
	    						
	    					</div>
	    				</c:forEach>
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
		 		 <div style="width:800px;margin-left:50px;display:Inline-block">
	    	   <label style="margin-top:10px;margin-bottom:10px" class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>  
		 		  <div class="col-md-6">
			 		  <input style="margin-top:10px;margin-bottom:10px; width:300px" list="suggestions" id="productName1" name="product" placeholder=" PRODUCT NAME" class="form-control input-md" onchange="updatePrice(this,'product-entry','price')">
				 	  <datalist id="suggestions">
		                 <c:forEach var="item" items="${product}">
		                     <option value="${item.productName}" data-price="${item.prince}" >${productName}</option>
		                 </c:forEach>
		              </datalist>
	              
		 		  </div>
	 			
	 			<br>
	 			 
	 			<label style="margin-top:10px;margin-bottom:10px" class="col-md-4 control-label" for="price">Size</label>  
	 	        <div class="col-md-6">
	 	            <input style="margin-top:10px;margin-bottom:10px; width:300px" id="size1" name="size" class="form-control input-md" type="text">    
	 	        </div>
	 	    
	 	       <label style="margin-top:10px;margin-bottom:10px" class="col-md-4 control-label" for="price">Color</label>  
	 	        <div class="col-md-6">
	 	            <input style="margin-top:10px;margin-bottom:10px; width:300px" id="color1" name="color" class="form-control input-md"  type="text">    
	 	        </div>
	 	    	
	 			<label style="margin-top:10px;margin-bottom:10px" class="col-md-4 control-label" for="price">Price</label>  
		 	        <div class="col-md-6">
		 	            <input style="margin-top:10px;margin-bottom:10p; width:300px" id="price1" name="price" class="form-control input-md" readonly type="text">    
		 	        </div>
		 	   
				<label style="margin-top:10px;margin-bottom:10px" class="col-md-4 control-label" for="available_quantity">QUANTITY</label>  
				  <div class="col-md-8">
				  	<input style="margin-top:10px;margin-bottom:10px; width:300px" id="quantity1" name="quantity" placeholder="QUANTITY" class="form-control input-md" required="" type="number">    
				  </div>
	       		</div>
				
			
	       `;
	
	       // Thêm phần tử mới vào container
	       document.getElementById('product-container').appendChild(productEntry);
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
		var customer=$('#customerName').val();
		var employeeId=$('#employeeID').val();
		var billId=$('#id').val();
		$(".product-entry").each(function name() {
			var name=$(this).find('#productName1').val();
			var quantity = $(this).find('#quantity1').val();
			var price=$(this).find('#price1').val();
			var total=quantity*price;
			var size=$(this).find('#size1').val();
			var color=$(this).find('#color1').val();
			var img="";
			var product={product:name,quantity:quantity,prince:price,size:size,color:color,image:img,total:total};
			listProduct.push(product);
		});
		if(billId==""){			
			add({customerName:customer,employeeID:employeeId,items:listProduct});
		}
		else{
			$(".product").each(function() {
		        var name = $(this).find("input[id^='name']").val(); // Tìm input có id bắt đầu bằng 'name'
		        var size = $(this).find("input[id^='size']").val(); // Tìm input có id bắt đầu bằng 'size'
		        var color = $(this).find("input[id^='color']").val(); // Tìm input có id bắt đầu bằng 'color'
		        var price = $(this).find("input[id^='price']").val(); // Tìm input có giá trị bắt đầu bằng 'x'        
		        var quantity = $(this).find("input[id^='quantity']").val(); // Tìm input có giá trị bắt đầu bằng 'x'
		        var img = "";
		        var total=price*quantity;
		        var product={product:name,quantity:quantity,prince:price,size:size,color:color,image:img,total:total};
		        listProduct.push(product);
			
		});
			add({billId:billId,customerName:customer,employeeID:employeeId,items:listProduct});
	};
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