// Download by http://www.jb51.net
var suningImages = function(){
	var box = $('#styleImg');
	var image = $('#imgMove_face');
	var btn = image.find('li');
	var len = btn.length ;
	var ul = image.find('ul');
	
	return{
		init:function(){
			var that = this ;
			var posx ;
			var posy ;
			var i = 0 ;
			ul.css('width',len*100);
			$('#proPicPrevBtn').click(function(e){
				//alert(image.prev);
				if(i<=0){
					//alert('到头了');
					return false;
				}
				i--;
				that.scroll(i);
				e.preventDefault();
			})
			
			$('#proPicNextBtn').click(function(e){
				if( len<=4 || i>=len-4){
					//alert('到尾了');
					return false;
				}
				i++;	
				that.scroll(i);
				e.preventDefault();
			})
			
			
			btn.each(function(i){
				$(this).find('a').click(function(e){
					index = i ;							 
					that.addbk(i);
					that.loadimg(i);
					e.preventDefault();
				})
			})
			
			/*
			var index = 0 ;
			box.click(function(e){
				var e = e || window.event ;
				//判断鼠标位置，鼠标位置大于图片1/2处加
				if(posx>document.documentElement.clientWidth/2){
					index++;
					if(index>=len)
					{
						index=0;
						ul.stop().animate({marginLeft: 0 },300);
					}
					that.next(index);
				}else{
					index--;
					if(index<0){
						index=len-1;
						ul.stop().animate({marginLeft: -86*parseInt(index/7)*7 },300);
					};
					that.prev(index);
				}	
				e.preventDefault();
			}).mousemove(function(e){
				var e = e || window.event ;
				posx = e.clientX ;
				alert(posx);
				alert(document.documentElement.clientWidth/2);
				if(posx>document.documentElement.clientWidth/2){
					box.css('cursor','url(http://img.baidu.com/img/image/mousedown.cur),pointer');
					box.attr('title','下一页');
				}else{
					box.css('cursor','url(http://img.baidu.com/img/image/mousedown.cur),pointer');
					box.attr('title','上一页');
				}
			});
			*/
			$(document).keyup(function(e){
				var e = e || window.event ;
				if(e.which == 39){
					index++;
					if(index>=len){
						index=0;
						ul.stop().animate({marginLeft: 0 },300);
					}
					that.next(index);
					
				}else if(e.which== 37 ){
					index--;
					if(index<0){
						index=len-1;
						ul.stop().animate({marginLeft: -86*parseInt(index/7)*7 },300);
					};
					that.prev(index);
				}
			});
			
			
		},
		loadimg:function(i){
			var src = btn.eq(i).find('img').attr('src');
			box.attr('src',src).hide().fadeIn(250);
		},
		addbk:function(i){
			btn.eq(i).find('img').addClass('on').parents('li').siblings().find('img').removeClass('on');
			if($('.close_video').length) $('.close_video').click();
		},
		scroll:function(i){
			ul.stop().animate({marginLeft: -92*i },300);
			
		},
		next:function(index){
			var that = this ;
			if(((index)%7)==0){
				ul.stop().animate({marginLeft: -86*(index) },300);
			}
			that.addbk(index);
			setTimeout(function(){that.loadimg(index);},400);
		},
		prev:function(index){
			var that = this ;
			if((index+1)%7==0){
				ul.stop().animate({marginLeft: -86*parseInt(index/7)*7 },300);
			}
			that.addbk(index);
			setTimeout(function(){that.loadimg(index);},400);
		}
	}
}
$(document).ready(function(){
	suningImages().init();
	$('.close_video').click(function(){
		$('.goods_video').hide();
		$('.play_video').show();
		$(this).hide();
		//var zsvideo = $("#zsvideo")[0];  
		//zsvideo.pause();
	});
	$('.play_video').click(function(){
		$('.goods_video').show();
		$('.close_video').show();
		$(this).hide();
		var zsvideo = $("#zsvideo")[0];  
		zsvideo.play();
	});
})
