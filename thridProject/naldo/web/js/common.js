/* $Id : common.js 4865 2007-01-31 14:04:10Z paulgao $ */

/* *
 * �����Ʒ�����ﳵ 
 */
 //window.onerror=function(){return true;};
function addToCart(goodsId, parentId, lzid)
{ 
  var goods        = new Object();
  var spec_arr     = new Array();
  var fittings_arr = new Array();
  var number       = 1;
  var formBuy      = document.forms['ECS_FORMBUY'];
  var quick		   = 0;
  var sp_attr="";
   ztid=(typeof(ztid) == "undefined") ? 0 : parseInt(ztid)

  if(ztid){
 	quick = 1;
	 var kezi=zt_kezi;
	 var size=zt_size;
	 var is_kezi=zt_is_kezi;
	 if(zt_attr)
	 	spec_arr=zt_attr.split('_');
  }else{
	 var kezi="";
	 var size="";
	 var is_kezi=0;
  }

  // ����Ƿ�����Ʒ��� 
  if (formBuy)
  {
    spec_arr = getSelectedAttributes_normal(formBuy);

    if (formBuy.elements['number'])
    {
      number = formBuy.elements['number'].value;
    }

	quick = 1;

	
	var singlegood=formBuy.elements['single_goods'].value; 
	var dia_id=$('#dia_id').val();

	if(singlegood==2){
	var material = $(".material span.on").html();
	var man_size =$(".man_size span.on").html();
	var woman_size =$(".woman_size span.on").html();
	//if(material) sp_attr +="���ʣ�"+ material;
	  
	  if($('#men_content').length)
	  var b_kezhi=$('#men_content').html();
	  if(b_kezhi=='����') b_kezhi='';
	  if($('#women_content').length)
	  var g_kezhi=$('#women_content').html();
	  if(g_kezhi=='����') g_kezhi='';
	  if(man_size || woman_size)
		  size=man_size+"|"+woman_size;
	  if($('#jewelrySize').length){
		  size = $("#jewelrySize").val();
		  is_kezi=1;
	  }
	  if($('#men_content').length || $('#women_content').length ){	
		  kezi=b_kezhi+"|"+g_kezhi;
		  is_kezi=1;
	  }
  
	}else if(singlegood==1){
	  var material = $(".material span.on").html();
	  //if(material) sp_attr +="���ʣ�"+ material;
	  if($('#kezi').length){
		  kezi =$('#kezi').val();
		  kezi=kezi.replace(/(&hearts;)/g,'(��)');
		  is_kezi=1;
	  }
	  if($('#jewelrySize').length)
		  size = $("#jewelrySize").val();
	  if(kezi == '����������� &gt;&gt;') kezi= '';
	  
	}
  }

  goods.quick    = quick;
  goods.spec     = spec_arr; 
  goods.goods_id = goodsId;
  goods.number   = number;
  goods.sp_attr  = sp_attr;
  goods.kezi     = kezi;
  goods.is_kezi  = is_kezi;
  goods.size     = size;
  goods.dia_id   =  (typeof(dia_id) == "undefined") ? 0 : parseInt(dia_id);
  goods.parent   = (typeof(parentId) == "undefined") ? 0 : parseInt(parentId);
  goods.lzid    = (typeof(lzid) == "undefined") ? 0 : parseInt(lzid);

  Ajax.call('flow.php?step=add_to_cart', 'goods=' + $.toJSON(goods), addToCartResponse, 'POST', 'JSON');
   
}

function addBareDiaToCart(goodsId, parentId)
{
  var goods        = new Object();
  var spec_arr     = new Array();
  var fittings_arr = new Array();
  var number       = 1;
  var formBuy      = document.forms['ECS_FORMBUY'];
  var quick		   = 0;
  var sp_attr="";
  sp_attr+="���أ�"+formBuy.elements['my_weight'].value;
  sp_attr+="<br/>֤�飺"+formBuy.elements['my_Lab'].value;
  sp_attr+="<br/>֤���ţ�"+formBuy.elements['my_LabNumber'].value;
  sp_attr+="<br/>�й���"+formBuy.elements['my_Cut'].value;
  sp_attr+="<br/>���ȣ�"+formBuy.elements['my_Clarity'].value; 

  if(formBuy.elements['gxkz']){
	  var  kezhi=formBuy.elements['gxkz'].value; 
	  if(kezhi=="���� �ĸ������� Ӣ�� �Ÿ�������")
		 kezhi="";
	  sp_attr+="<br/>���Կ��֣�"+kezhi;
  }
  // ����Ƿ�����Ʒ��� 
  if (formBuy)
  {
	  
    spec_arr = getSelectedAttributes(formBuy);

    if (formBuy.elements['number'])
    {
      number = formBuy.elements['number'].value;
    }

	quick = 1;
  }

  goods.quick    = quick;
  goods.spec     = spec_arr; 
  goods.goods_id = goodsId;
  goods.number   = number;
  goods.sp_attr  = sp_attr;
  goods.parent   = (typeof(parentId) == "undefined") ? 0 : parseInt(parentId);
  
  Ajax.call('flow.php?step=add_to_cart', 'goods=' + $.toJSON(goods), addToCartResponse, 'POST', 'JSON');
}


