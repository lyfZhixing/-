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
                width:150px;
            }
            #divto{
                float:left;
                width:150px;
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.5.3/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.5.3/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jquery-easyui-1.5.3/demo.css">
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.3/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.5.3/jquery.easyui.min.js"></script>

<script type="text/javascript">
$(function(){
	$("#subbtn").live("click",function(){
		var meetingname = $("#meetingname").val();
		var roomid = $("#roomselect").val();
		var reservationistid = $("#reservationistid").val();
		var numberofparticipants = $("#numberofparticipants").val();
		var starttime = $('#starttime').val();	
		var endtime = $("#endtime").val();
		var description = $("#description").val();
		//var emps = Array();
		//emps = $("#selSelectedEmployees").val();
		var emps =  $("#selSelectedEmployees option").map(function(){return $(this).val();}).get().join(',');
		//alert(emps);
		$.ajax({
			type : "POST",
			url : "MeetingBookServlet",
					data : {
						"meetingname" : meetingname,
						"roomid" : roomid,
						"reservationistid" : reservationistid,
						"numberofparticipants" : numberofparticipants,
						"starttime" : starttime,
						"endtime" : endtime,
						"description" : description,
						"emps" : emps
					},
			traditional: true,
			dataType : "json",
			success : function(data) {
				if(data){
					location.href="MybookingServlet";
				}else{
					alert("添加失败");
				}
			},
			error: function(){
				alert("出问题啦");
			}
		}); 
		
	});
});

</script>
</head>

<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bookmeeting.js"></script>
 <body>
       <%@ include file="/jsp/comment/pageHeader.jsp"%>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 预定会议
                </div>
                <form id="ff" method="post">
                    <fieldset>
                        <legend>会议信息</legend>
                        <table class="formtable">
                            <tr>
                                <td>会议名称：</td>
                                <td>
                                    <input class="easyui-textbox" type="text" id="meetingname" data-options="required:true"></input>
                                </td>
                            </tr>
                            <tr>
                                <td>预计参加人数：</td>
                                <td>
                                    <input class="easyui-numberspinner" id="numberofparticipants" style="width:80px;"   
        required="required" data-options="min:2,max:100,editable:false">  
                                </td>
                            </tr>
                            <tr>
                                <td>预计开始时间：</td>
                                <td>
                                <input class="easyui-datetimebox" name="birthday"
    data-options="required:true,showSeconds:false"  style="width:200px" id="starttime" />
                                   <!--  <input class="easyui-datetimebox" id="starttime" required style="width:200px"> -->
                                </td>
                            </tr>
                            <tr>
                                <td>预计结束时间：</td>
                                <td>
                                    <input class="easyui-datetimebox" data-options="required:true,showSeconds:false" id="endtime" required style="width:200px" />
                                </td>
                            </tr>
							<tr>
                                <td>会议室名称：</td>
                                <td>
                                    <select id="roomselect" name="roomid" style="width:200px;">   
									    
									</select>  

                                </td>
                            </tr>
                            <tr>
                                <td>会议说明：</td>
                                <td>
                                    <input class="easyui-textbox" id="description" data-options="multiline:true" style="height:60px;width:200px"></input>
                                </td>
                            </tr>
                            <tr>
                                <td>选择参会人员：</td>
                                <td>
                                    <div id="divfrom">
                                    <select id="selDepartments" name="dept" style="width:150px;">   
									</select> 
                                        <!-- <select id="selDepartments" onchange="fillEmployees()">
                                        </select> -->
                                    <!--     <input id="selEmployees" class="easyui-combobox"  -->
                                    <select id="selEmployees" multiple="multiple">
                                        </select>
                                    </div>
                                    <div id="divoperator">
                                        <input type="button" class="clickbutton" id="gt" value="&gt;" />
                                        <input type="button" class="clickbutton" id="lt" value="&lt;"/>
                                    </div>
                                    <div id="divto">
                                        <select id="selSelectedEmployees" name="emps" multiple="multiple">
                                        </select>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td class="command" colspan="2">
                                    <input type="button" id="subbtn" class="clickbutton" value="预定会议"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
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