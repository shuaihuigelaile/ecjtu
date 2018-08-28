$(function(){
	
	$('.share_btn').click(function(){
	uname=$('input[name=customer_name]').val();
	card_no=$('input[name=customer_no]').val();
	if(uname==''){
		layer.alert('请填写姓名');
		return false;
	}
	if(card_no==''){
		layer.alert('请填写身份证号码');
		return false;
	}
	var index = layer.load(1, {
	  shade: [0.1,'#fff'] //0.1透明度的白色背景
	});
	$.getJSON('fw.php?act=search_page', 'uname=' + encodeURI(uname) + '&card_no=' + card_no, searchResponse);
	});

});
  function searchResponse(result)
  {
	layer.closeAll('loading');
    if (result.error == 0)
    {
	  window.location.href=result.content;
    }else{
		 //alert(result.content);
		 layer.confirm('您尚未定制一生只送一人的乐维斯钻戒！<br/>真爱值得珍惜，快来挑选一枚乐维斯钻戒承诺一生挚爱。', {
		  btn: ['挑选钻戒','返回上一页'], //按钮
		  title:'<b>真爱查询</b>'
		}, function(){
		  window.location.href="/allring.html";
		}, function(){
		});
	}
  }