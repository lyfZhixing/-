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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css"/>
</head>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/notifications.js"></script>
    <body>
			<%@ include file="/jsp/comment/pageHeader.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    个人中心 > <a href="jsp/notifications">最新通知</a>
                </div>
                <table class="listtable">
                    <caption>
                        未来7天我要参加的会议:
                    </caption>
                    <tr class="listheader">
                        <th style="width:300px">会议名称</th>
                        <th>会议室</th>
                        <th>起始时间</th>
                        <th>结束时间</th>
                        <th style="width:100px">操作</th>
                    </tr>
                    <c:forEach var="meeting" items="${meetinglist }">
                    <tr>
                        <td>${meeting.meetingname }</td>
                        <td>${meeting.meetingroom.roomname }</td>
                        
                        <td><fmt:formatDate value="${meeting.starttime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                       
                        <td> <fmt:formatDate value="${meeting.endtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <a class="clickbutton" id="showinfo">查看详情</a>
                            <input type="hidden" id="meetingid" value="${meeting.meetingid }" />
                        </td>
                    </tr>
                    </c:forEach>
                </table>
                
                <table class="listtable" id="cancleMeeting">
						  <caption>
                        已取消的会议:
                    </caption>
                    <tr class="listheader">
                        <th style="width:300px">会议名称</th>
                        <th>会议室</th>
                        <th>起始时间</th>
                        <th>结束时间</th>
                        <th>取消原因</th>
                        <th style="width:100px">操作</th>
                    </tr>
                </table>
                
            </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
        
       
        
        
        
        
    </body>
</html>