<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
</head>
<body>
    		<div class="col-md-9 ftco-animate">
    			<div class="cart-list">
	    			<table class="table">
						<thead class="thead-primary">
						      <tr class="text-center">
						        <th>&nbsp;</th>
						        <th>&nbsp;</th>
						        <th>&nbsp;</th>
						        <th>Product</th>
						        <th>Catelogy</th>
						        <th>Description</th>
						        <th>Price</th>
						        <th>Quantity</th>
						        <th>Total</th>
						      </tr>
						 </thead>
						    <tbody>
						     <c:forEach var="item" items="${listProduct }">
						     	 <tr class="text-center">
						     	<td class="product-edit">
						     		<button style=" border: none; cursor: pointer;background: none;">
						     			<span><i style="color:#0099CC" class="fa fa-edit" aria-hidden="true"></i></span>
						     		</button>
						     	</td>
						     	<td class="product-remove">
						     		<button style=" border: none; cursor: pointer;background: none;">
						     			<span><i style="color:#0099CC" class="fa fa-trash" aria-hidden="true"></i></span>
						     		</button>
						     	</td>
						        <td class="image-prod">
								     <img src="${item.image}" class="d-block ui-w-40 ui-bordered mr-4" alt="" style="width: auto; height: 70px;">
								</td>
						   
						        
						        <td class="product-name">
						        <div class="input-group mb-1">
						        <input  type="text" value="${item.productName }" id="productName" name="productName" style="border-radius:10px; border-width: 0px; text-align: center;height:40px; width:150px"/>
						        </div>	
						        	<p>${item.description }</p>
						        </td> 
						        <td class="catelogy-name">
							        <div class="input-group mb-1">
							        <input type="text" value="${item.categoryName }" id="categoryName" name="categoryName" style="border-radius:10px; border-width: 0px; text-align: center;height:40px;width:150px"/>
							        </div>	
							        	
						        </td>
						          <td class="description" >
							        <div class="input-group mb-1">
							        <textarea  id="description" name="description"  style="border-radius:10px; border-width: 0px; text-align: center ;height:60px">${item.description }</textarea>
							        </div>	
							        	
						        </td>
						        <td class="price">
							        <div class="input-group mb-1">
							        <input type="text" value="${item.prince }" id="prince" name="prince" style="border-radius:10px; border-width: 0px; text-align: center;height:40px;width:120px"/>
							        </div>	
							        	
						        </td>
						        <td class="quantity">
						        	<div class="input-group mb-1">
					             	<input type="number" name="quantity" class="quantity form-control input-number" value="${item.quantity }" >
					          	</div>
					          </td>
						        
						        <td class="total">$4.90</td>
						      </tr><!-- END TR-->
						     	
						     </c:forEach>
						    </tbody>
						  </table>
					  </div>
    			</div>
    		</div>
 </div>
    
</body>
</html>