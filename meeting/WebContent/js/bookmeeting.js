/**
 * 
 */
//初始化会议室
$(function(){
	$.ajax({
		type : "POST",
		url : "QuerryAllMeetingRoomServlet",
		data : {},
		dataType : "json",
		success : function(data) {
			var inhtml = "";
			$.each(data, function(index, item) {
				inhtml += "<option value='"+item.roomid+"'>"+item.roomname+"</option>  ";
			});
			$("#roomselect").html(inhtml);
		}
	});
});
//初始化部门
$(function(){
	$.ajax({
		type : "POST",
		url : "QueryDepartmentServlet",
		data : {},
		dataType : "json",
		success : function(data) {
			var inhtml = "";
			$.each(data, function(index, item) {
				inhtml += "<option value='"+item.departmentid+"'>"+item.departmentname+"</option>  ";
				
			});
			$("#selDepartments").html(inhtml);
			var did = $("#selDepartments").val();
			queryemp(did);
		}
	});
});

function queryemp(did){
	$.ajax({
		type : "POST",
		url : "QueryEmployeeByDidServlet",
		data : {"did":did},
		dataType : "json",
		success : function(data) {
			var inhtml = "";
			$.each(data, function(index, item) {
				inhtml += "<option id='option"+item.employeeid+"' value='"+item.employeeid+"'>"+item.employeename+"</option>  ";
			});
			$("#selEmployees").html(inhtml);
		}
		
	});
}
//初始化员工列表
$(function(){
	$("#selDepartments").change(function(){
		var did = $("#selDepartments").val();
		queryemp(did);
	});
});
//添加
$(function(){
	$("#gt").click(function(){
		var empArray = $("#selEmployees").val();
		var inhtml = "";
		
		$.each(empArray,function(index,item){
			inhtml += "<option id='addoption"+item+"' value='"+item+"'>"+$('#option'+item).text()+"</option>";
		});
		$("#selSelectedEmployees").append(inhtml);
	});
});


//移除
$(function(){
	$("#lt").live("click",function(){
		var empArray = $("#selSelectedEmployees").val();
		$.each(empArray,function(index,item){
			$('#addoption'+item).remove();
		});
	});
});























