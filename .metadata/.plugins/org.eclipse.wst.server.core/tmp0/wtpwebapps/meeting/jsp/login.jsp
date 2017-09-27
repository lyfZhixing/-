<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
    </head>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" >
$(function(){
	$("#loginbutton").click(function(){
		var uname = $("#accountname").val();
		var upwd = $("#new").val();
		$.ajax({
			   type: "POST",
			   url: "LoginServlet",
			   data: {"uname":uname,"upwd":upwd},
			   dataType: "json",
			   success: function(data){
				   location.href="<%=basePath%>"+data;
			   }
			});
	});
});

</script>
    <body>
    <%@ include file="/jsp/comment/pageHeader.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    登录
                </div>
                    <fieldset>
                        <legend>登录信息</legend>
                        <table class="formtable" style="width:50%">
                            <tr>
                                <td>账号名:</td>
                                <td>
                                    <input id="accountname" type="text" />
                                </td>
                            </tr>
                            <tr>
                                <td>密码:</td>
                                <td>
                                    <input id="new" type="password" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                    <input type="button" value="登录" id="loginbutton" class="clickbutton" />
                                    <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/><span id="msg">${msg }</span>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
            </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>