$(function(){
	
	$("ul.menu li").mouseover(function(){
		$(this).addClass("over");							   
		if(!$(this).find("div").is(":animated")){								  
			$(this).find("div").slideDown(500);		
		}
	});		
	$("ul.menu li").bind("mouseleave", function(){
		$(this).removeClass("over");										
      	$(this).find("div").slideUp(500);
  	});  
	$("ul.menu li div").find(".menu_i").each(function(){
		if($(this).parent().height()>140){
		$(this).height($(this).parent().height()-20);}else{
			$(this).height(120);
		}
	});

	
	$("span.tb_shop").mouseover(function(){		
		if(!$(".tb_shop_box").is(":animated")){								  
			$(".tb_shop_box").slideDown(500);		
		}
	});		
	$("span.tb_shop").bind("mouseleave", function() {  										   
      		$(".tb_shop_box").slideUp(500);
  	});
	
	$(".cart_box").mouseover(function(){
		$(".cart_show").css("display","block");							  
	});
	$(".cart_box").mouseout(function(){
		$(".cart_show").css("display","none");							  
	});
	
	$(".float_mix").click(function(){								  
		float_id = 'float_s';
		$("#float").css("display","none");	
		$("#float_s").css("display","block");
	});
	$(".float_max").click(function(){
		float_id = 'float';
		$("#float").css("display","block");	
		$("#float_s").css("display","none");
	})
	//$(".history a.up").click(function(){
	//	var nowtop =$(".history_c ul").css("top").replace("px", "");		
	//	var thisheight = $(".history_c li").size()*53;
		// 允许向上的条件
	//	if (nowtop <= (thisheight-3*53) * -1) return;
	//	$(".history_c ul").css("top",(nowtop-53)+"px");
	//})
	
	//$(".history a.down").click(function(){
	//	var nowtop =$(".history_c ul").css("top").replace("px", "");
		// 允许向下的条件
	//	if (nowtop >= 0) return;
	//	$(".history_c ul").css("top",(Number(nowtop)+53)+"px")
	//})

	//   -------------------------------------------------

	
	//   主页	
	$(".foot_oc a").toggle(function(){
		$(this).addClass("un");								
		$(".foot_box").	slideUp(500);					
	},function(){
		$(this).removeClass("un");	
		$(".foot_box").	slideDown(500);					
	});
	
	$(".media_b").each(function(){
		var dl_tab = this;	
		$('dt', dl_tab).mouseover(function(){
			$('dt', dl_tab).removeClass("un");	
			$(this).addClass("un");
			$('dd', dl_tab).css("display","none");
			$(this).next().css("display","block");
		})
	});
	
	$(".f_link").mouseover(function(){
		$(this).css("height","auto")									  
	})
	$(".f_link").mouseout(function(){
		$(this).css("height","19px")									  
	});
	//裸钻搜索
	$(".da_b").mouseover(function(){		
		if(!$(".diamond_ct_b").is(":animated")){								  
			$(".diamond_ct_b").slideDown(500);		
		}
	});		
	$(".da_b").bind("mouseleave", function() {  										   
      		$(".diamond_ct_b").slideUp(500);
  	});
	
	$(".da_o").mouseover(function(){		
		if(!$(".diamond_ct_o").is(":animated")){								  
			$(".diamond_ct_o").slideDown(500);		
		}
	});		
	$(".da_o").bind("mouseleave", function() {  										   
      		$(".diamond_ct_o").slideUp(500);
  	});
	
	
	$(".top .tab_con div").mouseover(function(){
		$(this).css("z-index","2");										  
	}).mouseout(function(){
		$(this).css("z-index","1");
	});	
	
	$(".diamond_g").click(function(){
		var s_carat=$("#diamond_min").text();
		var e_carat=$("#diamond_max").text();
		s_carat	=	s_carat.substr(0,3);
		e_carat	=	e_carat.substr(0,3);
		window.open('/diamond.php?s_carat='+s_carat+'&e_carat='+e_carat);			  
	});

	$(".diamond_ct_b li").click(function(){
		$("#diamond_min").text($(this).text());
		if(!checkdiamond($(this).text(),$("#diamond_max").text())){
			$("#diamond_max").text($(this).text());
		}
		$(this).parent("ul").css("display","none");					  
	});
	$(".diamond_ct_o li").click(function(){
		$("#diamond_max").text($(this).text());
		if(!checkdiamond($("#diamond_min").text(),$(this).text())){
			$("#diamond_min").text($(this).text());
		}
		$(this).parent("ul").css("display","none");					  
	});
	
	var checkdiamond = function(min, max){
		if(parseInt(min) > parseInt(max)){
			return false;
		}
		return true;
	};
	// flash
	$(".flash_num a").mouseover(function(){
		if($(this).attr("class").indexOf('un') != -1){
			return;
		}
		$(".flash_num a").removeClass("un");							 
		$(this).addClass("un");		
		var index = $(".flash_num a").index($(this));
		$(".flash_pic li").fadeOut(300); 
		$(".flash_pic li").eq(index).fadeIn(300); 
	})
	setInterval(function(){
		for(var i=0;i<$(".flash_num a").length;i++){
			if($(".flash_num a").eq(i).attr("class").indexOf('un') != -1){
				if(i == ($(".flash_num a").length - 1)){
				 	var ii=0;
				}else{
					var ii=i+1;
				}
				$(".flash_num a").removeClass("un");
				$(".flash_num a").eq(ii).addClass("un");
				$(".flash_pic li").fadeOut(300);
				$(".flash_pic li").eq(ii).fadeIn(300);
				break;
			}
		}
	},5000);
	
	//   -------------
	var tabk = new Array();
	var tabfun = function(i,n,hd){
						//var index = $('.tab_nav b', hd).index($(this));	
						n = n<0 ? tabk[i]['focus'] : n;
						$('.tab_nav b', hd).removeClass("un");
						$('.tab_nav b', hd).eq(n).addClass("un");			
						$('.tab_con', hd).css("display","none");
						$('.tab_con', hd).eq(n).css("display","block");
						tabk[i]['focus'] = n==tabk[i]['len'] ? 0 : n+1;
					 }
	$(".tabs").each(function(i){
		var hd = this;
		var autop = $(this).hasClass("autoplay");
		tabk[i] = new Array();
		tabk[i]['focus'] = 0;
		$('.tab_nav b', hd).each(function(j){
			tabk[i]['len'] = j;
			$(this).mouseover(function(){
				tabfun(i,j,hd);
				clearInterval(tabk[i]['timef']);
				if($(this).attr("id") == "ms_over"){
					$("#pinglun").css("display","block");
					$("#pinglun").css("margin-top","10px");
				};
				if($(this).attr("id") == "pl_over"){
					$("#pinglun").css("margin-top","0");
				};
				//alert($(this).attr("id"));
				//$("#pl_over").mouseover(function(){
					//$("#pinglun").css("display","block");
				//});
			}).mouseout(function(){
				if(autop==1) tabk[i]['timef'] = setInterval(function(){tabfun(i,-1,hd)},2500);
			});
		});
		if(autop==1) tabk[i]['timef'] = setInterval(function(){tabfun(i,-1,hd)},2500);	
	});	
	

	//   -------------
	$(".border_hover").mouseover(function(){
		$(this).css("border-color","#7d4c00")								  
    }).mouseout(function(){
		$(this).css("border-color","#dfdfdf")								  
    })	
	
	//   -------------------------------------------------
	
	//   列表页
	//$(".new_o_box").mouseover(function(){	
//		$(this).css({'border-color':'#e5d6bf','background':'#fff','z-index':'888'});
//		$('a.pic',this).css("border-color","#e5d6bf")
//    }).mouseout(function(){
//		$(this).css({'border-color':'#ecebe6','background':'none','z-index':'887'});
//		$('a.pic',this).css("border-color","#ecebe6")
//    })	
//	$(".new_o_b").mouseover(function(){			
//		$(this).css("width","605px")
//    }).mouseout(function(){	
//		$(this).css("width","302px")
//    })	
//	$(".new_o_s").mouseover(function(){			
//		$(this).css("width","295px")
//    }).mouseout(function(){	
//		$(this).css("width","147px")
//    })	
//	$(".new_o_5").mouseover(function(){			
//		$(this).css("left","635px")
//    }).mouseout(function(){	
//		$(this).css("left","783px")
//    })	
//	$(".new_o_12").mouseover(function(){			
//		$(this).css("left","325px")
//    }).mouseout(function(){	
//		$(this).css("left","628px")
//    })	

//	$("ul.product li").mouseover(function(){
//		$(this).css("border-color","#E0D3C7");							  
//	});
//	$("ul.product li").mouseout(function(){
//		$(this).css("border-color","#fff");							  
//	});

	
	
	//   -------------------------------------------------
	
	//   单页
	$(".goods_pic_s a.up").click(function(){
		var nowtop =$(".goods_pic_slist .tab_nav").css("top").replace("px", "");
		var thisheight = $(".goods_pic_slist .tab_nav b").size()*83;
		// 允许向上的条件
		if (nowtop <= (thisheight-4*83) * -1) return;
		$(".goods_pic_slist .tab_nav").css("top",(nowtop-83)+"px")
	})
	$(".goods_pic_s a.down").click(function(){
		var nowtop =$(".goods_pic_slist .tab_nav").css("top").replace("px", "");
		// 允许向下的条件
		if (nowtop >= 0) return;
		$(".goods_pic_slist .tab_nav").css("top",(Number(nowtop)+83)+"px")
	})
	
	$(".stage_open").click(function(){
		$(".stage").css("display","block");	
		$(".base_con select").css("display","none");	
	})
	$(".stage_close").click(function(){
		$(".stage").css("display","none");	
		$(".base_con select").css("display","");
	})
	
	
	$(".hand").click(function(){
		$(".hand_inch").css("display","block");		
	})
	$(".hand_close").click(function(){
		$(".hand_inch").css("display","none");		
	})
	
	$(".membership").click(function(){
		$(".buy_membership").css("display","block");		
	})
	$(".membership_close").click(function(){
		$(".buy_membership").css("display","none");		
	})
	
	$(".description_info").each(function(){
		var p_tab = this;	
		$('.description_p', p_tab).click(function(){
			$('.description_p', p_tab).removeClass("un");	
			$(this).addClass("un");
			$('div', p_tab).css("display","none");
			$(this).next().css("display","block");
		})
	})	
	//$("a.goods_sina").mouseover(function(){
//		$("span.goods_sina_tip").css("display","block");							 
//	});
//	$("a.goods_sina").mouseout(function(){
//		$("span.goods_sina_tip").css("display","none");							 
//	});
	
	$("a.write").click(function(){
		$("#comment").slideDown(500);						 
	});	
	
	//   -------------------------------------------------
	
	//   购物车
	$(".cart_letter").each(function(){
		var cart = this;	
		$('.cart_letter_o', cart).click(function(){
			$(this).css("z-index","100");								 
			$('.cart_k', cart).css("display","block");			
		})
		$('.cart_letter_c', cart).click(function(){
			$('.cart_k', cart).css("display","none");			
		})
	});
	
	//   -------------
	$("#tool").each(function(){
		var body_w = document.body.scrollWidth;
		var tool_left = (body_w - 950) / 2 ;
		$("#tool").css("left",tool_left);
		var hd = this;
		$('.tool_menu b', hd).click(function(){	
			if ($("#tool .tool_box").css("height") == "auto")
			{
				tool_o();				
			}else{
				if($(".tool_nav a.tool_o").attr("id") != 'tool_o_cate'){//单页
					tool_s();
				}	
			}
  		    $('.tool_menu b', hd).removeClass("un");
			$(this).addClass("un");			
			$('.tab_con', hd).css("display","none");
			var index = $('.tool_menu b', hd).index($(this));
			$('.tab_con', hd).eq(index).css("display","block");
		});		
	});	
			
	function tool_s(){
		$(".tool_nav a.tool_s").css("display","none");
		$(".tool_nav a.tool_o").css("display","block");
		$("#tool .tool_box").slideUp();		
	}
	function tool_o(){
		if($(".tool_nav a.tool_o").attr("id") == 'tool_o_cate'){
			var vals=$("#bbs_ary_val").val();
			ajax_tools('category_bbs',vals,1);
		}		
		$(".tool_nav a.tool_o").css("display","none");
		$(".tool_nav a.tool_s").css("display","block");
		$("#tool .tool_box").slideDown();		
	}
	
	$(".tool_nav a.tool_s").click(function(){
		tool_s();								   
	});
	$(".tool_nav a.tool_o").click(function(){
		tool_o();
	});	
	
	$(".tool_nav a.tool_c").click(function(){
		$("#tool").css("display","none");								   
	});
	
	//   -------------
	
})	;

	
//   购物车弹出
var body_s;
function cart_o(){
	var body_w = document.body.clientWidth; 
	var body_h = document.documentElement.clientHeight;                                                                            

	var iHightEx = parseInt((body_h-430)/2);
	var iWidthEx = parseInt((body_w-760)/2) + parseInt(document.body.scrollLeft);

	$(".wrap").css("display","none");
	$("body").css("height","100%");
	$(".cart_tan_bg").css("display","block");
	$(".cart_tan").css("display","block");
	$(".cart_tan").css("left",iWidthEx + "px");
	$(".cart_tan").css("top",iHightEx + "px");
}
function cart_c(){	
	$(".wrap").css("display","block");	
	$(".cart_tan_bg").css("display","none");
	$(".cart_tan").css("display","none");
	$(window).scrollTop(body_s);
}


////   浮动的函数
//function set_div_display(id, type){	
//	document.getElementById(id).style.display = type;	
//}
