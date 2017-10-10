<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</style>
</head>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/register.js"></script>
<body>
	<%@ include file="/jsp/comment/pageHeader.jsp"%>
	<div class="page-content">
		<div class="content-nav">人员管理 > 员工注册</div>
		<fieldset>
			<legend>员工信息</legend>
			<form>
			<table class="formtable" style="width: 50%">
				<tr>
					<td>姓名：</td>
					<td><input type="text" id="employeename" maxlength="20" /></td>
				</tr>
				<tr>
					<td>账户名：</td>
					<td><input type="text" id="accountname" maxlength="20" /><span id="usermmsg"></span></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" id="password" maxlength="20"
						placeholder="请输入6位以上的密码" /> <span id="pwdmsg"></span></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" id="confirm" maxlength="20" /><span id="cfmmsg"></span></td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input type="text" id="phone" maxlength="20" /><span id="phonemsg"></span></td>
				</tr>
				<tr>
					<td>短信验证码：</td>
					<td><input type="text" id="vcode" maxlength="20" /><span id="vcodemsg"></span></td>
				</tr>
				<tr>
					<td>电子邮件：</td>
					<td><input type="text" id="email" maxlength="20" /><span id="emailmsg"></span></td>
				</tr>
				<tr>
				<td>所在部门：</td>
				<td><select name="deptid" id="deptid">
					<c:forEach var="department" items="${dlist }">
						<option value="${department.departmentid }">${department.departmentname }</option>
					</c:forEach>
				</select></td>
				</tr>
				<tr>
					<td colspan="6" class="command">
						<input type="button" class="clickbutton" id="register" value="注册" />
						<input type="reset" class="clickbutton" value="重置" /><span id="regmsg"></span>
					</td>
				</tr>
				
			</table>
			</form>
		</fieldset>
	</div>
	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>