<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	alert("성공적으로 회원가입이 되었습니다.");
	
	window.onload=function(){
		$.ajax({
			url:"<%=request.getContextPath() %>/getMcode.do?mName=회원목록",
			type:"get",
			success:function(event){
				window.opener.parent.location.href="<%=request.getContextPath() %>/index.do?mCode="+menu.mcode;
				window.close();
			}
		});
	}
</script>