<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
<style type="text/css">
#divfrom {
	float: left;
	width: 200px;
}

#divto {
	float: left;
	width: 200px;
}

#divoperator {
	float: left;
	width: 50px;
	padding: 60px 5px;
}

#divoperator input[type="button"] {
	margin: 10px 0;
}

#selDepartments {
	display: block;
	width: 100%;
}

#selEmployees {
	display: block;
	width: 100%;
	height: 200px;
}

#selSelectedEmployees {
	display: block;
	width: 100%;
	height: 225px;
}
</style>

</head>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/meetingfetails.js"></script>
<body onload="body_load()">
	<%@ include file="/jsp/comment/pageHeader.jsp"%>
	<div class="page-content">
		<div class="content-nav">会议预定 > 修改会议预定</div>
		<form>
			<fieldset>
				<legend>会议信息</legend>
				<table class="formtable">
					<tr>
						<td>会议名称：</td>
						<td>${meeting.meetingname }</td>
					</tr>
					<tr>
						<td>预计参加人数：</td>
						<td>${meeting.numberofparticipants }</td>
					</tr>
					<tr>
						<td>预计开始时间：</td>
						<td><fmt:formatDate value="${meeting.starttime }" pattern="yyyy-MM-dd HH:mm"/> </td>
					</tr>
					<tr>
						<td>预计结束时间：</td>
						<td><fmt:formatDate value="${meeting.endtime }" pattern="yyyy-MM-dd HH:mm"/> </td>
					</tr>
					<tr>
						<td>会议说明：</td>
						<td><textarea id="description" rows="5" readonly>${meeting.description }</textarea>
						
						</td>
					</tr>
					<tr>
						<td>参会人员：</td>
						<td>
							<table class="listtable" id="employeeinf">
								<tr class="listheader">
									<th>姓名</th>
									<th>联系电话</th>
									<td>电子邮件</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="command" colspan="2">
						<input type="button" class="clickbutton" value="撤销会议" id="canclebutton" />
							<input type="hidden" id="meetingid" value="${meeting.meetingid }" />
							<input type="hidden" id="meetingname" value="${meeting.meetingname }" />
						<input type="button" class="clickbutton" value="返回" onclick="window.history.back();" />
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>