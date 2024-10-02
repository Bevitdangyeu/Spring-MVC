<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	    			<c:forEach var="i" items="${item.items }">
	    				<div class="product" style="display: flex; flex-direction: row; justify-content: space-between; margin-left: 30px 0; border: 1px dashed #DDDDDD; padding: 10px; width: 100%; height: 130px;background-color:#9FB6CD;border-radius:20px">
						    <div style="margin-right: 30px;">
						        <input type="hidden" id="img${status.index}" value="${i.image}">
						        <img style="height: 50px; width: 50px; object-fit: cover; border-radius: 50px; border: 1px dashed #888888;" alt="" src="${i.image}">
						    </div>
						
						    <div>
						        <p class="d-flex">
						            <span style="color:#DDDDDD">Name</span>
						            <span><input value="${i.product}" id="name${status.index}" readonly style="border:none;background-color:#9FB6CD" /></span>
						        </p>
						        <p class="d-flex">
						            <span style="color:#DDDDDD">Phân Loại</span>
						            <span><input style="border:none;background-color:#9FB6CD" value="${i.size}" id="size${status.index}" readonly /></span>
						            <span><input style="border:none;background-color:#9FB6CD" value="${i.color}" id="color${status.index}" readonly /></span>
						        </p>
						        <p class="d-flex">
						            <span style="color:#DDDDDD">Số lượng</span>
						             <span><input style="border:none;background-color:#9FB6CD" value="${i.quantity}" id="quantity${status.index}" readonly /></span>
						        </p>
						    </div>
						
						    <div class="d-flex justify-content-center" style="align-items: center; flex-direction: column;">
						        <p class="d-flex">
						            <span><input style="border:none;background-color:#9FB6CD" value="${i.total}" id="total${status.index}" readonly /></span>
						        </p>
						    </div>
						</div>
	    			</c:forEach>
	    			 
	    		</div>
	    			
	    		</div>
	    		<div>
			    	<p >
			    		<span style="width:100%;text-align: right;margin-right:70px;padding:10px" ><input id="totalBill" value=" Tổng tiền: ${item.totalPrice} " style="border-radius:10px;border:1px dashed #DDDDDD"/></span> 
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
</div>
</body>
</html>