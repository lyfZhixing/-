/**
 * 
 */
$(function() {
	var meetingid = $("#meetingid").val();
	$.ajax({
		type : "POST",
		url : "MeetingDetailsServletTwo",
		data : {"meetingid" : meetingid},
		dataType : "json",
		success : function(data) {
			var inhtml = " <tr class='listheader'><th>姓名</th><th>联系电话</th><td>电子邮件</td></tr>";
			$.each(data, function(index, item) {
				inhtml += " <tr><td>" + item.username + "</td><td>"
						+ item.phone + "</td><td>" + item.email
						+ "</td></tr>";
			});
			$("#employeeinf").html(inhtml);
		}
	});
});

$(function(){
	$("#canclebutton").live("click",function(){
		var meetingid = $(this).next("#meetingid").val();
		var meetingname = $(this).parent("td").find("#meetingname").val();
		/*location.href="CancleMeetingServlet?meetingid="+meetingid;*/
		location.href="jsp/cancelmeeting.jsp?meetingid="+meetingid+"&meetingname="+meetingname;
	});
});