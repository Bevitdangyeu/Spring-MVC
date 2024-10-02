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
</head>
<body>
<div class="col-md-9 ftco-animate">
    	 <form action='<c:url value="/admin1/bill/list"/>'  id="listBill"  method="get">
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
						        <th>Employee ID</th>
						        <th>CustomerName</th>
						        <th>Product Name</th>
						        <th>Price</th>
						        <th>Quantity</th>
						        <th>Total</th>
						        <th>ToTal Bill</th>
						        <th>ToTal Quantity</th>
						       	<th>Status</th>
						      </tr>
						 </thead>
						    <tbody>
						     <c:forEach var="item" items="${listBill }" varStatus="status">
						     	<tr class="text-center">
							     	<td ><input type="checkbox" id="checkbox_${item.billId}" class="product-checkbox" value="${item.billId}" ></td>
							     	<td class="product-edit">
							     	<c:url var="EditURL" value="/admin1/bill/edit">
							      		<c:param name="id" value="${ item.billId}"/>
							      	</c:url>
							      	<a flag="edit"
										class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Edit Caterogy' 
										href='${EditURL}'>
										<span><i style="color:#0099CC" class="fa fa-edit" aria-hidden="true"></i></span>
									</a>
							     	</td>	
							     	<td class="EmployeeID">
								        <div class="input-group mb-1">
								        <input type="text" value="${item.employeeID }" id="employeeID${status.index}" name="employeeID" style="border-radius:10px; border-width: 0px; text-align: center;height:40px;width:80px"/>
								        </div>	
								        	
							        </td>	 
							        <td class="customerName">
								        <div class="input-group mb-1">
								        <input type="text" value="${item.customerName }" id="customerName${status.index}" name="customerName" style="border-radius:10px; border-width: 0px; text-align: center;height:40px;width:150px"/>
								        </div>	  	
							        </td>       
							       <c:forEach var="product" items="${item.items }">
							       		 <td class="product-name">
								         <div class="input-group mb-1">
									        	<input  type="text" value="${product.product }" id="productName${statusProduct.index}" name="productName" style="border-radius:10px; border-width: 0px; text-align: center;height:40px; width:150px"/>
								       	 </div>
								        </td> 
								         <td class="price">
								         <div class="input-group mb-1">
									        	<input  type="text" value="${product.prince}" id="prince${statusPrice.index}" name="prince" style="border-radius:10px; border-width: 0px; text-align: center;height:40px; width:120px"/>
								       	 </div>
								        </td> 
								         <td class="quantity">
								         <div class="input-group mb-1">
									        	<input  type="text" value="${product.quantity }" id="quantity${statusQuantity.index}" name="quantity" style="border-radius:10px; border-width: 0px; text-align: center;height:40px; width:50px"/>
								       	 </div>
								        </td> 
								         <td class="total">
								         <div class="input-group mb-1">
									        	<input  type="text" value="${product.total}" id="total${statusTotal.index}" name="total" style="border-radius:10px; border-width: 0px; text-align: center;height:40px; width:120px"/>
								       	 </div>
								        </td> 
							       </c:forEach>
							        <td class="TotalBill">
								        <div class="input-group mb-1">
								        <input type="text" value="${item.totalPrice }" id="totalPrice${status.index}" name="totalPrice" style="border-radius:10px; border-width: 0px; text-align: center;height:40px;width:120px"/>
								        </div>	
								        	
							        </td>
							        <td class="totalQuantity">
							        	<div class="input-group mb-1">
						             	<input type="number" name="totalQuantity" id="totalQuantity${status.index}"class="quantity form-control input-number" value="${item.totalQuantity }" >
						          	</div>
						          </td>
						           <td class="status">
							        	<div class="input-group mb-1">
						             	<input type="text" name="status" id="status${status.index}"class="quantity form-control input-number" value="${item.status }" style="border-radius:10px; border-width: 0px; text-align: center;height:40px; width:150px" readonly>
						          	</div>
						          </td>
							      
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
</body>
</html>