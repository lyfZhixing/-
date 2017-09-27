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
                    会议预定 > 修改会议室信息
                </div>
                <form action="UpdateRoomServlet" method="post">
                    <fieldset>
                        <legend>会议室信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>门牌号:</td>
                                <td>
                                    <input name="roomnumber" id="roomnumber" type="text" value="${mr.roomnum }" maxlength="10"/>
                                </td>
                            </tr>
                            <tr>
                                <td>会议室名称:</td>
                                <td>
                                    <input name="capacity" id="capacity" type="text" value="${mr.roomname}" maxlength="20"/>
                                </td>
                            </tr>
                            <tr>
                                <td>最多容纳人数：</td>
                                <td>
                                    <input name="roomcapacity" id="roomcapacity" type="text" value="${mr.capacity}"/>
                                </td>
                            </tr>
                            <tr>
                                <td>当前状态：</td>
                                <td>
                                	<c:if test="${mr.status=='1' }">
                                		<input type="radio" id="status" name="status" checked="checked" value="1"/><label for="status">启用</label>
	                                    <input type="radio" id="status" name="status" value="0"/><label for="status" >停用</label>
	                                    <input type="radio" id="status" name="status" value="-1"/><label for="status" >删除</label>
                                	</c:if>
                                	<c:if test="${mr.status=='0' }">
                                		<input type="radio" id="status" name="status" value="1"/><label for="status">启用</label>
	                                    <input type="radio" id="status" name="status" checked="checked" value="0"/><label for="status" >停用</label>
	                                    <input type="radio" id="status" name="status" value="-1"/><label for="status" >删除</label>
                                	</c:if>
                                	<c:if test="${mr.status=='-1' }">
                                		<input type="radio" id="status" name="status" value="1"/><label for="status">启用</label>
	                                    <input type="radio" id="status" name="status" value="0"/><label for="status" >停用</label>
	                                    <input type="radio" id="status" name="status" checked="checked" value="-1"/><label for="status" >删除</label>
                                	</c:if>
                                
                                
                                
                                   <!--  <input type="radio" id="status" name="status" checked="checked" value="1"/><label for="status">启用</label>
                                    <input type="radio" id="status" name="status" value="0"/><label for="status" >停用</label>
                                    <input type="radio" id="status" name="status" value="-1"/><label for="status" >删除</label> -->
                                </td>
                            </tr>
                            <tr>
                                <td>备注：</td>
                                <td>
                                    <textarea name="description" id="description" maxlength="200" rows="5" cols="60" >${mr.description }</textarea>
                                     <input name="roomid" type="hidden" value="${mr.roomid }" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" class="command">
                                
                                <c:if test="${session_role == '1'}">
									<input type="submit" value="确认修改" class="clickbutton"/>
								</c:if>
                                   <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
            </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>