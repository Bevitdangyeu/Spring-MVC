<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:url var="ApiUrl" value="/api/product/add"/>
    <c:url var="NewUrl" value="/admin1/product/edit"/>
    <c:url var="ApiDeleteColor" value="/api/color/delete"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
   <style>
        img {
            width: 150px;
            height: 150px;
            object-fit: cover;
            border: 2px solid #ccc;
            margin: 10px;
            display: inline-block;
        }
    </style>
</head>
<body>

<!------ Include the above in your HEAD tag ---------->
<div style="margin-left:100px;margin-top:30px">
			<fieldset>
		
		<!-- Form Name -->
		<legend>PRODUCTS</legend>
		
		<!-- Text input-->
		
		<!-- Text input-->
		<div class="form-group- row">
		  <label class="col-md-4 control-label" for="product_name">PRODUCT NAME</label>  
		  <div class="col-md-8">
		  <input value="${product.productName }" id="productName" name="productName" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">
		    
		  </div>
		</div>
		
		<!-- 
		<div class="form-group">
		  <label class="col-md-4 control-label" for="product_name_fr">MÔ TẢ NGẮN</label>  
		  <div class="col-md-4">
		  <input id="product_name_fr" name="product_name_fr" placeholder="PRODUCT DESCRIPTION FR" class="form-control input-md" required="" type="text">
		    
		  </div>
		</div> -->
		
		<!-- Select Basic -->
		<div class="form-group row " style="margin-top:20px">
			  <label class="col-md-4 control-label" for="product_categorie">PRODUCT CATEGORY</label>
			  <div class="col-md-8">
			  	<select id="categoryName" name="categoryName" class="form-control">
				  <c:if test="${empty product.productId }">
				  
				    <option selected>Open this select caterogy name</option>
						    			<c:forEach var="item" items="${category}" varStatus="status">
						    			 	 <option value="${item.categoryName}">${item.categoryName}</option>
						    			</c:forEach>	
				    
				  </c:if>
			   	  <c:if test="${not empty product.productId }">
			   	  		<c:forEach var="item" items="${category}">
			   	  		<!-- phần này dùng để hiển thị thông tin catelogy đã chọn -->
			   	  			<c:if test="${item.categoryId==product.categoryId }">
			   	  				<option value="${item.categoryName}" selected="selected">${item.categoryName}</option>
			   	  			</c:if>			   
			   	  			<c:if test="${item.categoryId != ProductEdit.catelogyId}">
			    				<option value="${item.categoryName}">${item.categoryName}</option>
			    			</c:if>
			   	  		</c:forEach>
			   	  		<option>Open this select caterogy name</option>		
			   	  </c:if>
			   	  </select>
			  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group row ">
		  <label class="col-md-4 control-label" for="available_quantity">QUANTITY</label>  
		  <div class="col-md-8">
		  <input value="${product.quantity }" id="quantity" name="quantity" placeholder="AVAILABLE QUANTITY" class="form-control input-md" required="" type="number">
		    
		  </div>
		</div>
		<div class="form-group row ">
		  <label class="col-md-4 control-label" for="available_quantity">PRINCE</label>  
		  <div class="col-md-8">
		  <input value="${product.prince }" id="prince" name="prince" placeholder="AVAILABLE QUANTITY" class="form-control input-md" required="" type="text">
		    
		  </div>
		</div>
		<!-- Textarea -->
		<div class="form-group row">
		  <label class="col-md-4 control-label" for="product_description">PRODUCT DESCRIPTION</label>
		  <div class="col-md-8">                     
		    <textarea class="form-control" id="description" name="description">${product.description }</textarea>
		  </div>
		</div>
		<!-- File Button --> 
		
		<c:if test="${ not empty product.image }">
			
			<div class="form-group row">
			  <label class="col-md-4 control-label" for="filebutton">main_image</label>
			  <div class="col-md-8">
			  	<img style ="margin-bottom:15px" src="${product.image}" alt="Auxiliary Image" width="100" height="100" />
			  	<div class="preview" ></div>
			    <input id="image" name="image" class="input-file" type="file" onchange="previewImages(event)">
			    
			  </div>
			</div>
		
		<c:forEach var="img" items="${product.listImage }">
			<div class="form-group row">
			  <label class="col-md-4 control-label" for="filebutton">auxiliary_images</label>
			  <div class="col-md-8">
			  	<img style ="margin-right:10px;margin-bottom:15px" src="${img}" alt="Auxiliary Image" width="100" height="100" />
			  </div>
			</div>
		</c:forEach>
				<div class="form-group row">
				  <label class="col-md-4 control-label" for="filebutton">auxiliary_images</label>
				  <div class="col-md-8">
				    <input id="listImage"  name="listImage" class="input-file" type="file" multiple onchange="previewImages(event)">
				    <div class="preview" ></div>
				  </div>
				</div>
		</c:if>
		 <!-- File Button --> 
		<c:if test="${ empty product.image}">
			<div class="form-group row">
			  <label class="col-md-4 control-label" for="filebutton">main_image</label>
			  <div class="col-md-8">
			    <input  id="image" name="image" class="input-file" type="file" onchange="previewImages(event)">
			     <div class="preview" ></div>
			  </div>
			</div>
			<!-- File Button --> 
				<div class="form-group row">
				  <label class="col-md-4 control-label" for="filebutton">auxiliary_images</label>
				  <div class="col-md-8">
				    <input id="listImage"  name="listImage" class="input-file" type="file" multiple onchange="previewImages(event)">
				   <div class="preview"></div> 
				  </div>
				</div>
		</c:if>
		<!-- check box thông tin sản phẩm -->
		<!-- SIZE -->
		<div class="form-group row" >
			<label class="col-md-4 control-label" for="filebutton">SIZE</label>
				<div class="col-md-8" style="display: inline-block">
				<c:if test="${not empty product.productId }">
					<c:set var="stopLoop" value="false" />
					<c:forEach var="i" items="${fn:split('S,M,L,XL', ',')}">
						<c:forEach var="j" items="${product.listSize }">
							<c:if test="${i==j }">
								<input type="checkbox" id="checkbox1" class="size-checkbox" value="${j }" checked>
								<label class="col-md-2 control-label" for="filebutton">${j}</label>
								<c:set var="stopLoop" value="true" />
							</c:if>
						</c:forEach>
						<c:if test="${stopLoop==false }">
								<input type="checkbox" id="checkbox1" class="size-checkbox" value="${i }">
								<label class="col-md-2 control-label" for="filebutton">${i}</label>
						</c:if>
						<c:set var="stopLoop" value="flase" />
					</c:forEach>
				</c:if>
				<c:if test="${empty product.productId }">
					<input type="checkbox" id="checkbox1" class="size-checkbox" value="S" >
					<label class="col-md-2 control-label" for="filebutton">S</label>
					<input type="checkbox" id="checkbox2" class="size-checkbox" value="M" >
					<label class="col-md-2 control-label" for="filebutton">M</label>
					<input type="checkbox" id="checkbox3" class="size-checkbox" value="L" >
					<label class="col-md-2 control-label" for="filebutton">L</label>
					<input type="checkbox" id="checkbox4" class="size-checkbox" value="XL" >
					<label class="col-md-2 control-label" for="filebutton">XL</label>
				</c:if>
				</div>
		</div>
		<!-- hiển thị color -->
		<c:if test="${not empty product.productId }">
			<div class="form-group row">
			  <label class="col-md-4 control-label" for="singlebutton">COLOR
			  <button id="btn_delete" type="button" style=" border: none; cursor: pointer;background: none;">
					<span><i style="color:#0099CC" class="fa fa-trash" aria-hidden="true"></i></span>
			  </button>
			   </label>
			    <div class="col-md-8">
			   		<div class="colorList" style="display: flex; gap: 10px;">
			   			<c:forEach var="color" items="${product.listColor }" varStatus="status">
			   			  <input type="checkbox" id="checkbox${status.index }" class="color-checkbox" value="${color }" >
			   			  <input id="color${status.index }" placeholder="Nhập màu sắc" type="text" name="color" value="${color }" style="margin-bottom:10px"class="form-control input-md" >	
			   			</c:forEach>
			   		</div>
				</div>
			  </div>
		</c:if>
			
		
		<!-- COLOR -->
		<div class="form-group row">
			  <label class="col-md-4 control-label" for="singlebutton">
			   	<button style="margin-top:20px;margin-bottom:20px" type="button" id="addColor" class="btn btn-primary">Thêm màu sắc</button>
			   </label>
			    <div class="col-md-8">
			   	<div id="product-container">
				<!-- Nơi ô nhập màu sắc sẽ được thêm vào -->
				</div>
			  </div>
		</div>
		<!-- <div class="form-group row" >
			<label class="col-md-4 control-label" for="singlebutton"></label>
			  <div class="col-md-8">
			   	<div id="product-container">
				Nơi ô nhập màu sắc sẽ được thêm vào
				</div>
			  </div>
			</div> -->
		<!-- Button -->
		<c:if test="${not empty product.productId }">
		<div class="form-group row">
		  <label class="col-md-6 control-label" for="singlebutton">
		  	<button type="submit"id="EditButton" name="EditButton" class="btn btn-primary">Sửa sản phẩm</button>
		  </label>
		    
		</div>
		</c:if>
		<c:if test="${ empty product.productId }">
		<div class="form-group row">
		  <label class="col-md-6 control-label" for="singlebutton">
		   	<button type="submit"id="EditButton" name="EditButton" class="btn btn-primary">Thêm sản phẩm</button>
		  </label>
		   
		</div>
		</c:if>
		<input type="hidden" value=${product.productId } id="productId"/>
		</fieldset>
