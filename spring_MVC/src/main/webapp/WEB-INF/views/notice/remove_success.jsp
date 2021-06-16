<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script>
	alert("${nno }번 공지가 성공적으로 삭제되었습니다.");
	window.opener.parent.location.reload();
	window.close();
// 	CloseWindow();
</script>