var my_weight="";
var my_Lab="";
var my_LabNumber="";
var my_Cut="";
var my_Clarity="";
var my_obj=null;
function addBareDiaToCart2(goodsId, parentId)
{
  var goods        = new Object();
  var spec_arr     = new Array();
  var fittings_arr = new Array();
  var number       = 1;
  var formBuy      = document.forms['ECS_FORMBUY'];
  var quick		   = 0;
  var sp_attr="";
  sp_attr+="���أ�"+my_weight;
  sp_attr+="<br/>֤�飺"+my_Lab;
  sp_attr+="<br/>֤���ţ�"+my_LabNumber;
  sp_attr+="<br/>�й���"+my_Cut;
  sp_attr+="<br/>���ȣ�"+my_Clarity;  
  // ����Ƿ�����Ʒ��� 
  if (formBuy)
  {
	  
    spec_arr = getSelectedAttributes(formBuy);

    if (formBuy.elements['number'])
    {
      number = formBuy.elements['number'].value;
    }

	quick = 1;
  }

  goods.quick    = quick;
  goods.spec     = spec_arr; 
  goods.goods_id = goodsId;
  goods.number   = number;
  goods.sp_attr  = sp_attr;
  goods.parent   = (typeof(parentId) == "undefined") ? 0 : parseInt(parentId);

  Ajax.call('/flow.php?step=add_to_cart', 'goods=' + $.toJSON(goods), addToCartResponse, 'POST', 'JSON');
}

function addBareDiaToCart3(goodsId, parentId)
{
  var goods        = new Object();
  var spec_arr     = new Array();
  var fittings_arr = new Array();
  var number       = 1;
  var formBuy      = document.forms['ECS_FORMBUY'];
  var quick		   = 0;
  var sp_attr="";
  /*sp_attr+="���أ�"+my_weight;
  sp_attr+="<br/>֤�飺"+my_Lab;
  sp_attr+="<br/>֤���ţ�"+my_LabNumber;
  sp_attr+="<br/>�й���"+my_Cut;
  sp_attr+="<br/>���ȣ�"+my_Clarity;  */
  sp_attr+="���أ�"+$("#weight").html();
  sp_attr+="<br/>֤�飺"+$("#lab").html();
  sp_attr+="<br/>֤���ţ�"+$("#labNumber").html();
  sp_attr+="<br/>�й���"+$("#cut").html();
  sp_attr+="<br/>���ȣ�"+$("#clarity").html();
  // ����Ƿ�����Ʒ��� 
  if (formBuy)
  {
	  
    spec_arr = getSelectedAttributes(formBuy);

    if (formBuy.elements['number'])
    {
      number = formBuy.elements['number'].value;
    }

	quick = 1;
  }

  goods.quick    = quick;
  goods.spec     = spec_arr; 
  goods.goods_id = goodsId;
  goods.number   = number;
  goods.sp_attr  = sp_attr;
  goods.parent   = (typeof(parentId) == "undefined") ? 0 : parseInt(parentId);
  
  Ajax.call('/flow.php?step=add_to_cart', 'goods=' + $.toJSON(goods), addToCartResponse, 'POST', 'JSON');
}
/**
 * ���ѡ������Ʒ����
 */
function getSelectedAttributes(formBuy)
{
  var spec_arr = new Array();
  var j = 0;

  for (i = 0; i < formBuy.elements.length; i ++ )
  {
    var prefix = formBuy.elements[i].name.substr(0, 5);  
    if (prefix == 'spec_' && (((formBuy.elements[i].type == 'radio' || formBuy.elements[i].type == 'checkbox') && formBuy.elements[i].checked) ||formBuy.elements[i].tagName == 'SELECT'||formBuy.elements[i].type == 'hidden'))
    {
      spec_arr[j] = formBuy.elements[i].value;
      j++ ;
    }
  }
  
   if($("ul.quality li span.on").length){
	  $("ul.quality li span.on").each(function(){
	   	spec_arr[j] = $(this).attr('attr_id');
		j++ ;
	   });
  }
  if($('#jewelrySize').length)
  	spec_arr[j] = $("#jewelrySize  option:selected").attr('attr_id');


  return spec_arr;
}

/**
 * ���ѡ������Ʒ����
 */
function getSelectedAttributes_normal(formBuy)
{
  var spec_arr = new Array();
  var j = 0;

  for (i = 0; i < formBuy.elements.length; i ++ )
  {
    var prefix = formBuy.elements[i].name.substr(0, 5);  
    if (prefix == 'spec_' && (((formBuy.elements[i].type == 'radio' || formBuy.elements[i].type == 'checkbox') && formBuy.elements[i].checked) ||formBuy.elements[i].tagName == 'SELECT'))
    {
      spec_arr[j] = formBuy.elements[i].value;
      j++ ;
    }
  }
  
  if($("ul.quality li span.on").length){
	  $("ul.quality li span.on").each(function(){
	   	spec_arr[j] = $(this).attr('attr_id');
		j++ ;
	   });
  }
  if($('#jewelrySize').length)
  	spec_arr[j] = $("#jewelrySize  option:selected").attr('attr_id');

  return spec_arr;
}

/* *
 * ���������Ʒ�����ﳵ�ķ�����Ϣ
 */
function addToCartResponse(result)
{ 
  if (result.error > 0)
  {
    // �����Ҫȱ���Ǽǣ���ת
    if (result.error == 2)
    {
      if (confirm(result.message))
      {
        location.href = '/user.php?act=add_booking&id=' + result.goods_id;
      }
    }
    // ûѡ��񣬵�������ѡ���
    else if (result.error == 6)
    {
      openSpeDiv(result.message, result.goods_id, result.parent, result.lz_id);
    }
    else
    {
      alert(result.message);
    }
  }
  else
  {
    var cartInfo = document.getElementById('ECS_CARTINFO');
    var cart_url = '/flow.php?step=cart';
    if (cartInfo)
    {
      cartInfo.innerHTML = result.content;
    }

    if (result.one_step_buy == '1')
    {
      location.href = cart_url;
    }
    else
    {
      switch(result.confirm_type)
      {
        case '1' :
          if (confirm(result.message)) location.href = cart_url;
          break;
        case '2' :
          if (!confirm(result.message)) location.href = cart_url;
          break;
        case '3' :
          location.href = cart_url;
          break;
        default :
          break;
      }
    }
  }
}

