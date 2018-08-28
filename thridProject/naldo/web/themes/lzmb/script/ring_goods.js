/* *
 * 商品JS
 */
var productLT;

jQuery(function($){
var formBuy      = document.forms['ECS_FORMBUY'];
/*var singlegood=formBuy.elements['single_goods'].value;
	$("#jewelrySize").change(function(){
		changePrice();
	});*/
	
	/*$("ul.quality li span").click(function(){

	  $(this).siblings('span').removeClass('on');
	  if($(this).html()=='更多'){
		  $(".tit").click();
		  window.location.href='#dia';
	  }else{
	  $(this).addClass('on');
	  }
	  changePrice();
	  changeTitle();
	});*/
	
	
	
	$(".buyNowBtn").click(function(){
		var material = $(".material span.on");
		var is_men = $("#is_men").val();
		var men = '';var women = '';
		var kezi="";var size="";

		if(singlegood==1 && material.length<1 && goods_cat_id !=24) {
			alert('请选择材质');
			return false;
		}

		var xk=cz=0;
		var attr='';
		$("ul.quality li label").each(function(){
			join_str= (attr=='') ? '' : '_';
			if($(this).html()=='镶口：'){
				sel_xk=$(this).siblings('span.on');
				xk=sel_xk.html();
				attr+=join_str+sel_xk.attr('attr_id');
			}else if($(this).html()=='材质：'){
				sel_cz=$(this).siblings('span.on');			
				cz=sel_cz.html();
				attr+=join_str+sel_cz.attr('attr_id');	
			}else{
				sel_item=$(this).siblings('span.on');			
				attr+=join_str+sel_item.attr('attr_id');	
			}
		
		});
		
		
		if($("#kezi").length && $("#kezi").val().length && getByteLen($("#writeContent").html())>10) {
			
			alert('不能超过10个字符');
			return false;
		}
		if($("#kezi").length) {
			kezi=$("#kezi").val();
			
		}
		if($('#jewelrySize').length){
  	       size = $("#jewelrySize").val();
		   attr+=join_str+$("#jewelrySize option:selected").attr('attr_id');
		}

		if(goods_cat_id == 2 || top_cat_id ==2){
			var lz_id=$('#lz_id').val();
			if(lz_id>0){
			addToCart(goodsID,0,lz_id);
			}else{
			addToCart(goodsID);
			}
		}else{
			if(lzid>0){
			addToCart(goodsID,0,lzid);
			}else if(top_cat_id==1){
				addToCart(goodsID);
			}else{
			alert('钻托选定成功，请选择钻石');
			j_url='diamond.php?ztid='+goodsID+'&xk='+xk;
			if(cz) j_url +='&cz='+cz;
			if(size) j_url +='&size='+size;
			if(kezi) j_url +='&kezi='+kezi;
			if(attr) j_url +='&attr='+attr;
			
			location.href=j_url;
			}
		}
		
	});
	
	/*$('#writeInSwitcher').bind('keyup',function(){
		
		var _val = $(this).val();
		var _max = $(this).attr('maxlength'); 
		var _cur = getByteLen(_val);
		if(_cur>_max){
			alert('超出范围');
			$(this).val(getByteVal(_val,_max)); //截取指定字节长度内的值 
		}
		
	});*/
	
	$('#kezi').bind('keyup',function(){
		
		var _val = $(this).val();
		var _max = $(this).attr('maxlength'); 
		var _cur = getByteLen(_val);
		if(_cur>_max){
			alert('超出范围');
			$(this).val(getByteVal(_val,_max)); //截取指定字节长度内的值 
		}
		
	});
	function getByteLen(val) {
	  var len = 0;
	  for (var i = 0; i < val.length; i++) {
	  if (val[i].match(/[^x00-xff]/ig) != null) //全角
	  len += 2;
	  else
	  len += 1;
	  }
	  return len;
	} 
	
	function getByteVal(val, max) {
	  var returnValue = '';
	  var byteValLen = 0;
	  for (var i = 0; i < val.length; i++) {
	  if (val[i].match(/[^x00-xff]/ig) != null)
	  byteValLen += 2;
	  else
	  byteValLen += 1;
	  if (byteValLen > max)
	  break;
	  returnValue += val[i];
	  }
	  return returnValue;
	} 

	
});
