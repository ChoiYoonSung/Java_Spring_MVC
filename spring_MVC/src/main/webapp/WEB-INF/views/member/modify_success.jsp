<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	alert("정보가 수정되었습니다.");
	
	<c:if test="${parentReload}">
		window.opener.parent.location.reload();
	</c:if>
	location.href='detail.do?id=${member.id }'
</script>