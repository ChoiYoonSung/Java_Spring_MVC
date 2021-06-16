<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<title>자료등록</title> 

<body> 
   <!-- Content Header (Page header) -->
    <section class="content-header">
    	<div class="container-fluid">
    		<div class="row mb-2">
    			<div class="col-sm-6">
	      			<h1>자료실</h1>
	      		</div>	      		
	    	
	       		
	       		<div class="col-sm-6">
			      <ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item"><a href="list.do"><i class="fa fa-dashboard"></i>자료실</a></li>
			        <li class="breadcrumb-item active">자료등록</li>		        
			      </ol>
		      	</div>
	     	</div>	     	
      	</div>
    </section>

    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h4>글등록</h4>
					</div><!--end card-header  -->
					<div class="card-body">
						<form enctype="multipart/form-data" role="form" method="post" action="regist.do" name="registForm">
							<div class="form-group">
								<label for="writer">작성자</label> 
								<input type="text" id="writer" readonly name="writer" class="form-control" value="${loginUser.id }">
							</div>
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title"
									name='title' class="form-control" placeholder="제목을 쓰세요">
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea class="textarea" name="content" id="content" rows="5"
									placeholder="1000자 내외로 작성하세요."></textarea>
							</div>
							<div class="form-group">								
								<div class="card card-outline card-success">
									<div class="card-header">
										<h5 style="display:inline;line-height:40px;">첨부파일 : </h5>
										&nbsp;&nbsp;<button class="btn btn-xs btn-primary" 
										type="button" id="addFileBtn" onclick="addFile_go();">Add File</button>
									</div>									
									<div class="card-footer fileInput">
									</div>
								</div>
							</div>
						</form>
					</div><!--end card-body  -->
					<div class="card-footer">
						<button type="button" class="btn btn-primary" id="registBtn" onclick="regist_go();">등 록</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn" id="cancelBtn" onclick="CloseWindow();">취 소</button>
					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
    
<script>
window.onload=function(){
	Summernote_start($('#content'));
	
	// 첨부파일 선택창 추가
	$('fileInput').on('change','input[type="file"]',function(event){
		if(this.files[0].size > 1024*1024*40){
			alert('파일 용량이 40MB를 초과하였습니다.');
			this.value="";
			$(this).click();
			return false;
		}; 
	});
	
	// 첨부파일 삭제
	$('div.fileInput').on('click','div.inputRow > button',function(event){
		$(this).parent('div.inputRow').remove();
	})
}

function addFile_go(){
	if($('input[name="uploadFile"]').length >= 5){
		alert("최대 5개의 파일만 등록 가능합니다.");
		return;
	}
	
	var input = $('<input>').attr({"type":"file","name":"uploadFile"}).css("display","inline");
	var div = $('<div>').addClass("inputRow");
	div.append(input).append("<button style='border:0; outline:0;' class='badge bg-red' type='button'>X</button>");
	div.appendTo($(".fileInput"));
}

function regist_go(){
	var files = $('input[name="uploadFile"]');
	for(var file of files){
		if(file.value == ""){
			alert('파일을 선택하세요.');
			file.focus();
			file.click();
			return;
		}
	}
	
	if($('input[name="title"]').val() == ""){
		alert('제목을 입력하세요.');
		$('input[name="title"]').focus();
		return;
	}
	
	document.registForm.submit();
}

</script>
<%@ include file="/WEB-INF/views/common/summernote.jsp" %>

</body>