$(function(){
	
	$('.share_btn').click(function(){
	uname=$('input[name=customer_name]').val();
	card_no=$('input[name=customer_no]').val();
	if(uname==''){
		layer.alert('����д����');
		return false;
	}
	if(card_no==''){
		layer.alert('����д���֤����');
		return false;
	}
	var index = layer.load(1, {
	  shade: [0.1,'#fff'] //0.1͸���ȵİ�ɫ����
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
		 layer.confirm('����δ����һ��ֻ��һ�˵���ά˹��䣡<br/>�氮ֵ����ϧ��������ѡһö��ά˹����ŵһ��ֿ����', {
		  btn: ['��ѡ���','������һҳ'], //��ť
		  title:'<b>�氮��ѯ</b>'
		}, function(){
		  window.location.href="/allring.html";
		}, function(){
		});
	}
  }