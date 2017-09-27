<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<script type="text/javascript">
	/*通过审批*/
	$(function(){
		$("#passbutton").live("click",function(){
			var empid = $(this).next(".empid").val();
			$.ajax({
				   type: "POST",
				   url: "ApproveaccountServlet",
				   data: {"empid":empid},
				   dataType:"json",
				   success: function(data){
					 var inhtml = "<caption>所有待审批注册信息：</caption><tr class='listheader'><th>姓名</th><th>账号名</th><th>联系电话</th><th>电子邮件</th><th>操作</th></tr>";
					 $.each(data,function(index,item){
						inhtml += "<tr><td>"+item.employeename+"</td><td>${item.username }</td><td>"+item.phone+"</td><td>"+item.email+"</td><td><input type='button' class='clickbutton' id='passbutton' value='通过'/> <input type='hidden' class='empid' value='"+item.employeeid+"' /><input type='button' class='clickbutton' id='deletebutton' value='删除'/><input type='hidden' class='empid' value='"+item.employeeid+"' /></td></tr>";
						 
					 });
					 $(".listtable").html(inhtml);
				   },
				   error:function(jqXHR, textStatus, errorThrown){
					   alert(jqXHR.responseText);
				   }
				});
		});
		
	});
	
	/*删除员工注册信息*/
	$(function(){
		$("#deletebutton").live("click",function(){
			var empid = $(this).next(".empid").val();
			$.ajax({
				   type: "POST",
				   url: "DeleteEmployeeServlet",
				   data: {"empid":empid},
				   dataType:"json",
				   success: function(data){
					 var inhtml = "<caption>所有待审批注册信息：</caption><tr class='listheader'><th>姓名</th><th>账号名</th><th>联系电话</th><th>电子邮件</th><th>操作</th></tr>";
					 $.each(data,function(index,item){
						inhtml += "<tr><td>"+item.employeename+"</td><td>${item.username }</td><td>"+item.phone+"</td><td>"+item.email+"</td><td><input type='hidden' class='empid' value='"+item.employeeid+"' /><input type='button' class='clickbutton' id='passbutton' value='通过'/>  <input type='hidden' class='empid' value='"+item.employeeid+"' /><input type='button' class='clickbutton' id='deletebutton' value='删除'/>  <input type='hidden' class='empid' value='"+item.employeeid+"' /></td></tr>";
						 
					 });
					 $(".listtable").html(inhtml);
				   },
				   error:function(jqXHR, textStatus, errorThrown){
					   alert(jqXHR.responseText);
				   }
				});
		});
	});
	
	
</script>
 <body>
        <%@ include file="/jsp/comment/pageHeader.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    人员管理 > 注册审批
                </div>
                <table class="listtable">
                    <caption>所有待审批注册信息：</caption>
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="emp" items="${emplist }">
                    	<tr>
                        <td>${emp.employeename }</td>
                        <td>${emp.username }</td>
                        <td>${emp.phone }</td>
                        <td>${emp.email }</td>
                        <td>
                        	
                            <input type="button" class="clickbutton" id="passbutton" value="通过"/>
                            <input type="hidden" class="empid" value="${emp.employeeid }" />
                            <input type="button" class="clickbutton" id="deletebutton" value="删除"/>
                            <input type="hidden" class="empid" value="${emp.employeeid }" />
                        </td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
  
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>
