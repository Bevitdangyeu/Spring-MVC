<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="<c:url value='/template/admin/css/sb-admin-2.min.css' />" rel="stylesheet">
</head>
<body>
	
	<%@ include file="/common/admin/Header.jsp" %>
	<div class="container-fluid">
		<div class="row">
			<%@ include file="/common/admin/Menu.jsp" %>
		 	<dec:body />
	  </div>
	  </div>
	<%@ include file="/common/admin/Footer.jsp" %>

  <!-- Bootstrap core JavaScript-->
    <script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
    <script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value='/template/admin/vendor/vendor/jquery-easing/jquery.easing.min.js' />"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value='/template/admin/js/sb-admin-2.min.js' />"></script>

    <!-- Page level plugins -->
    <script src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js' />"></script>

    <!-- Page level custom scripts -->
    <script src="<c:url value='/template/admin/js/demo/chart-area-demo.js' />"></script>
    <script src="<c:url value='/template/admin/js/demo/chart-pie-demo.js' />"></script>

</body>
</html>