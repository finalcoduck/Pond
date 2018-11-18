<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1,	user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="Keywords" content="">
<meta name="Description" content="">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap-4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/build/css/general.css">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
        crossorigin="anonymous">
<script src="${pageContext.request.contextPath}/resources/vendor/jquery-3.3.1/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/jQuery.serializeObject/js/jquery.serializeObject.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap-4.1.3/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/handlebars-v4.0.12/js/handlebars-v4.0.12.js"></script>
<script src="${pageContext.request.contextPath}/resources/build/js/commonConstant.js"></script>
<script src="${pageContext.request.contextPath}/resources/build/js/commonFunction.js"></script>
<script src="${pageContext.request.contextPath}/resources/vendor/sweetalert/dist/sweetalert.min.js"></script>

<title>POND</title>
</head>
<body class="bg-primary">
	

	<tiles:insertAttribute name="body" />
	
	
</body>
</html>