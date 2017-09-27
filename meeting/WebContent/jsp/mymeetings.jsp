<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
        <%@ include file="/jsp/comment/pageHeader.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > 我的会议
                </div>
                <table class="listtable">
                    <caption>我将参加的会议：</caption>
                    <tr class="listheader">
                        <th>会议名称</th>
                        <th>会议室名称</th>
                        <th>会议开始时间</th>
                        <th>会议结束时间</th>
                        <th>会议预定时间</th>
                        <th>预定者</th>
                        <th>操作</th>
                    </tr>
                     <c:forEach var="meeting" items="${meetinglist }">
	                    <tr>
	                        <td>${meeting.meetingname }</td>
		                    <td>${meeting.meetingroom.roomname }</td>
		                    <td><fmt:formatDate value="${meeting.starttime }" pattern="yyyy-MM-dd HH:mm"/> </td>
	                       	<td><fmt:formatDate value="${meeting.endtime }" pattern="yyyy-MM-dd HH:mm"/> </td>
		                    <td><fmt:formatDate value="${meeting.reservationtime }" pattern="yyyy-MM-dd HH:mm"/> </td>
	                        <td>${meeting.employee.employeename }</td>
	                        <td>
	                            <a class="clickbutton" href="MeetingDetailsServlet?meetingid=${meeting.meetingid }">查看详情</a>
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