function buyBareDiamond(refno){

 document.getElementById("buy_div").innerHTML="<img src='/luozuan/images/carting.gif'>&nbsp;���ڷ��빺�ﳵ";
 Ajax.call('/luozuan/buydia_1.php?refno='+refno, '', buyBareDiamondResponse, 'POST', 'JSON');
 

}

 
function buyBareDiamondResponse(result){

  if(result.error==1){
    
	alert(result.message);
	 document.getElementById("buy_div").innerHTML='<a href="javascript:buyBareDiamond(\''+result.refno+'\')"><img src="/themes/lzmb/images/goumai.jpg" /></a>';

  }else{
  
    addBareDiaToCart(result.goods_id);

  }

}




function buyBareDiamond2(refno,wt,lb,ln,ct,cl,obj){

 my_weight=wt;
 my_Lab=lb;
 my_LabNumber=ln;
 my_Cut=ct;
 my_Clarity=cl;
 my_obj=obj;
 obj.outerHTML="<img src='/luozuan/images/carting.gif'>";
 Ajax.call('/luozuan/buydia_1.php?refno='+refno, '', buyBareDiamondResponse2, 'POST', 'JSON');
 

}

 
function buyBareDiamondResponse2(result){ 
  if(result.error==1){
    
	 alert(result.message);
	  my_obj.innerHTML='<a href="javascript:buyBareDiamond2(\''+result.refno+'\',\''+my_weight+'\',\''+my_Lab+'\',\''+my_LabNumber+'\',\''+my_Cut+'\',\''+my_Clarity+'\',this)"><img src="/luozuan/images/columnBuy.gif" /></a>';

  }else{
  
    addBareDiaToCart2(result.goods_id);

  }

}

/* *
 * �����Ʒ���ղؼ�
 */
function collect(goodsId)
{
  Ajax.call('user.php?act=collect', 'id=' + goodsId, collectResponse, 'GET', 'JSON');
}

/* *
 * �����ղ���Ʒ�ķ�����Ϣ
 */
function collectResponse(result)
{
  alert(result.message);
}

/* *
 * �����Ա��¼�ķ�����Ϣ
 */
function signInResponse(result)
{
  toggleLoader(false);

  var done    = result.substr(0, 1);
  var content = result.substr(2);

  if (done == 1)
  {
    document.getElementById('member-zone').innerHTML = content;
  }
  else
  {
    alert(content);
  }
}

/* *
 * ���۵ķ�ҳ����
 */
function gotoPage(page, id, type)
{
  Ajax.call('comment.php?act=gotopage', 'page=' + page + '&id=' + id + '&type=' + type, gotoPageResponse, 'GET', 'JSON');
}

function gotoPageResponse(result)
{
  document.getElementById("ECS_COMMENT").innerHTML = result.content;
  $('#comment_rscnt').html(result.record_count);
}

/* *
 * ȡ�ø�ʽ����ļ۸�
 * @param : float price
 */
function getFormatedPrice(price)
{
  if (currencyFormat.indexOf("%s") > - 1)
  {
    return currencyFormat.replace('%s', advFormatNumber(price, 2));
  }
  else if (currencyFormat.indexOf("%d") > - 1)
  {
    return currencyFormat.replace('%d', advFormatNumber(price, 0));
  }
  else
  {
    return price;
  }
}

/* *
 * �ᱦ�����Ա����
 */

function bid(step)
{
  var price = '';
  var msg   = '';
  if (step != - 1)
  {
    var frm = document.forms['formBid'];
    price   = frm.elements['price'].value;
    id = frm.elements['snatch_id'].value;
    if (price.length == 0)
    {
      msg += price_not_null + '\n';
    }
    else
    {
      var reg = /^[\.0-9]+/;
      if ( ! reg.test(price))
      {
        msg += price_not_number + '\n';
      }
    }
  }
  else
  {
    price = step;
  }

  if (msg.length > 0)
  {
    alert(msg);
    return;
  }

  Ajax.call('snatch.php?act=bid&id=' + id, 'price=' + price, bidResponse, 'POST', 'JSON')
}

/* *
 * �ᱦ�����Ա���۷���
 */

function bidResponse(result)
{
  if (result.error == 0)
  {
    document.getElementById('ECS_SNATCH').innerHTML = result.content;
    if (document.forms['formBid'])
    {
      document.forms['formBid'].elements['price'].focus();
    }
    newPrice(); //ˢ�¼۸��б�
  }
  else
  {
    alert(result.content);
  }
}
 

/* *
 * �ᱦ������³���
 */

function newPrice(id)
{
  Ajax.call('snatch.php?act=new_price_list&id=' + id, '', newPriceResponse, 'GET', 'TEXT');
}

/* *
 * �ᱦ������³��۷���
 */

function newPriceResponse(result)
{
  document.getElementById('ECS_PRICE_LIST').innerHTML = result;
}

/* *
 *  ���������б�
 */
function getAttr(cat_id)
{
  var tbodies = document.getElementsByTagName('tbody');
  for (i = 0; i < tbodies.length; i ++ )
  {
    if (tbodies[i].id.substr(0, 10) == 'goods_type')tbodies[i].style.display = 'none';
  }

  var type_body = 'goods_type_' + cat_id;
  try
  {
    document.getElementById(type_body).style.display = '';
  }
  catch (e)
  {
  }
}

