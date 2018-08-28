
$(document).ready(function() {
	$('#radio_normal').attr('checked','checked');
	$('.login-item div').click(function() {
		$(this).addClass('cur').siblings().removeClass('cur');
		
		if ($(this).find('input').val()==1) {
			$('#send_login_verify').hide();
			$('#login_type').val('normal');
			$('#user').attr('placeholder','请输入手机号/邮箱/用户名');
			$('#pass').attr('placeholder','请输入密码');
		}else{
			$('#send_login_verify').show();
			$('#login_type').val('email');
			$('#user').attr('placeholder','请输入邮箱');
			$('#pass').attr('placeholder','请输入验证码');
		}
	})

	$('#send_login_verify').click(function(){
		var mobile=$('#user').val();
		if(!(/^1[34578]\d{9}$/.test(mobile))){ 
			alert("�ֻ��������������");  
			return false; 
		} 
		$.post('/sms/',{"flag":1,"mobile":mobile},function(res){
				alert(res.msg);
			},'json');
	});
	return false;
});
