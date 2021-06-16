// Paging + Search
function list_go(page,url){
	
	if(!url) url="list.do";	// url 없을 경우
	
	var jobForm = $('form#pageForm');
	jobForm.find('[name="page"]').val(page);	// Paging present page
	jobForm.find('[name="perPageNum"]').val($('select#perPageNum').val());	// page num per screen
	jobForm.find('[name="searchType"]').val($('select#searchType').val());	// 
	jobForm.find('[name="keyword"]').val($('div.input-group>input[name="keyword"]').val());
	
	jobForm.attr({
		action: url,
		method:'get'
	}).submit();
};

function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr , WinTitle , "scrollbars=yes,width="+ WinWidth +", " +"height="+ WinHeight +", top="+ wintop +", left="+ winleft +", resizable=yes, status=yes"  );
	win.focus() ; 
}

//팝업창 닫기
function CloseWindow(parentURL){
	if(parentURL){
		window.opener.parent.location.href=parentURL;	
	}else{
		window.opener.parent.location.reload(true);
	}
	window.close();
};

// 사용자 사진 미리보기
function MemberPictureThumb(targetObj, fileName){	// (대상, 이미지 파일명)
	targetObj.style.backgroundImage="url('getPicture.do?picture="+fileName+"')";
	targetObj.style.backgroundPosition="center";
	targetObj.style.backgroundRepeat="no-repeat";
	targetObj.style.backgroundSize="cover";
};
