/**
 * 
 */
$(function(){
	$.ajax({
		type: "POST",
	   url: "NotificationsServletTwo",
	   data: {},
	   dataType: "json",
	   success: function(data){
		  
		  var inhtml = "<caption>已取消的会议:</caption><tr class='listheader'><th style='width:300px'>会议名称</th><th>会议室</th><th>起始时间</th><th>结束时间</th><th>取消原因</th><th style='width:100px'>操作</th></tr>";
		  $.each(data,function(index,item){
			  var jsstarttime = new Date(item.starttime).Format("yyyy-MM-dd HH:mm");
			  var jsendtime = new Date(item.endtime).Format("yyyy-MM-dd HH:mm");
			  inhtml += "<tr><td>"+item.meetingname+"</td><td>"+item.meetingroom.roomname+"</td><td>"+jsstarttime+"</td><td>"+jsendtime+"</td><td>"+item.cancledreason+"</td><td><a class='clickbutton' id='showinfo'>查看详情</a><input type='hidden' id='meetingid' value='"+item.meetingid+"' /> </td></tr>";
		  });
		 $("#cancleMeeting").html(inhtml);
	   }
	});
});
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

$(function(){
	$("#showinfo").live("click",function(){
		var meetingid = $(this).next("#meetingid").val();
		location.href="MeetingDetailsServlet?meetingid="+meetingid;
		
	});
});
