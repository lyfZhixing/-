<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    </head>
    <body>
         <%@ include file="/jsp/comment/pageHeader.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 查看会议室
                </div>
                <table class="listtable">
                    <caption>所有会议室:</caption>
                    <tr class="listheader">
                        <th>门牌编号</th>
                        <th>会议室名称</th>
                        <th>容纳人数</th>
                        <th>当前状态</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="mr" items="${mlist }">
                    	<tr>
                        <td>${mr.roomnum }</td>
                        <td>${mr.roomname}</td>
                        <td>${mr.capacity}</td>
                        <td>
                        	<c:choose>
                        		<c:when test="${mr.status=='1' }">启用</c:when>
                        		<c:when test="${mr.status=='0' }">停用</c:when>
                        		<c:otherwise>删除</c:otherwise>
                        	</c:choose>
                        </td>
                        <td>
                            <a class="clickbutton" href="QuerrySingleServlet?mid=${mr.roomid }">查看详情</a>
                            <input id="roomid" type="hidden" value="${mr.roomid }" />
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