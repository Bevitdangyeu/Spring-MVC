<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><dec:title default="Đăng nhập" /></title>
</head>
<body>
<div id="login">
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                       <!--   <form id="login-form" class="form" action="<c:url value='/dang-nhap'/>"  method="POST">-->
                     	<form action="j_spring_security_check" id="formLogin" method="post">
                       		<c:if test="${ not empty mess}">
                            	<div class="alert alert-${alert}"  role="alert">
 									 ${mess}
								</div>
                            </c:if>
				            <h2 class="h2login">LOGIN TO CONTINUE</h2>
				            <button class="sign_in">SIGN IN</button>
				            <button class="login_button">LOGIN</button>
				            <div class="form">

				                <!-- <i class="fa fa-user-o"></i> -->
				                <i class="fas fa-home"></i>
				                <input type="text"  id="username" name="username" placeholder="Email/SDT" required>
				                <!-- <label for="email" id="lbemail">Email</label> -->
				                
				            </div>
				            <div class="form">
				                <i class="fa fa-key" aria-hidden="true"></i>
				                <input type="password" required placeholder="Password" id="password" name="password">
				                <label for="Password"></label>
				            </div>

				             <input type="submit" name="submit" class="submit" value="SUBMIT">
				
				        </form>
                           <!-- <h3 class="text-center text-info">Login</h3>
                            <div class="form-group">
                            	<c:if test="${ not empty mess}">
                            		<div class="alert alert-${alert}"  role="alert">
 									 ${mess}
									</div>
                            	 </c:if>
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="userName" id="userName" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control">
                            </div>
                            <input type="hidden" value="login" name="action"/> 
                            <div class="form-group">
                                <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="submit">
                            </div>
                            <div id="register-link" class="text-right">
                                <a href="#" class="text-info">Register here</a>
                            </div> 
                        </form>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

