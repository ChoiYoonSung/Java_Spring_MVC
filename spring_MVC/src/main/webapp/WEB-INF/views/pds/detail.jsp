<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<title>자료실 상세보기</title>

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
						<li class="breadcrumb-item"><a href="list.do"><i
								class="fa fa-dashboard"></i>자료실</a></li>
						<li class="breadcrumb-item active">상세보기</li>
					</ol>
				</div>
			</div>
		</div>
	</section>

	<!-- Main content -->
	<section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-primary">
					<div class="card-header">
						<h3 class="card-title">상세보기</h3>
					</div>
					<div class="card-body">
						<div class="form-group col-sm-12">
							<label for="title">제 목</label> <input type="text"
								class="form-control" id="title" value="${pds.title }" readonly />
						</div>
						<div class="col-sm-12 row">
							<div class="form-group col-sm-4">
								<label for="writer">작성자</label> <input type="text"
									class="form-control" id="writer" value="${pds.writer }"
									readonly />
							</div>

							<div class="form-group col-sm-4">
								<label for="regDate">작성일</label> <input type="text"
									class="form-control" id="regDate"
									value="<fmt:formatDate value="${pds.regDate }" pattern="yyyy년 MM월 dd일"/>"
									readonly />
							</div>
							<div class="form-group col-sm-4">
								<label for="viewcnt">조회수</label> <input type="text"
									class="form-control" id="viewcnt" value="${pds.viewcnt }"
									readonly />
							</div>
						</div>
						<div class="form-group col-sm-12">
							<label for="content">내 용</label>
							<div id="content">${pds.content }</div>
						</div>
						<div class="form-group col-sm-12">
							<div class="card card-outline card-success">
								<div class="card-header">
									<h3>첨부파일</h3>
								</div>
								<div class="card-footer">
									<div class="row">
										<ul class="mailbox-attachments d-flex align-items-stretch clearfix">
											<c:forEach var="attach" items="${pds.attachList }">
												<li>
													<span class="mailbox-attachment-icon bg-warning"><i class="far fa-file-pdf"></i></span>
													<div class="mailbox-attachment-info">
														<div class="mailbox-attachment-name"><i class="fas fa-paperclip"></i>${attach.fileName }</div>
														<span class="mailbox-attachment-size clearfix mt-1">
															<span>1,245 KB</span>
															<a href="<%=request.getContextPath() %>/pds/getFileByAno.do?ano=${attach.ano }" class="btn btn-default btn-sm float-right"><i class="fas fa-cloud-download-alt"></i></a>
														</span>
													</div>
												</li>
											</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div>

					</div>
					<div class="card-footer">

						<button type="button" id="modifyBtn" class="btn btn-warning" onclick="submit_go('modifyForm.do','${pds.pno }')">Modify</button>
						<button type="button" id="removeBtn" class="btn btn-danger" onclick="submit_go('remove.do','${pds.pno }')">REMOVE</button>

						<button type="button" id="listBtn" class="btn btn-primary"
							onclick="CloseWindow();">CLOSE</button>
					</div>
				</div>
				<!-- end card -->
			</div>
			<!-- end col-md-12 -->
		</div>
		<!-- end row  -->

	</section>
	
	<script>
		function submit_go(url, pno){
			location.href=url+"?pno="+pno;
		}
	</script>
</body>