</div>



<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
	function previewImages() {
		// Lấy đối tượng input đã kích hoạt sự kiện
		var input = event.target;
		// Tìm phần tử cha có lớp 'form-group' của đối tượng input
	    var formGroup = input.parentElement.parentElement; // Tìm thẻ cha .form-group
	    // Tìm phần tử con có lớp 'preview' trong phần tử cha
	    var previewContainer = formGroup.querySelector('.preview'); // Tìm thẻ .preview trong thẻ cha
	    // Xóa nội dung trước đó trong phần tử .preview
        previewContainer.innerHTML = ''; // Xóa nội dung trước đó
        // Lấy danh sách các file từ đối tượng input
        var files = input.files;
        // Kiểm tra nếu có file
        if (files) {
        	// Chuyển đổi đối tượng file thành mảng và lặp qua từng file
            Array.from(files).forEach(function(file) {
            	// Tạo đối tượng FileReader để đọc nội dung của file
                var reader = new FileReader();
                // Định nghĩa hàm sẽ được gọi khi FileReader hoàn thành việc đọc file
                reader.onload = function(e) {
                	 // Tạo phần tử hình ảnh mới
                    var img = document.createElement('img');
                    // Gán thuộc tính src của hình ảnh bằng dữ liệu đọc được từ FileReader
                    img.src = e.target.result;
                    img.style.width = '100px';  // Đặt chiều rộng
                    img.style.height = '100px'; // Đặt chiều cao
                    img.style.margin='10px',
                    // Thêm phần tử hình ảnh vào trong phần tử previewContainer
                    previewContainer.appendChild(img);
                }
                // Bắt đầu đọc file dưới dạng Data URL
                reader.readAsDataURL(file);
            });
        }
    };
	  document.getElementById('addColor').addEventListener('click', function() {
		// Tạo một phần tử div mới để chứa các mục nhập sản phẩm
	       // Hai câu lệnh này tạo và cấu hình một phần tử HTML mới bằng JavaScript:
	       var productEntry = document.createElement('div');// chỉ định thẻ <div> 
	       productEntry.className = 'row product-entry';// gán class và id sẽ được áp dụng, tương đương với <div class="row product-entry"> 
	       /*  // list="suggestions" với suggestions là id của danh sách các đề xuất sẽ được hiển thị ở trường nhập liệu */
	       // Thêm mã HTML cho phần nhập thông tin sản phẩm và phần số lượng
	       //Gán nội dung HTML phức tạp cho phần tử div
	       productEntry.innerHTML = `  	
	    	   <input style="margin-bottom:10px"class="form-control input-md" placeholder="Nhập màu sắc" type="text" id="color" name="color">
	       `;
	
	       // Thêm phần tử mới vào container
	       document.getElementById('product-container').appendChild(productEntry);
	  });
		$('#EditButton').click(function () {
		/* 	var productId=$('#productId').val(); */
			/* khai báo 2 mảng lưu trữ dữ liệu của size và color */
			var color=[];
			var productName=$('#productName').val();
			var catelogyName=$('#categoryName').val();
			var quantity=$('#quantity').val();
			var prince=$('#prince').val();
			var description=$('#description').val();
			var fileInput = $('#image')[0];
	  		var file = fileInput.files;
	  		var formData = new FormData();
	  		for (var i = 0; i < file.length; i++) {
	  		    formData.append('image', file[i]);
	  		}
	  		
	  		var fileInputList = $('#listImage')[0];
	  		var fileList = fileInputList.files;
	  		for (var i = 0; i < fileList.length; i++) {
	  		    formData.append('listImage', fileList[i]);
	  		}
	  		/* lấy dữ liệu của color */
	  		 $(".product-entry").each(function name() {
	  			var a=$(this).find('#color').val();
	  			color.push(a);
			}); 
	  	/* 	lấy dữ liệu của size */
	  		 var sizeChecked = $('.size-checkbox:checked').map(function() {
           	 return this.value;
        	 }).get();
	  		if($('#productId').length === 0){
	  			var jsonData = {
	  		  			productName: productName,
	  		  			categoryName: catelogyName,
	  		  			quantity: quantity,
	  		  			prince: prince,
	  		  			description:description,
	  		  			listSize:sizeChecked,
	  		  			listColor:color
	  		  	};
	  		  	
	  		    formData.append('jsonData', JSON.stringify(jsonData));
	  	  			add(formData)
	  		}
	  		else{
	  			$('.colorList').find('input[name="color"]').each(function() {
	  			    var a = $(this).val();
	  			    color.push(a);
	  			});
	  			var jsonData = {
	  					productId:$('#productId').val(),
	  		  			productName: productName,
	  		  			categoryName: catelogyName,
	  		  			quantity: quantity,
	  		  			prince: prince,
	  		  			description:description,
	  		  			listSize:sizeChecked,
  		  				listColor:color
	  		  	};
	  		  	
	  		    formData.append('jsonData', JSON.stringify(jsonData));
	  	  			add(formData)
	  		}
		  
		});
		function add(formData) {
			$.ajax({
				url:'${ApiUrl}',
				type:'post',
				data: formData,
				processData: false, // Để jQuery không xử lý dữ liệu thành chuỗi query string
			    contentType: false,
				success: function (result) {
				//	showToast("Add request successful","success");
					 alert('Sản phẩm được thêm thành công');
					window.location.href= window.location.href;;
					console.log(result);
				},
				error: function name(error) {
				//	showToast("Add request failed","danger");
					console.log(error);
				}
			});
		};
	/* 	hàm xóa color của sản phẩm */
	$('#btn_delete').click(function name() {
		var id=$(this).attr('id').replace('btn_delete', '');
		var color_delete =[];
		color_delete = $('.color-checkbox:checked').map(function() {
           	 return this.value;
        	 }).get();
		var productId=$('#productId').val();
		delete_fun({productId:productId,listColor:color_delete});
	});
	 function delete_fun(data){
	   $.ajax({
		   url:'${ApiDeleteColor}',
			type:'DELETE',
			data: JSON.stringify(data),
			contentType :'application/json',
			success: function (result) {
				window.location.href= window.location.href;;
			},
			error: function (error) {
				//showToast("Edit request failed","danger");
				console.log(error);
			}
		}); 
   };
</script>
</body>

</html>