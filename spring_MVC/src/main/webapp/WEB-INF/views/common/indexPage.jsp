<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ include file="/WEB-INF/views/include/main_header.jsp" %> --%>
<%-- <jsp:include page="/WEB-INF/views/include/main_header.jsp">
	<jsp:param value="<%=msg %>" name="msg"/>
</jsp:include> --%>

<title>Choi's Home</title>
<head>
<style>
*{margin:0; padding:0;}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/main_header.jsp" %>
	<%@ include file="/WEB-INF/views/include/main_aside.jsp" %>
	<div class="content-wrapper" style="background-color: #FFFFFF;">
		<iframe name="ifr" src="/main.do" frameborder="0" style="width:100%; height:86vh;"></iframe>
	</div>
	<%@ include file="/WEB-INF/views/include/main_footer.jsp" %>
<!-- handlebars -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.min.js"></script>

<script src="<%=request.getContextPath() %>/resources/js/index.js"></script>

<script type="text/x-handlebars-template"  id="subMenu-list-template" >
{{#each .}}
	<li class="nav-item subMenu" >
      	<a href="javascript:goPage('{{murl}}','{{mcode}}');initPageParam();" class="nav-link">
          <i class="{{micon}}"></i>
             <p>{{mname}}</p>
        </a>
	</li>
{{/each}}
</script>

<!-- common -->
<script >
function init(){
	subMenu('${menu.mcode}'.substring(0,3)+"0000");
	goPage('${menu.murl}','${menu.mcode}');
}
 </script>
</body>