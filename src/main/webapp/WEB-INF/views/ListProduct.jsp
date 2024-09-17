<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <c:url var="ApiDelete" value="/api/product/delete"/>
        <c:url var="NewUrl" value="/admin1/product/list?page=1&totalItem=3&sortBy=name"/>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
   
    	<div class="col-md-9 ftco-animate">
    	 <form action='<c:url value="/admin1/list"/>'  id="listProduct"  method="get">
    			<div class="cart-list">
	    			<table class="table">
						<thead class="thead-primary">
						      <tr class="text-center">
						      	<th>
						      		<button id="btn_delete" type="button" style=" border: none; cursor: pointer;background: none;">
							     		<span><i style="color:#0099CC" class="fa fa-trash" aria-hidden="true"></i></span>
							     	</button>
						      	</th>
						        <th>Edit</th>
						        <th>&nbsp;</th>
						        <th>Product</th>
						        <th>Catelogy</th>
						        <th>Description</th>
						        <th>Price</th>
						        <th>Quantity</th>
						        <th>sold quantity</th>
						      </tr>
						 </thead>
						    <tbody>
						     <c:forEach var="item" items="${listProduct }" varStatus="status">
						     	<tr class="text-center">
							     	<td ><input type="checkbox" id="checkbox_${item.productId}" class="product-checkbox" value="${item.productId}" ></td>
							     	<td class="product-edit">
							     	<c:url var="EditURL" value="/admin1/product/edit">
							      		<c:param name="id" value="${ item.productId}"/>
							      	</c:url>
							      	<a flag="edit"
										class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Edit Caterogy' 
										href='${EditURL}'>
										<span><i style="color:#0099CC" class="fa fa-edit" aria-hidden="true"></i></span>
									</a>
							     	</td>
							        <td class="image-prod">
									     <img id="image${status.index}" src="${item.image}" class="d-block ui-w-40 ui-bordered mr-4" alt="" style="width: auto; height: 70px;">
									</td>
							   
							        
							        <td class="product-name">
							        <div class="input-group mb-1">
							        <input  type="text" value="${item.productName }" id="productName${status.index}" name="productName" style="border-radius:10px; border-width: 0px; text-align: center;height:40px; width:150px"/>
							        </div>	
							        	<p>${item.description }</p>
							        </td> 
							        <td class="catelogy-name">
								        <div class="input-group mb-1">
								        <input type="text" value="${item.categoryName }" id="categoryName${status.index}" name="categoryName" style="border-radius:10px; border-width: 0px; text-align: center;height:40px;width:150px"/>
								        </div>	
								        	
							        </td>
							          <td class="description" >
								        <div class="input-group mb-1">
								        <textarea  id="description${status.index}" name="description"  style="border-radius:10px; border-width: 0px; text-align: center ;height:60px">${item.description }</textarea>
								        </div>	
								        	
							        </td>
							        <td class="price">
								        <div class="input-group mb-1">
								        <input type="text" value="${item.prince }" id="prince${status.index}" name="prince" style="border-radius:10px; border-width: 0px; text-align: center;height:40px;width:120px"/>
								        </div>	
								        	
							        </td>
							        <td class="quantity">
							        	<div class="input-group mb-1">
						             	<input type="number" name="quantity" id="quantity${status.index}"class="quantity form-control input-number" value="${item.quantity }" >
						          	</div>
						          </td>
							        
							        <td class="total">100</td>
						      </tr><!-- END TR-->
						     	
						     </c:forEach>
						    </tbody>
						  </table>
					  </div>
    			<ul style="display: flex;justify-content: center;" class="pagination" id="pagination"></ul>
    			<input type="hidden" id="page" value="" name="page">
    			<input type="hidden" id="totalItem" value="" name="totalItem">
				<input type="hidden" id="sortBy" value="" name="sortBy" />
    	</form>
    </div>
	<script type="text/javascript">
	var currentpage=${product.page};
	var visiblePage=${product.totalItem};
	var totalPage=${product.totalPage};
	var sortBy="${product.sortBy}";
	    $(function () {
	        window.pagObj = $('#pagination').twbsPagination({
	            totalPages: totalPage,<!-- tổng số trang -->
	            visiblePages: totalItem, <!-- tổng số lượng item trên 1 page -->
	            startPage:currentpage, <!-- page hiện tại đang trỏ -->
	            onPageClick: function (event, page) {
	                //console.info(page + ' (from options)');
	               if(currentpage!=page){
	            	   $('#maxPage').val(visiblePage);
		               $('#page').val(page);
		               $('#sortBy').val(sortBy);
		               $('#listProduct').submit();
	               }
	            }
	        }).on('page', function (event, page) {
	            console.info(page + ' (from event listening)');
	        });
	    });
 // xử lý xóa
 	// tác dụng khi click bất kì nút nào có bắt đầu là btn_edt
   $('#btn_delete').click(function (e) {
	   //lấy ra id bằng cách thay thế btn_edit bằng khoảng trắng-> còn lại số id của nút, mà số id của nút cũng bằng với id của các giá trị khác
	   // Lấy tất cả các checkbox được chọn
        var checkedValues = $('.product-checkbox:checked').map(function() {
            return this.value;
        }).get();
        delete_fun({ids:checkedValues})
	   
        alert('Bạn có chắc chắn muốn xóa : ' + checkedValues.join(', '));
   });
   function delete_fun(data){
	   $.ajax({
		   url:'${ApiDelete}',
			type:'DELETE',
			data: JSON.stringify(data),
			contentType :'application/json',
			success: function (result) {
				window.location.href="${NewUrl}";
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