
<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="page-header">
	<div class="header-banner">
		<img src="images/header.png" alt="CoolMeeting" />
	</div>
	<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
	<div class="header-quicklink">
		欢迎您，<strong>${uname}</strong>
		<div style="float: right">
			<a href="jsp/changepassword.jsp">[修改密码]</a> <a href="LoginOutServlet">[退出登录]</a>
		</div>

	</div>
</div>
<div class="page-body">
	<div class="page-sidebar">
		<div class="sidebar-menugroup">
			<div class="sidebar-grouptitle">个人中心</div>
			<ul class="sidebar-menu">
				<li class="sidebar-menuitem"><a href="jsp/notifications.jsp">最新通知</a></li>
				<li class="sidebar-menuitem active"><a
					href="jsp/mybookings.jsp">我的预定</a></li>
				<li class="sidebar-menuitem"><a href="MyMeetingServlet">我的会议</a></li>
			</ul>
		</div>
		<div class="sidebar-menugroup">


			<c:if test="${session_role == '1'}">
				<div class="sidebar-grouptitle">人员管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="jsp/departments.jsp">部门管理</a></li>
					<li class="sidebar-menuitem"><a href="jsp/register.jsp">员工注册</a></li>
					<li class="sidebar-menuitem"><a href="jsp/approveaccount.jsp">注册审批</a></li>
					<li class="sidebar-menuitem"><a href="jsp/searchemployees.jsp">搜索员工</a></li>
				</ul>
		
			</c:if>
		<c:if test="${session_role == null or session_role == '2'}">
				<div class="sidebar-grouptitle">人员管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="jsp/register.jsp">员工注册</a></li>
				</ul>
		
			</c:if>
			
			
		</div>


	<div class="sidebar-menugroup">
	
	<c:if test="${session_role == '1'}">
				<div class="sidebar-grouptitle">会议预定</div>
		<ul class="sidebar-menu">
			<li class="sidebar-menuitem"><a href="jsp/addmeetingroom.jsp">添加会议室</a></li>
			<li class="sidebar-menuitem"><a
				href="QuerryAllMeetingRoomServlet">查看会议室</a></li>
			<li class="sidebar-menuitem"><a href="jsp/bookmeeting.jsp">预定会议</a></li>
			<li class="sidebar-menuitem"><a href="jsp/searchmeetings.jsp">搜索会议</a></li>
		</ul>
		
			</c:if>
		<c:if test="${session_role == null or session_role == '2'}">
				<div class="sidebar-grouptitle">会议预定</div>
		<ul class="sidebar-menu">
			<li class="sidebar-menuitem"><a
				href="QuerryAllMeetingRoomServlet">查看会议室</a></li>
			<li class="sidebar-menuitem"><a href="jsp/bookmeeting.jsp">预定会议</a></li>
			<li class="sidebar-menuitem"><a href="jsp/searchmeetings.jsp">搜索会议</a></li>
		</ul>
		
			</c:if>
	
	
		
	</div>
</div>
</div>