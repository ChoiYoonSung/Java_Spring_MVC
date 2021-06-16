<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<form role="form" action="remove.do?id=${member.id }" method="post">
	<input type="hidden" name="id" value="${member.id }">
</form>
<script>
	if(confirm("삭제하시겠습니까?")){
		$('form[role="form"]').submit();
	}else{
		history.go(-1);
	}
</script>