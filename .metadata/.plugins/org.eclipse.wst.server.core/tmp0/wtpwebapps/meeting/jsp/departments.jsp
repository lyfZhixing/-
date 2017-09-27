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
<link rel="stylesheet" href="styles/common.css" />
</head>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/departments.js"></script>
<body>
	<%@ include file="/jsp/comment/pageHeader.jsp"%>
	<div class="page-content">
		<div class="content-nav">人员管理 > 部门管理</div>
		<fieldset>
			<legend>添加部门</legend>
			部门名称: <input type="text" id="departmentname" maxlength="20" /> <input
				type="button" id="insert" class="clickbutton" value="添加" />
		</fieldset>
		<table class="listtable">
			<caption>所有部门:</caption>
			<tr class="listheader">
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>
		</table>
	</div>
	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>