/* *
 * ��ȡС��λ��
 */
function advFormatNumber(value, num) // ��������
{
  var a_str = formatNumber(value, num);
  var a_int = parseFloat(a_str);
  if (value.toString().length > a_str.length)
  {
    var b_str = value.toString().substring(a_str.length, a_str.length + 1);
    var b_int = parseFloat(b_str);
    if (b_int < 5)
    {
      return a_str;
    }
    else
    {
      var bonus_str, bonus_int;
      if (num == 0)
      {
        bonus_int = 1;
      }
      else
      {
        bonus_str = "0."
        for (var i = 1; i < num; i ++ )
        bonus_str += "0";
        bonus_str += "1";
        bonus_int = parseFloat(bonus_str);
      }
      a_str = formatNumber(a_int + bonus_int, num)
    }
  }
  return a_str;
}

function formatNumber(value, num) // ֱ��ȥβ
{
  var a, b, c, i;
  a = value.toString();
  b = a.indexOf('.');
  c = a.length;
  if (num == 0)
  {
    if (b != - 1)
    {
      a = a.substring(0, b);
    }
  }
  else
  {
    if (b == - 1)
    {
      a = a + ".";
      for (i = 1; i <= num; i ++ )
      {
        a = a + "0";
      }
    }
    else
    {
      a = a.substring(0, b + num + 1);
      for (i = c; i <= b + num; i ++ )
      {
        a = a + "0";
      }
    }
  }
  return a;
}

/* *
 * ���ݵ�ǰshiping_id���õ�ǰ���͵ĵı��۷��ã�������۷���Ϊ0�������ر��۷���
 *
 * return       void
 */
function set_insure_status()
{
  // ȡ�ñ��۷��ã�ȡ����Ĭ��Ϊ0
  var shippingId = getRadioValue('shipping');
  var insure_fee = 0;
  if (shippingId > 0)
  {
    if (document.forms['theForm'].elements['insure_' + shippingId])
    {
      insure_fee = document.forms['theForm'].elements['insure_' + shippingId].value;
    }
    // ÿ��ȡ������ѡ��
    if (document.forms['theForm'].elements['need_insure'])
    {
      document.forms['theForm'].elements['need_insure'].checked = false;
    }

    // �������ͱ��ۣ�Ϊ0����
    if (document.getElementById("ecs_insure_cell"))
    {
      if (insure_fee > 0)
      {
        document.getElementById("ecs_insure_cell").style.display = '';
        setValue(document.getElementById("ecs_insure_fee_cell"), getFormatedPrice(insure_fee));
      }
      else
      {
        document.getElementById("ecs_insure_cell").style.display = "none";
        setValue(document.getElementById("ecs_insure_fee_cell"), '');
      }
    }
  }
}

/* *
 * ��֧����ʽ�ı�ʱ�������¼�
 * @param       pay_id      ֧����ʽ��id
 * return       void
 */
function changePayment(pay_id)
{
  // ���㶩������
  calculateOrderFee();
}

function getCoordinate(obj)
{
  var pos =
  {
    "x" : 0, "y" : 0
  }

  pos.x = document.body.offsetLeft;
  pos.y = document.body.offsetTop;

  do
  {
    pos.x += obj.offsetLeft;
    pos.y += obj.offsetTop;

    obj = obj.offsetParent;
  }
  while (obj.tagName.toUpperCase() != 'BODY')

  return pos;
}

function showCatalog(obj)
{
  var pos = getCoordinate(obj);
  var div = document.getElementById('ECS_CATALOG');

  if (div && div.style.display != 'block')
  {
    div.style.display = 'block';
    div.style.left = pos.x + "px";
    div.style.top = (pos.y + obj.offsetHeight - 1) + "px";
  }
}

function hideCatalog(obj)
{
  var div = document.getElementById('ECS_CATALOG');

  if (div && div.style.display != 'none') div.style.display = "none";
}

function sendHashMail()
{
  Ajax.call('user.php?act=send_hash_mail', '', sendHashMailResponse, 'GET', 'JSON')
}

function sendHashMailResponse(result)
{
  alert(result.message);
}

/* ������ѯ */
function orderQuery()
{
  var order_sn = document.forms['ecsOrderQuery']['order_sn'].value;

  var reg = /^[\.0-9]+/;
  if (order_sn.length < 10 || ! reg.test(order_sn))
  {
    alert(invalid_order_sn);
    return;
  }
  Ajax.call('user.php?act=order_query&order_sn=s' + order_sn, '', orderQueryResponse, 'GET', 'JSON');
}

function orderQueryResponse(result)
{
  if (result.message.length > 0)
  {
    alert(result.message);
  }
  if (result.error == 0)
  {
    var div = document.getElementById('ECS_ORDER_QUERY');
    div.innerHTML = result.content;
  }
}

function display_mode(str)
{
    document.getElementById('display').value = str;
    setTimeout(doSubmit, 0);
    function doSubmit() {document.forms['listform'].submit();}
}

function display_mode_wholesale(str)
{
    document.getElementById('display').value = str;
    setTimeout(doSubmit, 0);
    function doSubmit() 
    {
        document.forms['wholesale_goods'].action = "wholesale.php";
        document.forms['wholesale_goods'].submit();
    }
}

