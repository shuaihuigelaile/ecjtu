function kf_popupShow()
{
	$('.popup_float_div').fadeIn();
}

function kf_popupHide()
{
	$('.popup_float_div').fadeOut();
	window.setTimeout("kf_popupShow()",1000*120);
}
	



$(function(){
/*
	var nowUrl=window.location.href;
	if(nowUrl.indexOf('allring')>1){
		$('.menu li:eq(1)').addClass('on');
	}else if(nowUrl.indexOf('freeservice')>1){
		$('.menu li:eq(2)').addClass('on');
	}else if(nowUrl.indexOf('lovenus.html')>1){
		$('.menu li:eq(3)').addClass('on');
	}else if(nowUrl.indexOf('culture')>1){
		$('.menu li:eq(4)').addClass('on');
	}else{
		$('.menu li:eq(0)').addClass('on');
	}
	
	var qcloud={};
	$('[_t_nav]').hover(function(){
		var _nav = $(this).attr('_t_nav');
		clearTimeout( qcloud[ _nav + '_timer' ] );
		qcloud[ _nav + '_timer' ] = setTimeout(function(){
		$('[_t_nav]').each(function(){
		$(this)[ _nav == $(this).attr('_t_nav') ? 'addClass':'removeClass' ]('nav-up-selected');
		});
		$('#'+_nav).stop(true,true).slideDown(200);
		}, 150);
	},function(){
		var _nav = $(this).attr('_t_nav');
		clearTimeout( qcloud[ _nav + '_timer' ] );
		qcloud[ _nav + '_timer' ] = setTimeout(function(){
		$('[_t_nav]').removeClass('nav-up-selected');
		$('#'+_nav).stop(true,true).slideUp(200);
		}, 150);
	});

	$(".snav_ads a img").mouseenter(function(){
			$(this).fadeTo(100, 0.7,function(){
				$(this).fadeTo(100, 1);
			});
		});
	//下拉菜单
	
	$("ul.top_menu>li:eq(0)").hover(function(){
		$(this).addClass("over");					   
		if(!$(this).find("div").is(":animated")){								  
			$(this).find("div").slideDown(500);		
		}
	},function(){
		$(this).removeClass("over");										
      	$(this).find("div").slideUp(500);
	});	
	
	$("ul.top_menu>li:eq(1)").hover(function(){							  
		$(this).find("div").show();		
	
	},function(){										
      	$(this).find("div").hide();
	});	
	*/

	$("#addFavorite").click(function() {
	  var ctrl = (navigator.userAgent.toLowerCase()).indexOf('mac') != -1 ? 'Command/Cmd': 'CTRL';
	  if (document.all) {
		  window.external.addFavorite('https://www.lovenus.cn', '乐维斯有限公司')
	  } else if (window.sidebar) {
		  window.sidebar.addPanel('乐维斯有限公司', 'https://www.lovenus.cn', "")
	  } else {
		  alert('您可以尝试通过快捷键' + ctrl + ' + D 加入到收藏夹~')
	  }
	  return false; 
   })
   
   	$(".my_cart").mouseover(function(){
	$.ajax({
			url: "/services.php?act=getCartInfo",
			cache: false,
			dataType:"json",
			success: function(result){
				$(".cart_show").html(result.html);
				$("#headCartCount").html(result.count+'');
				$(".cart_show").show();
			}
		});
			
	});
	
	$(".header_cart_box").hover(function(){
		$(".cart_show").show();							  
	},function(){
		$(".cart_show").hide();							  
	});
    $('.to_top').css({'left':$(window).width()/2+500});
	$(window).scroll(function(){
		if($(this).scrollTop()>200){
		$('#toTop').fadeIn();
		}else{
		$('#toTop').fadeOut();
		} 
	});

	$('#toTop').focus(function(){this.blur();}).click(function(){  //back to top
		$('body,html').animate({scrollTop:0},800);
		return false;
	});
	
	$('.hide_kefu').click(function(){
	 $('.float_div').hide();
	 $('.zxzx').show();
	});
  $('.zxzx').click(function(){
	 $('.float_div').show();
	 $('.zxzx').hide();
	});
		
		
	window.setTimeout("kf_popupShow()",12000);
	$('.hide_popup_kefu,.later_call_kefu').click(function(){
	 kf_popupHide();
	});
	$('#erweima').hover(function(){
	 $('.zxerma').show();
	},function(){
	  $('.zxerma').hide();
	});

	$('#J_gotop').click(function () {
		$('html,body').animate({ scrollTop: 0 }, 500);
	});
	$(document).scroll(function(){
		//console.log($(document).scrollTop());
	   if($(document).scrollTop()>660){
			$('.float_div').show();
	   }else{
		   $('.float_div').hide();
	   }
	});
	
	
});


