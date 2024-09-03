<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">
	<link rel="stylesheet" href="<c:url value='/template/web/css/aos.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/open-iconic-bootstrap.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/animate.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/owl.carousel.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/owl.theme.default.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/magnific-popup.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/ionicons.min.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap-datepicker.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/jquery.timepicker.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/flaticon.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/icomoon.css' />" type="text/css">
    <link rel="stylesheet" href="<c:url value='/template/web/css/style.css' />" type="text/css">
</head>
<body>
	<%@ include file="/common/web/Header.jsp" %>
	 <dec:body/>
	 <%@include file="/common/web/Footer.jsp" %>
	
  <script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
    <script src="<c:url value='/template/web/js/jquery-migrate-3.0.1.min.js' />"></script>
    <script src="<c:url value='/template/web/js/popper.min.js' />"></script>
    <script src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/template/web/js/jquery.easing.1.3.js' />"></script>
    <script src="<c:url value='/template/web/js/jquery.waypoints.min.js' />"></script>
    <script src="<c:url value='/template/web/js/jquery.stellar.min.js' />"></script>
    <script src="<c:url value='/template/web/js/owl.carousel.min.js' />"></script>
    <script src="<c:url value='/template/web/js/jquery.magnific-popup.min.js' />"></script>
    <script src="<c:url value='/template/web/js/aos.js' />"></script>
    <script src="<c:url value='/template/web/js/jquery.animateNumber.min.js' />"></script>
    <script src="<c:url value='/template/web/js/bootstrap-datepicker.js' />"></script>
    <script src="<c:url value='/template/web/js/scrollax.min.js' />"></script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
    <script src="<c:url value='/template/web/js/google-map.js' />"></script>
    <script src="<c:url value='/template/web/js/main.js' />"></script>
</body>
</html>