/* �޸�IE6���°汾PNGͼƬAlpha */
function fixpng()
{
  var arVersion = navigator.appVersion.split("MSIE")
  var version = parseFloat(arVersion[1])

  if ((version >= 5.5) && (document.body.filters))
  {
     for(var i=0; i<document.images.length; i++)
     {
        var img = document.images[i]
        var imgName = img.src.toUpperCase()
        if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
        {
           var imgID = (img.id) ? "id='" + img.id + "' " : ""
           var imgClass = (img.className) ? "class='" + img.className + "' " : ""
           var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
           var imgStyle = "display:inline-block;" + img.style.cssText
           if (img.align == "left") imgStyle = "float:left;" + imgStyle
           if (img.align == "right") imgStyle = "float:right;" + imgStyle
           if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle
           var strNewHTML = "<span " + imgID + imgClass + imgTitle
           + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
           + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
           + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>"
           img.outerHTML = strNewHTML
           i = i-1
        }
     }
  }
}

function hash(string, length)
{
  var length = length ? length : 32;
  var start = 0;
  var i = 0;
  var result = '';
  filllen = length - string.length % length;
  for(i = 0; i < filllen; i++)
  {
    string += "0";
  }
  while(start < string.length)
  {
    result = stringxor(result, string.substr(start, length));
    start += length;
  }
  return result;
}

function stringxor(s1, s2)
{
  var s = '';
  var hash = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
  var max = Math.max(s1.length, s2.length);
  for(var i=0; i<max; i++)
  {
    var k = s1.charCodeAt(i) ^ s2.charCodeAt(i);
    s += hash.charAt(k % 52);
  }
  return s;
}

var evalscripts = new Array();
function evalscript(s)
{
  if(s.indexOf('<script') == -1) return s;
  var p = /<script[^\>]*?src=\"([^\>]*?)\"[^\>]*?(reload=\"1\")?(?:charset=\"([\w\-]+?)\")?><\/script>/ig;
  var arr = new Array();
  while(arr = p.exec(s)) appendscript(arr[1], '', arr[2], arr[3]);
  return s;
}

function $$(id)
{
    return document.getElementById(id);
}

function appendscript(src, text, reload, charset)
{
  var id = hash(src + text);
  if(!reload && in_array(id, evalscripts)) return;
  if(reload && $$(id))
  {
    $$(id).parentNode.removeChild($$(id));
  }
  evalscripts.push(id);
  var scriptNode = document.createElement("script");
  scriptNode.type = "text/javascript";
  scriptNode.id = id;
  //scriptNode.charset = charset;
  try
  {
    if(src)
    {
      scriptNode.src = src;
    }
    else if(text)
    {
      scriptNode.text = text;
    }
    $$('append_parent').appendChild(scriptNode);
  }
  catch(e)
  {}
}

function in_array(needle, haystack)
{
  if(typeof needle == 'string' || typeof needle == 'number')
  {
    for(var i in haystack)
    {
      if(haystack[i] == needle)
      {
        return true;
      }
    }
  }
  return false;
}

var pmwinposition = new Array();

var userAgent = navigator.userAgent.toLowerCase();
var is_opera = userAgent.indexOf('opera') != -1 && opera.version();
var is_moz = (navigator.product == 'Gecko') && userAgent.substr(userAgent.indexOf('firefox') + 8, 3);
var is_ie = (userAgent.indexOf('msie') != -1 && !is_opera) && userAgent.substr(userAgent.indexOf('msie') + 5, 3);
function pmwin(action, param)
{
  var objs = document.getElementsByTagName("OBJECT");
  if(action == 'open')
  {
    for(i = 0;i < objs.length; i ++)
    {
      if(objs[i].style.visibility != 'hidden')
      {
        objs[i].setAttribute("oldvisibility", objs[i].style.visibility);
        objs[i].style.visibility = 'hidden';
      }
    }
    var clientWidth = document.body.clientWidth;
    var clientHeight = document.documentElement.clientHeight ? document.documentElement.clientHeight : document.body.clientHeight;
    var scrollTop = document.body.scrollTop ? document.body.scrollTop : document.documentElement.scrollTop;
    var pmwidth = 800;
    var pmheight = clientHeight * 0.9;
    if(!$$('pmlayer'))
    {
      div = document.createElement('div');div.id = 'pmlayer';
      div.style.width = pmwidth + 'px';
      div.style.height = pmheight + 'px';
      div.style.left = ((clientWidth - pmwidth) / 2) + 'px';
      div.style.position = 'absolute';
      div.style.zIndex = '999';
      $$('append_parent').appendChild(div);
      $$('pmlayer').innerHTML = '<div style="width: 800px; background: #666666; margin: 5px auto; text-align: left">' +
        '<div style="width: 800px; height: ' + pmheight + 'px; padding: 1px; background: #FFFFFF; border: 1px solid #7597B8; position: relative; left: -6px; top: -3px">' +
        '<div onmousedown="pmwindrag(event, 1)" onmousemove="pmwindrag(event, 2)" onmouseup="pmwindrag(event, 3)" style="cursor: move; position: relative; left: 0px; top: 0px; width: 800px; height: 30px; margin-bottom: -30px;"></div>' +
        '<a href="###" onclick="pmwin(\'close\')"><img style="position: absolute; right: 20px; top: 15px" src="images/close.gif" title="�ر�" /></a>' +
        '<iframe id="pmframe" name="pmframe" style="width:' + pmwidth + 'px;height:100%" allowTransparency="true" frameborder="0"></iframe></div></div>';
    }
    $$('pmlayer').style.display = '';
    $$('pmlayer').style.top = ((clientHeight - pmheight) / 2 + scrollTop) + 'px';
    if(!param)
    {
        pmframe.location = 'pm.php';
    }
    else
    {
        pmframe.location = 'pm.php?' + param;
    }
  }
  else if(action == 'close')
  {
    for(i = 0;i < objs.length; i ++)
    {
      if(objs[i].attributes['oldvisibility'])
      {
        objs[i].style.visibility = objs[i].attributes['oldvisibility'].nodeValue;
        objs[i].removeAttribute('oldvisibility');
      }
    }
    hiddenobj = new Array();
    $$('pmlayer').style.display = 'none';
  }
}

