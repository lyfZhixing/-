<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">    
 <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#showAndCancle").live("click",function(){
		var meetingid = $(this).next("#meetingid").val();
		location.href="MymeetingdetailServlet?meetingid="+meetingid;
		
	});
});
</script>
    <body>
         <%@ include file="/jsp/comment/pageHeader.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > 我的预定
                </div>
                <table class="listtable">
                    <caption>我预定的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="meeting" items="${meetinglist }">
	                    <tr>
	                        <td>${meeting.meetingname }</td>
	                        <td>${meeting.meetingroom.roomname }</td>
	                         <td><fmt:formatDate value="${meeting.starttime }" pattern="yyyy-MM-dd HH:mm"/> </td>
                       		 <td><fmt:formatDate value="${meeting.endtime }" pattern="yyyy-MM-dd HH:mm"/></td>
	                        <td><fmt:formatDate value="${meeting.reservationtime }" pattern="yyyy-MM-dd HH:mm"/></td>
	                        <td>
	                            <a class="clickbutton" id='showAndCancle'>查看/撤销</a>
	                            <input type="hidden" id="meetingid" value="${meeting.meetingid }" />
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
