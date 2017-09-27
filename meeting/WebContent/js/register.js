/**
 * 注册
 */
function inputpwd(){
	/*$("#password").blur(function(){*/
		var password = $("#password").val();
		reg = /^\w{6,20}$/;
		var flag = true;
		if(!reg.test(password)){
			$("#pwdmsg").css("color","red");
			$("#pwdmsg").html("×");
		/*	$("#register").attr("disabled", true);*/
			flag = false;
		}else{
			$("#pwdmsg").css("color","green");
			$("#pwdmsg").html("√");
		}
		return flag;
	/*});*/
}

function inputcfm(){
/*	 $("#confirm").blur(function(){*/
		/* inputpwd();*/
		var password = $("#password").val();
		var confirm = $("#confirm").val();
		
		if(password == confirm && confirm != ""){
			$("#cfmmsg").css("color","green");
			$("#cfmmsg").html("√");
			return true;
		}else{
			$("#cfmmsg").css("color","red");
			$("#cfmmsg").html("×");
		/*	$("#register").attr("disabled", true);*/
			return false;
		}
/*	 });*/
}
	$(function(){
		var flag1 = false;
		var flag2 = false;
		var flag3 = false;
		var flag4 = false;
		var flag5 = false;
		 $("#password").blur(function(){
			 flag1 =inputpwd();
		 });
		 $("#confirm").blur(function(){
			 flag2 = inputcfm();
		 });
		 $("#accountname").blur(function(){	
			 flag3 = checkuname();
		});
		
		 $("#email").blur(function(){	
			 flag4 = checkEmail();
		});
		 $("#phone").blur(function(){	
			 flag5 = checknum();
		});
		 
		$("#register").click(function(){
			/*alert("1"+flag1);
			alert("2"+flag2);
			alert("3"+flag3);
			alert("4"+flag4);
			alert("5"+flag5);*/
			var employeename = $("#employeename").val();
			var accountname = $("#accountname").val();
			var password = $("#password").val();
			var confirm = $("#confirm").val();
			var phone = $("#phone").val();
			var email = $("#email").val();
			
			var deptid = $("#deptid").val();
			if(employeename != "" && accountname != ""
					&& password != "" && confirm != ""
					&& phone != "" && email != "" && deptid != ""
					&& flag1==true && flag2==true 
					 && flag4==true && flag5==true){
				$.ajax({
					   type: "POST",
					   url: "RegisterServlet",
					   data: {"employeename":employeename,"accountname":accountname,"password":password,"confirm":confirm,"phone":phone,"email":email,"deptid":deptid},
					   dataType:"json",
					   success: function(msg){
						 alert(msg);
					     //清空提示信息
						 $(":text,:password").val("");
					     $("#pwdmsg").html("");
					     $("#usermmsg").html("");
					 	$("#cfmmsg").html("");
					   }
					});
			}else{
				alert("请完善并正确填写信息");
			}
			
		
		});
	});

/**
 * 验证账户名
 */
		function checkuname(){
			var username = $("#accountname").val();
			$.ajax({
				 type: "POST",
				   url: "CheckUserNameServlet",
				   data: {"username":username},
				   dataType:"json",
				   success: function(msg){
					   if(msg == true ||  username == ""){
						   $("#usermmsg").css("color","red");
						   $("#usermmsg").html("该用户名不可用");
						   $("#register").attr("disabled", true);
						   return false;
					   }else{
						   $("#usermmsg").css("color","green");
						   $("#usermmsg").html("该用户名可用");
						   $("#register").attr("disabled", false);
						   return true;
					   }
					
				   }
			});
		}
/**
 * 验证电话号
 */
		function checknum() {
			var reg = /^[0-9]{11}$/;
			var num = $("#phone").val();
			var result = reg.test(num);
			if(!result) {
				$("#phonemsg").html("电话号码不正确！");
				return false;
			}
			$("#emailmsg").html("");
			return true;
		}
/**
 * 验证邮箱
 */
		function checkEmail() {
			var reg = /^\w+@\w+\.\w+$/;
			var emali = $("#email").val();
			var result = reg.test(emali);
			if(!result) {
				$("#emailmsg").html("邮箱格式不正确！");
				return false;
			}
			$("#emailmsg").html("");
			return true;
		}

		