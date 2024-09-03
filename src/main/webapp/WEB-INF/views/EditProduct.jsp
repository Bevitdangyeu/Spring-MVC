<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:url var="ApiUrl" value="/public/add"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		  <input id="productName" name="productName" placeholder="PRODUCT NAME" class="form-control input-md" required="" type="text">
		    
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
		    <option selected>Open this select caterogy name</option>
				    			<c:forEach var="item" items="${category}" varStatus="status">
				    			 	 <option value="${item.categoryName}">${item.categoryName}</option>
				    			</c:forEach>	
		    </select>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group row ">
		  <label class="col-md-4 control-label" for="available_quantity">QUANTITY</label>  
		  <div class="col-md-8">
		  <input id="quantity" name="quantity" placeholder="AVAILABLE QUANTITY" class="form-control input-md" required="" type="number">
		    
		  </div>
		</div>
		<div class="form-group row ">
		  <label class="col-md-4 control-label" for="available_quantity">PRINCE</label>  
		  <div class="col-md-8">
		  <input id="prince" name="prince" placeholder="AVAILABLE QUANTITY" class="form-control input-md" required="" type="text">
		    
		  </div>
		</div>
		<!-- Textarea -->
		<div class="form-group row">
		  <label class="col-md-4 control-label" for="product_description">PRODUCT DESCRIPTION</label>
		  <div class="col-md-8">                     
		    <textarea class="form-control" id="description" name="description"></textarea>
		  </div>
		</div>
		 <!-- File Button --> 
		<div class="form-group row">
		  <label class="col-md-4 control-label" for="filebutton">main_image</label>
		  <div class="col-md-8">
		    <input id="image" name="image" class="input-file" type="file">
		  </div>
		</div>
		<!-- File Button --> 
		<div class="form-group row">
		  <label class="col-md-4 control-label" for="filebutton">auxiliary_images</label>
		  <div class="col-md-8">
		    <input id="listImage" name="listImage" class="input-file" type="file" multiple>
		  </div>
		</div>
		
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
	$('#EditButton').click(function () {
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
	  	var jsonData = {
	  			productName: productName,
	  			categoryName: catelogyName,
	  			quantity: quantity,
	  			prince: prince,
	  			description:description
	  			
	  	};
	    formData.append('jsonData', JSON.stringify(jsonData));
  			add(formData)
  		
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
				console.log(result);
			},
			error: function name(error) {
			//	showToast("Add request failed","danger");
				console.log(error);
			}
		});
	};
</script>
</body>

</html>