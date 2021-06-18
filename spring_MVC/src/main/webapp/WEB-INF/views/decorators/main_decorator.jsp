<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><decorator:title default="Choi's System"/> </title>
<%@ include file="/WEB-INF/views/include/style.jsp" %>
<decorator:head />
</head>
<body class="hold-transition sidebar-mini" onload="init()">
<div class="wrapper">
		<div class="preloader flex-column justify-content-center align-items-center" style="height: 0px;">
			<img class="animation__shake" src="/resources/bootstrap/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60" style="display: none;">
		</div>
		<decorator:body />
</div>
<%@ include file="/WEB-INF/views/include/js.jsp" %>
</body>
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>
</html>