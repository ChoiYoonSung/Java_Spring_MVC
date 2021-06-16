<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE=html>

<html>
<head>
	<title></title>
	<%@ include file="/WEB-INF/views/include/style.jsp" %>
</head>
<body>
<section class="content">
      <div class="error-page">
        <h2 class="headline text-danger">500</h2>

        <div class="error-content">
          <h3><i class="fas fa-exclamation-triangle text-danger"></i>서버에 문제가 발생하였습니다.</h3>

          <p>
            We will work on fixing that right away.
            Meanwhile, you may <a href="/">return to dashboard</a> or try using the search form.
          </p>

          <form class="search-form">
            <div class="input-group">
              <input type="text" name="search" class="form-control" placeholder="Search">

              <div class="input-group-append">
                <button type="submit" name="submit" class="btn btn-danger"><i class="fas fa-search"></i>
                </button>
              </div>
            </div>
            <!-- /.input-group -->
          </form>
        </div>
      </div>
      <!-- /.error-page -->

    </section>
    <%@ include file="/WEB-INF/views/include/js.jsp" %>
</body>
</html>