var pmwindragstart = new Array();
function pmwindrag(e, op)
{
  if(op == 1)
  {
    pmwindragstart = is_ie ? [event.clientX, event.clientY] : [e.clientX, e.clientY];
    pmwindragstart[2] = parseInt($$('pmlayer').style.left);
    pmwindragstart[3] = parseInt($$('pmlayer').style.top);
    doane(e);
  }
  else if(op == 2 && pmwindragstart[0])
  {
    var pmwindragnow = is_ie ? [event.clientX, event.clientY] : [e.clientX, e.clientY];
    $$('pmlayer').style.left = (pmwindragstart[2] + pmwindragnow[0] - pmwindragstart[0]) + 'px';
    $$('pmlayer').style.top = (pmwindragstart[3] + pmwindragnow[1] - pmwindragstart[1]) + 'px';
    doane(e);
  }
  else if(op == 3)
  {
    pmwindragstart = [];
    doane(e);
  }
}

function doane(event)
{
  e = event ? event : window.event;
  if(is_ie)
  {
    e.returnValue = false;
    e.cancelBubble = true;
  }
  else if(e)
  {
    e.stopPropagation();
    e.preventDefault();
  }
}

/* *
 * �����������ﳵ
 */
function addPackageToCart(packageId)
{
  var package_info = new Object();
  var number       = 1;

  package_info.package_id = packageId
  package_info.number     = number;

  Ajax.call('flow.php?step=add_package_to_cart', 'package_info=' + obj2str(package_info), addPackageToCartResponse, 'POST', 'JSON');
}

/* *
 * ���������������ﳵ�ķ�����Ϣ
 */
function addPackageToCartResponse(result)
{
  if (result.error > 0)
  {
    if (result.error == 2)
    {
      if (confirm(result.message))
      {
        location.href = 'user.php?act=add_booking&id=' + result.goods_id;
      }
    }
    else
    {
      alert(result.message);    
    }
  }
  else
  {
    var cartInfo = document.getElementById('ECS_CARTINFO');
    var cart_url = 'flow.php?step=cart';
    if (cartInfo)
    {
      cartInfo.innerHTML = result.content;
    }

    if (result.one_step_buy == '1')
    {
      location.href = cart_url;
    }
    else
    {
      switch(result.confirm_type)
      {
        case '1' :
          if (confirm(result.message)) location.href = cart_url;
          break;
        case '2' :
          if (!confirm(result.message)) location.href = cart_url;
          break;
        case '3' :
          location.href = cart_url;
          break;
        default :
          break;
      }
    }
  }
}

function setSuitShow(suitId)
{
    var suit    = document.getElementById('suit_'+suitId);

    if(suit == null)
    {
        return;
    }
    if(suit.style.display=='none')
    {
        suit.style.display='';
    }
    else
    {
        suit.style.display='none';
    }
}


/* �����ĸ�����Ϊ����ѡ�񵯳���Ĺ��ܺ������� */
//�����Ƿ��Ѿ�����
function docEle() 
{
  return document.getElementById(arguments[0]) || false;
}

