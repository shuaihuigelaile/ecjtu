// JavaScript Document

jQuery(function(){
	jQuery("#writeContent").click(function(){
		jQuery("#customPop").show();
	});

	jQuery("#love_mark").click(function(){
			jQuery("#writeInSwitcher").val(jQuery("#writeInSwitcher").val()+'&hearts;');
		
	});
	jQuery("#and_mark").click(function(){
		
		jQuery("#writeInSwitcher").val(jQuery("#writeInSwitcher").val()+'＆');
		
	});
	
	jQuery("#men_content").click(function(){
		jQuery("#is_men").val('men');
		jQuery("#customPop").css({'margin-left':'5px'}).show();
	});
	jQuery("#women_content").click(function(){
		jQuery("#is_men").val('women');
		jQuery("#customPop").css({'margin-left':'150px'}).show();
	});

});
function closeWriteWordsDiv(){
	var content = jQuery.trim(jQuery("#writeInSwitcher").val());
	var type = jQuery("#is_men").val();
	if(content){
		if(type == 'men'){
			jQuery("#men_content").html(content);
		}else if(type == 'women'){
			jQuery("#women_content").html(content);
		}else{
			jQuery("#writeContent").html(content);
			jQuery("#kezi").val(content);
		}
	}else{
		if(type == 'men'){
			jQuery("#men_content").html('无');
		}else if(type == 'women'){
			jQuery("#women_content").html('无');
		}else{
			jQuery("#writeContent").html('输入刻字内容 &gt;&gt;');
		}
	}
	//jQuery("#is_men").val('');
	jQuery("#customPop").hide();
}