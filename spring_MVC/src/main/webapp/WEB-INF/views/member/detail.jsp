<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<title>회원상세보기</title>

<body>

  <!-- Content Wrapper. Contains page content -->
  <div >
    <!-- Main content -->
    <section class="content register-page">       
		<div class="register-box">         
	    	<form role="form" class="form-horizontal"  method="post">
	        	<div class="register-card-body" >
	            	<div class="row"  style="height:200px;">
						<div class="mailbox-attachments clearfix col-md-12" style="text-align: center;">							
							<div id="pictureView" data-id="${member.id }" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>														
						</div>
					</div>
					<br />
	                <div class="form-group row" >
	                  <label for="inputId" class="col-sm-3 control-label text-right">아이디</label>
	
	                  <div class="col-sm-9">
	                    <input name="id" type="text" class="form-control" id="inputId"  value="${member.id }" readonly>
	                  </div>
	                </div>	               
	                <div class="form-group row">
	                  <label for="inputName" class="col-sm-3 control-label text-right">이  름</label>
	
	                  <div class="col-sm-9">
	                    <input name="pwd" type="text" class="form-control" id="inputName" value="${member.name }" readonly>
	                  </div>
	                </div>
	                 <div class="form-group row">
	                  <label for="inputEmail" class="col-sm-3 control-label text-right">이메일</label>
	
	                  <div class="col-sm-9">
	                    <input name="email" type="email" class="form-control" id="inputEmail" value="${member.email }" readonly>
	                  </div>
	                </div>
	                 <div class="form-group row">
	                  <label for="inputPhone" class="col-sm-3 control-label text-right">전화번호</label>
	                  <div class="col-sm-9">   
	                  	<input name="phone" type="text" class="form-control" id="inputPhone" value="${member.phone }" readonly>	                
	                  </div>                  
	                </div>               
	              </div>  
	              
		          <div class="card-footer" >
		          		<div class="row">
			          		<div class="col-sm-3 text-center">
			          			<button type="button" onclick="location.href='modifyForm.do?id=${member.id}';" id="modifyBtn" class="btn btn-warning ">수 정</button>
			          		</div>
		          		
			          		<div class="col-sm-3 text-center">
			          			<button type="button" onclick="location.href='remove.do?id=${member.id}';" 
			          			id="deleteBtn" class="btn btn-danger" >삭 제</button>
			          		</div>
			          		<div class="col-sm-3 text-center">
			          			<button type="button" id="stopBtn" class="btn btn-info" >정 지</button>
			          		</div>
			          	
			          		<div class="col-sm-3 text-center">
			            		<button type="button" id="listBtn" onclick="CloseWindow()" class="btn btn-primary pull-right">닫 기</button>
			            	</div>
		          	    </div>  	
		          </div>
	      	  </form>
      	  </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
<script>
window.onload=function(){
	MemberPictureThumb(document.querySelector('[data-id="${member.id}"]'),'${member.picture}');
}
</script>
</body>