//��������ѡ���
function openSpeDiv(message, goods_id, parent, lz_id)
{
  var _id = "speDiv";
  var m = "mask";
  if (docEle(_id)) document.removeChild(docEle(_id));
  if (docEle(m)) document.removeChild(docEle(m));
  if (typeof(lz_id) == 'undefined' || lz_id=='') lz_id=0;
  //�����Ͼ�Ԫ��ֵ
  var scrollPos; 
  if (typeof window.pageYOffset != 'undefined') 
  { 
    scrollPos = window.pageYOffset; 
  } 
  else if (typeof document.compatMode != 'undefined' && document.compatMode != 'BackCompat') 
  { 
    scrollPos = document.documentElement.scrollTop; 
  } 
  else if (typeof document.body != 'undefined') 
  { 
    scrollPos = document.body.scrollTop; 
  }

  var i = 0;
  var sel_obj = document.getElementsByTagName('select');
  while (sel_obj[i])
  {
    sel_obj[i].style.visibility = "hidden";
    i++;
  }

  // �¼���ͼ��
  var newDiv = document.createElement("div");
  newDiv.id = _id;
  newDiv.style.position = "absolute";
  newDiv.style.zIndex = "10000";
  newDiv.style.width = "300px";
  newDiv.style.height = "260px";
  newDiv.style.top = (parseInt(scrollPos + 200)) + "px";
  newDiv.style.left = (parseInt(document.body.offsetWidth) - 200) / 2 + "px"; // ��Ļ����
  newDiv.style.overflow = "auto"; 
  newDiv.style.background = "#FFF";
  newDiv.style.border = "3px solid #59B0FF";
  newDiv.style.padding = "5px";

  //���ɲ�������
  newDiv.innerHTML = '<h4 style="font-size:14; margin:15 0 0 15;">' + select_spe + "</h4>";

  for (var spec = 0; spec < message.length; spec++)
  {
      newDiv.innerHTML += '<hr style="color: #EBEBED; height:1px;"><h6 style="text-align:left; background:#ffffff; margin-left:15px;">' +  message[spec]['name'] + '</h6>';

      if (message[spec]['attr_type'] == 1)
      {
        for (var val_arr = 0; val_arr < message[spec]['values'].length; val_arr++)
        {
          if (val_arr == 0)
          {
            newDiv.innerHTML += "<input style='margin-left:15px;' type='radio' name='spec_" + message[spec]['attr_id'] + "' value='" + message[spec]['values'][val_arr]['id'] + "' id='spec_value_" + message[spec]['values'][val_arr]['id'] + "' checked /><font color=#555555>" + message[spec]['values'][val_arr]['label'] + '</font> [' + message[spec]['values'][val_arr]['format_price'] + ']</font><br />';      
          }
          else
          {
            newDiv.innerHTML += "<input style='margin-left:15px;' type='radio' name='spec_" + message[spec]['attr_id'] + "' value='" + message[spec]['values'][val_arr]['id'] + "' id='spec_value_" + message[spec]['values'][val_arr]['id'] + "' /><font color=#555555>" + message[spec]['values'][val_arr]['label'] + '</font> [' + message[spec]['values'][val_arr]['format_price'] + ']</font><br />';      
          }
        } 
        newDiv.innerHTML += "<input type='hidden' name='spec_list' value='" + val_arr + "' />";
      }
      else
      {
        for (var val_arr = 0; val_arr < message[spec]['values'].length; val_arr++)
        {
          newDiv.innerHTML += "<input style='margin-left:15px;' type='checkbox' name='spec_" + message[spec]['attr_id'] + "' value='" + message[spec]['values'][val_arr]['id'] + "' id='spec_value_" + message[spec]['values'][val_arr]['id'] + "' /><font color=#555555>" + message[spec]['values'][val_arr]['label'] + ' [' + message[spec]['values'][val_arr]['format_price'] + ']</font><br />';     
        }
        newDiv.innerHTML += "<input type='hidden' name='spec_list' value='" + val_arr + "' />";
      }
  }
  newDiv.innerHTML += "<br /><center>[<a href='javascript:submit_div(" + goods_id + "," + parent+ "," + lz_id + ")' class='f6' >" + btn_buy + "</a>]&nbsp;&nbsp;[<a href='javascript:cancel_div()' class='f6' >" + is_cancel + "</a>]</center>";
  document.body.appendChild(newDiv);


  // maskͼ��
  var newMask = document.createElement("div");
  newMask.id = m;
  newMask.style.position = "absolute";
  newMask.style.zIndex = "9999";
  newMask.style.width = document.body.scrollWidth + "px";
  newMask.style.height = document.body.scrollHeight + "px";
  newMask.style.top = "0px";
  newMask.style.left = "0px";
  newMask.style.background = "#FFF";
  newMask.style.filter = "alpha(opacity=30)";
  newMask.style.opacity = "0.40";
  document.body.appendChild(newMask);
} 

//��ȡѡ�����Ժ��ٴ��ύ�����ﳵ
function submit_div(goods_id, parentId,lz_id) 
{
  var goods        = new Object();
  var spec_arr     = new Array();
  var fittings_arr = new Array();
  var number       = 1;
  var input_arr      = document.getElementsByTagName('input'); 
  var quick		   = 1;

  var spec_arr = new Array();
  var j = 0;

  for (i = 0; i < input_arr.length; i ++ )
  {
    var prefix = input_arr[i].name.substr(0, 5);

    if (prefix == 'spec_' && (
      ((input_arr[i].type == 'radio' || input_arr[i].type == 'checkbox') && input_arr[i].checked)))
    {
      spec_arr[j] = input_arr[i].value;
      j++ ;
    }
  }

  goods.quick    = quick;
  goods.spec     = spec_arr;
  goods.goods_id = goods_id;
  goods.lzid     = lz_id;
  goods.number   = number;
  goods.parent   = (typeof(parentId) == "undefined") ? 0 : parseInt(parentId);
  goods.is_kezi  = is_kezi;

  Ajax.call('flow.php?step=add_to_cart', 'goods=' + obj2str(goods), addToCartResponse, 'POST', 'JSON');

  document.body.removeChild(docEle('speDiv'));
  document.body.removeChild(docEle('mask'));

  var i = 0;
  var sel_obj = document.getElementsByTagName('select');
  while (sel_obj[i])
  {
    sel_obj[i].style.visibility = "";
    i++;
  }

}

// �ر�mask����ͼ��
function cancel_div() 
{
  document.body.removeChild(docEle('speDiv'));
  document.body.removeChild(docEle('mask'));

  var i = 0;
  var sel_obj = document.getElementsByTagName('select');
  while (sel_obj[i])
  {
    sel_obj[i].style.visibility = "";
    i++;
  }
}
function get_zt(){
  var objs=document.getElementsByName("ztinput");
  var str="";
  for(var i=0;i<objs.length;i++){
    if(objs[i].checked){
	  str+=objs[i].value+",";
	}
  }
  str+="0"; 
  document.getElementById("hiddendiv").style.display="block";
  Ajax.call('getzt.php?cats='+str+'&'+Math.random(), '', get_ztResponse, 'GET', 'JSON');
}

function get_ztResponse(result){ 
   document.getElementById("hiddendiv").style.display="none"
   document.getElementById("dz_zt_list").innerHTML=result.message; 
   document.getElementById("reslut_zt").innerText=result.allsum;
    $(".carouse2").jCarouselLite({
                btnNext: ".next2",
                btnPrev: ".prev2", 
                visible: 4,
				scroll:4
            });
}

