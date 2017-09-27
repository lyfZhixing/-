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
        <link rel="stylesheet" href="styles/common.css"/>
        <style type="text/css">
            #divfrom{
                float:left;
                width:200px;
            }
            #divto{
                float:left;
                width:200px;
            }
            #divoperator{
                float:left;
                width:50px;
                padding:60px 5px;
            }
            #divoperator input[type="button"]{
                margin:10px 0;
            }
            #selDepartments{
                display:block;
                width:100%;
            }
            #selEmployees{
                display:block;
                width:100%;
                height:200px;
            }
            #selSelectedEmployees{
                display:block;
                width:100%;
                height:225px;
            }
        </style>
        <script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript">

                     $(function(){
                    	 $("input[name=cancelbtn]").live("click",function(){
                    		 if(confirm("撤销请点击确认")){
                    			var meetingid = $(this).prev().val();
                          		var description = $("#description").val();
                          		alert(meetingid+description);
                          		location.href="CancleMeetingServlet?meetingid="+meetingid+"&description="+description;
                    		 }
                     		
           				});             	
                     });
        </script>
    </head>
    <body onload="body_load()">
       <%@ include file="/jsp/comment/pageHeader.jsp"%>
            <div class="page-content">
                 <div class="content-nav">
                    会议预定 > 撤销会议预定
                </div>
                <form>
                    <fieldset>
                        <legend>撤销预定</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>${param.meetingname }</td>
                            </tr>                            
                            <tr>
                                <td>撤销理由：</td>
                                <td> <textarea id="description" rows="5"></textarea></td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="hidden" value="${param.meetingid }" />
                                    <input type="button" class="clickbutton" value="确认撤销" name="cancelbtn"/>
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