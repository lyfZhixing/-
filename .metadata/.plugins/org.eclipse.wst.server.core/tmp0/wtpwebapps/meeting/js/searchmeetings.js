/**
 * 搜索会议
 */

// 对Date的扩展，将 Date 转化为指定格式的String  
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
Date.prototype.Format = function (fmt) { 
    var o = {  
        "M+": this.getMonth() + 1, //月份   
        "d+": this.getDate(), //日   
        "H+": this.getHours(), //小时   
        "m+": this.getMinutes(), //分   
        "s+": this.getSeconds(), //秒   
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度   
        "S": this.getMilliseconds() //毫秒   
    };  
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
    for (var k in o)  
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
    return fmt;  
}  


function paging(pageindex,pagemax){
	
		var meetingname = $("#meetingname").val();
		var roomname = $("#roomname").val();
		var reservername = $("#reservername").val();
		var reservefromdate = $("#reservefromdate").val();
		var reservetodate = $("#reservetodate").val();
		var meetingfromdate = $("#meetingfromdate").val();
		var meetingtodate = $("#meetingtodate").val();
		
		$.ajax({
			   type: "POST",
			   url: "SearchMeetingServlet",
			   data : {
				"meetingname" : meetingname,
				"roomname" : roomname,
				"employeename" : reservername,
				"starttime1str" : reservefromdate,
				"starttime2str" : reservetodate,
				"endtime1str" : meetingfromdate,
				"endtime2str" : meetingtodate,
				"pageindex":pageindex,
				"pagemax":pagemax
			   	},
			   dataType:"json",
			   success: function(page){
				  var inhtml_1 = " <h3 style='text-align:center;color:black'>查询结果</h3><div class='pager-header'><div class='header-info'>共<span class='info-number' id='recordmax'>"+page.recordmax+"</span>条结果，分成<span class='info-number' id='pagemax'>"+page.pagemax+"</span>页显示， 当前第<span class='info-number' id='pageindex'>"+page.pageindex+"</span>页</div><div class='header-nav'><input type='button' class='clickbutton' id='homepage' value='首页'/><input type='button' class='clickbutton' id='prepage' value='上页'/><input type='button' class='clickbutton' id='nextpage' value='下页'/><input type='button' class='clickbutton' id='lastpage' value='末页'/>跳到第<input type='text' id='pagenum' class='nav-number'/>页<input type='button' id='gopage' class='clickbutton' value='跳转'/> </div></div>";
				  $("#searchresult").html(inhtml_1);
				  var inhtml_2 = "<tr class='listheader'> <th>会议名称</th> <th>会议室名称</th> <th>会议开始时间</th> <th>会议结束时间</th> <th>会议预定时间</th> <th>预定者</th> <th>操作</th> </tr>";
				 $.each(page.list,function(index,item){
					 var fmtstarttime = new Date(item.starttime).Format("yyyy-MM-dd HH:mm");
					 var fmtendtime = new Date(item.endtime).Format("yyyy-MM-dd HH:mm");
					 var fmtreservationtime= new Date(item.reservationtime).Format("yyyy-MM-dd HH:mm");
					 inhtml_2 += " <tr> <td>"+item.meetingname+"</td> <td>"+item.meetingroom.roomname+"</td> <td>"+fmtstarttime+"</td> <td>"+fmtendtime+"</td> <td>"+fmtreservationtime+"</td> <td>"+item.employee.employeename+"</td> <td> <a class='clickbutton' href='MeetingDetailsServlet?meetingid="+item.meetingid+"'>查看详情</a> </td> </tr>";
				 });
				 $(".listtable").html(inhtml_2);
			   }
			});
}




//首次查询
$(function(){
	$("#search").live("click",function(){
		paging();
	});
});
//下一页
$(function(){
	$("#nextpage").live("click",function(){
		var pageindex = parseInt($("#pageindex").text())+1;
		var pagemax = parseInt($("#pagemax").text());
		paging(pageindex,pagemax);
	});
});
//上一页
$(function(){
	$("#prepage").live("click",function(){
		var pageindex = parseInt($("#pageindex").text())-1;
		var pagemax = parseInt($("#pagemax").text());
		paging(pageindex,pagemax);
	});
});
//首页
$(function(){
	$("#homepage").live("click",function(){
		var pagemax = parseInt($("#pagemax").text());
		paging(1,pagemax);
	});
});
//末页
$(function(){
	$("#lastpage").live("click",function(){
		var pagemax = parseInt($("#pagemax").text());
		paging(pagemax,pagemax);
	});
});
//跳页
$(function(){
	$("#gopage").live("click",function(){
		var pageindex = $("#pagenum").val();
		var pagemax = parseInt($("#pagemax").text());
		paging(pageindex,pagemax);
	});
});

