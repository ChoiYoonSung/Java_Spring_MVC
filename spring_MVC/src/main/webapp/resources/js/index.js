function subMenu(mcode){
	if(mcode != 'M000000'){
	 $.getJSON("/subMenu.do?mCode="+mcode, function(data){
		printData(data, $('.subMenuList'),$('#subMenu-list-template'), '.subMenu');
	 });
	}else{
	 $('.subMenuList').html("");
	}
}

function printData(dataArr, target, templateObject, removeClass){
	var template = Handlebars.compile(templateObject.html());
	var html = template(dataArr);
	
	$(removeClass).remove();
	target.append(html);
}

function goPage(url, mcode){
 	// HTML5 지원브라우저에서 사용 가능
	if (typeof(history.pushState) == 'function'){
		// 현재 주소 가져옴
		var renewURL = location.href;
		// 현재 주소 중 .do / .html 뒤 부분이 있다면 날려버림(파라미터)
		renewURL = renewURL.substring(0, renewURL.indexOf(".do")+3);
		
		if(mcode != 'M000000'){
		 renewURL += "?mCode="+mcode;
		}
		// 페이지를 리로드 하지 않고 페이지 주소만 변경할 때 사용
		history.pushState(mcode, null, renewURL);
	}else{
		location.hash = "#"+mcode;
	}
 
	$('iframe[name="ifr"]').attr("src",url);
}