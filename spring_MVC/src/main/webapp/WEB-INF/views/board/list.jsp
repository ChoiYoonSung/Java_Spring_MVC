<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="boardList" value="${dataMap.boardList }" />

<title>자유게시판</title>
<head></head>
<body>
 <!-- Main content -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row md-2">
				<div class="col-sm-6">
					<h1>자유게시판</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item">
							<a href="list.do">
								<i class="fa fa-dashboard"></i>
								자유게시판
							</a>
						</li>
						<li class="breadcrumb-item active">목록</li>
					</ol>
				</div>
			</div>
		</div>
	</section>

	<section class="content">
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary" onclick="OpenWindow('registForm.do', '게시글등록', 800, 700);">게시글등록</button>
				<div id="keyword" class="card-tools" style="width:550px;">
					<div class="input-group row">
						<select class="form-control col-md-3" name="perPageNum" id="perPageNum"
							onchange="list_go(1)">
							<option value="10">정렬 개수</option>
							<option value="20" ${cri.perPageNum eq 20 ? 'selected' : "" }>20개씩</option>
							<option value="30" ${cri.perPageNum eq 30 ? 'selected' : "" }>30개씩</option>
							<option value="50" ${cri.perPageNum eq 50 ? 'selected' : "" }>50개씩</option>
						</select>
						<select class="form-control col-md-3" name="searchType" id="searchType" >
							<option value="">검색구분</option>
							<option value="tcw" ${cri.searchType eq 'tcw' ? 'selected' : "" }>전체</option>
							<option value="t" ${cri.searchType eq 't' ? 'selected' : "" }>제목</option>
							<option value="w" ${cri.searchType eq 'w' ? 'selected' : "" }>작성자</option>
							<option value="c" ${cri.searchType eq 'c' ? 'selected' : "" }>내용</option>
							<option value="tw" ${cri.searchType eq 'tw' ? 'selected' : "" }>제목+작성자</option>
							<option value="tc" ${cri.searchType eq 'tc' ? 'selected' : "" }>제목+내용</option>
							<option value="cw" ${cri.searchType eq 'cw' ? 'selected' : "" }>내용+작성자</option>
						</select>
						<input class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${cri.keyword }">
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" id="searchBtn" data-card-widget="search" onclick="list_go(1);">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
				</div>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered">
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						<c:forEach var="board" items="${boardList }" >
							<tr style="cursor:pointer;">
								<td style="width:10%">${board.bno }</td>
								<td style="width:50%">
									<a href="javascript:OpenWindow('detail.do?bno=${board.bno }','게시글 상세보기','800','900')">
										<span class="col-sm-12">${board.title }
											<c:if test="${board.replycnt ne 0 }">
												<span class="nav-item">
													&nbsp;&nbsp;<i class="fa fa-comment"></i>
													&nbsp;&nbsp;<span class="badge badge-warning navbar-badge">${board.replycnt }</span>
												</span>
											</c:if>
										</span>
									</a>
								</td>
								<td style="width:20%">${board.writer }</td>
								<td style="width:15%"><fmt:formatDate value="${board.regdate }" pattern="yyyy년 MM월 dd일"/></td>
								<td style="width:15%">${board.viewcnt }</td>
							</tr>
						</c:forEach>
						</table>
					</div>
				</div>
			</div>
			<div class="card-footer">
				<c:set var="list_url" value="list.do"/>
				<%@ include file="/WEB-INF/views/common/pagination.jsp" %>
			</div>
		</div>
	</section>
</body>
