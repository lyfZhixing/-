/**
 * 修改密码
 */
$(function(){
	
	$("#origin").blur(function(){
		var empid = $("#empid").val();
		var opwd = $("#origin").val();
		var npwd = $("#new").val();
		var cfm = $("#confirm").val();
		$.ajax({
			type : "POST",
			url : "CheckPwdServlet",
			data : {"empid":empid,"opwd":opwd},
			dataType : "json",
			success : function(data) {
				
				if(data=="true"){
					$("#msg").css("color","green");
					$("#msg").html("原密码输入正确√");
					$("#new").removeAttr("readonly");
					$("#confirm").removeAttr("readonly");
				}else if(data=="false"){
					$("#msg").css("color","red");
					$("#msg").html("原密码输入错误x");
					$("#new").val("");
					$("#new").attr("readonly","readonly");
					$("#confirm").attr("readonly","readonly");
				}
			}
		});
	});
	
});
/*$(function(){
	$("#new").blur(function(){
		var newpwd = $("#newpwd").val();
		reg = /^\w{6,20}$/;
		if(!reg.test(newpwd)){
			$("#nmsg").css("color","red");
			$("#nmsg").html("密码由6-20位数字字母下划线组成×");
		}else{
			$("#nmsg").css("color","green");
			$("#nmsg").html("√");
		}
	});
});*/

/*$(function(){
	$("#confirm").blur(function(){
		var cfmpwd = $("#confirm").val();
		var newpwd = $("#newpwd").val();
		if(cfmpwd == newpwd){
			$("#cmsg").css("color","green");
			$("#cmsg").html("√");
		}else{
			$("#cmsg").css("color","red");
			$("#cmsg").html("两次输入的密码不一致×");
		}
	});
});
*/