function getZtGoodsInfo(id){
  document.getElementById("dr_goods_right").innerHTML="���ڶ�ȡ��Ϣ...";
  Ajax.call('getztgoods.php?id='+id+'&'+Math.random(), '', getZtGoodsInfoResponse, 'GET', 'JSON');

}
function getZtGoodsInfoResponse(result){
   
   document.getElementById("dr_goods_right").innerHTML=result.message;
   if(document.getElementById("zt_id"))
     document.getElementById("zt_id").value=result.id; 
   if(document.getElementById("zjjg"))
     document.getElementById("zjjg").innerText=(new Number(document.getElementById("lzjg").innerText))+(new Number(result.shop_price))
}
function chosedia(){
  var ztid=document.getElementById("zt_id").value;
  if(ztid==""){
    alert("����û��ѡ������Ŷ������ѡ������");
  }else{
	var weight = document.getElementById("wws_weight").value;
	var shape = document.getElementById("wws_shape").value;
	  
   window.open("/luozuan/index.php?ztid="+ztid+"&wws_weight="+weight+"&wws_shape="+shape);
  }

}
function luozuan_dingzhi(){
  var lz_id=document.getElementById("lz_id").value;
  var zt_id=document.getElementById("zt_id").value; 
  if(lz_id==""){
    alert("��û��ѡ������");
  }else if(zt_id==""){
    alert("��û��ѡ������");
  }else{
    if(confirm("��ȷ��Ҫ���ƴ������ô��")){
	  document.getElementById("dingzhi_img").innerHTML+="<img src='/luozuan/images/carting.gif'>&nbsp;����Ϊ������,���Ժ�..."
	  add_dingzhi_tocart_first(lz_id);
	}
  }
}

function add_dingzhi_tocart_first(refno){
 
 Ajax.call('/luozuan/buydia_1.php?refno='+refno, '', add_dingzhi_tocart_firstResponse, 'POST', 'JSON');
 

}

 
function add_dingzhi_tocart_firstResponse(result){

  if(result.error==1){
    
	alert(result.message);
	 
  }else{
   
    add_dingzhi_tocart(result.goods_id);

  }

}


function add_dingzhi_tocart(goodsId)
{
 
  var goods        = new Object();
  var spec_arr     = new Array();
  var fittings_arr = new Array();
  var number       = 1;
  var formBuy      = document.forms['ECS_FORMBUY'];
  var quick		   = 0;
  var sp_attr="";
  sp_attr+="���أ�"+document.getElementById("lz_weight").value;
  sp_attr+="<br/>֤�飺"+document.getElementById("lz_lab").value;
  sp_attr+="<br/>֤���ţ�"+document.getElementById("lz_labnumber").value;
  sp_attr+="<br/>�й���"+document.getElementById("lz_cut").value;;
  sp_attr+="<br/>���ȣ�"+document.getElementById("lz_clarity").value;;  
  // ����Ƿ�����Ʒ��� 
  if (formBuy)
  {
	  
    spec_arr = getSelectedAttributes(formBuy);

    if (formBuy.elements['number'])
    {
      number = formBuy.elements['number'].value;
    }

	quick = 1;
  }

  goods.quick    = quick;
  goods.spec     = spec_arr; 
  goods.goods_id = goodsId;
  goods.number   = number;
  goods.sp_attr  = sp_attr;
  goods.parent   = (typeof(parentId) == "undefined") ? 0 : parseInt(parentId);
  
  Ajax.call('/flow.php?step=add_to_cart', 'goods=' + $.toJSON(goods), add_dingzhi_tocartResponse, 'POST', 'JSON');
}
 
function add_dingzhi_tocartResponse(result)
{
  if (result.error > 0)
  {
    // �����Ҫȱ���Ǽǣ���ת
    if (result.error == 2)
    {
      if (confirm(result.message))
      {
        location.href = '/user.php?act=add_booking&id=' + result.goods_id;
      }
    }
    // ûѡ��񣬵�������ѡ���
    else if (result.error == 6)
    {
      openSpeDiv(result.message, result.goods_id, result.parent, result.lz_id);
    }
    else
    {
      alert(result.message);
    }
  }
  else
  {
    var cartInfo = document.getElementById('ECS_CARTINFO');
    var cart_url = '/flow.php?step=cart';
    if (cartInfo)
    {
      cartInfo.innerHTML = result.content;
    }

    if (result.one_step_buy == '1')
    {
      location.href = cart_url;
    }
    else
    {
      switch(result.confirm_type)
      {
        case '1' :
          if (confirm(result.message)) location.href = cart_url;
          break;
        case '2' :
          if (!confirm(result.message)) location.href = cart_url;
          break;
        case '3' :
          var zt_id=document.getElementById("zt_id").value;
		   
		  addToCart(zt_id,0);
          break;
        default :
          break;
      }
    }
  }
}


function luozuan_dingzhi2(){
  var lz_id=document.getElementById("lz_id").value;
  var zt_id=document.getElementById("zt_id").value;
  if(lz_id==""){
    alert("��û��ѡ������");
  }else if(zt_id==""){
    alert("��û��ѡ������");
  }else{
    if(confirm("��ȷ��Ҫ���ƴ������ô��")){
	  document.getElementById("dingzhi_img").innerHTML+="<img src='/luozuan/images/carting.gif'>&nbsp;����Ϊ������,���Ժ�..."
	  add_dingzhi_tocart(lz_id);
	}
  }
}

function ImgAuto(ImgD,FitWidth,FitHeight){ 
		 
	    var image=new Image();
     image.src=ImgD.src;
     if(image.width>0 && image.height>0){
         if(image.width/image.height>= FitWidth/FitHeight){
             if(image.width>FitWidth){
                 ImgD.width=FitWidth;
                 ImgD.height=(image.height*FitWidth)/image.width;
             }else{
                 ImgD.width=image.width; 
                ImgD.height=image.height;
             }
         } else{
             if(image.height>FitHeight){
                 ImgD.height=FitHeight;
                 ImgD.width=(image.width*FitHeight)/image.height;
             }else{
                 ImgD.width=image.width; 
                ImgD.height=image.height;
             } 
        }
     } 

} 